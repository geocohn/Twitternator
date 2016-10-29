package com.creationgroundmedia.twitternator.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.creationgroundmedia.twitternator.R;
import com.creationgroundmedia.twitternator.RestApplication;
import com.creationgroundmedia.twitternator.models.Tweet;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Tweet> tweets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((RestApplication)getApplicationContext()).getRestClient().getTweets();

    }
}
