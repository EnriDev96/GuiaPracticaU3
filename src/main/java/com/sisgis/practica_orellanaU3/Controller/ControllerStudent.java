package com.sisgis.practica_orellanaU3.Controller;

import com.sisgis.practica_orellanaU3.Service.ServiceStudent;
import com.sisgis.practica_orellanaU3.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerStudent {

    @Autowired
    private ServiceStudent serviceStudent;

    @GetMapping("/student/listar")
    public ResponseEntity<List<Student>> listStudent() {
        try {
            return new ResponseEntity<List<Student>>(serviceStudent.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/student/listar/{number_student}")
    public ResponseEntity<Student> findBysAndStudentNumber(@PathVariable("number_student") Long number_student) {
        try {
            return new ResponseEntity(serviceStudent.findByAndStudentNumber(number_student), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/student/listar/em/{email}")
    public ResponseEntity<Student> findByEmail(@PathVariable("email") String email) {
        try {
            return new ResponseEntity<>(serviceStudent.findByEmail(email), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/student/listar/gpa")
    public ResponseEntity<List<Student>> findAllByOrderByGpa() {
        try {
            return new ResponseEntity<>(serviceStudent.findAllByOrderByGpa(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping ("/student/save")
    public ResponseEntity<Student> saveOrUpdateStudent(@RequestBody Student student) {
        try {
            return new ResponseEntity<>(serviceStudent.save(student), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/student/update/{id}")
    public ResponseEntity<Student> actualizarProducto(@PathVariable String id, @RequestBody Student p) {
        Student student = serviceStudent.findById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                student.setStudentNumber(p.getStudentNumber());
                student.setName(p.getName());
                student.setEmail(p.getEmail());
                student.setCouserList(p.getCouserList());
                student.setGpa(p.getGpa());
                return new ResponseEntity<>(serviceStudent.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping(("/student/delete/{id}"))
    public ResponseEntity<?> deleteStudent(@PathVariable("id") String id) {
        try {
            serviceStudent.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}




