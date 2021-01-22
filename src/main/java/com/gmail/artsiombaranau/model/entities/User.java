package com.gmail.artsiombaranau.model.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int ID;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

}
