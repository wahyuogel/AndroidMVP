package com.wahyuadityanugraha.mvpexample.app.databases;

/**
 * Created by wahyuadityanugraha on 8/20/14.
 */
import com.j256.ormlite.field.DatabaseField;

public class FeedModel {

    @DatabaseField(id = true)
    private Integer id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String image;
    @DatabaseField
    private String status;
    @DatabaseField
    private String profilePic;
    @DatabaseField
    private String timeStamp;
    @DatabaseField
    private String url;


    public FeedModel(){

    }

    public FeedModel(Integer id, String name, String image, String status, String profilePic, String timeStamp, String url) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.status = status;
        this.profilePic = profilePic;
        this.timeStamp = timeStamp;
        this.url = url;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int save(Repo repo)
    {
        if(repo.Feeds.getByName(name) == null)
        {
            return repo.Feeds.create(this);
        }
        else
        {
            return repo.Feeds.update(this);
        }
    }

    public int delete(Repo repo)
    {
        return repo.Feeds.delete(this);
    }



}