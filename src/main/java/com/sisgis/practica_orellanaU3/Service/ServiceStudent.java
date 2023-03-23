package com.sisgis.practica_orellanaU3.Service;

import com.sisgis.practica_orellanaU3.model.Student;

import java.util.List;

public interface ServiceStudent extends GenericService<Student, String>{
    public List<Student> findAll();

    public Student findByAndStudentNumber(Long number_student);

    public Student findByEmail(String email);

    public List<Student> findAllByOrderByGpa();

}
