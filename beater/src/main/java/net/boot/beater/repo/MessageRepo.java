package net.boot.beater.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.boot.beater.entity.Message;

public interface MessageRepo extends CrudRepository<Message, Long> {

	List<Message> findByTag(String tag);
}
