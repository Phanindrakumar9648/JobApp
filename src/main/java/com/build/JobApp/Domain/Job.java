package com.build.JobApp.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for PostgreSQL auto increment
        private Integer id;
        private String title;
        private String description;

    public Job() {
    }

    public Job( String title, String description) {
            this.title = title;
            this.description = description;

        }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
