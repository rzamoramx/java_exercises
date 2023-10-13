package com.ivansoft.java.exercises.sql.hibernate.models;

import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Immutable
@Getter
public class ViewExample {
    private Long id;
    private String name;
}