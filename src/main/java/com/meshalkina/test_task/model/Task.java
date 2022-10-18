package com.meshalkina.test_task.model;

public class Task {

    private Long id;
    private String body;
    private String answer1;
    private String answer2;
    private String result1;
    private String result2;
    private int salary1;
    private int salary2;

    public Task() {
    }

    public Task(Long id, String body, String answer1, String answer2, String result1, String result2, int salary1, int salary2) {
        this.id = id;
        this.body = body;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.result1 = result1;
        this.result2 = result2;
        this.salary1 = salary1;
        this.salary2 = salary2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getResult1() {
        return result1;
    }

    public void setResult1(String result1) {
        this.result1 = result1;
    }

    public String getResult2() {
        return result2;
    }

    public void setResult2(String result2) {
        this.result2 = result2;
    }

    public int getSalary1() {
        return salary1;
    }

    public void setSalary1(int salary1) {
        this.salary1 = salary1;
    }

    public int getSalary2() {
        return salary2;
    }

    public void setSalary2(int salary2) {
        this.salary2 = salary2;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", result1='" + result1 + '\'' +
                ", result2='" + result2 + '\'' +
                ", salary1=" + salary1 +
                ", salary2=" + salary2 +
                '}';
    }
}
