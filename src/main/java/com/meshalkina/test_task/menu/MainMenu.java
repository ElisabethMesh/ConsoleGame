package com.meshalkina.test_task.menu;

import com.meshalkina.test_task.game.service.HeroAddGoldService;
import com.meshalkina.test_task.game.service.HeroService;
import com.meshalkina.test_task.game.service.OperationService;
import com.meshalkina.test_task.game.service.TaskService;
import com.meshalkina.test_task.game.threads.ThreadGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {
    OperationService operationService = new OperationService();
    HeroService heroService = new HeroService();

    public void selectAction() {
        System.out.println("Выберите действие\n" +
                "1.Начать новую игру\n" +
                "2.Информация для службы поддержки\n" +
                "3.Выход");
        callingActions();
    }

    public void callingActions() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String answer = br.readLine();
            if (answer.equals("1")) {
                heroService.startGame();
            } else if (answer.equals("2")) {
                operationService.viewAllOperations();
                selectAction();
            } else if (answer.equals("3")) {
                HeroAddGoldService.closeStream();
                TaskService.closeStream();
                System.exit(0);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
