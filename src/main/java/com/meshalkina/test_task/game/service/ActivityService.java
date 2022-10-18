package com.meshalkina.test_task.game.service;

import com.meshalkina.test_task.menu.MainMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ActivityService {
    MainMenu mainMenu = new MainMenu();
    HeroAddGoldService addGoldService = new HeroAddGoldService();
    FightService fightService = new FightService();
    TaskService taskService = new TaskService();
    InformationAboutClan informationAboutClan = new InformationAboutClan();

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void completeActivity() {
        System.out.println("Что ты хочешь сделать?\n" +
                "1.Пополнить казну клана\n" +
                "2.Вступить в бой\n" +
                "3.Выполнить задание\n" +
                "4.Посмотреть информацию по клану\n" +
                "5.Вернуться в главное меню.");
        callingServices();
    }

    public void callingServices() {
        try {
            String answer = br.readLine();
            if (answer.equals("1")) {
                addGoldService.addGoldToClan();
                completeActivity();
            } else if (answer.equals("2")) {
                fightService.joinBattle();
                completeActivity();
            } else if (answer.equals("3")) {
                taskService.completeTask();
                completeActivity();
            } else if (answer.equals("4")) {
                informationAboutClan.getInformationAboutClan();
                completeActivity();
            } else if (answer.equals("5")) {
                mainMenu.selectAction();
                br.close();
            } else {
                System.out.println("Нет такого варианта");
                callingServices();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
