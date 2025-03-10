package ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Event;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.EventPk;

@Repository
public interface EventRepository extends JpaRepository<Event, EventPk> {
}
