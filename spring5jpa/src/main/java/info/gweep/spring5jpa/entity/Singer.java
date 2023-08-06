package info.gweep.spring5jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Singer.FIND_ALL", query = "SELECT s FROM Singer s"),
        //@NamedQuery(name = "Singer.FIND_BY_ID", query = "SELECT DISTINCT s FROM Singer s LEFT JOIN FETCH s.albums a LEFT JOIN FETCH s.instruments i WHERE s.id = :id"),
        @NamedQuery(name = "Singer.FIND_BY_ID", query = "SELECT DISTINCT s FROM Singer s WHERE s.id = :id"),
        //@NamedQuery(name = "Singer.FIND_ALL_WITH_ALBUM", query = "SELECT DISTINCT s FROM Singer s LEFT JOIN FETCH s.albums a LEFT JOIN FETCH s.instruments i")
        @NamedQuery(name = "Singer.FIND_ALL_WITH_ALBUM", query = "SELECT DISTINCT s FROM Singer s")
})
@SqlResultSetMapping(name = "singerResult", entities = @EntityResult(entityClass = Singer.class))
public class Singer implements Serializable {

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

    @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Album> albums = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "singer_instrument",
    joinColumns = @JoinColumn(name = "singer_id"),
    inverseJoinColumns = @JoinColumn(name = "instrument_id"))
    private Set<Instrument> instruments = new HashSet<>();

    public Singer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "id=" + id +
                ", version=" + version +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", albums=" + albums +
                '}';
    }
}
