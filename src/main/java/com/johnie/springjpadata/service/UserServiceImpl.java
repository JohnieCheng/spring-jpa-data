package com.johnie.springjpadata.service;

import com.johnie.springjpadata.entity.User;
import com.johnie.springjpadata.repository.UserRepository;
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
}
