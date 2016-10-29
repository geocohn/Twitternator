
package com.creationgroundmedia.twitternator.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.validation.Valid;

@Generated("org.jsonschema2pojo")
public class Entities implements Parcelable
{

    @SerializedName("urls")
    @Expose
    @Valid
    private List<Url> urls = new ArrayList<Url>();
    @SerializedName("hashtags")
    @Expose
    @Valid
    private List<Object> hashtags = new ArrayList<Object>();
    @SerializedName("user_mentions")
    @Expose
    @Valid
    private List<Object> userMentions = new ArrayList<Object>();
    public final static Parcelable.Creator<Entities> CREATOR = new Creator<Entities>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Entities createFromParcel(Parcel in) {
            Entities instance = new Entities();
            in.readList(instance.urls, (com.creationgroundmedia.twitternator.models.Url.class.getClassLoader()));
            in.readList(instance.hashtags, (java.lang.Object.class.getClassLoader()));
            in.readList(instance.userMentions, (java.lang.Object.class.getClassLoader()));
            return instance;
        }

        public Entities[] newArray(int size) {
            return (new Entities[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The urls
     */
    public List<Url> getUrls() {
        return urls;
    }

    /**
     * 
     * @param urls
     *     The urls
     */
    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

    /**
     * 
     * @return
     *     The hashtags
     */
    public List<Object> getHashtags() {
        return hashtags;
    }

    /**
     * 
     * @param hashtags
     *     The hashtags
     */
    public void setHashtags(List<Object> hashtags) {
        this.hashtags = hashtags;
    }

    /**
     * 
     * @return
     *     The userMentions
     */
    public List<Object> getUserMentions() {
        return userMentions;
    }

    /**
     * 
     * @param userMentions
     *     The user_mentions
     */
    public void setUserMentions(List<Object> userMentions) {
        this.userMentions = userMentions;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(urls);
        dest.writeList(hashtags);
        dest.writeList(userMentions);
    }

    public int describeContents() {
        return  0;
    }

}
