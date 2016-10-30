package com.creationgroundmedia.twitternator.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.creationgroundmedia.twitternator.R;
import com.creationgroundmedia.twitternator.models.Tweet;


public class TweetAddFragment extends DialogFragment {
final static String LOG_TAG = TweetAddFragment.class.getSimpleName();

    private OnFragmentInteractionListener mListener;
    private Tweet mTweet;
    private EditText etTweet;
    private TextView tvCharsLeft;
    private Button btOK;
    private Button btCancel;
    private int charsLeft;

    public TweetAddFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tweet_add, container, false);
        etTweet = (EditText) view.findViewById(R.id.etNewTweet);
        tvCharsLeft = (TextView) view.findViewById(R.id.tvCharsLeft);
        btOK = (Button) view.findViewById(R.id.btOK);
        btCancel = (Button) view.findViewById(R.id.btCancel);

        tvCharsLeft.setText(Integer.toString(140));
        etTweet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tvCharsLeft.setText(Integer.toString(140 - s.length()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFragmentInteraction(String.valueOf(etTweet.getText()));
                dismiss();
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (TweetAddFragment.OnFragmentInteractionListener) context;
        }
        catch (ClassCastException e) {
            Log.e(LOG_TAG, "Activity needs to implement TweetAddFragment.OnFragmentInteractionListener");
        }
      }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String status);
    }
}
