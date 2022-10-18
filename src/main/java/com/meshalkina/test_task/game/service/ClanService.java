package com.meshalkina.test_task.game.service;

import com.meshalkina.test_task.game.dao.ClanDAO;
import com.meshalkina.test_task.util.CurrentHero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClanService {

    ClanDAO clanDAO = new ClanDAO();

    private static ActivityService activityService = new ActivityService();

    public void suggestClanOptions() {
        System.out.println("Выбери клан");
        clanDAO.findAll().forEach(clan -> {
            System.out.println(clan.getId() + ". " + clan.getName());
        });
        selectClan();
    }

    public void selectClan() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String answer = br.readLine();
            if (answer.equals("1") || answer.equals("2") || answer.equals("3")) {
                CurrentHero.setClan(clanDAO.findById(Long.valueOf(answer)));
            } else {
                System.out.println("Нет такого варианта");
            }
            if (CurrentHero.getClan() != null) {
                System.out.println("Вы в клане " + CurrentHero.getClan().getName() + "\n");
                activityService.completeActivity();
            } else {
                selectClan();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void changeAmount(int sum) {
        clanDAO.updateGold(CurrentHero.getClan(), sum);
        CurrentHero.setClan(clanDAO.findById(CurrentHero.getClan().getId()));
    }
}
