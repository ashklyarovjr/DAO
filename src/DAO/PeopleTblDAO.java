package DAO;

import Entities.Human;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class PeopleTblDAO extends AbstractDAO<Human> {

    public PeopleTblDAO(Connection requestedConnection) {
        setConnection(requestedConnection);
    }

    @Override
    public String getSelectRequest() {
        return "SELECT * FROM letters.peopletbl";
    }

    @Override
    public String getCreateRequest() {
        return "INSERT INTO letters.peopletbl (hName, hSurname, hFatherName, birthDate) \n" +
                "VALUES(?, ?, ?, ?)";
    }

    @Override
    public String getUpdateRequest() {
        return "UPDATE letters.peopletbl SET hName= ?, hSurname= ?, hFatherName= ?, birthDate= ? WHERE letterID= ?";
    }

    @Override
    public String getDeleteRequest() {
        return "DELETE FROM letters.peopletbl WHERE humanID= ?";
    }

    @Override
    public String getOneRequest() {
        return "SELECT * FROM letters.peopletbl WHERE humanID= ?";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Human object) {
        try {
            if (object == null) {
                throw new SQLException("Given object cannot be null");
            }

            statement.setString(1, object.getName());
            statement.setString(2, object.getSurname());
            statement.setString(3, object.getFatherName());
            statement.setDate(4, object.getBirthDate());

        } catch (SQLException e) {
            System.out.println("Cannot find the required field or type of field is incorrect");
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Human object) {
        try {
            if (object == null) {
                throw new SQLException("Given object cannot be null");
            }

            statement.setInt(1, object.getId());
            statement.setString(2, object.getName());
            statement.setString(3, object.getSurname());
            statement.setString(4, object.getFatherName());
            statement.setDate(5, (java.sql.Date) object.getBirthDate());

        } catch (SQLException e) {
            System.out.println("Cannot find the required field or type of field is incorrect");
        }
    }

    @Override
    protected void prepareStatementForDelete(PreparedStatement statement, Human object) {
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
        int max = Integer.MAX_VALUE;

        String request = "";

        PreparedStatement statement = getConnection().prepareStatement(request);
        ResultSet set = statement.executeQuery();
        //List<Human> people = parseResultSet(set);


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
