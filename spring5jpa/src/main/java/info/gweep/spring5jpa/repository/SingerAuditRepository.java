package info.gweep.spring5jpa.repository;

import info.gweep.spring5jpa.entity.SingerAudit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerAuditRepository extends CrudRepository<SingerAudit, Long> {

}
