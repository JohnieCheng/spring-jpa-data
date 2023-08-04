package com.johnie.springjpadata.repository;

import com.johnie.springjpadata.entity.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long>, RevisionRepository<User, Long, Long>, QuerydslPredicateExecutor<User> {
}
