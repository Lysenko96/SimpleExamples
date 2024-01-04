package org.example.mvcappboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionRequest {

    private PictureSubmission pictureSubmission;
    private String address;
}
