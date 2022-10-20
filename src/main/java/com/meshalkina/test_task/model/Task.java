package com.meshalkina.test_task.model;

public class Task {

    private Long id;
    private String body;
    private int salary;

    public Task() {
    }

    public Task(Long id, String body, int salary) {
        this.id = id;
        this.body = body;
        this.salary = salary;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", salary=" + salary +
                '}';
    }
}
