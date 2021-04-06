package org.honorcloud.code.souyunku.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.honorcloud.code.dao.base.YmqBaseDao;
import org.honorcloud.code.souyunku.model.base.ResultModel;
import org.honorcloud.code.souyunku.model.enums.Constant;
import org.honorcloud.code.souyunku.model.po.CloudStorageConfigPo;
import org.honorcloud.code.souyunku.model.po.SysConfigPo;
import org.honorcloud.code.souyunku.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * 描述: 系统配置
 *
 * @author yanpenglei
 * @create 2017-09-11 22:31
 **/
@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private YmqBaseDao ymqBaseDao;



    @Override
    public ResultModel<CloudStorageConfigPo> selectCloudStorageConfig() {

        ResultModel resultModel = new ResultModel(Constant.MessageEnum.CLOUD_STORAGE_IS_EMPTY.getKey(), Constant.MessageEnum.CLOUD_STORAGE_IS_EMPTY.getValue(), null);

        SysConfigPo sysConfigPo = new SysConfigPo();

        sysConfigPo.setConfigKey(Constant.SysConfigEnum.CLOUD_STORAGE.getKey());

        try {

            SysConfigPo sysConfig = ymqBaseDao.selectOne(sysConfigPo);

            if (sysConfig == null || StringUtils.isBlank(sysConfig.getConfigValue())) return resultModel;

            CloudStorageConfigPo cloudStorageConfigPo = JSONObject.parseObject(sysConfig.getConfigValue(), CloudStorageConfigPo.class);

            return new ResultModel(Constant.MessageEnum.SUCCESS.getKey(), Constant.MessageEnum.SUCCESS.getValue(), cloudStorageConfigPo);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultModel;

    }

}










