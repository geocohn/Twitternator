package com.creationgroundmedia.twitternator.models;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = TwitterDb.NAME, version = TwitterDb.VERSION)
public class TwitterDb {

    public static final String NAME = "TwitterDatabase";

    public static final int VERSION = 1;
}