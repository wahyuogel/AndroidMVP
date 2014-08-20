package com.wahyuadityanugraha.mvpexample.app.databases;

import android.content.Context;

/**
 * Created by wahyuadityanugraha on 8/20/14.
 */
public class Repo {

    DatabaseHelper db;

    public RepoFeed feedObject;

    public Repo(Context context)
    {
        DatabaseManager<DatabaseHelper> manager = new DatabaseManager<DatabaseHelper>();
        db = manager.getHelper(context);

        feedObject = new RepoFeed(db);

    }

}
