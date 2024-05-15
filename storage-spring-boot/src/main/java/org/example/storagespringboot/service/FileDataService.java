package org.example.storagespringboot.service;

import lombok.RequiredArgsConstructor;
import org.example.storagespringboot.entity.FileData;
import org.example.storagespringboot.entity.ImageData;
import org.example.storagespringboot.repository.FileDataRepository;
import org.example.storagespringboot.repository.StorageRepository;
import org.example.storagespringboot.util.ImageUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
@Transactional
@RequiredArgsConstructor
public class FileDataService {

    private final FileDataRepository fileDataRepository;
    private static final String FOLDER_PATH = "/home/user/Files/";

    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath = FOLDER_PATH + file.getOriginalFilename();
        FileData fileData = fileDataRepository.save(FileData.builder()
                .name(file.getName())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        return "file uploaded successfully: " + filePath + System.lineSeparator() + fileData;
    }

    public byte[] downloadImageFromFileSystem(String imageName) throws IOException {
        FileData fileData = fileDataRepository.findByName(imageName);
        String filePath = fileData.getFilePath();
        byte[] bytes = Files.readAllBytes(new File(filePath).toPath());
        return bytes;
    }
}
