package com.example.springdownloadfile.exception;

import com.example.springdownloadfile.controller.ImageController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(basePackageClasses = ImageController.class)
public class FileUploadExceptionAdvice {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView handleMaxSizeException(ModelAndView model){
        model.addObject("message", "file too large");
        model.setViewName("error");
        return model;
    }
}
