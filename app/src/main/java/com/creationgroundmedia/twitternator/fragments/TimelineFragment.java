package com.creationgroundmedia.twitternator.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creationgroundmedia.twitternator.R;
import com.creationgroundmedia.twitternator.TwitterApplication;
import com.creationgroundmedia.twitternator.TwitterClient;
import com.creationgroundmedia.twitternator.adapters.EndlessRecyclerViewScrollListener;
import com.creationgroundmedia.twitternator.adapters.TweetsAdapter;
import com.creationgroundmedia.twitternator.models.Tweet;
import com.creationgroundmedia.twitternator.models.Tweet_Table;
import com.creationgroundmedia.twitternator.models.User;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;


public abstract class TimelineFragment
        extends Fragment {
    final static String LOG_TAG = TimelineFragment.class.getSimpleName();
    public final static String ARG_COLLECTION = "collection";
    public final static String ARG_USER = "user";

    TwitterClient client;
    RecyclerView mRvTweets;
    ArrayList<Tweet> mTweets;
    TweetsAdapter mTweetsAdapter;
    SwipeRefreshLayout swipeContainer;
    private String mCollection;
    private User mUser;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            mCollection = args.getString(ARG_COLLECTION);
            mUser = args.getParcelable(ARG_USER);
        }
        client = TwitterApplication.getRestClient();

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timeline, container, false);

        mRvTweets = (RecyclerView) view.findViewById(R.id.rvTweets);

        mTweets = new ArrayList<>();
        mTweetsAdapter = new TweetsAdapter(getActivity(), mTweets);
        mRvTweets.setAdapter(mTweetsAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRvTweets.setLayoutManager(layoutManager);
        mRvTweets.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                if (!mTweets.isEmpty()) {
                    // get any tweets newer than the top of the list
                    populateTimeline(mUser, mCollection, true, 0, mTweets.get(0).getId(), 0);
                    // pick up 25 more tweets from the bottom
                    populateTimeline(mUser, mCollection, false, 25, 0, mTweets.get(mTweets.size() - 1).getId() - 1);
                } else {
                    populateTimeline(mUser, mCollection, false, 25, 1, 0);
                }
            }
        });

        swipeContainer = (SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getNewTweets();
            }
        });
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        if (preloadTimeline() == 0) {
            populateTimeline(mUser, mCollection, false, 25, 1, 0);
        } else {
            if (!mTweets.isEmpty()) {
                populateTimeline(mUser, mCollection, true, 25, mTweets.get(0).getId(), 0);
            }
        }

        return view;
    }

    private void getNewTweets() {
        swipeContainer.setRefreshing(true);
        if (mTweets.isEmpty()) {
            populateTimeline(mUser, mCollection, false, 25, 1, 0);
        } else {
            populateTimeline(mUser, mCollection, true, 25, mTweets.get(0).getId(), 0);
        }
    }

    private int preloadTimeline() {
        mTweets.addAll((ArrayList<Tweet>) SQLite.select()
                .from(Tweet.class)
                .where(Tweet_Table.collection.is(mCollection))
                .queryList());
        Log.d(LOG_TAG, "preloadTimeline returning " + mTweets.size());
        if (!mTweets.isEmpty()) {
            Log.d(LOG_TAG, "preloadTimeline notifyDataSetChanged");
            mTweetsAdapter.notifyDataSetChanged();
        }
        return mTweets.size();
    }

    abstract void populateTimeline(User user, String collection, final boolean newTweets, int count, long sinceId, long maxId);

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void addTweet(Tweet tweet) {
        tweet.setCollection(mCollection);
        mTweets.add(0, tweet);
        mTweetsAdapter.notifyDataSetChanged();
    }
}
