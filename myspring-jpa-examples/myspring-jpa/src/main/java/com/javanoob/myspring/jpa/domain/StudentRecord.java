/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javanoob.myspring.jpa.domain;

import com.javanoob.myspring.jpa.domain.api.Student;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 *
 * @author ruel
 */
@Entity
@Table(name="STUDENT", schema="schl_regs")
public class StudentRecord implements Student{
    @Id
    @GeneratedValue
    @Column(name="STUD_ID")
    private Long id;
    
    @Column(name="ADDRESS")
    private String address;
    
    @Column(name="F_NAME")
    private String firstName;
    
    @Column(name="L_NAME")
    private String lastName;
    
    @Column(name="CRSE_ID")
    private Long courseId;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
    
    
}
