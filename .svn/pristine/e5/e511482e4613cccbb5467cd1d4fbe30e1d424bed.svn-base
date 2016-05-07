/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deivydas.voroneckis.housingservice.springmvc.converters;

import com.deivydas.voroneckis.domain.Student;
import com.deivydas.voroneckis.service.HousingFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


/**
 *
 * @author vdeiv
 */
public class StudentConverter implements Converter<String, Student> {
    @Autowired
    private HousingFacade housingFacade;
    @Override
    public Student convert(String id) {
        return housingFacade.getStudent(Integer.valueOf(id));
    }
}
