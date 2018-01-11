package com.java.webdev.DAO;

import com.java.webdev.Entity.MWorkstationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by M Nurul Fikri on 09/01/2018
 */
@Repository
public interface MWorkstationDAO extends JpaRepository<MWorkstationEntity, Integer> {
    MWorkstationEntity findByWorkstation (String workstation);
}
