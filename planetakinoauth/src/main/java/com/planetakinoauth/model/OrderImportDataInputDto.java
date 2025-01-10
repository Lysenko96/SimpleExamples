package com.planetakinoauth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import static com.planetakinoauth.model.SourceType.DREAM_TOWN;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderImportDataInputDto {

    @Builder.Default
    private String id = "";
    @Builder.Default
    private String source = DREAM_TOWN.name();
}
