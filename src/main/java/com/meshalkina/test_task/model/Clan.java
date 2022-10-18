package com.meshalkina.test_task.model;

public class Clan {
    private Long id;
    private String name;
    private int gold;

    public Clan() {
    }

    public Clan(Long id, String name, int gold) {
        this.id = id;
        this.name = name;
        this.gold = gold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        return "Clan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gold=" + gold +
                '}';
    }
}
