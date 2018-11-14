package com.reg.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.reg.admin.model.*;
import com.reg.admin.services.*;


@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class AdminController {

    @Autowired private AdminService adminService;

    @ResponseBody
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public int create(@RequestBody Admin admin) {
        return adminService.save(admin).getId();
    }

    @ResponseBody
    @RequestMapping(value = "/admin/{id}", method = RequestMethod.POST)
    public int create(@PathVariable int id, @RequestBody Admin admin) {
        return adminService.save(admin).getId();
    }

    @ResponseBody
    @RequestMapping(value = "/admin/{id}", method = RequestMethod.PUT)
    public int updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
        return adminService.save(admin).getId();
    }

    //curl -X DELETE http://localhost:8080/admin/1
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/admin/{id}", method = RequestMethod.DELETE)
    public void updateAdmin(@PathVariable  int id ) { adminService.deleteById(id); }

    //curl  http://localhost:8080/admin
    @ResponseBody
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public List<Admin> findAll() { return (List<Admin>)adminService.findAll(); }

    //curl  http://localhost:8080/todo/1
    @ResponseBody
    @RequestMapping(value = "/admin/{id}", method = RequestMethod.GET)
    public Optional<Admin> adminById(@PathVariable  int id) { return  adminService.findById(id); }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String page() {
        return "admin";
    }

}
