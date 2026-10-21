package com.example.spring.repository;

import com.example.spring.dto.PersonalInfo;
import com.example.spring.model.Role;
import com.example.spring.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findAllBy(Pageable pageable);

    List<User> findFirst2By(Sort sort);

    Optional<User> findFirstByCompanyIsNotNullOrderByIdDesc();

    List<User> findFirst3ByCompanyIsNotNullOrderByIdDesc();

    @Query("""
    SELECT new com.example.spring.dto.PersonalInfo(
        u.firstname,
        u.lastname,
        u.birthDate
    )
    FROM User u
    WHERE u.id = :id
""")
    List<PersonalInfo> findAllByCompanyId(@Param("id") Integer id);

    @Query("select u from User u where u.firstname like %:firstname% and u.lastname like %:lastname%")
    List<User> findAllByFirstnameContainingAndLastnameContaining(@Param("firstname") String firstname,@Param("lastname") String lastname);

    @Query(value = "select u.* from user u where u.username", nativeQuery = true)
    List<User> findAllByUsername(@Param("username") String username);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.role = :role where u.id in (:ids)")
    int updateRole(@Param("role") Role role, @Param("ids") Long... ids);

}
