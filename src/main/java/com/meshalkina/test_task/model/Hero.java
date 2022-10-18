package com.meshalkina.test_task.model;

public class Hero {

    private Long id;
    private String name;
    private Clan clan;

    public Hero() {
    }

    public Hero(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Hero(Long id, String name, Clan clan) {
        this.id = id;
        this.name = name;
        this.clan = clan;
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

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clan=" + clan +
                '}';
    }
}
