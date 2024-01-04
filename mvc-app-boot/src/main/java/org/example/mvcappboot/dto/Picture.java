package org.example.mvcappboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.Cacheable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Picture {

    private String url;
    private Long size;
}
