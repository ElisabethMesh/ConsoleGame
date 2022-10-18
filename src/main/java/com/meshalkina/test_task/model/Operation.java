package com.meshalkina.test_task.model;

import java.time.LocalDateTime;

public class Operation {

    private Long id;
    private Clan clan;
    private Hero hero;
    private String reason;
    private int sum;
    private int amountBefore;
    private int amountAfter;
    private LocalDateTime dateTime;

    public Operation() {
    }

    public Operation(Long id, Clan clan, Hero hero, String reason, int sum, int amountBefore, int amountAfter, LocalDateTime dateTime) {
        this.id = id;
        this.clan = clan;
        this.hero = hero;
        this.reason = reason;
        this.sum = sum;
        this.amountBefore = amountBefore;
        this.amountAfter = amountAfter;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getAmountBefore() {
        return amountBefore;
    }

    public void setAmountBefore(int amountBefore) {
        this.amountBefore = amountBefore;
    }

    public int getAmountAfter() {
        return amountAfter;
    }

    public void setAmountAfter(int amountAfter) {
        this.amountAfter = amountAfter;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", clan=" + clan +
                ", hero=" + hero +
                ", reason='" + reason + '\'' +
                ", sum=" + sum +
                ", amountBefore=" + amountBefore +
                ", amountAfter=" + amountAfter +
                ", dateTime=" + dateTime +
                '}';
    }
}
