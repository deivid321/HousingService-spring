/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deivydas.voroneckis.housingservice.springmvc;

import com.deivydas.voroneckis.domain.Room;
import com.deivydas.voroneckis.domain.Student;
import com.deivydas.voroneckis.service.IHousingFacade;
import java.util.List;
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
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private IHousingFacade facade;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getStudents() {
        return new ModelAndView("students", "students", facade.getStudentsList());
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView getNewForm() {
        List<Room> roomList = facade.getRoomsList();
        addEmptyOptionToRoomList(roomList);
        return new ModelAndView("studentForm", "student", new Student()).addObject("rooms", roomList);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            //ModelAndView object aan
            //modelAndView.addObject("erros", result.getAllErrors()); What is it?
            return "studentForm";
        }
        Room room = student.getRoom();
        if (room != null && room.getStreet().equals("Without room")) {
            student.setRoom(null);
        }
        facade.addStudent(student);
        return "redirect:/students.htm";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            //return  new ModelAndView("studentForm", "rooms", roomList);
            return "studentForm";
        }
        Room room = student.getRoom();
        if (room != null && room.getStreet().equals("Without room")) {
            student.setRoom(null);
        }   
        facade.updateStudent(student);
        return "redirect:/students.htm";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getEditForm(@PathVariable long id) {
        List<Room> roomList = facade.getRoomsList();
        addEmptyOptionToRoomList(roomList);
        return new ModelAndView("studentUpdate", "student", facade.getStudent(id)).addObject("rooms", roomList);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    public String remove(@ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            //ModelAndView object aan
            //modelAndView.addObject("erros", result.getAllErrors()); What is it?
            return "studentUpdate";
        }
        facade.removeStudent(facade.getStudent(student.getId()));
        return "redirect:/students.htm";
    }
    
    //****
    void addEmptyOptionToRoomList(List<Room> roomList){
        Room room = new Room();
        room.setId(new Long(0));
        room.setStreet("Without room");
        roomList.add(room);
    }
}
