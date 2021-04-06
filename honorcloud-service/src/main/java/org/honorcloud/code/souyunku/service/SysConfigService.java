package org.honorcloud.code.souyunku.service;

import org.honorcloud.code.souyunku.model.base.ResultModel;
import org.honorcloud.code.souyunku.model.po.CloudStorageConfigPo;

/**
 * 描述: 系统配置
 *
 * @author yanpenglei
 * @create 2017-09-11 22:27
 **/
public interface SysConfigService {


    /**
     * 描述: 查询云存储配置
     * author: yanpenglei
     * Date: 2017/9/12 13:21
     */
    ResultModel<CloudStorageConfigPo>  selectCloudStorageConfig();


}
