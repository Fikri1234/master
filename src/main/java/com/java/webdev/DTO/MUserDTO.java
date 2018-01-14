package com.java.webdev.DTO;

import java.io.Serializable;
import java.util.Date;

public class MUserDTO implements Serializable{
  private int user_id;
  private String address;
  private int created_by;
  private Date created_date;
  private String strCreated_date;
  private String divisi;
  private String flag;
  private Date last_update;
  private String strLast_update;
  private String password;
  private String position;
  private int updated_by;
  private String user_name;
  private int workstation_id;
  private MWorkstationDTO mWorkstation;

  public MUserDTO(){}
  public MUserDTO(int user_id,
                  String user_name,
                  String password,
                  String address,
                  String position,
                  String divisi,
                  String flag,
                  int workstation_id,
                  int updated_by,
                  Date last_update,
                  Date created_date,
                  String strLast_update,
                  String strCreated_date,
                  int created_by){
    this.user_id = user_id;
    this.user_name = user_name;
    this.password = password;
    this.address = address;
    this.position = position;
    this.divisi = divisi;
    this.flag = flag;
    this.workstation_id = workstation_id;
    this.updated_by = updated_by;
    this.last_update = last_update;
    this.created_date = created_date;
    this.strLast_update = strLast_update;
    this.strCreated_date = strCreated_date;
    this.created_by = created_by;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getCreated_by() {
    return created_by;
  }

  public void setCreated_by(int created_by) {
    this.created_by = created_by;
  }

  public Date getCreated_date() {
    return created_date;
  }

  public void setCreated_date(Date created_date) {
    this.created_date = created_date;
  }

  public String getStrCreated_date() {
    return strCreated_date;
  }

  public void setStrCreated_date(String strCreated_date) {
    this.strCreated_date = strCreated_date;
  }

  public String getDivisi() {
    return divisi;
  }

  public void setDivisi(String divisi) {
    this.divisi = divisi;
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

  public String getStrLast_update() {
    return strLast_update;
  }

  public void setStrLast_update(String strLast_update) {
    this.strLast_update = strLast_update;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public int getUpdated_by() {
    return updated_by;
  }

  public void setUpdated_by(int updated_by) {
    this.updated_by = updated_by;
  }

  public String getUser_name() {
    return user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  public int getWorkstation_id() {
    return workstation_id;
  }

  public void setWorkstation_id(int workstation_id) {
    this.workstation_id = workstation_id;
  }

  public MWorkstationDTO getMWorkstation() {
    return mWorkstation;
  }

  public void setMWorkstation(MWorkstationDTO mWorkstation) {
    this.mWorkstation = mWorkstation;
  }
}
