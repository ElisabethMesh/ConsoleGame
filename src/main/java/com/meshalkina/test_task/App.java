package com.meshalkina.test_task;

import com.meshalkina.test_task.menu.MainMenu;

public class App {
    private static MainMenu mainMenu = new MainMenu();

    public static void main(String[] args) {
        mainMenu.selectAction();
    }
}