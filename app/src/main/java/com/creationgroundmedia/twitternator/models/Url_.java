
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
public class Url_ implements Parcelable
{

    @SerializedName("urls")
    @Expose
    @Valid
    private List<Url__> urls = new ArrayList<Url__>();
    public final static Parcelable.Creator<Url_> CREATOR = new Creator<Url_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Url_ createFromParcel(Parcel in) {
            Url_ instance = new Url_();
            in.readList(instance.urls, (com.creationgroundmedia.twitternator.models.Url__.class.getClassLoader()));
            return instance;
        }

        public Url_[] newArray(int size) {
            return (new Url_[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The urls
     */
    public List<Url__> getUrls() {
        return urls;
    }

    /**
     * 
     * @param urls
     *     The urls
     */
    public void setUrls(List<Url__> urls) {
        this.urls = urls;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(urls);
    }

    public int describeContents() {
        return  0;
    }

}
