package org.example.springioc.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("theSigner")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Scope("prototype")
public class Signer {
    private String name = "default";

    public Signer(@Value("signerName") String name) {
        this.name = name;
    }
}
