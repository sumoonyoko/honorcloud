package org.honorcloud.common.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.UUID;
import java.util.regex.Pattern;

import org.honorcloud.common.constant.Constant;
import org.honorcloud.common.constant.ErrorCodeEnum;
import org.honorcloud.common.exception.BusinessException;

/**
 * @Description: 文件工具类
 * @version: v1.0.0
 * @author: sumoonyoko
 * @date: 2019年11月06日 
 */
public class FileUtils {

    /**
     * 删除不用的旧文件
     * @param parentPath 文件路径
     * @param fileName 要删除文件，支持正则查找
     * @param latestTime 删除多久之前文件
     */
    public static void delOldFile(String parentPath, final String fileName, long latestTime){
        File files = new File(parentPath);
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String regexp = fileName;
                return Pattern.matches(regexp, name);
            }
        };
        File[] oldFiles = files.listFiles(filenameFilter);
        for(File oldFile : oldFiles){
            if(oldFile.exists() && oldFile.lastModified() < System.currentTimeMillis() - latestTime){
                oldFile.delete();
            }
        }
    }

    /**
     * 上传NFS文件
     * @param path
     * @param fileByte
     * @Value fileName  自动创建文件名
     */
    public static String uploadNfsFile(String path, byte[] fileByte) throws BusinessException {
        File directory = new File(path);
        if(!directory.exists()){
            directory.mkdirs();
        }
        String fileName = Constant.NFS_PREFIX + UUID.randomUUID().toString().replace("-", "").toLowerCase();
        try {
            Files.write(Paths.get(path + "/" + fileName), fileByte, StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            throw new BusinessException(ErrorCodeEnum.UPLOAD_IMAGE_ERROR, "文件上传异常：" + e.getMessage());
        }
        return fileName;
    }

    public static void main(String[] args) {
        String regexp = "^Device[0-9]*.xlsx$";
        String name = "Device453087854151619777.xlsx";
        System.out.println(Pattern.matches(regexp, name));
    }
}
