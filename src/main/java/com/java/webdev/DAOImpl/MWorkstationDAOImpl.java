package com.java.webdev.DAOImpl;

import com.java.webdev.DAO.MWorkstationDAO;
import com.java.webdev.DTO.MWorkstationDTO;
import com.java.webdev.Entity.MWorkstationEntity;
import com.java.webdev.Service.MWorkstationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by M Nurul Fikri on 11/01/2018
 */
@Service("MWorkstationService")
@Transactional
public class MWorkstationDAOImpl implements MWorkstationService{
    @Autowired
    private MWorkstationDAO mWorkstationDAO;

    public MWorkstationEntity findById (int id){
        return mWorkstationDAO.findOne(id);
    }

    public MWorkstationEntity findByWorkstation (String workstation){
        return mWorkstationDAO.findByWorkstation(workstation);
    }

    public void saveWorkstation (MWorkstationEntity mWorkstationEntity){
        mWorkstationDAO.save(mWorkstationEntity);
    }

    public void updateWorkstation (MWorkstationEntity mWorkstationEntity){
        saveWorkstation(mWorkstationEntity);
    }

    public void deleteWorkstationById (int id){
        mWorkstationDAO.delete(id);
    }

    public void deleteAllWorkstation(){
        mWorkstationDAO.deleteAll();
    }

    public List<MWorkstationEntity> findAllWorkstation(){
        return mWorkstationDAO.findAll();
    }

    public boolean isWorkstationExist(MWorkstationDTO mWorkstationDTO){
        return findByWorkstation(mWorkstationDTO.getWorkstation()) != null;
    }
}
