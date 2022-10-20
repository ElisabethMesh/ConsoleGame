package com.meshalkina.test_task.game.threads;

import com.meshalkina.test_task.game.service.HeroService;

public class ThreadGame extends Thread {

    HeroService heroService = new HeroService();

    public ThreadGame() {
        this.start();
    }

    @Override
    public void run() {
        heroService.startGame();
    }
}
