package com.java.webdev.Service;

import com.java.webdev.DTO.MWorkstationDTO;
import com.java.webdev.Entity.MWorkstationEntity;

import java.util.List;

/**
 * Created by M Nurul Fikri on 10/01/2018
 */
public interface MWorkstationService {
    MWorkstationEntity findById(int id);
    MWorkstationEntity findByWorkstation(String workstation);
    void saveWorkstation (MWorkstationEntity mWorkstationEntity);
    void updateWorkstation (MWorkstationEntity mWorkstationEntity);
    void deleteWorkstationById (int id);
    void deleteAllWorkstation ();
    List<MWorkstationEntity> findAllWorkstation();
    boolean isWorkstationExist(MWorkstationDTO mWorkstationDTO);
}
