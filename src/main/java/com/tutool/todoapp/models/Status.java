package com.tutool.todoapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Status {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long statusId;
    private String description;
}
