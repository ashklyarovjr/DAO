package Factory;

import DAO.AbstractDAO;
import DAO.LettersTblDAO;
import DAO.PeopleTblDAO;

import java.sql.Connection;
import java.sql.SQLException;


public interface DAOFactory {
    Connection getConnection() throws SQLException;

    LettersTblDAO getLettersDao() throws SQLException;

    PeopleTblDAO getPeopleDao() throws SQLException;
}
