package com.creationgroundmedia.twitternator.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by geo on 11/3/16.
 */

public class User implements Parcelable {
    private String name;
    private long id;
    private String screenName;
    private String profileImageUrl;
    private String tagline;
    private int followers;
    private int following;

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public static User fromJson(@NonNull JSONObject jsonUser) {
        User user = new User();
        try {
            user.setName(jsonUser.getString("name"));
            user.setId(jsonUser.getLong("id"));
            user.setScreenName("@" + jsonUser.getString("screen_name"));
            user.setProfileImageUrl(jsonUser.getString("profile_image_url").replace("normal", "bigger"));
            user.setTagline(jsonUser.getString("description"));
            user.setFollowers(jsonUser.getInt("followers_count"));
            user.setFollowing(jsonUser.getInt("friends_count"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static User fromTweet(Tweet tweet) {
        User user = new User();
        user.setName(tweet.getUserName());
        user.setId(tweet.getUserId());
        user.setScreenName(tweet.getUserScreenName());
        user.setProfileImageUrl(tweet.getUserProfileImageUrl());
        user.setTagline(tweet.getUserTagline());
        user.setFollowers(tweet.getUserFollowers());
        user.setFollowing(tweet.getUserFollowing());
        return user;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeLong(this.id);
        dest.writeString(this.screenName);
        dest.writeString(this.profileImageUrl);
        dest.writeString(this.tagline);
        dest.writeInt(this.followers);
        dest.writeInt(this.following);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.name = in.readString();
        this.id = in.readLong();
        this.screenName = in.readString();
        this.profileImageUrl = in.readString();
        this.tagline = in.readString();
        this.followers = in.readInt();
        this.following = in.readInt();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
