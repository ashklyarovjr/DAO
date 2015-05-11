package Factory;

import DAO.AbstractDAO;
import DAO.LettersTblDAO;
import DAO.PeopleTblDAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Anton on 5/11/2015.
 */
public interface DAOFactory {
    Connection getConnection() throws SQLException;

    AbstractDAO getLettersDao(Connection connection) throws SQLException;

    AbstractDAO getPeopleDao(Connection connection) throws SQLException;
}
