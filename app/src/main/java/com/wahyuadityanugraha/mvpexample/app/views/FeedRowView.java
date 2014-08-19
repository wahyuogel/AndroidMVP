package com.wahyuadityanugraha.mvpexample.app.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.wahyuadityanugraha.mvpexample.app.R;
import com.wahyuadityanugraha.mvpexample.app.entities.Feed;
import com.wahyuadityanugraha.mvpexample.app.finditems.FeedRowFunction;
import com.wahyuadityanugraha.mvpexample.app.server.RequestManager;

/**
 * Created by wahyuadityanugraha on 8/19/14.
 */
public class FeedRowView extends LinearLayout implements FeedRowFunction{

    private ImageView avatar;
    private TextView name;
    private TextView status;

    public FeedRowView(Context context) {
        super(context);
        init();
    }

    public FeedRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FeedRowView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.feed_row_view, this, true);
        findViews();
    }


    private void findViews() {
        avatar = (ImageView) findViewById( R.id.imageView );
        name = (TextView)findViewById( R.id.textView );
        status = (TextView)findViewById( R.id.textView2 );
    }

    @Override
    public void setDataRow(Feed dataRow){
        name.setText(dataRow.getName());
        status.setText(dataRow.getStatus());
        RequestManager.getInstance(getContext()).getImageLoader().get(dataRow.getProfilePic(), ImageLoader.getImageListener(avatar, R.drawable.ic_launcher, R.drawable.ic_launcher));

    }
}
