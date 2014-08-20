package com.wahyuadityanugraha.mvpexample.app.server;

import android.content.Context;

import com.wahyuadityanugraha.mvpexample.app.databases.Repo;
import com.wahyuadityanugraha.mvpexample.app.entities.Feeds;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by wahyuadityanugraha on 8/19/14.
 */
public class ConvertStringToJSON {
        public static Feeds getFeeds(String json, Context context) throws  JsonParseException, JsonMappingException, IOException{
            Feeds mFeeds = new ObjectMapper().readValue(json, Feeds.class);
            return mFeeds;
        }
}
