package org.william.services;

import org.william.dto.PostUserDTO;

import java.util.List;

import org.william.dto.GetUserDTO;
import org.william.entity.UserEntity;
import org.william.mapper.UserMapper;
import org.william.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserServices {
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Inject
    UserServices(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public void createUser(PostUserDTO postUserDTO) {
        UserEntity userEntity = this.userMapper.toEntity(postUserDTO);
        this.userRepository.saveUser(userEntity);
    }

    @Transactional
    public List<GetUserDTO> getUsers() {
        return this.userRepository.listAll()
        .stream()
        .map(m -> this.userMapper.toGetUserDto(m))
        .toList();
    }

}