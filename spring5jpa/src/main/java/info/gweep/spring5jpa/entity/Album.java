package info.gweep.spring5jpa.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private int version;
    private String title;
    @Temporal(TemporalType.DATE)
    @Column(name = "release_date")
    private Date releaseDate;

    @ManyToOne
    //@JoinColumn(name = "singer_id")
    private Singer singer;


    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", version=" + version +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
