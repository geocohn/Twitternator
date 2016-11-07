/*
 * Copyright 2016 George Cohn III
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.creationgroundmedia.twitternator.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.creationgroundmedia.twitternator.R;
import com.creationgroundmedia.twitternator.activities.ProfileActivity;
import com.creationgroundmedia.twitternator.models.Tweet;
import com.creationgroundmedia.twitternator.models.User;
import com.creationgroundmedia.twitternator.util.RoundedCornersTransform;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by geo on 2016.10.29
 */

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder> {

    static final String LOG_TAG = TweetsAdapter.class.getSimpleName();
    private Context mContext;
    private ArrayList<Tweet> mTweets;

    private Context getContext() {
        return mContext;
    }

    public TweetsAdapter(Context context, ArrayList<Tweet> tweets) {
        mContext = context;
        mTweets = tweets;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(getContext())
                .inflate(R.layout.activity_timeline_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Tweet tweet = mTweets.get(position);
        Picasso.with(mContext)
                .load(tweet.getUserProfileImageUrl())
                .transform(new RoundedCornersTransform())
                .into(holder.ivProfileImage);
        holder.ivProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileActivity.launchActivity(mContext, User.fromTweet(tweet));
            }
        });
        holder.tvUserName.setText(tweet.getUserName());
        holder.tvScreenName.setText(tweet.getUserScreenName());
        holder.tvCreatedAt.setText(tweet.getCreatedAtRelativeTimeAgo());
        holder.tvBody.setText(tweet.getBody());
    }

    @Override
    public int getItemCount() {
        return mTweets.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View vItem;
        ImageView ivProfileImage;
        TextView tvUserName;
        TextView tvScreenName;
        TextView tvCreatedAt;
        TextView tvBody;

        ViewHolder(View itemView) {
            super(itemView);

            vItem = itemView;

            ivProfileImage = (ImageView) itemView.findViewById(R.id.ivProfileImage);
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
            tvScreenName = (TextView) itemView.findViewById(R.id.tvScreenName);
            tvCreatedAt = (TextView) itemView.findViewById(R.id.tvCreatedAt);
            tvBody = (TextView) itemView.findViewById(R.id.tvBody);
        }
    }
}
