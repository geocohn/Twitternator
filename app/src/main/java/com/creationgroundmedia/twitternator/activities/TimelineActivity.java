package com.creationgroundmedia.twitternator.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.creationgroundmedia.twitternator.R;
import com.creationgroundmedia.twitternator.TwitterApplication;
import com.creationgroundmedia.twitternator.TwitterClient;
import com.creationgroundmedia.twitternator.adapters.EndlessRecyclerViewScrollListener;
import com.creationgroundmedia.twitternator.adapters.TweetsAdapter;
import com.creationgroundmedia.twitternator.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class TimelineActivity extends AppCompatActivity {
    final static String LOG_TAG = TimelineActivity.class.getSimpleName();

    private TwitterClient client;
    ArrayList<Tweet> mTweets;
    TweetsAdapter mTweetsAdapter;
    RecyclerView mRvTweets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        mRvTweets = (RecyclerView) findViewById(R.id.rvTweets);
        mTweets = new ArrayList<>();
        mTweetsAdapter = new TweetsAdapter(this, mTweets);
        mRvTweets.setAdapter(mTweetsAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRvTweets.setLayoutManager(layoutManager);
        mRvTweets.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                if (!mTweets.isEmpty()) {
                    // get any tweets newer than the top of the list
                    populateTimeline(true, 0, mTweets.get(0).getId(), 0);
                    // pick up 25 more tweets from the bottom
                    populateTimeline(false, 25, 0, mTweets.get(mTweets.size() - 1).getId() - 1);
                } else {
                    populateTimeline(false, 25, 1, 0);
                }
            }
        });

        client = TwitterApplication.getRestClient();

        populateTimeline(false, 25, 1, 0);
    }

    private void populateTimeline(final boolean newTweets, int count, long sinceId, long maxId) {
        Log.d(LOG_TAG, "populateTimeline(" + newTweets + ", " + count + ", " + sinceId + ", " + maxId + ")");
        client.getHomeTimeline(count, sinceId, maxId, (new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                if (newTweets) {
                    Log.d(LOG_TAG, "inserting " + response.length() + " new tweets");
                    mTweets.addAll(0, Tweet.fromJsonArray(response));
                } else {
                    Log.d(LOG_TAG, "appending " + response.length() + " tweets");

                    mTweets.addAll(Tweet.fromJsonArray(response));
                }
                mTweetsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
            }
        }));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_timeline, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}