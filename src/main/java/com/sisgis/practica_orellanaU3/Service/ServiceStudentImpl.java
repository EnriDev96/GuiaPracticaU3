package com.sisgis.practica_orellanaU3.Service;

import com.sisgis.practica_orellanaU3.Repository.StudentRepository;
import com.sisgis.practica_orellanaU3.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceStudentImpl extends GenericServiceImpl<Student, String> implements ServiceStudent{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public CrudRepository<Student, String> getDao() {
        return studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findByAndStudentNumber(Long number_student) {
        return studentRepository.findByAndStudentNumber(number_student);
    }

    @Override
    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public List<Student> findAllByOrderByGpa() {
        return studentRepository.findAllByOrderByGpa();
    }

}
