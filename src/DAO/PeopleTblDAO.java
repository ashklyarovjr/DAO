package DAO;

import Entities.Entity;
import Entities.Human;
import Entities.Letter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Anton on 5/11/2015.
 */
public class PeopleTblDAO implements AbstractDAO<Integer, Human> {

    private final Connection connection;

    public PeopleTblDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Human create() {
        return null;
    }

    @Override
    public Human get(Integer key) throws SQLException {
        String request = "SELECT * FROM letters.peopletbl WHERE id = ?;";
        PreparedStatement statement = connection.prepareStatement(request);

        statement.setInt(1, key);

        ResultSet set = statement.executeQuery();
        set.next();
        Human human = new Human();

        human.setId(set.getInt("id"));
        human.setName(set.getString("HName"));
        human.setSurname(set.getString("HSurname"));
        human.setFatherName(set.getString("HFatherName"));
        human.setBirthDate(set.getDate("BirthDate"));

        return human;
    }

    @Override
    public void delete(Human entity) {

    }

    @Override
    public void update(Human entity) {

    }

    @Override
    public List<Human> getAll() throws SQLException {
        List<Human> people = new ArrayList<>();
        String request = "SELECT * FROM letters.peopletbl;";
        PreparedStatement statement = connection.prepareStatement(request);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Human human = new Human();

            human.setId(set.getInt("id"));
            human.setName(set.getString("HName"));
            human.setSurname(set.getString("HSurname"));
            human.setFatherName(set.getString("HFatherName"));
            human.setBirthDate(set.getDate("BirthDate"));

            people.add(human);
        }
        return people;
    }

    public List<Human> getHumanWithSmallestLetter() throws SQLException {
        List<Human> people = new ArrayList<>();
        String request = "";
        PreparedStatement statement = connection.prepareStatement(request);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Human human = new Human();

            human.setId(set.getInt("id"));
            human.setName(set.getString("HName"));
            human.setSurname(set.getString("HSurname"));
            human.setFatherName(set.getString("HFatherName"));
            human.setBirthDate(set.getDate("BirthDate"));

            people.add(human);
        }
        return people;
    }

    public List<Human> getPeopleAndLetters() throws SQLException {
        List<Human> people = new ArrayList<>();
        String request = "";
        PreparedStatement statement = connection.prepareStatement(request);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Human human = new Human();

            human.setId(set.getInt("id"));
            human.setName(set.getString("HName"));
            human.setSurname(set.getString("HSurname"));
            human.setFatherName(set.getString("HFatherName"));
            human.setBirthDate(set.getDate("BirthDate"));
            human.setLettersQuantity(1);

            people.add(human);
        }
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
        List<Human> people = new ArrayList<>();
        String request = "";
        PreparedStatement statement = connection.prepareStatement(request);
        statement.setString(1, subject);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Human human = new Human();

            human.setId(set.getInt("id"));
            human.setName(set.getString("HName"));
            human.setSurname(set.getString("HSurname"));
            human.setFatherName(set.getString("HFatherName"));
            human.setBirthDate(set.getDate("BirthDate"));
            human.setLettersQuantity(1);

            people.add(human);
        }
        return people;
    }

    public List<Human> getPeopleWhoDidntRecieveThatSubject(String subject) throws SQLException {
        List<Human> people = new ArrayList<>();
        String request = "";
        PreparedStatement statement = connection.prepareStatement(request);
        statement.setString(1, subject);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Human human = new Human();

            human.setId(set.getInt("id"));
            human.setName(set.getString("HName"));
            human.setSurname(set.getString("HSurname"));
            human.setFatherName(set.getString("HFatherName"));
            human.setBirthDate(set.getDate("BirthDate"));
            human.setLettersQuantity(1);

            people.add(human);
        }
        return people;
    }
}
