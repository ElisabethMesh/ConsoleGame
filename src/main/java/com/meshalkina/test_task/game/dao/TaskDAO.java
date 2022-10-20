package com.meshalkina.test_task.game.dao;

import com.meshalkina.test_task.model.Task;
import com.meshalkina.test_task.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private static Connection connection = ConnectionManager.open();

    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery
                    ("SELECT * FROM tasks ORDER BY task_id");
            while (resultSet.next()) {
                Task task = getTaskFromResultSet(resultSet);
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public Task findById(Long id) {
        Task task = null;
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM tasks WHERE task_id=?")) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            task = getTaskFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }

    private Task getTaskFromResultSet(ResultSet resultSet) throws SQLException {
        Task task = new Task();

        task.setId(resultSet.getLong("task_id"));
        task.setBody(resultSet.getString("body"));
        task.setSalary(resultSet.getInt("salary"));

        return task;
    }
}
