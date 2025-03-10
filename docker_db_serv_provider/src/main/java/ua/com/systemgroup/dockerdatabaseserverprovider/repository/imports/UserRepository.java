package ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.User;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.UserPk;

public interface UserRepository extends JpaRepository<User, UserPk> {
}
