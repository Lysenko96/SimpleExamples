package ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Profile;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.ProfilePk;

public interface ProfileRepository extends JpaRepository<Profile, ProfilePk> {
}
