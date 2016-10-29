
package com.creationgroundmedia.twitternator.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import javax.validation.Valid;

@Generated("org.jsonschema2pojo")
public class Entities_ implements Parcelable
{

    @SerializedName("url")
    @Expose
    @Valid
    private Url_ url;
    @SerializedName("description")
    @Expose
    @Valid
    private Description description;
    public final static Parcelable.Creator<Entities_> CREATOR = new Creator<Entities_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Entities_ createFromParcel(Parcel in) {
            Entities_ instance = new Entities_();
            instance.url = ((Url_) in.readValue((Url_.class.getClassLoader())));
            instance.description = ((Description) in.readValue((Description.class.getClassLoader())));
            return instance;
        }

        public Entities_[] newArray(int size) {
            return (new Entities_[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The url
     */
    public Url_ getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(Url_ url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The description
     */
    public Description getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(Description description) {
        this.description = description;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(description);
    }

    public int describeContents() {
        return  0;
    }

}
