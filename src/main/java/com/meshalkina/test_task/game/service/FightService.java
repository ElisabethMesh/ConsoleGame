package com.meshalkina.test_task.game.service;

import com.meshalkina.test_task.game.dao.HeroDAO;
import com.meshalkina.test_task.model.Hero;
import com.meshalkina.test_task.util.CurrentHero;


public class FightService {
    HeroDAO heroDAO = new HeroDAO();
    OperationService operationService = new OperationService();

    public void joinBattle() {
        Hero currentAntagonist = heroDAO.findRandomAntagonist();
        String nameAnt = currentAntagonist.getName();
        String nameHero = CurrentHero.getCurrentHero().getName();
        int gold = 0;

        System.out.println("Вас вызывает на поединок " + nameAnt + "\n");

        int userDamage = 0;
        int antDamage = 0;

        for (int i = 0; i < 3; i++) {
            try {
                int damage = (int) (Math.random() * 50);
                System.out.println(nameHero + " наносит удар! Урон " + damage);
                userDamage += damage;
                Thread.sleep(1000);
                damage = (int) (Math.random() * 50);
                System.out.println(nameAnt + " наносит ответный удар! Урон " + damage);
                antDamage += damage;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (userDamage > antDamage) {
            gold = 20;
            operationService.createOperation("Победа в бою", gold);
            System.out.println("\nПобеда! Вы заработали 20 золота. Теперь баланс казны клана составляет " + CurrentHero.getClan().getGold() + "\n");
        } else if (antDamage > userDamage) {
            System.out.println("\nВы проиграли.\n");
        } else {
            gold = 5;
            operationService.createOperation("Ничья в бою", gold);
            System.out.println("\nНичья. Все участники получают утешительные 5 золотых. Теперь баланс казны клана составляет " + CurrentHero.getClan().getGold() + "\n");
        }
    }
}
