package com.wahyuadityanugraha.mvpexample.app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.wahyuadityanugraha.mvpexample.app.entities.Feed;
import com.wahyuadityanugraha.mvpexample.app.views.FeedRowView;

import java.util.List;

/**
 * Created by wahyuadityanugraha on 8/19/14.
 */
public class FeedAdapter extends ArrayAdapter<Feed>
{

    private static final String LOG = "Feed";

    private List<Feed> mObjects;
    private Context context;


    public FeedAdapter(Context context, int resource, List<Feed> objects) {
        super(context, resource, objects);
        this.context = context;
        this.mObjects = objects;
    }


    @Override
    public long getItemId(int position) {
        int id = position;
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Feed object = getItem(position);

        if (convertView == null) {

            convertView = new FeedRowView(context);
        }


        ((FeedRowView) convertView).setDataRow(object);

        return convertView;
    }

    @Override
    public int getCount() {

        return mObjects.size();
    }

    @Override
    public Feed getItem(int position) {
        return mObjects.get(position);
    }


}

