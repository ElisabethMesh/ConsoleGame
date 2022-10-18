package com.meshalkina.test_task.game.service;

import com.meshalkina.test_task.game.dao.OperationDAO;
import com.meshalkina.test_task.model.Clan;
import com.meshalkina.test_task.model.Hero;
import com.meshalkina.test_task.model.Operation;
import com.meshalkina.test_task.util.CurrentHero;

import java.time.LocalDateTime;


public class OperationService {

    OperationDAO operationDAO = new OperationDAO();

    private static ClanService clanService = new ClanService();

    public void createOperation(String reason, int sum) {
        Hero currentHero = CurrentHero.getCurrentHero();
        Clan currentClan = CurrentHero.getClan();
        LocalDateTime currentDateTime = LocalDateTime.now();

        Operation operation = new Operation();
        operation.setClan(currentClan);
        operation.setHero(currentHero);
        operation.setReason(reason);
        operation.setSum(sum);
        operation.setAmountBefore(currentClan.getGold());
        operation.setAmountAfter(currentClan.getGold() + sum);
        operation.setDateTime(currentDateTime);
        operationDAO.save(operation);

        clanService.changeAmount(sum);
    }

    public void viewAllOperations() {
        operationDAO.findAll().forEach(operation -> {
            System.out.println("Клан " + operation.getClan().getName() + ", персонаж " + operation.getHero().getName() + ". " + operation.getReason() +
                    ". Добавлена сумма " + operation.getSum() + " \nСумма до " + operation.getAmountBefore() +
                    ", сумма после " + operation.getAmountAfter() + ". Время " + operation.getDateTime() + "\n");
        });
    }
}
