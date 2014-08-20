package com.wahyuadityanugraha.mvpexample.app.databases;

import android.content.Context;

/**
 * Created by wahyuadityanugraha on 8/20/14.
 */
public class Repo {

    DatabaseHelper db;

    public RepoFeed Feeds;

    public Repo(Context context)
    {
        DatabaseManager<DatabaseHelper> manager = new DatabaseManager<DatabaseHelper>();
        db = manager.getHelper(context);

        Feeds = new RepoFeed(db);

    }

}
