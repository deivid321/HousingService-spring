/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deivydas.voroneckis.housingservice.springmvc.converters;

import com.deivydas.voroneckis.domain.Room;
import com.deivydas.voroneckis.domain.Student;
import com.deivydas.voroneckis.service.HousingFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author vdeiv
 */
public class RoomConverter implements Converter<String, Room> {

    @Autowired
    private HousingFacade housingFacade;

    @Override
    public Room convert(String id) {
        if (Integer.parseInt(id) == 0) {
            Room room = new Room();
            room.setStreet("Without room");
            return room;
        }
        return housingFacade.getRoom(Integer.valueOf(id));
    }
}
