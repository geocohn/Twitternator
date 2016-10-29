
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
public class Url__ implements Parcelable
{

    @SerializedName("expanded_url")
    @Expose
    private Object expandedUrl;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("indices")
    @Expose
    @Valid
    private List<Integer> indices = new ArrayList<Integer>();
    public final static Parcelable.Creator<Url__> CREATOR = new Creator<Url__>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Url__ createFromParcel(Parcel in) {
            Url__ instance = new Url__();
            instance.expandedUrl = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.indices, (java.lang.Integer.class.getClassLoader()));
            return instance;
        }

        public Url__[] newArray(int size) {
            return (new Url__[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The expandedUrl
     */
    public Object getExpandedUrl() {
        return expandedUrl;
    }

    /**
     * 
     * @param expandedUrl
     *     The expanded_url
     */
    public void setExpandedUrl(Object expandedUrl) {
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(expandedUrl);
        dest.writeValue(url);
        dest.writeList(indices);
    }

    public int describeContents() {
        return  0;
    }

}
