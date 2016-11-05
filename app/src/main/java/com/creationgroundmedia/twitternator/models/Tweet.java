package com.creationgroundmedia.twitternator.models;

import android.os.Parcel;
import android.os.Parcelable;
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

@Table(database = TwitterDb.class)
public class Tweet extends BaseModel implements Parcelable {
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

    @Column
    String userTagline;

    @Column
    int userFollowers;

    @Column
    int userFollowing;

    @Column
    String collection;

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
                User user = User.fromJson(jsonUser);
                tweet.setUserName(user.getName());
                tweet.setUserId(user.getId());
                tweet.setUserScreenName(user.getScreenName());
                tweet.setUserProfileImageUrl(user.getProfileImageUrl());
                tweet.setUserTagline(user.getTagline());
                tweet.setUserFollowers(user.getFollowers());
                tweet.setUserFollowing(user.getFollowing());
            }
            tweet.save();
        } catch (JSONException e) {
            e.printStackTrace();
        };

        return tweet;
    }

    public static Tweet fromJson(@NonNull JSONObject jsonTweet, String collection) {
        Tweet tweet = fromJson(jsonTweet);
        if (tweet != null) {
            tweet.collection = collection;
        }
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

    public int getUserFollowers() {
        return userFollowers;
    }

    public void setUserFollowers(int userFollowers) {
        this.userFollowers = userFollowers;
    }

    public int getUserFollowing() {
        return userFollowing;
    }

    public void setUserFollowing(int userFollowing) {
        this.userFollowing = userFollowing;
    }

    public String getUserTagline() {
        return userTagline;
    }

    public void setUserTagline(String userTagline) {
        this.userTagline = userTagline;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
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

    public static ArrayList<Tweet> fromJsonArray(JSONArray jsonTweets, String collection) {
        ArrayList<Tweet> tweets = new ArrayList<>();

        for (int i = 0; i < jsonTweets.length(); i++) {
            Tweet tweet = null;
            try {
                tweet = Tweet.fromJson(jsonTweets.getJSONObject(i), collection);
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.createdAt);
        dest.writeLong(this.id);
        dest.writeString(this.body);
        dest.writeString(this.userName);
        dest.writeLong(this.userId);
        dest.writeString(this.userScreenName);
        dest.writeString(this.userProfileImageUrl);
        dest.writeString(this.collection);
    }

    protected Tweet(Parcel in) {
        this.createdAt = in.readString();
        this.id = in.readLong();
        this.body = in.readString();
        this.userName = in.readString();
        this.userId = in.readLong();
        this.userScreenName = in.readString();
        this.userProfileImageUrl = in.readString();
        this.collection = in.readString();
    }

    public static final Parcelable.Creator<Tweet> CREATOR = new Parcelable.Creator<Tweet>() {
        @Override
        public Tweet createFromParcel(Parcel source) {
            return new Tweet(source);
        }

        @Override
        public Tweet[] newArray(int size) {
            return new Tweet[size];
        }
    };
}
