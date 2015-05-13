package Factory;

import DAO.LettersTblDAO;
import DAO.PeopleTblDAO;

import java.sql.Connection;
import java.sql.SQLException;


public class DbDAOFactory implements DAOFactory{
    @Override
    public Connection getConnection() throws SQLException {
        return Connector.getConnection();
    }

    @Override
    public LettersTblDAO getLettersDao() throws SQLException {
        return new LettersTblDAO(getConnection());
    }

    @Override
    public PeopleTblDAO getPeopleDao() throws SQLException {
        return new PeopleTblDAO(getConnection());
    }
}
