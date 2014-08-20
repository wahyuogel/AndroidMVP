package com.wahyuadityanugraha.mvpexample.app.databases;

/**
 * Created by wahyuadityanugraha on 8/20/14.
 */


        import java.sql.SQLException;
        import java.util.List;
        import com.j256.ormlite.dao.Dao;
        import com.j256.ormlite.stmt.PreparedQuery;
        import com.j256.ormlite.stmt.QueryBuilder;

public class RepoFeed {

    Dao<FeedModel, String> feedDao;

    public RepoFeed(DatabaseHelper db)
    {
        try {
            feedDao = db.getFeedDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
    }

    public int create(FeedModel feed)
    {
        try {
            return feedDao.create(feed);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }
    public int update(FeedModel feed)
    {
        try {
            return feedDao.update(feed);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }
    public int delete(FeedModel feed)
    {
        try {
            return feedDao.delete(feed);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }
    public FeedModel getByName(String username)
    {
        try {
            QueryBuilder<FeedModel, String> qb = feedDao.queryBuilder();

            qb.where().eq("name", username);

            PreparedQuery<FeedModel> pq = qb.prepare();
            return feedDao.queryForFirst(pq);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
    public List<FeedModel> getAll()
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
