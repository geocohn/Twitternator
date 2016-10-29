package com.creationgroundmedia.twitternator.data;

import com.creationgroundmedia.twitternator.models.Tweet;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by geo on 10/28/16.
 */

@Table(database = TwitterDb.class)
public class DbTweet extends BaseModel {
    @Column
    String createdAt;

    @Column
    @PrimaryKey
    int id;

    @Column
    String text;

    @Column
    String userName;

    @Column
    String userProfileImageUrl;

    public DbTweet() {
    }

    public DbTweet(Tweet tweet) {
        setCreatedAt(tweet.getCreatedAt());
        setId(tweet.getId());
        setText(tweet.getText());
        setUserName(tweet.getUser().getName());
        setUserProfileImageUrl(tweet.getUser().getProfileImageUrl());
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserProfileImageUrl() {
        return userProfileImageUrl;
    }

    public void setUserProfileImageUrl(String userProfileImageUrl) {
        this.userProfileImageUrl = userProfileImageUrl;
    }
}
