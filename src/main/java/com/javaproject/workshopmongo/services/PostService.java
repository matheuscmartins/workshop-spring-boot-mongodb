package com.javaproject.workshopmongo.services;

import com.javaproject.workshopmongo.domain.Post;
import com.javaproject.workshopmongo.domain.User;
import com.javaproject.workshopmongo.dto.UserDTO;
import com.javaproject.workshopmongo.repository.PostRepository;
import com.javaproject.workshopmongo.repository.UserRepository;
import com.javaproject.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not Found by Id: " + id));
    }
    public List<Post> findByTitle(String text){
        return postRepository.searchTitle(text);
    }


}
