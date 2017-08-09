package com.jeiker.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jeiker.demo.mapper.UserRoleMapper;
import com.jeiker.demo.model.UserRole;
import com.jeiker.demo.service.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 *
 * UserRole 表数据服务层接口实现类
 *
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}