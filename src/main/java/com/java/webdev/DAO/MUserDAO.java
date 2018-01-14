package com.java.webdev.DAO;

import com.java.webdev.Entity.MUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by M Nurul Fikri on 07/01/2018
 */
@Repository
public interface MUserDAO extends JpaRepository<MUserEntity, Integer> {
    MUserEntity findByUserName (String userName);
}
