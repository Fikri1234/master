package com.java.webdev.Controller;

import com.java.webdev.DTO.MUserDTO;
import com.java.webdev.DTO.MWorkstationDTO;
import com.java.webdev.Entity.MUserEntity;
import com.java.webdev.Entity.MWorkstationEntity;
import com.java.webdev.Service.MUserService;
import com.java.webdev.Service.MWorkstationService;
import com.java.webdev.Util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by M Nurul Fikri on 07/01/2018
 */
@RestController
@RequestMapping("/user")
public class MUserControllerAPI {
    public static final Logger logger = LoggerFactory.getLogger(MUserControllerAPI.class);

    @Autowired
    MUserService mUserService;

    @Autowired
    MWorkstationService mWorkstationService;

    DateFormat df = new SimpleDateFormat("yyyy-MM-d HH:mm:ss");

    //     ------------ retreave all data user ---------------
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity listAllUser(){
        List<MUserEntity> users = mUserService.findAllUser();
        if (users.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        MUserDTO part;
        List<MUserDTO> listData = new ArrayList<MUserDTO>();
        for (MUserEntity model : users){
            part = new MUserDTO();
            part.setUser_id(model.getUserId());
            part.setAddress(model.getAddress());
            part.setCreated_by(model.getCreatedBy());
            part.setCreated_date(model.getCreatedDate());
            part.setStrCreated_date(df.format(part.getCreated_date()));
            part.setDivisi(model.getDivisi());
            part.setFlag(model.getFlag());
            part.setLast_update(model.getLastUpdate());
            part.setStrLast_update(df.format(part.getCreated_date()));
            part.setPassword(model.getPassword());
            part.setPosition(model.getPosition());
            part.setUpdated_by(model.getUpdatedBy());
            part.setUser_name(model.getUserName());
            part.setWorkstation_id(model.getWorkstationId());

            MWorkstationEntity mWorkstationEntity = mWorkstationService.findById(model.getWorkstationId());
            MUserEntity userUpdate = mUserService.findById(mWorkstationEntity.getUpdatedBy());
            MUserEntity userCreate = mUserService.findById(mWorkstationEntity.getCreatedBy());

            MWorkstationDTO partDtl = new MWorkstationDTO(mWorkstationEntity.getWorkstation(),userUpdate.getUserName(),userCreate.getUserName());

            part.setMWorkstation(partDtl);
            listData.add(part);
        }
        return new ResponseEntity(listData, HttpStatus.OK);
    }

    //    --------------- retreave single user ------------------
    @RequestMapping(value = "/{id}", method =  RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable("id") int id){
        logger.info("user Id: "+id);
        MUserEntity userEntity = mUserService.findById(id);
        if (userEntity == null){
            logger.error("id not found",id);
            return new ResponseEntity(new CustomErrorType("user with id "+id+" not found"), HttpStatus.NOT_FOUND);
        }
        MUserDTO mUserDTO = new MUserDTO(userEntity.getUserId(),userEntity.getUserName(),userEntity.getPassword(),userEntity.getAddress(),userEntity.getPosition(),userEntity.getDivisi(),userEntity.getFlag(),userEntity.getWorkstationId(),userEntity.getUpdatedBy(),userEntity.getLastUpdate(),userEntity.getCreatedDate(),df.format(userEntity.getLastUpdate()),df.format(userEntity.getCreatedDate()),userEntity.getCreatedBy());
        return new ResponseEntity(mUserDTO, HttpStatus.OK);
    }

    //    ------------------ create user -----------------------
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody MUserDTO mUserDTO, UriComponentsBuilder ucBuilder){
        logger.info("create user: "+ mUserDTO);

        if (mUserService.isUserExist(mUserDTO)){
            logger.error("Unable to create. A user with {} already exist", mUserDTO.getUser_name());
            return new ResponseEntity(new CustomErrorType("Unable to create. A user with "+ mUserDTO.getUser_name()+" already exist"),HttpStatus.CONFLICT);
        }

        MUserEntity mUserEntity = new MUserEntity();
        mUserEntity.setUserId(mUserDTO.getUser_id());
        mUserEntity.setUserName(mUserDTO.getUser_name());
        mUserEntity.setPassword(mUserDTO.getPassword());
        mUserEntity.setAddress(mUserDTO.getAddress());
        mUserEntity.setPosition(mUserDTO.getPosition());
        mUserEntity.setDivisi(mUserDTO.getDivisi());
        mUserEntity.setFlag("Y");
        mUserEntity.setWorkstationId(mUserDTO.getWorkstation_id());
        mUserEntity.setUpdatedBy(mUserDTO.getUpdated_by());
        mUserEntity.setLastUpdate(new Date());
        mUserEntity.setCreatedDate(new Date());
        mUserEntity.setCreatedBy(mUserDTO.getCreated_by());

        mUserService.saveUser(mUserEntity);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(mUserEntity.getUserId()).toUri());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    //    ----------------------- update user ---------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@PathVariable("id") int id, @RequestBody MUserDTO mUserDTO){
        logger.info("Updating user with id {}",id);

        MUserEntity currentUser = mUserService.findById(id);
        if (currentUser==null){
            logger.error("Unable to update. User with id {} not found",id);
            return new ResponseEntity(new CustomErrorType("Unable to update. User with id "+id+" not found"), HttpStatus.NOT_FOUND);
        }

        currentUser.setUserName(mUserDTO.getUser_name());
        currentUser.setPassword(mUserDTO.getPassword());
        currentUser.setAddress(mUserDTO.getAddress());
        currentUser.setPosition(mUserDTO.getPosition());
        currentUser.setDivisi(mUserDTO.getDivisi());
        currentUser.setWorkstationId(mUserDTO.getWorkstation_id());
        currentUser.setUpdatedBy(mUserDTO.getUpdated_by());
        currentUser.setLastUpdate(new Date());

        mUserService.updateUser(currentUser);

        return new ResponseEntity(currentUser, HttpStatus.OK);
    }

//    --------------------------- Delete user by Id --------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUserByIds(@PathVariable("id") int id) {
        logger.info("Fetching & Deleting User with id {}", id);

        MUserEntity user = mUserService.findById(id);
        if (user == null) {
            logger.error("Unable to delete. User with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        mUserService.deleteUserById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //    ----------------------------- Delete all user -----------------------------
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity<MUserEntity> deleteUser() {
        logger.info("Deleting All User");

        mUserService.deleteAllUser();
        return new ResponseEntity<MUserEntity>(HttpStatus.NO_CONTENT);
    }
}
