package com.meshalkina.test_task.game.service;

import com.meshalkina.test_task.util.CurrentHero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeroAddGoldService {

    OperationService operationService = new OperationService();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void addGoldToClan() {
        System.out.println("Введите сумму :");
        try {
            int gold = Integer.parseInt(br.readLine());
            operationService.createOperation("Пополнение казны игроком", gold);
            System.out.println("Вы пополнили казну на " + gold + ". Теперь баланс казны клана составляет " + CurrentHero.getClan().getGold() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException n) {
            System.out.println("Неверный формат");
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
