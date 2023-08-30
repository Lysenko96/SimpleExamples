package com.example.springdownloadfile.controller;

import com.example.springdownloadfile.entity.File;
import com.example.springdownloadfile.repository.FileRepo;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/file")
@Slf4j
public class ImageController {

    private FileRepo imageRepo;

    public ImageController(FileRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    @GetMapping
    public String validLoadImage(Model model) {
        model.addAttribute("message", "Max 1MB");
        return "file";
    }

    @PostMapping
    public String loadImage(@RequestParam("description") String description,
                            @RequestParam("file") MultipartFile file) {
        try {
            Byte[] imageBytes = new Byte[file.getBytes().length];
            for (int i = 0; i < imageBytes.length; i++) imageBytes[i] = file.getBytes()[i];
            imageRepo.save(new File(description, imageBytes));
            log.info(new File(description, imageBytes).toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/file";
    }

    @GetMapping("/{id}")
    public void uploadImage(@PathVariable("id") Long id, HttpServletResponse response){
        String headerKey = "Content-Disposition";
        File image = imageRepo.findById(id).orElse(null);
        if(image != null) {
            String headerValue = String.format("attachment; filename=\"%s\"", image.getDescription());
            response.setHeader(headerKey, headerValue);
            byte[] imageBytes = new byte[image.getFile().length];
            for (int i = 0; i < imageBytes.length; i++) imageBytes[i] = image.getFile()[i];
            try(InputStream is = new ByteArrayInputStream(imageBytes)){
                response.getOutputStream().write(is.readAllBytes());
                //IOUtils.copy(is, response.getOutputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
