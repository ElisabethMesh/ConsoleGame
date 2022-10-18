package com.meshalkina.test_task;

import com.meshalkina.test_task.game.dao.HeroDAO;
import com.meshalkina.test_task.game.service.OperationService;
import com.meshalkina.test_task.model.Hero;

public class Test2 extends Thread {
    HeroDAO heroDAO = new HeroDAO();
    OperationService operationService = new OperationService();

    @Override
    public void run() {
//        Hero hero3 = heroDAO.findById(6L);
//        operationService.createOperationForTest(hero3, "Пополнение казны игроком", 200);
//        operationService.createOperationForTest(hero3, "Выполнение задания", 10);
//        Hero hero5 = heroDAO.findById(8L);
//        operationService.createOperationForTest(hero5, "Победа в бою", 20);
//        operationService.createOperationForTest(hero5, "Выполнение задания", 10);

    }
}
