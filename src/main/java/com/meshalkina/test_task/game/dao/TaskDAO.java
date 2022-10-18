package com.meshalkina.test_task.game.dao;

import com.meshalkina.test_task.model.Task;
import com.meshalkina.test_task.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskDAO {
    private static Connection connection = ConnectionManager.open();

    public Task findRandomTask() {
        Task task = null;
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM tasks ORDER BY rand()")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if (resultSet.next()) {
                task = getTaskFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }

    private Task getTaskFromResultSet(ResultSet resultSet) throws SQLException {
        Task task = new Task();

        task.setId(resultSet.getLong("task_id"));
        task.setBody(resultSet.getString("body"));
        task.setAnswer1(resultSet.getString("answer1"));
        task.setAnswer2(resultSet.getString("answer2"));
        task.setResult1(resultSet.getString("result1"));
        task.setResult2(resultSet.getString("result2"));
        task.setSalary1(resultSet.getInt("salary1"));
        task.setSalary2(resultSet.getInt("salary2"));

        return task;
    }

}
