package com.trainings_notebook.backend.dao;

import com.trainings_notebook.backend.model.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class PostRepositoryTest {


    private String POST_TITLE = "Nutrition during strength training";
    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    void setUp() {
        Post post = new Post();
        post.setTitle(POST_TITLE);
        post.setContent("test content");
        post.setCreateDate(LocalDate.now());
        postRepository.save(post);
    }

    @Test
    void findByTitle() {
        Post post = postRepository.findByTitle(POST_TITLE).orElseThrow();
        assertNotNull(post);
        assertEquals(POST_TITLE, post.getTitle());
    }
}