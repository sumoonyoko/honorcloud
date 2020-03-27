package org.honorcloud.code.xchat.service.impl;

import java.io.File;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.honorcloud.code.xchat.config.FileConfig;
import org.honorcloud.code.xchat.enums.CodeEnum;
import org.honorcloud.code.xchat.exception.ErrorCodeException;
import org.honorcloud.code.xchat.service.UploadService;
import org.honorcloud.code.xchat.utils.CheckUtils;
import org.honorcloud.code.xchat.utils.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yanpanyi
 * @date 2019/3/27
 */
@Service
@Slf4j
public class UploadServiceImpl implements UploadService {

    @Resource
    private FileConfig fileConfig;

    @Override
    public String uploadImage(MultipartFile multipartFile) throws Exception {
        if (multipartFile.isEmpty()) {
            throw new ErrorCodeException(CodeEnum.FAILED);
        }

        return execute(multipartFile);
    }

    private String execute(MultipartFile multipartFile) throws Exception {
        String originalFilename = multipartFile.getOriginalFilename();
        if (StringUtils.isEmpty(originalFilename)) {
            throw new ErrorCodeException(CodeEnum.INVALID_PARAMETERS);
        }

        String type = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        if (!CheckUtils.isImage(type)) {
            throw new ErrorCodeException(CodeEnum.UPLOADED_FILE_IS_NOT_AN_IMAGE);
        }

        String fileName = UUIDUtils.create() + "." + type;
        String respPath = fileConfig.getAccessAddress() + fileName;

        File file = new File(fileConfig.getDirectoryMapping() + fileConfig.getUploadPath() + fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        multipartFile.transferTo(file);

        return respPath;
    }
}
