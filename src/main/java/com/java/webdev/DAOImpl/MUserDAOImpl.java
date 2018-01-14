package com.java.webdev.DAOImpl;

import com.java.webdev.DAO.MUserDAO;
import com.java.webdev.DTO.MUserDTO;
import com.java.webdev.Entity.MUserEntity;
import com.java.webdev.Service.MUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by M Nurul Fikri on 07/01/2018
 */
@Service("MUserService")
@Transactional
public class MUserDAOImpl implements MUserService {

    @Autowired
    private MUserDAO mUserDAO;

    public MUserEntity findById (int id){
        return mUserDAO.findOne(id);
    }

    public MUserEntity findByUserName (String user){
        return mUserDAO.findByUserName(user);
    }

    public void saveUser (MUserEntity userEntity){
        mUserDAO.save(userEntity);
    }

    public void updateUser (MUserEntity userEntity){
        saveUser(userEntity);
    }

    public void deleteUserById (int id){
         mUserDAO.delete(id);
    }

    public void deleteAllUser(){
        mUserDAO.deleteAll();
    }

    public List<MUserEntity> findAllUser(){
        return mUserDAO.findAll();
    }

    public boolean isUserExist(MUserDTO mUserDTO){
        return findByUserName(mUserDTO.getUser_name()) != null;
    }
}
