package com.java.webdev.Service;

import com.java.webdev.DTO.MUserDTO;
import com.java.webdev.Entity.MUserEntity;

import java.util.List;

/**
 * Created by M Nurul Fikri on 07/01/2018
 */
public interface MUserService {
    MUserEntity findById(int id);
    MUserEntity findByUserName(String user);
    void saveUser (MUserEntity mUserEntity);
    void updateUser (MUserEntity mUserEntity);
    void deleteUserById (int id);
    void deleteAllUser ();
    List<MUserEntity> findAllUser();
    boolean isUserExist(MUserDTO mUserDTO);
}
