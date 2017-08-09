package com.jeiker.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.jeiker.demo.commons.result.Tree;
import com.jeiker.demo.commons.shiro.ShiroUser;
import com.jeiker.demo.model.Resource;

import java.util.List;

/**
 *
 * Resource 表数据服务层接口
 *
 */
public interface IResourceService extends IService<Resource> {

    List<Resource> selectAll();

    List<Tree> selectAllMenu();

    List<Tree> selectAllTree();

    List<Tree> selectTree(ShiroUser shiroUser);

}