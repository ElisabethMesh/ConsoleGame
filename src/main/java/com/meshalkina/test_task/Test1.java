package com.meshalkina.test_task;

import com.meshalkina.test_task.game.dao.HeroDAO;
import com.meshalkina.test_task.game.service.OperationService;
import com.meshalkina.test_task.model.Hero;

public class Test1 extends Thread {

    HeroDAO heroDAO = new HeroDAO();
    OperationService operationService = new OperationService();

    @Override
    public void run() {
//        Hero hero2 = heroDAO.findById(5L);
//        operationService.createOperationForTest(hero2, "Ничья в бою", 5);
    }
}
