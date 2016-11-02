package com.creationgroundmedia.twitternator.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.creationgroundmedia.twitternator.R;
import com.creationgroundmedia.twitternator.TwitterApplication;
import com.creationgroundmedia.twitternator.TwitterClient;
import com.creationgroundmedia.twitternator.fragments.HomeTimelineFragment;
import com.creationgroundmedia.twitternator.fragments.TimelineFragment;
import com.creationgroundmedia.twitternator.fragments.TweetAddFragment;
import com.creationgroundmedia.twitternator.fragments.UserTimelineFragment;
import com.creationgroundmedia.twitternator.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.util.TextUtils;

import static com.creationgroundmedia.twitternator.fragments.TimelineFragment.ARG_COLLECTION;

public class TimelineActivity
        extends AppCompatActivity
        implements TweetAddFragment.OnFragmentInteractionListener {

    final static String LOG_TAG = TimelineActivity.class.getSimpleName();

    TwitterClient client;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.drawable.ic_launcher);

        client = TwitterApplication.getRestClient();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TweetAddFragment().show(getSupportFragmentManager(),
                        "new tweet");
            }
        });

        TimelinePagerAdapter timelinePagerAdapter = new TimelinePagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.vpContainer);
        mViewPager.setAdapter(timelinePagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tlTabs);
        tabLayout.setupWithViewPager(mViewPager);
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

    @Override
    public void onFragmentInteraction(String status) {
        if (!TextUtils.isEmpty(status)) {
            client.updateStatus(status, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    Tweet tweet = Tweet.fromJson(response);
                    tweet.setCollection("me");
                    tweet.save();
                    // TODO: get this to work
//                    mTweets.add(0, tweet);
//                    mTweetsAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                }
            });
        }
    }

    public class TimelinePagerAdapter extends FragmentPagerAdapter {

        TimelinePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: return timelineFragmentInstance(new HomeTimelineFragment(), "home");
                case 1: return timelineFragmentInstance(new UserTimelineFragment(), "me");
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Home";
                case 1:
                    return "My tweets";
            }
            return null;
        }

        private Fragment timelineFragmentInstance(TimelineFragment fragment, String collection) {
            Bundle args = new Bundle();
            args.putString(ARG_COLLECTION, collection);
            fragment.setArguments(args);
            return fragment;
        }
    }
}
