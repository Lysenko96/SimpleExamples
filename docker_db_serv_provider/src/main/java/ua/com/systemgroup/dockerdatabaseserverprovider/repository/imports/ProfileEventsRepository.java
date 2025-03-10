package ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.ProfileEvents;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.ProfileEventsPk;

@Repository
public interface ProfileEventsRepository extends JpaRepository<ProfileEvents, ProfileEventsPk> {
}
