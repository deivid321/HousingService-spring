/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deivydas.voroneckis.housingservice.springmvc;

import com.deivydas.voroneckis.service.IHousingFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author vdeiv
 */
@Controller
@RequestMapping(value = "/contacts")
public class ContactsController {

    @Autowired
    private IHousingFacade facade;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getContacts() {
        return new ModelAndView("contacts", "contacts", null);
    }

}
