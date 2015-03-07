/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javanoob.myspring.jpa.domain.api;

/**
 *
 * @author ruel
 */
public interface Student {
    Long getId();
    String getLastName();
    String getFirstName();
    String getAddress();
    Long getCourseId();
}
