package com.creationgroundmedia.twitternator.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.creationgroundmedia.twitternator.R;
import com.creationgroundmedia.twitternator.models.User;
import com.creationgroundmedia.twitternator.util.CircleTransform;
import com.squareup.picasso.Picasso;

public class ProfileHeaderFragment extends Fragment {
    private static final String USER = "user";

    private User mUser;


    public ProfileHeaderFragment() {
        // Required empty public constructor
    }


    public static ProfileHeaderFragment newInstance(User user) {
        ProfileHeaderFragment fragment = new ProfileHeaderFragment();
        Bundle args = new Bundle();
        args.putParcelable(USER, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUser = getArguments().getParcelable(USER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_header, container, false);
        ImageView ivProfileImage = (ImageView) view.findViewById(R.id.iv_profile_image);
        TextView tvProfileName = (TextView) view.findViewById(R.id.tv_profile_name);
        TextView tvProfileScreenname = (TextView) view.findViewById(R.id.tv_profile_screenname);
        TextView tvProfileTagline = (TextView) view.findViewById(R.id.tv_profile_tagline);
        TextView tvFollowers = (TextView) view.findViewById(R.id.tv_followers);
        TextView tvFollowing = (TextView) view.findViewById(R.id.tv_following);

        Picasso.with(getContext())
                .load(mUser.getProfileImageUrl())
                .transform(new CircleTransform())
                .into(ivProfileImage);
        tvProfileName.setText(mUser.getName());
        tvProfileScreenname.setText(mUser.getScreenName());
        tvProfileTagline.setText(mUser.getTagline());
        tvFollowers.setText(String.valueOf(mUser.getFollowers()));
        tvFollowing.setText(String.valueOf(mUser.getFollowing()));

        return view;
    }

}
