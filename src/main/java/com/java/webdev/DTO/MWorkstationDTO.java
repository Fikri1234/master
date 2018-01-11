package com.java.webdev.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MWorkstationDTO implements Serializable{
  private String workstation;
  private int workstation_id;
  private String flag;
  private Date last_update;
  private Date created_date;
  private int update_by;
  private int created_by;
  private String updateByName;
  private String createdByName;

  public MWorkstationDTO(){}

  public MWorkstationDTO(
          String workstation,
          int workstation_id,
          String flag,
          Date last_update,
          Date created_date,
          int update_by,
          int created_by,
          String updateByName,
          String createdByName){
    this.workstation = workstation;
    this.workstation_id = workstation_id;
    this.flag = flag;
    this.last_update = last_update;
    this.created_date = created_date;
    this.update_by = update_by;
    this.created_by = created_by;
    this.updateByName = updateByName;
    this.createdByName = createdByName;
  }

  public MWorkstationDTO (
          String workstation,
          String updateByName,
          String createdByName){
     this.workstation = workstation;
     this.updateByName = updateByName;
     this.createdByName = createdByName;
  }

  public String getWorkstation() {
    return workstation;
  }

  public void setWorkstation(String workstation) {
    this.workstation = workstation;
  }

  public int getWorkstation_id() {
    return workstation_id;
  }

  public void setWorkstation_id(int workstation_id) {
    this.workstation_id = workstation_id;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public Date getLast_update() {
    return last_update;
  }

  public void setLast_update(Date last_update) {
    this.last_update = last_update;
  }

  public Date getCreated_date() {
    return created_date;
  }

  public void setCreated_date(Date created_date) {
    this.created_date = created_date;
  }

  public int getUpdate_by() {
    return update_by;
  }

  public void setUpdate_by(int update_by) {
    this.update_by = update_by;
  }

  public int getCreated_by() {
    return created_by;
  }

  public void setCreated_by(int created_by) {
    this.created_by = created_by;
  }

  public String getUpdateByName() {
    return updateByName;
  }

  public void setUpdateByName(String updateByName) {
    this.updateByName = updateByName;
  }

  public String getCreatedByName() {
    return createdByName;
  }

  public void setCreatedByName(String createdByName) {
    this.createdByName = createdByName;
  }
}
