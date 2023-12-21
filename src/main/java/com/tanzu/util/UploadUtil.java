package com.tanzu.util;


import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

/**
 * 储存对象
 */
public class UploadUtil {
    static String bucketName = "imge-1319580658"; //桶的名称
    static COSCredentials cred = null;
    static ClientConfig clientConfig = null;
    static COSClient cosClient = null;
    static final String TENGXUN_url = "https://imge-1319580658.cos.ap-guangzhou.myqcloud.com/";
    static {
        String secretId = "AKIDALFIKE4vegkilppdMAsSq0wiIlL0qeUI";
        String secretKey = "z4A92rdLxRuAD8oLfkprFRRHvLXXItTu";
        cred = new BasicCOSCredentials(secretId, secretKey);
        Region region = new Region("ap-guangzhou");
        clientConfig = new ClientConfig(region);
        clientConfig.setHttpProtocol(HttpProtocol.http);
        cosClient = new COSClient(cred, clientConfig);
    }

    public static String uploadImageAva(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        int imgext = originalFilename.lastIndexOf('.');
        String ext = "." + originalFilename.substring(imgext + 1);
        String uuid = UUID.randomUUID().toString().replace("-","");
        String filename = uuid + ext;
        File Localfile = File.createTempFile("temp", null);
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, Localfile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        System.out.println(filename);
        String key = "avg_imge/" + filename;
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key,Localfile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        cosClient.shutdown();
        return TENGXUN_url + key;
    }
    public static String uploadImageBack(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        int imgext = originalFilename.lastIndexOf('.');
        String ext = "." + originalFilename.substring(imgext + 1);
        String uuid = UUID.randomUUID().toString().replace("-","");
        String filename = uuid + ext;
        File Localfile = File.createTempFile("temp", null);
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, Localfile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception e){
            throw e;
        }
        System.out.println(filename);
        String key = "back_imge/" + filename;
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key,Localfile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        cosClient.shutdown();
        return TENGXUN_url + key;
    }
}
