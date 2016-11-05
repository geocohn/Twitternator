package com.creationgroundmedia.twitternator.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.creationgroundmedia.twitternator.R;
import com.creationgroundmedia.twitternator.fragments.ProfileHeaderFragment;
import com.creationgroundmedia.twitternator.fragments.TimelineFragment;
import com.creationgroundmedia.twitternator.fragments.UserTimelineFragment;
import com.creationgroundmedia.twitternator.models.Tweet;
import com.creationgroundmedia.twitternator.models.Tweet_Table;
import com.creationgroundmedia.twitternator.models.User;
import com.raizlabs.android.dbflow.sql.language.SQLite;

/**
 * Created by geo on 11/3/16.
 */
public class ProfileActivity  extends AppCompatActivity {
    private static final String USER = "user";
    private static final String USER_PROFILE = "profile";

    public static void launchActivity(Context context, User user) {
        SQLite.delete()
                .from(Tweet.class)
                .where(Tweet_Table.collection.is(USER_PROFILE))
                .query();
        context.startActivity(instanceIntent(context, user));
    }

    private static Intent instanceIntent(Context context, User user) {
        Intent intent = new Intent(context, ProfileActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(USER, user);
        intent.putExtras(bundle);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        Bundle extras = getIntent().getExtras();
        User user = extras.getParcelable(USER);

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.container_profile_header, ProfileHeaderFragment.newInstance(user))
                .commit();

        UserTimelineFragment fragment = new UserTimelineFragment();
        Bundle args = new Bundle();
        args.putString(TimelineFragment.ARG_COLLECTION, USER_PROFILE);
        args.putParcelable(TimelineFragment.ARG_USER, user);
        fragment.setArguments(args);

        fragmentManager.beginTransaction()
                .replace(R.id.container_profile_timeline, fragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Doing this makes sure the screen back button behavior
        // is identical to the system back button's
        finish();
        return true;
    }
}
