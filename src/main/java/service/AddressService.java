package service;

import bl.Util;
import dao.AddressDAO;
import entity.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressService extends Util implements AddressDAO {
    public void add(Address address) {
        String sql = "INSERT INTO ADDRESS (ID, COUNTRY, CITY, STREET, POST_CODE) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setLong(1, address.getId());
            preparedStatement.setString(2, address.getCountry());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getStreet());
            preparedStatement.setString(5, address.getPostCode());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Address> getAll() {
        List<Address> result = new ArrayList<>();

        String sql = "SELECT * FROM ADDRESS";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Address address = new Address();
                address.setId(resultSet.getLong("ID"));
                address.setCountry(resultSet.getString("COUNTRY"));
                address.setCity(resultSet.getString("CITY"));
                address.setStreet(resultSet.getString("STREET"));
                address.setPostCode(resultSet.getString("POST_CODE"));

                result.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public Address getById(Long id) {
        Address result = null;
        String sql = "SELECT * FROM ADDRESS WHERE ID = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                result = new Address();

                result.setId(resultSet.getLong("ID"));
                result.setCountry(resultSet.getString("COUNTRY"));
                result.setCity(resultSet.getString("CITY"));
                result.setStreet(resultSet.getString("STREET"));
                result.setPostCode(resultSet.getString("POST_CODE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void update(Address address) {
        String sql = "UPDATE ADDRESS SET COUNTRY = ?, CITY = ?, STREET = ?, POST_CODE = ? WHERE ID = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getPostCode());
            preparedStatement.setLong(5, address.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(Address address) {
        String sql = "DELETE FROM ADDRESS WHERE ID = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, address.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
