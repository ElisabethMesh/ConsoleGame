package com.meshalkina.test_task.game.service;

import com.meshalkina.test_task.game.dao.TaskDAO;
import com.meshalkina.test_task.model.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskService {
    TaskDAO taskDAO = new TaskDAO();
    OperationService operationService = new OperationService();

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void completeTask() {
        taskDAO.findAll().forEach(task -> {
            System.out.println(task.getId() + ". " + task.getBody());
        });
        selectAnswer();
    }

    public void selectAnswer() {
        int gold;
        Task selectedTask;

        try {
            String answer = br.readLine();
            if (answer.equals("1") || answer.equals("2") || answer.equals("3") ||
                    answer.equals("4") || answer.equals("5") || answer.equals("6")) {
                selectedTask = taskDAO.findById(Long.parseLong(answer));

                gold = selectedTask.getSalary();
                System.out.println("Ваша награда " + gold + "\n");
                operationService.createOperation("Выполнение задания", gold);
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
