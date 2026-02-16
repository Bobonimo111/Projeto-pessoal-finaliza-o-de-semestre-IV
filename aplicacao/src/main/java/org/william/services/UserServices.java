package org.william.services;

import org.william.dto.users.PostUserDTO;

import java.util.List;

import org.william.dto.users.GetUserDTO;
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
    public GetUserDTO createUser(PostUserDTO postUserDTO) {
        UserEntity userEntity = this.userMapper.toEntity(postUserDTO);
        this.userRepository.persist(userEntity);
        return userMapper.toGetUserDto(userEntity);
    }

    public List<GetUserDTO> getUsers() {
        return this.userRepository.listAll()
        .stream()
        .map(this.userMapper::toGetUserDto)
        .toList();
    }

    public UserEntity getUserById(int id) {
        return this.userRepository.findById(id);
    }

    @Transactional
    public void updateFullUser(PostUserDTO postUserDTO, int id) {
        UserEntity dbUserEntity = this.userRepository.findById(id);
        dbUserEntity.setName(postUserDTO.getName());
        dbUserEntity.setLastName(postUserDTO.getLastName());
    }

    @Transactional
    public void deleteUserById(int id) {
        this.userRepository.deleteById(id);
    }
}