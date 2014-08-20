package com.wahyuadityanugraha.mvpexample.app.databases;

/**
 * Created by wahyuadityanugraha on 8/20/14.
 */


        import java.sql.SQLException;
        import java.util.List;
        import com.j256.ormlite.dao.Dao;
        import com.j256.ormlite.stmt.PreparedQuery;
        import com.j256.ormlite.stmt.QueryBuilder;
        import com.wahyuadityanugraha.mvpexample.app.entities.Feed;

public class RepoFeed {

    Dao<Feed, String> feedDao;

    public RepoFeed(DatabaseHelper db)
    {
        try {
            feedDao = db.getFeedDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
    }

    public int create(Feed feed)
    {
        try {
            return feedDao.create(feed);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }
    public int update(Feed feed)
    {
        try {
            return feedDao.update(feed);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }
    public int delete(Feed feed)
    {
        try {
            return feedDao.delete(feed);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }
    public Feed getByName(String username)
    {
        try {
            QueryBuilder<Feed, String> qb = feedDao.queryBuilder();

            qb.where().eq("name", username);

            PreparedQuery<Feed> pq = qb.prepare();
            return feedDao.queryForFirst(pq);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
    public List<Feed> getAll()
    {
        try {
            return feedDao.queryForAll();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

}
