package com.meshalkina.test_task;

import com.meshalkina.test_task.game.dao.HeroDAO;
import com.meshalkina.test_task.game.service.HeroService;
import com.meshalkina.test_task.game.service.OperationService;
import com.meshalkina.test_task.model.Clan;
import com.meshalkina.test_task.model.Hero;
import com.meshalkina.test_task.model.Operation;

import java.time.LocalDateTime;

public class Test extends Thread {

    HeroDAO heroDAO = new HeroDAO();
    OperationService operationService = new OperationService();

    @Override
    public void run() {
//        Hero hero1 = heroDAO.findById(4L);
//        operationService.createOperationForTest(hero1, "Победа в бою", 20);
//        Hero hero2 = heroDAO.findById(5L);
//       operationService.createOperationForTest(hero2, "Ничья в бою", 5);
    }
}


//    public void changeAmountForTest(Hero hero, int sum) {
//        clanDAO.updateGold(hero.getClan(), sum);
//        hero.setClan(clanDAO.findById(hero.getClan().getId()));
//    }
// from clan service



//    public void createOperationForTest(Hero hero, String reason, int sum) {
//        Clan currentClan = hero.getClan();
//        LocalDateTime currentDateTime = LocalDateTime.now();
//
//        Operation operation = new Operation();
//        operation.setClan(currentClan);
//        operation.setHero(hero);
//        operation.setReason(reason);
//        operation.setSum(sum);
//        operation.setAmountBefore(currentClan.getGold());
//        operation.setAmountAfter(currentClan.getGold() + sum);
//        operation.setDateTime(currentDateTime);
//        operationDAO.save(operation);
//
//        clanService.changeAmountForTest(hero, sum);
//        System.out.println("Клан " + operation.getClan().getName() + ", персонаж " + operation.getHero().getName() + " " + operation.getReason() + " " +
//                operation.getSum() + " золота.\n" + "Сумма до " + operation.getAmountBefore() + ", сумма после " + operation.getAmountAfter()
//                + ". Время " + operation.getDateTime() + "\n");
//    }
// from operation service
