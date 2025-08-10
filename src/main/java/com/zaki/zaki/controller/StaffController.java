package com.zaki.zaki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zaki.zaki.Constants;
import com.zaki.zaki.model.Staff;
import com.zaki.zaki.service.StaffService;

import jakarta.validation.Valid;

@Controller
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping("/")
    public String intailPage(Model model) {
        model.addAttribute("STAFF_DETAILS", Constants.STAFF_DETAILS);
        return "index";
    }
    
    @GetMapping("/" + Constants.STAFF_DETAILS)
    public String getStaffDetails(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("allStaff", staffService.getAllStaff());
        model.addAttribute("staff", staffService.getStaffById(id));
        model.addAttribute("STAFF_DETAILS", Constants.STAFF_DETAILS);
        return "staffDetailsView";
    }
    
    @PostMapping("/addNewStaff")
    public String addStaff(@Valid @ModelAttribute("staff") Staff staff, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "staffDetailsView";
        staffService.submitStaff(staff);
        return "redirect:/" + Constants.STAFF_DETAILS;
    }

    @GetMapping("/deleteStaff")
    public String deleteStaff(@RequestParam String id) {
        staffService.deleteStaff(id);
        return "redirect:/" + Constants.STAFF_DETAILS;
    }
}
