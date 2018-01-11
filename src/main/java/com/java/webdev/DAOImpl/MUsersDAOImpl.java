package com.java.webdev.DAOImpl;

import com.java.webdev.DAO.MUsersDAO;
import com.java.webdev.DTO.MUsersDTO;
import com.java.webdev.Entity.MUsersEntity;
import com.java.webdev.Service.MUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by M Nurul Fikri on 07/01/2018
 */
@Service("MUsersService")
@Transactional
public class MUsersDAOImpl implements MUsersService{

    @Autowired
    private MUsersDAO mUsersDAO;

    public MUsersEntity findById (int id){
        return mUsersDAO.findOne(id);
    }

    public MUsersEntity findByUserName (String user){
        return mUsersDAO.findByUserName(user);
    }

    public void saveUser (MUsersEntity usersEntity){
        mUsersDAO.save(usersEntity);
    }

    public void updateUser (MUsersEntity usersEntity){
        saveUser(usersEntity);
    }

    public void deleteUserById (int id){
         mUsersDAO.delete(id);
    }

    public void deleteAllUser(){
        mUsersDAO.deleteAll();
    }

    public List<MUsersEntity> findAllUser(){
        return mUsersDAO.findAll();
    }

    public boolean isUserExist(MUsersDTO mUsersDTO){
        return findByUserName(mUsersDTO.getUser_name()) != null;
    }
}
