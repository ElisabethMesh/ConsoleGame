package com.meshalkina.test_task.util;

import com.meshalkina.test_task.model.Clan;
import com.meshalkina.test_task.model.Hero;

public class CurrentHero {

    private static Hero currentHero;

    public static Hero getCurrentHero() {
        return currentHero;
    }

    public static void setCurrentHero(Hero currentHero) {
        CurrentHero.currentHero = currentHero;
    }

    public static Clan getClan() {
        return currentHero.getClan();
    }

    public static void setClan(Clan clan) {
        currentHero.setClan(clan);
    }
}
