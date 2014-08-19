package com.wahyuadityanugraha.mvpexample.app.entities;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by miftahmubarak on 8/18/14.
 */
@JsonPropertyOrder({
        "feed"
})
public class Feeds {

    @JsonProperty("feed")
    private List<Feed> feed = new ArrayList<Feed>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("feed")
    public List<Feed> getFeed() {
        return feed;
    }

    @JsonProperty("feed")
    public void setFeed(List<Feed> feed) {
        this.feed = feed;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
