/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javanoob.myspring.jpa.service;

import com.javanoob.myspring.jpa.domain.StudentRecord;
import com.javanoob.myspring.jpa.domain.api.Student;
import com.javanoob.myspring.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ruel
 */
@Service
public class StudentServiceImpl implements StudentService{
    
    @Autowired
    public StudentRepository studentRepository;


    @Override
    public Student createStudent(Student student) {
        StudentRecord studentRecord = new StudentRecord();
        studentRecord.setAddress(student.getAddress());
        studentRecord.setFirstName(student.getFirstName());
        studentRecord.setLastName(student.getLastName());
        return studentRepository.save(studentRecord);
    }
    
    
    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
