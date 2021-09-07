package net.gweep.webtrunk.repo;

import org.springframework.data.repository.CrudRepository;

import net.gweep.webtrunk.entity.User;

public interface UserRepo extends CrudRepository<User, Integer> {

}
