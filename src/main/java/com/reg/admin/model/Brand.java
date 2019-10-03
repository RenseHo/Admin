package com.reg.admin.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

//@Embeddable
@Entity
public class Brand {

    @Id @GeneratedValue
    private int id;
    @Column(name = "BRAND_NAME")
    private String bName;
    @Column(name = "BRAND_COUNTRY")
    private String bCountry;
    @ManyToMany
    private Collection<Admin> adminList = new ArrayList();


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbCountry() {
        return bCountry;
    }

    public void setbCountry(String bCountry) {
        this.bCountry = bCountry;
    }

    public Collection<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(Collection<Admin> adminList) {
        this.adminList = adminList;
    }
}
