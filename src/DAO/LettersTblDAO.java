package DAO;

import Entities.Letter;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class LettersTblDAO extends AbstractDAO<Letter> {

    public LettersTblDAO(Connection requestedConnection) {
        setConnection(requestedConnection);
    }

    @Override
    public String getSelectRequest() {
        return "SELECT * FROM letters.letterstbl";
    }

    @Override
    public String getCreateRequest() {
        return "INSERT INTO letters.letterstbl (senderID, recieverID, subject, text, sendDate) \n" +
                "VALUES(?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateRequest() {
        return "UPDATE letters.letterstbl SET senderID= ?, recieverID= ?, subject= ?, text= ?, sendDate= ? WHERE letterID= ?";
    }

    @Override
    public String getDeleteRequest() {
        return "DELETE FROM letters.letterstbl WHERE letterID= ?";
    }

    @Override
    public String getOneRequest() {
        return "SELECT * FROM letters.peopletbl WHERE id = ?;";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Letter object) {
        try {
            if (object == null) {
                throw new SQLException("Given object cannot be null");
            }
            statement.setInt(1, object.getSenderID());
            statement.setInt(2, object.getReceiverID());
            statement.setString(3, object.getLetterSubject());
            statement.setString(4, object.getLetterText());
            statement.setDate(5, (Date) object.getSendDate());
        } catch (SQLException e) {
            System.out.println("Cannot find the required field or type of field is incorrect");
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Letter object) {
        try {
            if (object == null) {
                throw new SQLException("Given object cannot be null");
            }
            statement.setInt(6, object.getId());
            statement.setInt(1, object.getSenderID());
            statement.setInt(2, object.getReceiverID());
            statement.setString(3, object.getLetterSubject());
            statement.setString(4, object.getLetterText());
            statement.setDate(5, (Date) object.getSendDate());
        } catch (SQLException e) {
            System.out.println("Cannot find the required field or type of field is incorrect");
        }
    }

    @Override
    protected void prepareStatementForDelete(PreparedStatement statement, Letter object) {
        try {
            if (object == null) {
                throw new SQLException("Given object cannot be null");
            }
            statement.setInt(1, object.getId());
        } catch (SQLException e) {
            System.out.println("Cannot find the required field or type of field is incorrect");
        }
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
            letter.setReceiverID(set.getInt("recieverID"));
            letter.setLetterText(set.getString("text"));
            letter.setLetterSubject(set.getString("subject"));
            letter.setSendDate(set.getDate("sendDate"));

            letters.add(letter);
        }
        return letters;
    }

    //TODO Send a letter with given subject to all receivers in th DB

}

