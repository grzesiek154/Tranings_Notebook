package com.grzegorz_malarski.trainings_notebook.services.implementation;

import com.grzegorz_malarski.trainings_notebook.exceptions.NotFoundException;
import com.grzegorz_malarski.trainings_notebook.model.Comment;
import com.grzegorz_malarski.trainings_notebook.repositories.CommentRepository;
import com.grzegorz_malarski.trainings_notebook.services.CommentService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CommentServiceImpl implements CommentService {

   private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Set<Comment> findAll() {
        Set<Comment> comments = new HashSet<>();
        commentRepository.findAll().forEach(comments::add);

        return comments;
    }

    @Override
    public Comment findById(Long aLong) {
        Optional<Comment> userAccountOptional = commentRepository.findById(aLong);

        if(!userAccountOptional.isPresent()) {
            throw new NotFoundException("User account with id: " + aLong + " not found");
        }

        return userAccountOptional.get();
    }

    @Override
    public Comment save(Comment object) {
        return commentRepository.save(object);
    }

    @Override
    public void delete(Comment object) {
        commentRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        commentRepository.deleteById(aLong);
    }
}
