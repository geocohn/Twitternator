package com.creationgroundmedia.twitternator;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.codepath.oauth.OAuthBaseClient;
import com.creationgroundmedia.twitternator.data.DbTweet;
import com.creationgroundmedia.twitternator.models.Tweet;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.TwitterApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

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
public class RestClient extends OAuthBaseClient {
	public static final Class<? extends Api> REST_API_CLASS = TwitterApi.class;
	public static final String REST_URL = "http://api.twitter.com/1.1";
	public static final String REST_CONSUMER_KEY = "45qVwRFymD27p3i98zCLIHEjC";
	public static final String REST_CONSUMER_SECRET = "rtY4aJD9m7zAH0va0Cf2gF6NgnRaovlvK3SxEfWV8CFpBiAMZD";
	public static final String REST_CALLBACK_URL = "oauth://cgmtweets";
	private static final String LOG_TAG = RestClient.class.getSimpleName();

	Retrofit mRetrofit;
	private Context mContext;

	public RestClient(Context context) {
		super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
		mContext = context;
		mRetrofit = new Retrofit.Builder()
				.baseUrl("https://api.twitter.com/1.1/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
	}

	public interface TwitterApiInterface {
		@GET("statuses/home_timeline.json")
		Call<List<Tweet>> getTweets(@Query("since_id") int tweetId, @Query("count") int count);
	}

	public void getTweets() {
		TwitterApiInterface twitterApiService = mRetrofit.create(TwitterApiInterface.class);
		Call<List<Tweet>> call = twitterApiService.getTweets(1, 25);
		call.enqueue(new Callback<List<Tweet>>() {
			@Override
			public void onResponse(Call<List<Tweet>> call, Response<List<Tweet>> response) {
				if (response.isSuccessful()) {
                    if (response.body() != null) {
                        List<Tweet> tweetList = response.body();
                        for (Tweet tweet : tweetList) {
                            new DbTweet(tweet).save();
                        }
                    }
					Toast.makeText(mContext, "Got tweets! " + response.message(), Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(mContext, "Clean response, no tweets", Toast.LENGTH_SHORT).show();
					Log.d(LOG_TAG, "Response message: " + response.message());
				}
			}

			@Override
			public void onFailure(Call<List<Tweet>> call, Throwable t) {
				Toast.makeText(mContext, "FAIL to get tweets", Toast.LENGTH_SHORT).show();
			}
		});
	}
	// CHANGE THIS
	// DEFINE METHODS for different API endpoints here
	public void getInterestingnessList(AsyncHttpResponseHandler handler) {
		String apiUrl = getApiUrl("?nojsoncallback=1&method=flickr.interestingness.getList");
		// Can specify query string params directly or through RequestParams.
		RequestParams params = new RequestParams();
		params.put("format", "json");
		client.get(apiUrl, params, handler);
	}

	/* 1. Define the endpoint URL with getApiUrl and pass a relative path to the endpoint
	 * 	  i.e getApiUrl("statuses/home_timeline.json");
	 * 2. Define the parameters to pass to the request (query or body)
	 *    i.e RequestParams params = new RequestParams("foo", "bar");
	 * 3. Define the request method and make a call to the client
	 *    i.e client.get(apiUrl, params, handler);
	 *    i.e client.post(apiUrl, params, handler);
	 */
}