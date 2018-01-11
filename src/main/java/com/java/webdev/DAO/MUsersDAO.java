package com.java.webdev.DAO;

import com.java.webdev.Entity.MUsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by M Nurul Fikri on 07/01/2018
 */
@Repository
public interface MUsersDAO extends JpaRepository<MUsersEntity, Integer> {
    MUsersEntity findByUserName (String userName);
}
