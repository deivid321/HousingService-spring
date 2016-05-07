/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deivydas.voroneckis.housingservice.springmvc.validators;

import com.deivydas.voroneckis.domain.Room;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author vdeiv
 */
public class RoomValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return Room.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors e) {
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "street", "street.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "houseNumber", "houseNumber.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "roomNumber", "roomNumber.empty");
        Room r = (Room) o;
        if (r.getHouseNumber() < 1) {
            e.rejectValue("houseNumber", "negative or null value");
        }
        if (r.getRoomNumber() < 1) {
            e.rejectValue("roomNumber", "negative or null value");
        }
    }
}
