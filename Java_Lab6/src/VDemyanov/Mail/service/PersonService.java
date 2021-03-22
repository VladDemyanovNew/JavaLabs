package VDemyanov.Mail.service;

import VDemyanov.Mail.bl.Util;
import VDemyanov.Mail.dao.PersonDAO;
import VDemyanov.Mail.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonService extends Util implements PersonDAO {
    Connection connection = getConnection();

    /**
     * Вывести информацию о пользователях, которые получили хотя бы
     * одно сообщение с заданной темой
     * @param topic
     */
    @Override
    public void printInfo2(String topic) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT DISTINCT Person.Id, Person.Birthday, Person.Name " +
                " FROM Letter " +
                " JOIN Person ON Letter.Recipient = Person.Id " +
                " WHERE Letter.Topic = ?; ";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, topic);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(
                        "Person{" +
                                "id=" + resultSet.getInt("Id") +
                                ", name='" + resultSet.getString("Name") + '\'' +
                                ", birthday=" + resultSet.getDate("Birthday") +
                                '}'
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * Вывести информацию о пользователях, которые не получали
     * сообщения с заданной темой
     * @param topic
     */
    @Override
    public void printInfo3(String topic) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = " SELECT * FROM Person " +
                " WHERE Person.Id NOT IN ( " +
                " SELECT DISTINCT Person.Id FROM Letter " +
                " JOIN Person ON Person.Id = Letter.Recipient " +
                " WHERE Topic = ?); ";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, topic);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(
                        "Person{" +
                                "id=" + resultSet.getInt("Id") +
                                ", name='" + resultSet.getString("Name") + '\'' +
                                ", birthday=" + resultSet.getDate("Birthday") +
                                '}'
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * Находит пользователя у которого меньше всего писем
     * @return
     * @throws SQLException
     */
    @Override
    public Person getByFewestLetters() throws SQLException {
        String sql = "SELECT *, (SELECT COUNT(*) FROM Letter WHERE Sender = Person.Id OR Recipient = Person.Id) AS COUNT " +
                " FROM Person " +
                " ORDER BY COUNT " +
                " LIMIT 1 ";
        Person person = new Person();
        Statement statement = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                person.setId(resultSet.getInt("Id"));
                person.setBirthday(resultSet.getDate("Birthday"));
                person.setName(resultSet.getString("Name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return person;
    }

    /**
     * Выводит информацию о пользователях, а также количестве
     * полученных и отправленных ими письмах.
     * @throws SQLException
     */
    @Override
    public void printInfo1() throws SQLException {
        String sql = "SELECT *, " +
                " (SELECT COUNT(*) FROM Letter WHERE Sender = Person.Id) AS Sent, " +
                " (SELECT COUNT(*) FROM Letter WHERE Recipient = Person.Id) AS Received " +
                " FROM Person;";
        Statement statement = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                System.out.println(
                        "Person{" +
                                "id=" + resultSet.getInt("Id") +
                                ", name='" + resultSet.getString("Name") + '\'' +
                                ", birthday=" + resultSet.getDate("Birthday") + '\'' +
                                ", sent='" + resultSet.getInt("Sent") + '\'' +
                                ", received='" + resultSet.getInt("Received") +
                                '}'
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * Добавляет пользователя в БД
     * @param person
     * @throws SQLException
     */
    @Override
    public void add(Person person) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO Person (Id, Name, Birthday) VALUES (?, ?, ?)";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setDate(3, person.getBirthday());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    /**
     * Возвращает всех пользователей из БД
     * @return
     * @throws SQLException
     */
    @Override
    public List<Person> getAll() throws SQLException {
        String sql = "SELECT * FROM Person";
        List<Person> people = new ArrayList<Person>();
        Statement statement = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Person person = new Person(
                        resultSet.getInt("Id"),
                        resultSet.getString("Name"),
                        resultSet.getDate("Birthday")
                );

                people.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return people;
    }

    /**
     * Возврщает пользователя из БД по заданному id
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Person getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Person person = new Person();
        String sql = "SELECT * FROM Person WHERE Id = ?";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                person.setId(resultSet.getInt("Id"));
                person.setName(resultSet.getString("Name"));
                person.setBirthday(resultSet.getDate("Birthday"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return person;
    }

    /**
     * Обновляет пользователя в БД
     * @param person
     * @throws SQLException
     */
    @Override
    public void update(Person person) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE Person SET Name = ?, Birthday = ? WHERE Id = ?";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setDate(2, person.getBirthday());
            preparedStatement.setInt(3, person.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * Удаляет пользователя из БД
     * @param person
     * @throws SQLException
     */
    @Override
    public void remove(Person person) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM Person WHERE Id = ?";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, person.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

}
