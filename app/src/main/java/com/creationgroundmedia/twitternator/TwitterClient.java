package com.creationgroundmedia.twitternator;

import android.content.Context;

import com.codepath.oauth.OAuthBaseClient;
import com.creationgroundmedia.twitternator.models.User;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.TwitterApi;

/*
 * 
 * This is the object responsible for communicating with a REST API. 
 * Specify the constants below to change the API being communicated with.
 * See a full list of supported API classes: 
 *   https://github.com/fernandezpablo85/scribe-java/tree/master/src/main/java/org/scribe/builder/api
 * Key and Secret are provided by the developer site for the given API i.e dev.twitter.com
 * Add methods for each relevant endpoint in the API.
 * 
 * NOTE: You may want to rename this object based on the service i.e TwitterClient or FlickrClient
 * 
 */
public class TwitterClient extends OAuthBaseClient {
	public static final Class<? extends Api> REST_API_CLASS = TwitterApi.class;
	public static final String REST_URL = "https://api.twitter.com/1.1";
	public static final String REST_CONSUMER_KEY = "45qVwRFymD27p3i98zCLIHEjC";
	public static final String REST_CONSUMER_SECRET = "rtY4aJD9m7zAH0va0Cf2gF6NgnRaovlvK3SxEfWV8CFpBiAMZD";
	public static final String REST_CALLBACK_URL = "oauth://cgmtweets";
	private static final String LOG_TAG = TwitterClient.class.getSimpleName();

	private Context mContext;

	public TwitterClient(Context context) {
		super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
		mContext = context;
	}

	public void getTimeline(User user, String apiUrl, int count, long sinceId, long maxId, JsonHttpResponseHandler handler) {
		RequestParams params = new RequestParams();
		if (user != null) {
			params.put("user_id", user.getId());
		}
		if (count != 0) {
			params.put("count", count);
		}
		if (sinceId != 0) {
			params.put("since_id", sinceId);
		}
		if (maxId != 0) {
			params.put("max_id", maxId);
		}
		getClient().get(apiUrl, params, handler);
	}
	public void getHomeTimeline(int count, long sinceId, long maxId, JsonHttpResponseHandler handler) {
		getTimeline(null, getApiUrl("statuses/home_timeline.json"), count, sinceId, maxId, handler);
	}

	public void getUserTimeline(User user, int count, long sinceId, long maxId, JsonHttpResponseHandler handler) {
		getTimeline(user, getApiUrl("statuses/user_timeline.json"), count, sinceId, maxId, handler);
	}

	public void getMentionsTimeline(int count, long sinceId, long maxId, JsonHttpResponseHandler handler) {
		getTimeline(null, getApiUrl("statuses/mentions_timeline.json"), count, sinceId, maxId, handler);
	}

	public void getVerifyCredentials(JsonHttpResponseHandler handler) {
		getClient().get(getApiUrl("account/verify_credentials.json"), null, handler);
	}

	public void updateStatus(String status, JsonHttpResponseHandler handler) {
		String apiUrl = getApiUrl("statuses/update.json");
		RequestParams params = new RequestParams();

		params.put("status", status);
		getClient().post(apiUrl, params, handler);
	}
}