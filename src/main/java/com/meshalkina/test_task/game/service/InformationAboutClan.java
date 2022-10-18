package com.meshalkina.test_task.game.service;

import com.meshalkina.test_task.model.Clan;
import com.meshalkina.test_task.util.CurrentHero;

public class InformationAboutClan {

    public void getInformationAboutClan() {
        Clan clan = CurrentHero.getCurrentHero().getClan();
        System.out.println("Название клана " + clan.getName() + ". Золота в казне " + clan.getGold() + "\n");
    }
}
