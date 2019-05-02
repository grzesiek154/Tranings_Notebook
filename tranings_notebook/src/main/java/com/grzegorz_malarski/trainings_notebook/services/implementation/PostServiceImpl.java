package com.grzegorz_malarski.trainings_notebook.services.implementation;

import com.grzegorz_malarski.trainings_notebook.exceptions.NotFoundException;
import com.grzegorz_malarski.trainings_notebook.model.Post;
import com.grzegorz_malarski.trainings_notebook.repositories.PostRepository;
import com.grzegorz_malarski.trainings_notebook.services.PostService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public Set<Post> findAll() {
        Set<Post> posts = new HashSet<>();
        postRepository.findAll().forEach(posts::add);

        return posts;
    }

    @Override
    public Post findByTitle(String title) {
        return null;
    }

    @Override
    public Post findById(Long aLong) {
        Optional<Post> userAccountOptional = postRepository.findById(aLong);

        if(!userAccountOptional.isPresent()) {
            throw new NotFoundException("User account with id: " + aLong + " not found");
        }

        return userAccountOptional.get();
    }

    @Override
    public Post save(Post object) {
        return postRepository.save(object);
    }

    @Override
    public void delete(Post object) {
        postRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        postRepository.deleteById(aLong);
    }
}
