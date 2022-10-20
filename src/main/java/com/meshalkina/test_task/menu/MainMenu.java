package com.meshalkina.test_task.menu;

import com.meshalkina.test_task.game.service.HeroAddGoldService;
import com.meshalkina.test_task.game.service.OperationService;
import com.meshalkina.test_task.game.service.TaskService;
import com.meshalkina.test_task.game.threads.ThreadGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {
    OperationService operationService = new OperationService();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void selectAction() {
        System.out.println("Выберите действие\n" +
                "1.Начать новую игру\n" +
                "2.Информация для службы поддержки\n" +
                "3.Выход");
        callingActions();
    }

    public void callingActions() {
        try {
            String answer = br.readLine();
            if (answer.equals("1")) {
                new ThreadGame();
            } else if (answer.equals("2")) {
                operationService.viewAllOperations();
                selectAction();
            } else if (answer.equals("3")) {
                HeroAddGoldService.closeStream();
                TaskService.closeStream();
                closeStream();
                System.exit(0);
            } else {
                System.out.println("Нет такого варианта" + "\n");
                selectAction();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeStream() {
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
