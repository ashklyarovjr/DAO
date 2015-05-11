package Factory;

import DAO.AbstractDAO;
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
    public AbstractDAO getLettersDao(Connection connection) throws SQLException {
        return new LettersTblDAO(getConnection());
    }

    @Override
    public AbstractDAO getPeopleDao(Connection connection) throws SQLException {
        return new PeopleTblDAO(getConnection());
    }
}
