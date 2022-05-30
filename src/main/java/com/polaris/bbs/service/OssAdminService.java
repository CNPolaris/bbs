package com.polaris.bbs.service;

import java.io.InputStream;

/**
 * @author CNPolaris
 * @version 1.0
 */
public interface OssAdminService {
    /**
     * 七牛云上传图片
     * @param file FileInputStream
     * @param key String
     * @return String
     */
    public String uploadImage(InputStream file, String key);
}
