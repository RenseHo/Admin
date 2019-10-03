package com.reg.admin.model;

import javax.persistence.*;
import java.util.*;


@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    //@OneToMany(mappedBy = "admin")
    //@JoinColumn(name = "ADMIN_BRAND")
/*    @JoinTable(name = "ADMIN_BRAND",
            joinColumns = @JoinColumn(name="ADMIN_IDS"),
        inverseJoinColumns = @JoinColumn(name = "BRAND_IDS")
    )
*/
    @ManyToMany
    private Collection<Brand> brandList = new ArrayList();

    @Temporal(TemporalType.DATE)
    private Date registrationDate;
    private String description;

    public Admin () {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(Collection<Brand> brandList) {
        this.brandList = brandList;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                ", description='" + description + '\'' +
                '}';
    }

    /*
        @Embedded
    Category category;
        @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="cName", column=@Column(name = "SUB_CAT_NAME")),
        @AttributeOverride(name="cDiscription", column=@Column(name = "SUB_CAT_DESRIPTION"))
    })
    Category sub_category;

        @ElementCollection
    @JoinTable(name = "ADMIN_BRAND", joinColumns = @JoinColumn(name = "PRODUCT_ID")
    )
    private Collection<Brand> listOfBrands =  new ArrayList<Brand>();

     */
}
