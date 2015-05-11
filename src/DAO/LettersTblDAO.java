package DAO;

import Entities.Letter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 5/11/2015.
 */
public class LettersTblDAO implements AbstractDAO<Integer, Letter> {

    private final Connection connection;

    public LettersTblDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Letter create() {
        return null;
    }

    @Override
    public Letter get(Integer key) throws SQLException {
        String request = "SELECT * FROM letters.peopletbl WHERE id = ?;";
        PreparedStatement statement = connection.prepareStatement(request);

        statement.setInt(1, key);

        ResultSet set = statement.executeQuery();
        set.next();
        Letter letter = new Letter();

        letter.setId(set.getInt("id"));
        letter.setSender(set.getString("SenderName"));
        letter.setReciever(set.getString("RecieverName"));
        letter.setLetterText(set.getString("TextOfLetter"));
        letter.setLetterSubject(set.getString("LetterSubject"));
        letter.setSendDate(set.getDate("SendDate"));

        return letter;
    }

    @Override
    public void delete(Letter entity) {

    }

    @Override
    public void update(Letter entity) {

    }

    @Override
    public List<Letter> getAll() throws SQLException {
        List<Letter> letters = new ArrayList<>();
        String request = "SELECT * FROM letters.letterstbl;";
        PreparedStatement statement = connection.prepareStatement(request);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Letter letter = new Letter();

            letter.setId(set.getInt("id"));
            letter.setSender(set.getString("SenderName"));
            letter.setReciever(set.getString("RecieverName"));
            letter.setLetterText(set.getString("TextOfLetter"));
            letter.setLetterSubject(set.getString("LetterSubject"));
            letter.setSendDate(set.getDate("SendDate"));

            letters.add(letter);
        }

        return letters;
    }
}
