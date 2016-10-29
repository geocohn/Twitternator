
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
public class Url implements Parcelable
{

    @SerializedName("expanded_url")
    @Expose
    private String expandedUrl;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("indices")
    @Expose
    @Valid
    private List<Integer> indices = new ArrayList<Integer>();
    @SerializedName("display_url")
    @Expose
    private String displayUrl;
    public final static Parcelable.Creator<Url> CREATOR = new Creator<Url>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Url createFromParcel(Parcel in) {
            Url instance = new Url();
            instance.expandedUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.indices, (java.lang.Integer.class.getClassLoader()));
            instance.displayUrl = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Url[] newArray(int size) {
            return (new Url[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The expandedUrl
     */
    public String getExpandedUrl() {
        return expandedUrl;
    }

    /**
     * 
     * @param expandedUrl
     *     The expanded_url
     */
    public void setExpandedUrl(String expandedUrl) {
        this.expandedUrl = expandedUrl;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The indices
     */
    public List<Integer> getIndices() {
        return indices;
    }

    /**
     * 
     * @param indices
     *     The indices
     */
    public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }

    /**
     * 
     * @return
     *     The displayUrl
     */
    public String getDisplayUrl() {
        return displayUrl;
    }

    /**
     * 
     * @param displayUrl
     *     The display_url
     */
    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(expandedUrl);
        dest.writeValue(url);
        dest.writeList(indices);
        dest.writeValue(displayUrl);
    }

    public int describeContents() {
        return  0;
    }

}
