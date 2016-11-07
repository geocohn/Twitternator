
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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.creationgroundmedia.twitternator.R;
import com.creationgroundmedia.twitternator.TwitterApplication;
import com.creationgroundmedia.twitternator.TwitterClient;
import com.creationgroundmedia.twitternator.fragments.HomeTimelineFragment;
import com.creationgroundmedia.twitternator.fragments.MentionsTimelineFragment;
import com.creationgroundmedia.twitternator.fragments.TimelineFragment;
import com.creationgroundmedia.twitternator.fragments.TweetAddFragment;
import com.creationgroundmedia.twitternator.models.Tweet;
import com.creationgroundmedia.twitternator.models.User;
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
    private MenuItem mMyProfileMenu;
    private User mMe;
    private HomeTimelineFragment mHomeTimelineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.drawable.ic_launcher);

        client = TwitterApplication.getRestClient();
        getProfileUserInfo();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TweetAddFragment.newInstance(null).show(getSupportFragmentManager(),
                        "new tweet");
            }
        });

        TimelinePagerAdapter timelinePagerAdapter = new TimelinePagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.vpContainer);
        mViewPager.setAdapter(timelinePagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tlTabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void getProfileUserInfo() {
        client.getVerifyCredentials(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                mMe = User.fromJson(response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d(LOG_TAG, "onFailure 2");
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_timeline, menu);
        mMyProfileMenu = menu.findItem(R.id.menu_my_profile);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item == mMyProfileMenu) {
            ProfileActivity.launchActivity(this, mMe);
        }
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
                    sendTweetToHomeTimeline(tweet);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                }
            });
        }
    }

    private void sendTweetToHomeTimeline(Tweet tweet) {
            if (mHomeTimelineFragment != null && mHomeTimelineFragment.getClass().isInstance(TimelineFragment.class)) {
                Log.d(LOG_TAG, "Adding new tweet to fragment");
                mHomeTimelineFragment.addTweet(tweet);
            }

    }

    public class TimelinePagerAdapter extends FragmentPagerAdapter {

        TimelinePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: {
                    mHomeTimelineFragment = new HomeTimelineFragment();
                    return timelineFragmentInstance(mHomeTimelineFragment, "home");
                }
                case 1: return timelineFragmentInstance(new MentionsTimelineFragment(), "mentions");
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
                    return getString(R.string.tab_title_home);
                case 1:
                    return getString(R.string.tab_title_mentions);
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
