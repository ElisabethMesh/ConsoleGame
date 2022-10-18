package com.meshalkina.test_task.game.dao;

import com.meshalkina.test_task.model.Clan;
import com.meshalkina.test_task.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClanDAO {

    private static Connection connection = ConnectionManager.open();

    public List<Clan> findAll() {
        List<Clan> clans = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clans ORDER BY clan_id;");
            while (resultSet.next()) {
                Clan clan = getClanFromResultSet(resultSet);
                clans.add(clan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clans;
    }

    public Clan findById(Long id) {
        Clan clan = null;
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM clans WHERE clan_id=?")) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            clan = getClanFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clan;
    }

    public void updateGold(Clan clan, int sum) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("UPDATE clans SET gold =? WHERE clan_id=?")) {
            preparedStatement.setInt(1, clan.getGold() + sum);
            preparedStatement.setLong(2, clan.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Clan getClanFromResultSet(ResultSet resultSet) throws SQLException {
        Clan clan = new Clan();
        clan.setId(resultSet.getLong("clan_id"));
        clan.setName(resultSet.getString("clan_name"));
        clan.setGold(resultSet.getInt("gold"));
        return clan;
    }
}
