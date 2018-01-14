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
  private int updated_by;
  private int created_by;
  private String updatedByName;
  private String createdByName;

  public MWorkstationDTO(){}

  public MWorkstationDTO(
          String workstation,
          int workstation_id,
          String flag,
          Date last_update,
          Date created_date,
          int updated_by,
          int created_by,
          String updatedByName,
          String createdByName){
    this.workstation = workstation;
    this.workstation_id = workstation_id;
    this.flag = flag;
    this.last_update = last_update;
    this.created_date = created_date;
    this.updated_by = updated_by;
    this.created_by = created_by;
    this.updatedByName = updatedByName;
    this.createdByName = createdByName;
  }

  public MWorkstationDTO (
          String workstation,
          String updatedByName,
          String createdByName){
     this.workstation = workstation;
     this.updatedByName = updatedByName;
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

  public int getUpdated_by() {
    return updated_by;
  }

  public void setUpdated_by(int updated_by) {
    this.updated_by = updated_by;
  }

  public int getCreated_by() {
    return created_by;
  }

  public void setCreated_by(int created_by) {
    this.created_by = created_by;
  }

  public String getUpdatedByName() {
    return updatedByName;
  }

  public void setUpdatedByName(String updatedByName) {
    this.updatedByName = updatedByName;
  }

  public String getCreatedByName() {
    return createdByName;
  }

  public void setCreatedByName(String createdByName) {
    this.createdByName = createdByName;
  }
}
