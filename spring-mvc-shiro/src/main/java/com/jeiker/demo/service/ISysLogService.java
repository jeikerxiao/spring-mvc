package com.jeiker.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.jeiker.demo.commons.result.PageInfo;
import com.jeiker.demo.model.SysLog;

/**
 *
 * SysLog 表数据服务层接口
 *
 */
public interface ISysLogService extends IService<SysLog> {

    void selectDataGrid(PageInfo pageInfo);

}