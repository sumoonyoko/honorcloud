package org.honorcloud.code.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.honorcloud.code.controller.base.BaseControFunc;
import org.honorcloud.code.controller.base.BaseController;
import org.honorcloud.code.service.AlbumService;
import org.honorcloud.code.souyunku.model.base.ResultModel;
import org.honorcloud.code.souyunku.model.enums.Constant;
import org.honorcloud.code.souyunku.model.po.CloudStorageConfigPo;
import org.honorcloud.code.souyunku.model.po.ImagesPo;
import org.honorcloud.code.souyunku.service.CloudStorageService;
import org.honorcloud.code.souyunku.service.SysConfigService;
import org.honorcloud.common.constant.PageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sumoon
 * @since 2020-03-09
 */
@Slf4j
@Controller
@RequestMapping("/album")
public class AlbumAction extends BaseController{
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
    private CloudStorageService cloudStorageService;

    @Autowired
    private SysConfigService sysConfigService;

    private String params;
	
	@RequestMapping("/index")
	public String index() {
		return PageConstant.ALBUM_INDEX;
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return PageConstant.ALBUM_ADMIN;
	}
	
	@RequestMapping("/oss")
	public String oss() {
		return PageConstant.ALBUM_OSS;
	}
	
	@RequestMapping("/timeline")
	public String timeline() {
		return PageConstant.ALBUM_TIMELINE;
	}
	
	/**
     * 上传图片
     *
     * @param file
     * @return
     * @throws Exception
     */
	@ResponseBody
    @RequestMapping("/upload")
    public ResultModel upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new RuntimeException("上传文件不能为空");
        }
        return cloudStorageService.upload(file);
    }

    /**
     * 图片列表分页
     *
     * @param params
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getImagesList")
    public HashMap<String, Object> upload(@RequestParam String params, String pageNum, String pageSize) throws Exception {
        return cloudStorageService.selectListAndCount(params, pageNum, pageSize);
    }

    /**
     * 更新图片
     *
     * @param params
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultModel<Integer> update(@RequestParam String params) throws Exception {

        if (StringUtils.isBlank(params)) {
            new ResultModel(Constant.MessageEnum.PARAMS_EXCEPTION.getKey(), Constant.MessageEnum.PARAMS_EXCEPTION.getValue(), null);
        }

        ImagesPo imagesPo = JSONObject.parseObject(params, ImagesPo.class);

        return cloudStorageService.update(imagesPo);
    }

    /**
     * 删除图片
     *
     * @param imagesId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/deleteById")
    public ResultModel<Integer> deleteById(@RequestParam Integer imagesId) throws Exception {
        return cloudStorageService.deleteById(imagesId);
    }

    /**
     * 保存云存储配置
     *
     * @param params
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/saveCloudStorageConfig", method = RequestMethod.POST)
    public ResultModel<Integer> saveCloudStorageConfig(@RequestParam String params) throws Exception {

        if (StringUtils.isBlank(params)) {
            new ResultModel(Constant.MessageEnum.CLOUD_STORAGE_IS_EMPTY.getKey(), Constant.MessageEnum.CLOUD_STORAGE_IS_EMPTY.getValue(), null);
        }

        CloudStorageConfigPo CloudStorageConfigPo = JSONObject.parseObject(params, CloudStorageConfigPo.class);

        return cloudStorageService.saveCloudStorageConfig(CloudStorageConfigPo);

    }


    /**
     * 设置默认云存储类型
     *
     * @param storageType
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/defaultCloudStorageType", method = RequestMethod.POST)
    public ResultModel<Integer> defaultCloudStorageType(@RequestParam String storageType) throws Exception {

        if (StringUtils.isBlank(params)) {
            new ResultModel(Constant.MessageEnum.PARAMS_EXCEPTION.getKey(), Constant.MessageEnum.PARAMS_EXCEPTION.getValue(), null);
        }

        return cloudStorageService.defaultCloudStorageType(storageType);
    }

    /**
     * 描述: 查询云存储配置
     * author: yanpenglei
     * Date: 2017/9/12 13:21
     */
    @ResponseBody
    @RequestMapping("/selectCloudStorageConfig")
    public ResultModel<CloudStorageConfigPo> selectCloudStorageConfig() throws Exception {
        return sysConfigService.selectCloudStorageConfig();
    }
	
}

