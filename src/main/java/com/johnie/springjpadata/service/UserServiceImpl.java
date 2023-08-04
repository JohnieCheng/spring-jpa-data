package com.johnie.springjpadata.service;

import com.johnie.springjpadata.entity.QUser;
import com.johnie.springjpadata.entity.User;
import com.johnie.springjpadata.repository.UserRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final EntityManager entityManager;

    protected JPAQueryFactory jpaQueryFactory;

    @PostConstruct
    public void init() {
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<User> getHistoryById(Long id) {
        Revisions<Long, User> revisions = userRepository.findRevisions(id);
        return revisions.getContent().stream().map(Revision::getEntity).collect(Collectors.toList());
    }

    @Override
    public User getById(Long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }


    /**
     * 单表查询
     *
     * @param username
     * @return
     */
    @Override
    public User getByUsername(String username) {
        QUser user = QUser.user;
        return jpaQueryFactory.selectFrom(user)
                .where(user.userName.eq(username))
                .fetchOne();
    }

    @Override
    public User getByUsername2(String username) {
        QUser user = QUser.user;
        Predicate predicate = user.userName.equalsIgnoreCase(username);
        return userRepository.findOne(predicate).orElse(null);
    }

    @Override
    public User getByUsername3(String username) {
        QUser user = QUser.user;
        QBean<User> qBean = Projections.bean(User.class, user.id, user.userName, user.password);
        return jpaQueryFactory.select(qBean).from(user)
                .where(user.userName.eq(username))
                .fetchOne();
    }
}
