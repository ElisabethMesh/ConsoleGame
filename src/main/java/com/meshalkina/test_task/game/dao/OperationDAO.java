package com.meshalkina.test_task.game.dao;

import com.meshalkina.test_task.model.Clan;
import com.meshalkina.test_task.model.Hero;
import com.meshalkina.test_task.model.Operation;
import com.meshalkina.test_task.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperationDAO {

    private static Connection connection = ConnectionManager.open();

    public void save(Operation operation) {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO operations (op_clan, op_hero, reason, sum, amount_before, amount_after, date_time) VALUES(?, ?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setLong(1, operation.getClan().getId());
            preparedStatement.setLong(2, operation.getHero().getId());
            preparedStatement.setString(3, operation.getReason());
            preparedStatement.setInt(4, operation.getSum());
            preparedStatement.setInt(5, operation.getAmountBefore());
            preparedStatement.setInt(6, operation.getAmountAfter());
            preparedStatement.setTimestamp(7, Timestamp.valueOf(operation.getDateTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Operation> findAll() {
        List<Operation> result = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery
                    ("SELECT * FROM operations LEFT JOIN clans ON operations.op_clan = clans.clan_id " +
                            "LEFT JOIN heroes ON operations.op_hero = heroes.hero_id ORDER BY operations.op_id");
            while (resultSet.next()) {
                Operation operation = getOperationFromResultSet(resultSet);
                result.add(operation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Operation getOperationFromResultSet(ResultSet resultSet) throws SQLException {
        Clan clan = new Clan();
        Hero hero = new Hero();
        Operation operation = new Operation();

        clan.setId(resultSet.getLong("clan_id"));
        clan.setName(resultSet.getString("clan_name"));
        clan.setGold(resultSet.getInt("gold"));

        hero.setId(resultSet.getLong("hero_id"));
        hero.setName(resultSet.getString("hero_name"));
        hero.setClan(clan);

        operation.setId(resultSet.getLong("op_id"));
        operation.setClan(clan);
        operation.setHero(hero);
        operation.setReason(resultSet.getString("reason"));
        operation.setSum(resultSet.getInt("sum"));
        operation.setAmountBefore(resultSet.getInt("amount_before"));
        operation.setAmountAfter(resultSet.getInt("amount_after"));
        operation.setDateTime(resultSet.getTimestamp("date_time").toLocalDateTime());

        return operation;
    }
}
