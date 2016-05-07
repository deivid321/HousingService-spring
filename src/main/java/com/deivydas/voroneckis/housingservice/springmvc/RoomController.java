/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deivydas.voroneckis.housingservice.springmvc;

import com.deivydas.voroneckis.domain.Room;
import com.deivydas.voroneckis.domain.Student;
import com.deivydas.voroneckis.housingservice.springmvc.validators.RoomValidator;
import com.deivydas.voroneckis.service.IHousingFacade;
import com.deivydas.voroneckis.service.HousingFacade;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author vdeiv
 */
@Controller
@RequestMapping(value = "/rooms")
public class RoomController {

    @Autowired
    private IHousingFacade facade;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getHouses() {
        return new ModelAndView("rooms", "rooms", facade.getRoomsList());
    }

    @RequestMapping(value = "info/{id}", method = RequestMethod.GET)
    public ModelAndView roomInfo(@PathVariable long id) {
        return new ModelAndView("roomInfo", "room", facade.getRoom(id));
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView getNewForm() {
        ModelAndView model = new ModelAndView("roomForm", "room", new Room()).addObject("students", facade.getStudentsList());
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute("room") Room room, BindingResult result) {
        //RoomValidator roomValidator = new RoomValidator();
        //roomValidator.validate(room, result);
        if (result.hasErrors()) {
            //ModelAndView object aan
            //modelAndView.addObject("erros", result.getAllErrors()); What is it?
            System.out.print("ERROR adding");
            return "roomForm";
        }
        facade.addRoom(room);
        return "redirect:/rooms.htm";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String update(@PathVariable long id, @Valid @ModelAttribute("room") Room room, BindingResult result) {
        // RoomValidator roomValidator = new RoomValidator();
        //roomValidator.validate(room, result);
        if (result.hasErrors()) {
            System.out.print("ERRORAS updating" + result.toString());
            return "roomForm";
        }
        facade.updateRoom(room);
        return "redirect:/rooms.htm";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getEditForm(@PathVariable long id) {
        return new ModelAndView("roomUpdate", "room", facade.getRoom(id)).addObject("students", facade.getStudentsList());
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    public String remove(@ModelAttribute("room") Room room, BindingResult result) {
        if (result.hasErrors()) {
            System.out.print("ERRORAS deleteing" + result.toString());
            return "roomUpdate";
        }
        facade.removeRoom(facade.getRoom(room.getId())); //because only id given
        return "redirect:/rooms.htm";
    }

}
