package com.github.scotchg.sample.audit.infra.repository;

import com.github.scotchg.sample.audit.infra.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends BaseRepository<TodoEntity, String>{
    Optional<TodoEntity> findOneById(String id);

}
