package ua.com.systemgroup.dockerdatabaseserverprovider.repository.loyal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.loyal.Sertificates;

@Repository
public interface SertificatesRepository extends JpaRepository<Sertificates, Long> {
}
