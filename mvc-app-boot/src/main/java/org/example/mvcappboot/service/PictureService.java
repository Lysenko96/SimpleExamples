package org.example.mvcappboot.service;

import lombok.extern.slf4j.Slf4j;
import org.example.mvcappboot.dto.Picture;
import org.example.mvcappboot.dto.SubmissionRequest;
import org.example.mvcappboot.dto.User;
import org.example.mvcappboot.exception.IncorrectPictureException;
import org.example.mvcappboot.exception.InvalidUserException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class PictureService {

    private Map<String, User> userMap = new ConcurrentHashMap<>();
    private NasaClientService nasaClientService;

    public PictureService(NasaClientService nasaClientService) {
        this.nasaClientService = nasaClientService;
    }

    public void submit(SubmissionRequest request){
//        if(userMap.containsKey(request.getAddress())){
//            throw new RuntimeException();
//        }
        User user = request.getPictureSubmission().getUser();
        if(ObjectUtils.isEmpty(user.getFirstName()) || ObjectUtils.isEmpty(user.getLastName())){
            throw new InvalidUserException();
        }
        Picture picture = request.getPictureSubmission().getPicture();
        long start = System.currentTimeMillis();
        log.info("Start finding picture...");
        Picture correct = nasaClientService.getLargestPicture();
        log.info("Picture found: " + (System.currentTimeMillis() - start) + "ms");
        if(picture.equals(correct)){
            userMap.put(request.getAddress(), user);
        } else {
            throw new IncorrectPictureException();
        }
    }
}
