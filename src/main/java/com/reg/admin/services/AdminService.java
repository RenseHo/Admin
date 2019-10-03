package com.reg.admin.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reg.admin.model.*;

@Repository
public interface AdminService extends CrudRepository<Admin, Integer> {


}
