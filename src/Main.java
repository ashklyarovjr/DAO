import DAO.AbstractDAO;
import DAO.LettersTblDAO;
import DAO.PeopleTblDAO;
import Entities.Human;
import Entities.Letter;
import Factory.DAOFactory;
import Factory.DbDAOFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Anton_Shkliarov on 5/12/2015.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        DbDAOFactory factory = new DbDAOFactory();
        LettersTblDAO lettersTblDAO = factory.getLettersDao();
        PeopleTblDAO peopleTblDAO = factory.getPeopleDao();
        Date bDate = new Date(1993, 8, 23);

        peopleTblDAO.create(new Human("Vasya", "Vaskin", "Antonovich", bDate));
        peopleTblDAO.create(new Human("Kolya", "Kolin", "Vasevich", bDate));

    }
}
