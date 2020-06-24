package com.lindiso.black.swan.manage.users.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/*@Document(collection="Task")
@TypeAlias("task")*/
public class Task {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private long id;
    private String name;
    private String description;
    private Date dateTime;
    private String userId;

    public Task() {
    }

    public Task(long id, String name, String description, Date dateTime, String userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateTime = dateTime;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", userId='" + userId + '\'' +
                '}';
    }
}
