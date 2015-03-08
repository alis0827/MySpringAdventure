/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javanoob.myspring.jpa.main;

import com.javanoob.myspring.jpa.context.AppContext;
import com.javanoob.myspring.jpa.domain.StudentRecord;
import com.javanoob.myspring.jpa.domain.api.Student;
import com.javanoob.myspring.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ruel
 */
public class App {
    private static StudentService studentService;
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppContext.class);
        ctx.refresh();
        
        studentService = (StudentService) ctx.getBean("studentServiceImpl");
        
        Student student = new Student() {

            @Override
            public Long getId() {
              return null;
             }

            @Override
            public String getLastName() {
               return "Santiago";
            }

            @Override
            public String getFirstName() {
                return "Ruel";
            }

            @Override
            public String getAddress() {
                return "Merrillville IN";
            }

            @Override
            public Long getCourseId() {
                return 125L;
            }       
        };
        

        studentService.createStudent(student);
    }
}
