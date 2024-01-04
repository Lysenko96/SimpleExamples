package org.example.mvcappboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.mvcappboot.dto.PictureSubmission;
import org.example.mvcappboot.dto.SubmissionRequest;
import org.example.mvcappboot.service.PictureService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pictures")
public class PictureController {

    private PictureService pictureService;
    private HttpServletRequest request;

    public PictureController(PictureService pictureService, HttpServletRequest request) {
        this.pictureService = pictureService;
        this.request = request;
    }

    @PostMapping
    public void submit(@RequestBody PictureSubmission pictureSubmission){
        pictureService.submit(new SubmissionRequest(pictureSubmission, request.getRemoteAddr()));
    }
}
