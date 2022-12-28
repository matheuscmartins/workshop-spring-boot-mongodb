package com.javaproject.workshopmongo.services;

import com.javaproject.workshopmongo.domain.User;
import com.javaproject.workshopmongo.dto.UserDTO;
import com.javaproject.workshopmongo.repository.UserRepository;
import com.javaproject.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return  userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not Found by Id: " + id));
    }

    public User insert(User user){
        return userRepository.insert(user);
    }
    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }
    public User fromDTO(UserDTO userDTO){
    return  new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
