package com.trainings_notebook.backend.services.implementations;

import com.trainings_notebook.backend.dao.PostRepository;
import com.trainings_notebook.backend.model.Post;
import com.trainings_notebook.backend.services.PostService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post findByTitle(String title) {
        return null;
    }

    @Override
    public Set<Post> findAll() {
        Set<Post> posts = new HashSet<>();
        postRepository.findAll().forEach(posts::add);

        return posts;
    }

    @Override
    public Post findById(Long aLong) {
        return postRepository.findById(aLong).orElseThrow();
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
