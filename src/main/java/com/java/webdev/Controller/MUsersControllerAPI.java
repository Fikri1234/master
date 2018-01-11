package com.java.webdev.Controller;

import com.java.webdev.DTO.MUsersDTO;
import com.java.webdev.DTO.MWorkstationDTO;
import com.java.webdev.Entity.MUsersEntity;
import com.java.webdev.Entity.MWorkstationEntity;
import com.java.webdev.Service.MUsersService;
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
public class MUsersControllerAPI {
    public static final Logger logger = LoggerFactory.getLogger(MUsersControllerAPI.class);

    @Autowired
    MUsersService mUsersService;

    @Autowired
    MWorkstationService mWorkstationService;

    DateFormat df = new SimpleDateFormat("yyyy-MM-d HH:mm:ss");

    //     ------------ retreave all data users ---------------
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity listAllUser(){
        List<MUsersEntity> users = mUsersService.findAllUser();
        if (users.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        MUsersDTO part;
        List<MUsersDTO> listData = new ArrayList<MUsersDTO>();
        for (MUsersEntity model : users){
            part = new MUsersDTO();
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
            part.setUpdate_by(model.getUpdateBy());
            part.setUser_name(model.getUserName());
            part.setWorkstation_id(model.getWorkstationId());

            MWorkstationEntity mWorkstationEntity = mWorkstationService.findById(model.getWorkstationId());
            MUsersEntity userUpdate = mUsersService.findById(mWorkstationEntity.getUpdateBy());
            MUsersEntity usersCreate = mUsersService.findById(mWorkstationEntity.getCreatedBy());

            MWorkstationDTO partDtl = new MWorkstationDTO(mWorkstationEntity.getWorkstation(),userUpdate.getUserName(),usersCreate.getUserName());

            part.setMWorkstation(partDtl);
            listData.add(part);
        }
        return new ResponseEntity(listData, HttpStatus.OK);
    }

    //    --------------- retreave single user ------------------
    @RequestMapping(value = "/{id}", method =  RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable("id") int id){
        logger.info("user Id: "+id);
        MUsersEntity usersEntity = mUsersService.findById(id);
        if (usersEntity == null){
            logger.error("id not found",id);
            return new ResponseEntity(new CustomErrorType("user with id "+id+" not found"), HttpStatus.NOT_FOUND);
        }
        MUsersDTO mUsersDTO = new MUsersDTO(usersEntity.getUserId(),usersEntity.getUserName(),usersEntity.getPassword(),usersEntity.getAddress(),usersEntity.getPosition(),usersEntity.getDivisi(),usersEntity.getFlag(),usersEntity.getWorkstationId(),usersEntity.getUpdateBy(),usersEntity.getLastUpdate(),usersEntity.getCreatedDate(),df.format(usersEntity.getLastUpdate()),df.format(usersEntity.getCreatedDate()),usersEntity.getCreatedBy());
        return new ResponseEntity(mUsersDTO, HttpStatus.OK);
    }

    //    ------------------ create user -----------------------
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody MUsersDTO mUsersDTO, UriComponentsBuilder ucBuilder){
        logger.info("create user: "+mUsersDTO);

        if (mUsersService.isUserExist(mUsersDTO)){
            logger.error("Unable to create. A user with {} already exist", mUsersDTO.getUser_name());
            return new ResponseEntity(new CustomErrorType("Unable to create. A user with "+mUsersDTO.getUser_name()+" already exist"),HttpStatus.CONFLICT);
        }

        MUsersEntity mUsersEntity = new MUsersEntity();
        mUsersEntity.setUserId(mUsersDTO.getUser_id());
        mUsersEntity.setUserName(mUsersDTO.getUser_name());
        mUsersEntity.setPassword(mUsersDTO.getPassword());
        mUsersEntity.setAddress(mUsersDTO.getAddress());
        mUsersEntity.setPosition(mUsersDTO.getPosition());
        mUsersEntity.setDivisi(mUsersDTO.getDivisi());
        mUsersEntity.setFlag("Y");
        mUsersEntity.setWorkstationId(mUsersDTO.getWorkstation_id());
        mUsersEntity.setUpdateBy(mUsersDTO.getUpdate_by());
        mUsersEntity.setLastUpdate(new Date());
        mUsersEntity.setCreatedDate(new Date());
        mUsersEntity.setCreatedBy(mUsersDTO.getCreated_by());

        mUsersService.saveUser(mUsersEntity);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(mUsersEntity.getUserId()).toUri());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    //    ----------------------- update user ---------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@PathVariable("id") int id, @RequestBody MUsersDTO mUsersDTO){
        logger.info("Updating user with id {}",id);

        MUsersEntity currentUser = mUsersService.findById(id);
        if (currentUser==null){
            logger.error("Unable to update. User with id {} not found",id);
            return new ResponseEntity(new CustomErrorType("Unable to update. User with id "+id+" not found"), HttpStatus.NOT_FOUND);
        }

        currentUser.setUserName(mUsersDTO.getUser_name());
        currentUser.setPassword(mUsersDTO.getPassword());
        currentUser.setAddress(mUsersDTO.getAddress());
        currentUser.setPosition(mUsersDTO.getPosition());
        currentUser.setDivisi(mUsersDTO.getDivisi());
        currentUser.setWorkstationId(mUsersDTO.getWorkstation_id());
        currentUser.setUpdateBy(mUsersDTO.getUpdate_by());
        currentUser.setLastUpdate(new Date());

        mUsersService.updateUser(currentUser);

        return new ResponseEntity(currentUser, HttpStatus.OK);
    }

//    --------------------------- Delete user by Id --------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUserByIds(@PathVariable("id") int id) {
        logger.info("Fetching & Deleting User with id {}", id);

        MUsersEntity user = mUsersService.findById(id);
        if (user == null) {
            logger.error("Unable to delete. User with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        mUsersService.deleteUserById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //    ----------------------------- Delete all user -----------------------------
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity<MUsersEntity> deleteUser() {
        logger.info("Deleting All Users");

        mUsersService.deleteAllUser();
        return new ResponseEntity<MUsersEntity>(HttpStatus.NO_CONTENT);
    }
}
