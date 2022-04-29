package edu.pro.springdemo6.form;
/*
  @author   george
  @project   spring-demo6
  @class  ItemForm
  @version  1.0.0 
  @since 08.04.22 - 21.17
*/

import edu.pro.springdemo6.model.DaysOfWeek;

import java.time.LocalDateTime;

public class ItemForm {
    private String id;
    private String name;
    private String description;
    private DaysOfWeek day;
    private String createdAt;
    private String updatedAt;


    public ItemForm() {
    }

    public DaysOfWeek getDay() {
        return day;
    }

    public void setDay(DaysOfWeek day) {
        this.day = day;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "ItemForm{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
