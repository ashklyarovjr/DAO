package DAO;

import Entities.Entity;
import Entities.Human;
import Entities.Letter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class PeopleTblDAO extends AbstractDAO<Integer,Human> {

    public PeopleTblDAO(Connection requestedConnection) {
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
        return null;
    }

    @Override
    public String getOneRequest() {
        return "SELECT * FROM letters.peopletbl WHERE id = ?;";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Human object) {

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Human object) {

    }

    @Override
    protected void prepareStatementForDelete(PreparedStatement statement, Human object) {

    }

    @Override
    protected List<Human> parseResultSet(ResultSet set) throws SQLException {
        if (set == null) {
            throw new SQLException("Statement cannot be null");
        }
        List<Human> people = new LinkedList<>();
        while (set.next()) {
            Human human = new Human();

            human.setId(set.getInt("humanID"));
            human.setName(set.getString("hName"));
            human.setSurname(set.getString("hSurname"));
            human.setFatherName(set.getString("hFatherName"));
            human.setBirthDate(set.getDate("birthDate"));

            people.add(human);
        }
        return people;
    }


    public List<Human> getHumanWithSmallestLetter() throws SQLException {

        String request = "";

        PreparedStatement statement = getConnection().prepareStatement(request);
        ResultSet set = statement.executeQuery();
        return parseResultSet(set);
    }

    public List<Human> getPeopleAndLetters() throws SQLException {

        String request = "";
        PreparedStatement statement = getConnection().prepareStatement(request);

        ResultSet set = statement.executeQuery();
        List<Human> people = parseResultSet(set);

        for (int i = people.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (Objects.equals(people.get(i).getSurname(), people.get(j).getSurname())) {
                    people.get(i).setLettersQuantity(people.get(i).getLettersQuantity() + 1);
                    people.remove(j);
                }
            }
        }

        return people;
    }

    public List<Human> getPeopleWhoSentThatSubject(String subject) throws SQLException {

        //TODO Compose request
        String request = "";
        PreparedStatement statement = getConnection().prepareStatement(request);

        statement.setString(1, subject);

        ResultSet set = statement.executeQuery();

        return parseResultSet(set);
    }

    public List<Human> getPeopleWhoDidntRecieveThatSubject(String subject) throws SQLException {

        //TODO Compose Request
        String request = "";
        PreparedStatement statement = getConnection().prepareStatement(request);
        statement.setString(1, subject);
        ResultSet set = statement.executeQuery();

        return parseResultSet(set);
    }
}
