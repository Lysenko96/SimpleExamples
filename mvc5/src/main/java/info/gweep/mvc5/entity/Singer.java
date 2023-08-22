package info.gweep.mvc5.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
//@Component
//@Scope("prototype")
public class Singer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    private String description;

    @Basic(fetch = FetchType.LAZY)
    //@Lob
    private Byte[] photo;

    public Singer(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Transient
    public String getBirthDateString(){
        String birthDateString = "";
        if(birthDate != null){
            SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
            birthDateString = simpleFormat.format(birthDate);
        }
        return birthDateString;
    }
}
