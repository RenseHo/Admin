package com.reg.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;

//@Entity
public class Category {

    //@Column(name = "CATEGORY_NAME")
    private String cName;
    //@Column(name = "CATEGORY_DISCRIPTION")
    private String cDiscription;

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDiscription() {
        return cDiscription;
    }

    public void setcDiscription(String cDiscription) {
        this.cDiscription = cDiscription;
    }
}