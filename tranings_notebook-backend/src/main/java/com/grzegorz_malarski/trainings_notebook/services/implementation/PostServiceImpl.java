package com.grzegorz_malarski.trainings_notebook.services.implementation;

import com.grzegorz_malarski.trainings_notebook.exceptions.NotFoundException;
import com.grzegorz_malarski.trainings_notebook.model.Comment;
import com.grzegorz_malarski.trainings_notebook.model.Post;
import com.grzegorz_malarski.trainings_notebook.repositories.CommentRepository;
import com.grzegorz_malarski.trainings_notebook.repositories.PostRepository;
import com.grzegorz_malarski.trainings_notebook.services.PostService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {


    private final PostRepository postRepository;
    private final CommentRepository commentRepository;


    public PostServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }


    @Override
    public Set<Post> findAll() {
        Set<Post> posts = new HashSet<>();
        postRepository.findAll().forEach(posts::add);

        return posts;
    }

    @Override
    public Post findByTitle(String title) {
        Optional<Post> postOptional = postRepository.findByTitle(title);
        if(postOptional.isPresent()) {
            return postOptional.get();
        } else {
            throw new NotFoundException("Post with title " + title + " not found.");
        }

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

//    @Override
//    public Comment addCommentToPost(Comment comment) {
//
//        if(comment != null && comment.getContent().length() > 0) {
//            commentRepository.save(comment);
//            return comment;
//        } else {
//            throw new NullPointerException();
//        }
//    }
}
