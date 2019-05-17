package com.lee.gmall.service;

import com.lee.gmall.bean.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserInfo> userInfoList();

    UserInfo login(UserInfo userInfo);
}
