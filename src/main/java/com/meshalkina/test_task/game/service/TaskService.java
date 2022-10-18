package com.meshalkina.test_task.game.service;

import com.meshalkina.test_task.game.dao.TaskDAO;
import com.meshalkina.test_task.model.Task;
import com.meshalkina.test_task.util.CurrentHero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskService {
    TaskDAO taskDAO = new TaskDAO();
    Task task = new Task();
    OperationService operationService = new OperationService();

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void completeTask() {
        task = taskDAO.findRandomTask();
        System.out.println(task.getBody() + "\n" + task.getAnswer1() + "\n" + task.getAnswer2());
        selectAnswer();
    }

    public void selectAnswer() {
        int clanTreasury = CurrentHero.getClan().getGold();
        int gold = 0;

        try {
            String answer = br.readLine();
            if (answer.equals("1")) {
                System.out.println(task.getResult1() + "\n");
                gold = task.getSalary1();
                operationService.createOperation("Выполнение задания", gold);
                System.out.println("Ваша награда " + gold + ". Теперь баланс казны клана составляет " + clanTreasury + "\n");
            } else if (answer.equals("2")) {
                System.out.println(task.getResult2() + "\n");
                gold = task.getSalary2();
                operationService.createOperation("Выполнение задания", gold);
                System.out.println("Ваша награда " + gold + ". Теперь баланс казны клана составляет " + clanTreasury + "\n");
            } else {
                System.out.println("Нет такого варианта");
                selectAnswer();
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
