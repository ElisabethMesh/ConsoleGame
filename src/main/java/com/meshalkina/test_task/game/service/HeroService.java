package com.meshalkina.test_task.game.service;

import com.meshalkina.test_task.game.dao.HeroDAO;
import com.meshalkina.test_task.util.CurrentHero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeroService {

    HeroDAO heroDAO = new HeroDAO();

    private static ClanService clanService = new ClanService();

    public void startGame() {
        System.out.println("\nЗдравствуй, путник! Как тебя зовут?");
        heroDAO.findHeroForGame().forEach(character -> {
            System.out.println(character.getId() + ". " + character.getName());
        });
        selectHero();
    }

    public void selectHero() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String answer = br.readLine();
            if (answer.equals("1") || answer.equals("2") || answer.equals("3")) {
                CurrentHero.setCurrentHero(heroDAO.findById(Long.parseLong(answer)));
            } else {
                System.out.println("Нет такого варианта");
            }
            if (CurrentHero.getCurrentHero() != null) {
                System.out.println("Вы выбрали персонажа " + CurrentHero.getCurrentHero().getName() + "\n");
                clanService.suggestClanOptions();
            } else {
                selectHero();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

