package com.sisgis.practica_orellanaU3.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document (collection = "students")
public class Student {
    @Id
    private String id;
    private String name;
    private Long studentNumber;
    private String email;
    private List<String> couserList;
    private Double gpa;

}
