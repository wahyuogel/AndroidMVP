/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.wahyuadityanugraha.mvpexample.app.finditems;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.wahyuadityanugraha.mvpexample.app.R;
import com.wahyuadityanugraha.mvpexample.app.adapter.FeedAdapter;
import com.wahyuadityanugraha.mvpexample.app.application.MyApplication;
import com.wahyuadityanugraha.mvpexample.app.entities.Feed;
import com.wahyuadityanugraha.mvpexample.app.entities.Feeds;
import com.wahyuadityanugraha.mvpexample.app.server.ConvertStringToJSON;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class FeedActivity extends Activity implements FeedFunction, AdapterView.OnItemClickListener {

    private ListView listView;
    private ProgressBar progressBar;
    private FeedAdapter feedAdapter;
    private FeedPresenter presenter;
    private Feeds myFeeds;
    private JsonObjectRequest mJsonObjectRequest;
    private static final String API_URL = "http://api.androidhive.info/feed/feed.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        init();
    }

    private void init() {
        presenter = new FeedPresenterImpl(this);
        mJsonObjectRequest = new JsonObjectRequest(API_URL,null,mObjectListener,errorListener);
        MyApplication.getInstance().addToRequestQueue(mJsonObjectRequest);
        findViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    private void findViews(){
        listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.progress);
    }

    @Override public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
    }

    @Override public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override public void setItems(List<Feed> items) {
          feedAdapter = new FeedAdapter(this,0,items);
          listView.setAdapter(feedAdapter);
    }

    @Override public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.onItemClicked(position);
    }

    private Response.Listener<JSONObject> mObjectListener = new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject jsonObject) {
            //Log.i("response : ", jsonObject.toString());


            try{
                myFeeds = ConvertStringToJSON.getFeeds(jsonObject.toString(), getApplicationContext());
            }catch (JsonParseException e){
                myFeeds = null;
            }catch (JsonMappingException e){
                myFeeds = null;
            }catch (IOException e){
                myFeeds = null;
            }

            if (myFeeds != null)
                setItems(myFeeds.getFeed());
                hideProgress();
        }
    };


    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError volleyError) {

        }
    };
}
