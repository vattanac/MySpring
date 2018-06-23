package com.vattanac.demo.services;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadService {
    String sigleFileUpload(MultipartFile file,String folder);

    List<String> multipleFileUpload(List<MultipartFile> files,String folder);

    String upload(MultipartFile file,String folder);
    List<String> upload(List<MultipartFile> files,String folder);
    List<String> upload(List<MultipartFile> files);
    String upload(MultipartFile file);
}
