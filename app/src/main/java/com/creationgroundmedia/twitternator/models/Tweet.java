package com.creationgroundmedia.twitternator.models;

import android.support.annotation.NonNull;
import android.text.format.DateUtils;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by geo on 10/28/16.
 */

@Table(database = TwitterDb.class)
public class Tweet extends BaseModel {
    @Column
    String createdAt;

    @Column
    @PrimaryKey
    long id;

    @Column
    String body;

    @Column
    String userName;

    @Column
    long userId;

    @Column
    String userScreenName;

    @Column
    String userProfileImageUrl;

    public Tweet() {
    }

    public static Tweet fromJson(@NonNull JSONObject jsonTweet) {
        Tweet tweet = new Tweet();
        try {
            tweet.setBody(jsonTweet.getString("text"));
            tweet.setId(jsonTweet.getLong("id"));
            tweet.setCreatedAt(jsonTweet.getString("created_at"));
            JSONObject jsonUser = jsonTweet.getJSONObject("user");
            if (jsonUser != null) {
                tweet.setUserName(jsonUser.getString("name"));
                tweet.setUserId(jsonUser.getLong("id"));
                tweet.setUserScreenName("@" + jsonUser.getString("screen_name"));
                tweet.setUserProfileImageUrl(
                        jsonUser.getString("profile_image_url").replace("normal", "bigger"));
            }
            tweet.save();
        } catch (JSONException e) {
            e.printStackTrace();
        };

        return tweet;
    }
    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserScreenName() {
        return userScreenName;
    }

    public void setUserScreenName(String userScreenName) {
        this.userScreenName = userScreenName;
    }

    public String getUserProfileImageUrl() {
        return userProfileImageUrl;
    }

    public void setUserProfileImageUrl(String userProfileImageUrl) {
        this.userProfileImageUrl = userProfileImageUrl;
    }

    // getRelativeTimeAgo("Mon Apr 01 21:16:23 +0000 2014");
    // from https://gist.github.com/nesquena/f786232f5ef72f6e10a7
    public String getCreatedAtRelativeTimeAgo() {
        String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
        SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
        sf.setLenient(true);

        String relativeDate = "";
        try {
            long dateMillis = sf.parse(getCreatedAt()).getTime();
            relativeDate = DateUtils.getRelativeTimeSpanString(dateMillis,
                    System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return relativeDate;
    }

    public static ArrayList<Tweet> fromJsonArray(JSONArray jsonTweets) {
        ArrayList<Tweet> tweets = new ArrayList<>();

        for (int i = 0; i < jsonTweets.length(); i++) {
            Tweet tweet = null;
            try {
                tweet = Tweet.fromJson(jsonTweets.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
                continue;
            }
            if (tweet != null) {
                tweets.add(tweet);
            }
        }
        return tweets;
    }
}
