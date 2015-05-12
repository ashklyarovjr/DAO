package DAO;

import Entities.Entity;
import Entities.Letter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Anton on 5/11/2015.
 */
public abstract class AbstractDAO<K,T extends Entity> {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * Returns SQL request to insert some element to the DB
     * Ex.: INSERT INTO [Table] ([column, column, ...]) VALUES (?, ?, ...)
     * */
    public abstract String getCreateRequest();

    /**
     * Returns SQL request to update some element in the DB
     * Ex.: UPDATE [Table] SET [column = ?, column = ?, ...] WHERE id = ?;
     * */
    public abstract String getUpdateRequest();

    /**
     * Returns SQL request to delete some element in the DB
     * Ex.:DELETE FROM [Table] WHERE id= ?;
     * */
    public abstract String getDeleteRequest();

    /**
     * Returns SQL request to get all the elements from the table
     * Ex.: SELECT * FROM [Table]
     * */
    public abstract String getAllRequest();

    /**
     * Returns SQL request to get one element by id from the table
     * Ex.: SELECT * FROM [Table] WHERE id = ?;
     * */
    public abstract String getOneRequest();

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object);

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object);

    protected abstract void prepareStatementForDelete(PreparedStatement statement, T object);

    protected abstract List<T> parseResultSet(ResultSet set) throws SQLException;

    //TODO
    T create() throws SQLException {
        return null;
    }
    //TODO
    void delete(T entity) {}
    //TODO
    void update(T entity) {}

    public T get(Integer key) throws SQLException {
        String request = getOneRequest();
        PreparedStatement statement = getConnection().prepareStatement(request);

        statement.setInt(1, key);

        ResultSet set = statement.executeQuery();
        return parseResultSet(set).get(0);
    }

    List<T> getAll() throws SQLException {
        String request = getAllRequest();
        PreparedStatement statement = getConnection().prepareStatement(request);

        ResultSet set = statement.executeQuery();
        return parseResultSet(set);
    }
}
