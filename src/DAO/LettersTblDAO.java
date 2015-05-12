package DAO;

import Entities.Letter;
import com.sun.xml.internal.bind.v2.TODO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class LettersTblDAO extends AbstractDAO<Integer,Letter> {

    public LettersTblDAO(Connection requestedConnection) {
        setConnection(requestedConnection);
    }

    @Override
    public String getCreateRequest() {
        return null;
    }

    @Override
    public String getUpdateRequest() {
        return null;
    }

    @Override
    public String getDeleteRequest() {
        return null;
    }

    @Override
    public String getAllRequest() {
        return "SELECT * FROM letters.letterstbl;";
    }

    @Override
    public String getOneRequest() {
        return "SELECT * FROM letters.peopletbl WHERE id = ?;";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Letter object) {
        //TODO
        if (object == null) {
            throw new IllegalArgumentException("Letter cannot be null");
        }

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Letter object) {
        //TODO
    }

    @Override
    protected void prepareStatementForDelete(PreparedStatement statement, Letter object) {
        //TODO
    }

    @Override
    protected List<Letter> parseResultSet(ResultSet set) throws SQLException {
        if (set == null) {
            throw new SQLException("Request cannot be empty");
        }
        List<Letter> letters = new LinkedList<>();
        while (set.next()) {
            Letter letter = new Letter();

            letter.setId(set.getInt("letterID"));
            letter.setSenderID(set.getInt("senderID"));
            letter.setRecieverID(set.getInt("recieverID"));
            letter.setLetterText(set.getString("text"));
            letter.setLetterSubject(set.getString("subject"));
            letter.setSendDate(set.getDate("sendDate"));

            letters.add(letter);
        }
        return letters;
    }

    //TODO Send a letter with given subject to all receivers in th DB

}

