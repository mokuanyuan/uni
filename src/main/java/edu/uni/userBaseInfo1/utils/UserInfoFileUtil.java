package edu.uni.userBaseInfo1.utils;

import edu.uni.bean.Result;
import edu.uni.bean.ResultType;
import edu.uni.config.GlobalConfig;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * @Author deschen
 * @Create 2019/5/21
 * @Description 文件上传下载工具类
 * @Since 1.0.0
 */
@Data
@Slf4j
public class UserInfoFileUtil {

    private String uploadRootDir;

    private String filePrefix;

    public String getFilePrefix() {
        return filePrefix;
    }

    public String getUploadRootDir() {
        return uploadRootDir;
    }

    public UserInfoFileUtil() {
    }

    //设置存储路径，后缀默认
    public UserInfoFileUtil(String uploadRootDir) {
        char c = uploadRootDir.charAt(uploadRootDir.length() - 1);
        if (c != '/') {
            uploadRootDir = uploadRootDir + "/";
        }
        this.uploadRootDir = uploadRootDir;
        this.filePrefix = UUID.randomUUID().toString().replaceAll("-", "");
    }

    /*设置存储路径和后缀*/
    public UserInfoFileUtil(String uploadRootDir, String filePrefix) {
        char c = uploadRootDir.charAt(uploadRootDir.length() - 1);
        if (c != '/') {
            uploadRootDir = uploadRootDir + "/";
        }
        this.uploadRootDir = uploadRootDir;
        this.filePrefix = filePrefix;
    }

    //存储文件并返回文件路径名
    public String uploadFile(MultipartFile multipartFile, HttpServletRequest request) throws IOException {

        String fIlePath = getFilePath(multipartFile);
        File file = new File(fIlePath);
        //如果没有files文件夹，则创建
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        //文件写入指定路径
//        multipartFile.transferTo(file);
        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
        //log.info("【文件工具】保存文件成功，filePath={}", fIlePath);
        System.out.println("【文件工具】保存文件成功，filePath={}"+fIlePath);
        return fIlePath;
    }

    // 下载文件
    public void downloadFile(
            String fileName, HttpServletResponse response) throws UnsupportedEncodingException {


        String filePath = uploadRootDir + fileName;

        System.out.println("########## Path:" + filePath);

        File file = new File(filePath);
        if (file.exists()) {
            // 文件名字
//            String simpleName = file.getName();
//            String filePath = simpleName.substring(0, simpleName.lastIndexOf("_"));
            String suffix = filePath.substring(filePath.lastIndexOf("."));
//            filePath = filePath + suffix;

            // 防止中文乱码
//            response.setContentType("multipart/form-data");
            if(suffix.substring(1).equals("xls"))
                response.setContentType("application/vnd.ms-excel");
            else{
                if(suffix.substring(1).equals("xlsx"))
                    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                else {
                    try {
                        response.getWriter().write(Result.build(ResultType.ParamError,"该文件的后缀名不合法").convertIntoJSON());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

//            response.setHeader("Content-Disposition", "attachment;filename=" + new String(filePath.getBytes("UTF-8"), "iso-8859-1"));
            response.setHeader("Content-Disposition", "attachment;filename=" +
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + suffix);
            // 输出流
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                //log.info("【文件工具】下载成功，fileName={}");
                System.out.println("【文件工具】下载成功，fileName={}"+filePath);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // 删除文件
    public boolean deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                /*log.info("【文件工具】删除文件成功，filePath={}",
                        filePath);*/
                System.out.println("【文件工具】下载成功，fileName={}"+filePath);
                return true;
            }else {
                /*log.info("【文件工具】删除文件失败，filePath={}",
                        filePath);*/
                System.out.println("【文件工具】下载成功，fileName={}"+filePath);
                return false;
            }
        }
        /*log.info("【文件工具】删除文件失败，不存在该文件，filePath={}",
                filePath);*/
        System.out.println("【文件工具】下载成功，fileName={}"+filePath);
        return false;

    }
    // 生成文件路径名
    private String getFilePath(MultipartFile file) {
        // 获取文件的后缀名
        String originalFilename = file.getOriginalFilename();
        // 文件名除后缀
        String fileName = originalFilename.substring(0, originalFilename.lastIndexOf("."));
        // 文件后缀名
        String suffixName =
                originalFilename.substring(originalFilename.lastIndexOf("."));
       /* log.info("【文件工具】后缀, suffixName = {}", suffixName);*/
        // 防止文件重复
        String path = uploadRootDir + filePrefix + suffixName;
        System.out.println("【文件工具】后缀, suffixName = {}"+suffixName+" path:-->"+path);
        return path;
    }

}
