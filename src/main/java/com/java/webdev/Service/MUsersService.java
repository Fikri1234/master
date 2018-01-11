package com.java.webdev.Service;

import com.java.webdev.DTO.MUsersDTO;
import com.java.webdev.Entity.MUsersEntity;

import java.util.List;

/**
 * Created by M Nurul Fikri on 07/01/2018
 */
public interface MUsersService {
    MUsersEntity findById(int id);
    MUsersEntity findByUserName(String user);
    void saveUser (MUsersEntity mUsersEntity);
    void updateUser (MUsersEntity mUsersEntity);
    void deleteUserById (int id);
    void deleteAllUser ();
    List<MUsersEntity> findAllUser();
    boolean isUserExist(MUsersDTO mUsersDTO);
}
