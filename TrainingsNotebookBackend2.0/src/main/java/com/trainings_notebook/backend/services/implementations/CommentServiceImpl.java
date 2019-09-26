package com.trainings_notebook.backend.services.implementations;

import com.trainings_notebook.backend.dao.CommentRepository;
import com.trainings_notebook.backend.model.Comment;
import com.trainings_notebook.backend.services.CommentService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
        return commentRepository.findById(aLong).orElseThrow();
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
