package com.jeiker.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.jeiker.demo.commons.result.Tree;
import com.jeiker.demo.model.Organization;

import java.util.List;

/**
 *
 * Organization 表数据服务层接口
 *
 */
public interface IOrganizationService extends IService<Organization> {

    List<Tree> selectTree();

    List<Organization> selectTreeGrid();

}