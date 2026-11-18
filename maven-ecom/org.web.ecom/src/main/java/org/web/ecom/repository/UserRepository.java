package org.web.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.web.ecom.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
