package service;

import bl.Util;
import dao.EmplProjDAO;
import entity.EmplProj;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmplProjService extends Util implements EmplProjDAO {
    @Override
    public void add(EmplProj emplProj) {
        String sql = "INSERT INTO EMPL_PROJ (EMPLOYEE_ID, PROJECT_ID) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<EmplProj> getAll() {
        List<EmplProj> result = new ArrayList<>();
        String sql = "SELECT * FROM EMPL_PROJ";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                EmplProj emplProj = new EmplProj();
                emplProj.setEmployeeId(resultSet.getLong("EMPLOYEE_ID"));
                emplProj.setProjectId(resultSet.getLong("PROJECT_ID"));

                result.add(emplProj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public EmplProj getByEmpliyeeIdAndProjectId(Long employeeId, Long projectId) {
        EmplProj result = null;
        String sql = "SELECT * FROM EMPL_PROJ WHERE EMPLOYEE_ID = ? AND PROJECT_ID = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, employeeId);
            preparedStatement.setLong(2, employeeId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                result = new EmplProj();
                result.setEmployeeId(resultSet.getLong("EMPLOYEE_ID"));
                result.setProjectId(resultSet.getLong("PROJECT_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void update(EmplProj emplProj) {
        String sql = "";
    }

    @Override
    public void remove(EmplProj emplProj) {
        String sql = "DELETE FROM EMPL_PROJ WHERE EMPLOYEE_ID = ? AND PROJECT_ID = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setLong(2, emplProj.getProjectId());
            preparedStatement.setLong(1, emplProj.getEmployeeId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
