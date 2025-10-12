package com.zaki.zaki.model;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Staff {
    private String id;
    @NotBlank(message = "Name is required")
    private String name;
    @Min(value = 18, message = "Age must be at least 18")
    private int age;
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Phone is required")
    private String phone;
    @Min(value = 0, message = "Salary must be positive")
    private double salary;

    public Staff() {
        this.id = UUID.randomUUID().toString();
    }

    public Staff(String name, int age, String title, String phone, double salary) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.title = title;
        this.phone = phone;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTitle() {
        return title;
    }

    public String getPhone() {
        return phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
