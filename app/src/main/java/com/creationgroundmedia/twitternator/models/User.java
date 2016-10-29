
package com.creationgroundmedia.twitternator.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import javax.validation.Valid;

@Generated("org.jsonschema2pojo")
public class User implements Parcelable
{

    @SerializedName("profile_sidebar_fill_color")
    @Expose
    private String profileSidebarFillColor;
    @SerializedName("profile_sidebar_border_color")
    @Expose
    private String profileSidebarBorderColor;
    @SerializedName("profile_background_tile")
    @Expose
    private boolean profileBackgroundTile;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("profile_image_url")
    @Expose
    private String profileImageUrl;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("follow_request_sent")
    @Expose
    private boolean followRequestSent;
    @SerializedName("profile_link_color")
    @Expose
    private String profileLinkColor;
    @SerializedName("is_translator")
    @Expose
    private boolean isTranslator;
    @SerializedName("id_str")
    @Expose
    private String idStr;
    @SerializedName("entities")
    @Expose
    @Valid
    private Entities_ entities;
    @SerializedName("default_profile")
    @Expose
    private boolean defaultProfile;
    @SerializedName("contributors_enabled")
    @Expose
    private boolean contributorsEnabled;
    @SerializedName("favourites_count")
    @Expose
    private int favouritesCount;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("profile_image_url_https")
    @Expose
    private String profileImageUrlHttps;
    @SerializedName("utc_offset")
    @Expose
    private int utcOffset;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("profile_use_background_image")
    @Expose
    private boolean profileUseBackgroundImage;
    @SerializedName("listed_count")
    @Expose
    private int listedCount;
    @SerializedName("profile_text_color")
    @Expose
    private String profileTextColor;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("followers_count")
    @Expose
    private int followersCount;
    @SerializedName("protected")
    @Expose
    private boolean _protected;
    @SerializedName("notifications")
    @Expose
    private Object notifications;
    @SerializedName("profile_background_image_url_https")
    @Expose
    private String profileBackgroundImageUrlHttps;
    @SerializedName("profile_background_color")
    @Expose
    private String profileBackgroundColor;
    @SerializedName("verified")
    @Expose
    private boolean verified;
    @SerializedName("geo_enabled")
    @Expose
    private boolean geoEnabled;
    @SerializedName("time_zone")
    @Expose
    private String timeZone;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("default_profile_image")
    @Expose
    private boolean defaultProfileImage;
    @SerializedName("profile_background_image_url")
    @Expose
    private String profileBackgroundImageUrl;
    @SerializedName("statuses_count")
    @Expose
    private int statusesCount;
    @SerializedName("friends_count")
    @Expose
    private int friendsCount;
    @SerializedName("following")
    @Expose
    private Object following;
    @SerializedName("show_all_inline_media")
    @Expose
    private boolean showAllInlineMedia;
    @SerializedName("screen_name")
    @Expose
    private String screenName;
    public final static Parcelable.Creator<User> CREATOR = new Creator<User>() {


        @SuppressWarnings({
            "unchecked"
        })
        public User createFromParcel(Parcel in) {
            User instance = new User();
            instance.profileSidebarFillColor = ((String) in.readValue((String.class.getClassLoader())));
            instance.profileSidebarBorderColor = ((String) in.readValue((String.class.getClassLoader())));
            instance.profileBackgroundTile = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.profileImageUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.createdAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.location = ((String) in.readValue((String.class.getClassLoader())));
            instance.followRequestSent = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.profileLinkColor = ((String) in.readValue((String.class.getClassLoader())));
            instance.isTranslator = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.idStr = ((String) in.readValue((String.class.getClassLoader())));
            instance.entities = ((Entities_) in.readValue((Entities_.class.getClassLoader())));
            instance.defaultProfile = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.contributorsEnabled = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.favouritesCount = ((int) in.readValue((int.class.getClassLoader())));
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            instance.profileImageUrlHttps = ((String) in.readValue((String.class.getClassLoader())));
            instance.utcOffset = ((int) in.readValue((int.class.getClassLoader())));
            instance.id = ((int) in.readValue((int.class.getClassLoader())));
            instance.profileUseBackgroundImage = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.listedCount = ((int) in.readValue((int.class.getClassLoader())));
            instance.profileTextColor = ((String) in.readValue((String.class.getClassLoader())));
            instance.lang = ((String) in.readValue((String.class.getClassLoader())));
            instance.followersCount = ((int) in.readValue((int.class.getClassLoader())));
            instance._protected = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.notifications = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.profileBackgroundImageUrlHttps = ((String) in.readValue((String.class.getClassLoader())));
            instance.profileBackgroundColor = ((String) in.readValue((String.class.getClassLoader())));
            instance.verified = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.geoEnabled = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.timeZone = ((String) in.readValue((String.class.getClassLoader())));
            instance.description = ((String) in.readValue((String.class.getClassLoader())));
            instance.defaultProfileImage = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.profileBackgroundImageUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.statusesCount = ((int) in.readValue((int.class.getClassLoader())));
            instance.friendsCount = ((int) in.readValue((int.class.getClassLoader())));
            instance.following = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.showAllInlineMedia = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.screenName = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The profileSidebarFillColor
     */
    public String getProfileSidebarFillColor() {
        return profileSidebarFillColor;
    }

    /**
     * 
     * @param profileSidebarFillColor
     *     The profile_sidebar_fill_color
     */
    public void setProfileSidebarFillColor(String profileSidebarFillColor) {
        this.profileSidebarFillColor = profileSidebarFillColor;
    }

    /**
     * 
     * @return
     *     The profileSidebarBorderColor
     */
    public String getProfileSidebarBorderColor() {
        return profileSidebarBorderColor;
    }

    /**
     * 
     * @param profileSidebarBorderColor
     *     The profile_sidebar_border_color
     */
    public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
        this.profileSidebarBorderColor = profileSidebarBorderColor;
    }

    /**
     * 
     * @return
     *     The profileBackgroundTile
     */
    public boolean isProfileBackgroundTile() {
        return profileBackgroundTile;
    }

    /**
     * 
     * @param profileBackgroundTile
     *     The profile_background_tile
     */
    public void setProfileBackgroundTile(boolean profileBackgroundTile) {
        this.profileBackgroundTile = profileBackgroundTile;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The profileImageUrl
     */
    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    /**
     * 
     * @param profileImageUrl
     *     The profile_image_url
     */
    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    /**
     * 
     * @return
     *     The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * @param createdAt
     *     The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 
     * @return
     *     The location
     */
    public String getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The followRequestSent
     */
    public boolean isFollowRequestSent() {
        return followRequestSent;
    }

    /**
     * 
     * @param followRequestSent
     *     The follow_request_sent
     */
    public void setFollowRequestSent(boolean followRequestSent) {
        this.followRequestSent = followRequestSent;
    }

    /**
     * 
     * @return
     *     The profileLinkColor
     */
    public String getProfileLinkColor() {
        return profileLinkColor;
    }

    /**
     * 
     * @param profileLinkColor
     *     The profile_link_color
     */
    public void setProfileLinkColor(String profileLinkColor) {
        this.profileLinkColor = profileLinkColor;
    }

    /**
     * 
     * @return
     *     The isTranslator
     */
    public boolean isIsTranslator() {
        return isTranslator;
    }

    /**
     * 
     * @param isTranslator
     *     The is_translator
     */
    public void setIsTranslator(boolean isTranslator) {
        this.isTranslator = isTranslator;
    }

    /**
     * 
     * @return
     *     The idStr
     */
    public String getIdStr() {
        return idStr;
    }

    /**
     * 
     * @param idStr
     *     The id_str
     */
    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    /**
     * 
     * @return
     *     The entities
     */
    public Entities_ getEntities() {
        return entities;
    }

    /**
     * 
     * @param entities
     *     The entities
     */
    public void setEntities(Entities_ entities) {
        this.entities = entities;
    }

    /**
     * 
     * @return
     *     The defaultProfile
     */
    public boolean isDefaultProfile() {
        return defaultProfile;
    }

    /**
     * 
     * @param defaultProfile
     *     The default_profile
     */
    public void setDefaultProfile(boolean defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    /**
     * 
     * @return
     *     The contributorsEnabled
     */
    public boolean isContributorsEnabled() {
        return contributorsEnabled;
    }

    /**
     * 
     * @param contributorsEnabled
     *     The contributors_enabled
     */
    public void setContributorsEnabled(boolean contributorsEnabled) {
        this.contributorsEnabled = contributorsEnabled;
    }

    /**
     * 
     * @return
     *     The favouritesCount
     */
    public int getFavouritesCount() {
        return favouritesCount;
    }

    /**
     * 
     * @param favouritesCount
     *     The favourites_count
     */
    public void setFavouritesCount(int favouritesCount) {
        this.favouritesCount = favouritesCount;
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
     *     The profileImageUrlHttps
     */
    public String getProfileImageUrlHttps() {
        return profileImageUrlHttps;
    }

    /**
     * 
     * @param profileImageUrlHttps
     *     The profile_image_url_https
     */
    public void setProfileImageUrlHttps(String profileImageUrlHttps) {
        this.profileImageUrlHttps = profileImageUrlHttps;
    }

    /**
     * 
     * @return
     *     The utcOffset
     */
    public int getUtcOffset() {
        return utcOffset;
    }

    /**
     * 
     * @param utcOffset
     *     The utc_offset
     */
    public void setUtcOffset(int utcOffset) {
        this.utcOffset = utcOffset;
    }

    /**
     * 
     * @return
     *     The id
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The profileUseBackgroundImage
     */
    public boolean isProfileUseBackgroundImage() {
        return profileUseBackgroundImage;
    }

    /**
     * 
     * @param profileUseBackgroundImage
     *     The profile_use_background_image
     */
    public void setProfileUseBackgroundImage(boolean profileUseBackgroundImage) {
        this.profileUseBackgroundImage = profileUseBackgroundImage;
    }

    /**
     * 
     * @return
     *     The listedCount
     */
    public int getListedCount() {
        return listedCount;
    }

    /**
     * 
     * @param listedCount
     *     The listed_count
     */
    public void setListedCount(int listedCount) {
        this.listedCount = listedCount;
    }

    /**
     * 
     * @return
     *     The profileTextColor
     */
    public String getProfileTextColor() {
        return profileTextColor;
    }

    /**
     * 
     * @param profileTextColor
     *     The profile_text_color
     */
    public void setProfileTextColor(String profileTextColor) {
        this.profileTextColor = profileTextColor;
    }

    /**
     * 
     * @return
     *     The lang
     */
    public String getLang() {
        return lang;
    }

    /**
     * 
     * @param lang
     *     The lang
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     * 
     * @return
     *     The followersCount
     */
    public int getFollowersCount() {
        return followersCount;
    }

    /**
     * 
     * @param followersCount
     *     The followers_count
     */
    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    /**
     * 
     * @return
     *     The _protected
     */
    public boolean isProtected() {
        return _protected;
    }

    /**
     * 
     * @param _protected
     *     The protected
     */
    public void setProtected(boolean _protected) {
        this._protected = _protected;
    }

    /**
     * 
     * @return
     *     The notifications
     */
    public Object getNotifications() {
        return notifications;
    }

    /**
     * 
     * @param notifications
     *     The notifications
     */
    public void setNotifications(Object notifications) {
        this.notifications = notifications;
    }

    /**
     * 
     * @return
     *     The profileBackgroundImageUrlHttps
     */
    public String getProfileBackgroundImageUrlHttps() {
        return profileBackgroundImageUrlHttps;
    }

    /**
     * 
     * @param profileBackgroundImageUrlHttps
     *     The profile_background_image_url_https
     */
    public void setProfileBackgroundImageUrlHttps(String profileBackgroundImageUrlHttps) {
        this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
    }

    /**
     * 
     * @return
     *     The profileBackgroundColor
     */
    public String getProfileBackgroundColor() {
        return profileBackgroundColor;
    }

    /**
     * 
     * @param profileBackgroundColor
     *     The profile_background_color
     */
    public void setProfileBackgroundColor(String profileBackgroundColor) {
        this.profileBackgroundColor = profileBackgroundColor;
    }

    /**
     * 
     * @return
     *     The verified
     */
    public boolean isVerified() {
        return verified;
    }

    /**
     * 
     * @param verified
     *     The verified
     */
    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    /**
     * 
     * @return
     *     The geoEnabled
     */
    public boolean isGeoEnabled() {
        return geoEnabled;
    }

    /**
     * 
     * @param geoEnabled
     *     The geo_enabled
     */
    public void setGeoEnabled(boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    /**
     * 
     * @return
     *     The timeZone
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * 
     * @param timeZone
     *     The time_zone
     */
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The defaultProfileImage
     */
    public boolean isDefaultProfileImage() {
        return defaultProfileImage;
    }

    /**
     * 
     * @param defaultProfileImage
     *     The default_profile_image
     */
    public void setDefaultProfileImage(boolean defaultProfileImage) {
        this.defaultProfileImage = defaultProfileImage;
    }

    /**
     * 
     * @return
     *     The profileBackgroundImageUrl
     */
    public String getProfileBackgroundImageUrl() {
        return profileBackgroundImageUrl;
    }

    /**
     * 
     * @param profileBackgroundImageUrl
     *     The profile_background_image_url
     */
    public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
        this.profileBackgroundImageUrl = profileBackgroundImageUrl;
    }

    /**
     * 
     * @return
     *     The statusesCount
     */
    public int getStatusesCount() {
        return statusesCount;
    }

    /**
     * 
     * @param statusesCount
     *     The statuses_count
     */
    public void setStatusesCount(int statusesCount) {
        this.statusesCount = statusesCount;
    }

    /**
     * 
     * @return
     *     The friendsCount
     */
    public int getFriendsCount() {
        return friendsCount;
    }

    /**
     * 
     * @param friendsCount
     *     The friends_count
     */
    public void setFriendsCount(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    /**
     * 
     * @return
     *     The following
     */
    public Object getFollowing() {
        return following;
    }

    /**
     * 
     * @param following
     *     The following
     */
    public void setFollowing(Object following) {
        this.following = following;
    }

    /**
     * 
     * @return
     *     The showAllInlineMedia
     */
    public boolean isShowAllInlineMedia() {
        return showAllInlineMedia;
    }

    /**
     * 
     * @param showAllInlineMedia
     *     The show_all_inline_media
     */
    public void setShowAllInlineMedia(boolean showAllInlineMedia) {
        this.showAllInlineMedia = showAllInlineMedia;
    }

    /**
     * 
     * @return
     *     The screenName
     */
    public String getScreenName() {
        return screenName;
    }

    /**
     * 
     * @param screenName
     *     The screen_name
     */
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(profileSidebarFillColor);
        dest.writeValue(profileSidebarBorderColor);
        dest.writeValue(profileBackgroundTile);
        dest.writeValue(name);
        dest.writeValue(profileImageUrl);
        dest.writeValue(createdAt);
        dest.writeValue(location);
        dest.writeValue(followRequestSent);
        dest.writeValue(profileLinkColor);
        dest.writeValue(isTranslator);
        dest.writeValue(idStr);
        dest.writeValue(entities);
        dest.writeValue(defaultProfile);
        dest.writeValue(contributorsEnabled);
        dest.writeValue(favouritesCount);
        dest.writeValue(url);
        dest.writeValue(profileImageUrlHttps);
        dest.writeValue(utcOffset);
        dest.writeValue(id);
        dest.writeValue(profileUseBackgroundImage);
        dest.writeValue(listedCount);
        dest.writeValue(profileTextColor);
        dest.writeValue(lang);
        dest.writeValue(followersCount);
        dest.writeValue(_protected);
        dest.writeValue(notifications);
        dest.writeValue(profileBackgroundImageUrlHttps);
        dest.writeValue(profileBackgroundColor);
        dest.writeValue(verified);
        dest.writeValue(geoEnabled);
        dest.writeValue(timeZone);
        dest.writeValue(description);
        dest.writeValue(defaultProfileImage);
        dest.writeValue(profileBackgroundImageUrl);
        dest.writeValue(statusesCount);
        dest.writeValue(friendsCount);
        dest.writeValue(following);
        dest.writeValue(showAllInlineMedia);
        dest.writeValue(screenName);
    }

    public int describeContents() {
        return  0;
    }

}
