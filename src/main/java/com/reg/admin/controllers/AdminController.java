package com.reg.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.reg.admin.model.*;
import com.reg.admin.services.*;


@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private BrandServices brandService;

    @ResponseBody
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public int create(@RequestBody Admin admin) { return adminService.save(admin).getId(); }

    @ResponseBody
    @RequestMapping(value = "/ad", method = RequestMethod.POST)
    public long createNew() {

        Admin admin1 = new Admin();
        admin1.setName("Personen auto");
        admin1.setRegistrationDate(new Date());
        admin1.setDescription("Ding op 4 wielen");
        adminService.save(admin1);

        Admin admin2 = new Admin();
        admin2.setName("Vracht auto");
        admin2.setRegistrationDate(new Date());
        admin2.setDescription("Ding op 8 wielen");
        adminService.save(admin2);

        Brand brand1 = new Brand();
        brand1.setbName("BMW wielen");
        brand1.setbCountry("Nederland");
        admin1.getBrandList().add(brand1);
        brand1.getAdminList().add(admin1);
        brandService.save(brand1);

        Brand brand2 = new Brand();
        brand2.setbName("Audi Wielen");
        brand2.setbCountry("Duitsland");
        admin1.getBrandList().add(brand2);
        brand2.getAdminList().add(admin1);
        brandService.save(brand2);

        //admin1.setBrand(brand1);

        long before = adminService.count();
        //adminService.save(admin2);
        long after = adminService.count();
        //String uit = System.out.println("Before : " +before+ " and After : "+after);
        return adminService.count();
    }


    @ResponseBody
    @RequestMapping(value = "/admin/{id}", method = RequestMethod.POST)
    public int create(@PathVariable int id, @RequestBody Admin admin) {
       return adminService.save(admin).getId();
    }

    /*
    @ResponseBody
    @RequestMapping(value = "/admin/{id}", method = RequestMethod.POST)
    public int create(@PathVariable int id, @RequestBody Admin adm) {


        Admin admin = new Admin();
        //admin.setId(1);
        //admin.setName("Auto");
        //admin.setCategory("Produkten");

        return adminService.save(admin).getId();
    }
    */

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

            /*
        Admin admin1 = new Admin();
        admin1.setName("Auto");
        admin1.setRegistrationDate(new Date());
        admin1.setDescription("Ding op 4 wielen");
        Brand brand1 = new Brand();
        brand1.setbName("Ford");
        brand1.setbCountry("Engeland");
        Brand brand2 = new Brand();
        brand2.setbName("Audi");
        brand2.setbCountry("Duitsland");
        admin1.getListOfBrands().add(brand1);
        admin1.getListOfBrands().add(brand2);

        Admin admin2 = new Admin();
        admin2.setName("Fiets");
        admin2.setRegistrationDate(new Date());
        admin2.setDescription("Ding op 2 wielen");
        Category category2 = new Category();
        category2.setcName("Produkten");
        category2.setcDiscription("Fysieke apparaten");
        admin2.setHoofd_category(category2);
        admin2.setSub_category(category2);
        */

}
