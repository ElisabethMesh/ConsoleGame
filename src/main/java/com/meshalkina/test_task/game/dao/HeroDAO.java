package com.meshalkina.test_task.game.dao;

import com.meshalkina.test_task.model.Clan;
import com.meshalkina.test_task.model.Hero;
import com.meshalkina.test_task.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO {
    private static Connection connection = ConnectionManager.open();

    public List<Hero> findHeroForGame() {
        List<Hero> heroes = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery
                    ("SELECT * FROM heroes LEFT JOIN clans ON heroes.clan = clans.clan_id WHERE heroes.hero_id < 4 ORDER BY heroes.hero_id");
            while (resultSet.next()) {
                Hero hero = getHeroFromResultSet(resultSet);
                heroes.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heroes;
    }

    public Hero findById(Long id) {
        Hero hero = null;
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM heroes LEFT JOIN clans ON heroes.clan = clans.clan_id WHERE heroes.hero_id=?")) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            hero = getHeroFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }

    public Hero findRandomAntagonist() {
        Hero hero = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("SELECT * FROM heroes LEFT JOIN clans ON heroes.clan = clans.clan_id WHERE heroes.hero_id > 3 ORDER BY rand()")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            hero = getHeroFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }

    private Hero getHeroFromResultSet(ResultSet resultSet) throws SQLException {
        Hero hero = new Hero();
        Clan clan = new Clan();

        clan.setId(resultSet.getLong("clan_id"));
        clan.setName(resultSet.getString("clan_name"));
        clan.setGold(resultSet.getInt("gold"));

        hero.setId(resultSet.getLong("hero_id"));
        hero.setName(resultSet.getString("hero_name"));
        hero.setClan(clan);

        return hero;
    }
}

