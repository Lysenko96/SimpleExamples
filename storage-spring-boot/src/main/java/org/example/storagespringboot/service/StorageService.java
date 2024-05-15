package org.example.storagespringboot.service;

import lombok.RequiredArgsConstructor;
import org.example.storagespringboot.entity.ImageData;
import org.example.storagespringboot.repository.StorageRepository;
import org.example.storagespringboot.util.ImageUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional
public class StorageService {
    
    private final StorageRepository storageRepository;

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = storageRepository.save(ImageData.builder()
                .name(file.getName())
                .type(file.getContentType())
                .imageData(ImageUtils.compress(file.getBytes())).build());
        return imageData.getImageData() != null ? "file uploaded successfully: " + file.getOriginalFilename() : null;
    }
    
    public byte[] downloadImage(String imageName) {
        ImageData doImageData = storageRepository.findByName(imageName);
        byte[] images = ImageUtils.decompress(doImageData.getImageData());
        return images;
    }
}
