package com.lee.gmall.bean;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

public class UserInfo implements Serializable {

  private String id;
  private String loginName;
  private String nickName;
  private String passwd;
  private String name;
  private String phoneNum;
  private String email;
  private String headImg;
  private String userLevel;

  @Transient
  List<UserAddress> userAddressList;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }


  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }


  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getHeadImg() {
    return headImg;
  }

  public void setHeadImg(String headImg) {
    this.headImg = headImg;
  }


  public String getUserLevel() {
    return userLevel;
  }

  public void setUserLevel(String userLevel) {

    this.userLevel = userLevel;
  }

  public List<UserAddress> getUserAddressList() {
    return userAddressList;
  }

  public void setUserAddressList(List<UserAddress> userAddressList) {
    this.userAddressList = userAddressList;
  }
}
