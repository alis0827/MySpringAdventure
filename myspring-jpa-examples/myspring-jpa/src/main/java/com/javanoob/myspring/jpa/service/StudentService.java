/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javanoob.myspring.jpa.service;

import com.javanoob.myspring.jpa.domain.api.Student;
import org.springframework.stereotype.Service;

/**
 *
 * @author ruel
 */ 
public interface StudentService {
    public Student createStudent(Student student);
}
