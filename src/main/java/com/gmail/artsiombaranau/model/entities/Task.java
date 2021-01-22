package com.gmail.artsiombaranau.model.entities;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    private int ID;
    private int userID;
    private LocalDate createdAt;
    private String task;
}
