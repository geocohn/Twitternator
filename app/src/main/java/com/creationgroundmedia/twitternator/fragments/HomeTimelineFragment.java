package com.creationgroundmedia.twitternator.fragments;

import android.util.Log;

import com.creationgroundmedia.twitternator.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


public class HomeTimelineFragment
        extends TimelineFragment {
    final static String LOG_TAG = HomeTimelineFragment.class.getSimpleName();

    @Override
    public void populateTimeline(final boolean newTweets, int count, long sinceId, long maxId) {
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
                swipeContainer.setRefreshing(false);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
            }
        }));
    }
}
