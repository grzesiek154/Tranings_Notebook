package com.grzegorz_malarski.trainings_notebook.converters.command_to_entity;


import com.grzegorz_malarski.trainings_notebook.commands.CommentCommand;
import com.grzegorz_malarski.trainings_notebook.model.Comment;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CommentCommandToEntityTest {

    private final Long ID_VALUE = 1L;
    private final String CONTENT = "some comment content";
    private final Long BASE_APP_ACCOUNT_ID = 2L;
    private final Long POST_ID = 3L;
    private final LocalDate CREATE_DATE = LocalDate.now();

    CommentCommandToEntity converter;

    @Before
    public void setUp() throws Exception {
        converter = new CommentCommandToEntity();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }


    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new CommentCommand()));
    }

    @Test
    public void convert() {
        CommentCommand commentCommand = new CommentCommand();
        commentCommand.setId(ID_VALUE);
        commentCommand.setContent(CONTENT);
        commentCommand.setAuthorId(BASE_APP_ACCOUNT_ID);
        commentCommand.setPostId(POST_ID);
        commentCommand.setCreateDate(CREATE_DATE);

        //when
        Comment comment = converter.convert(commentCommand);

        //then
        assertNotNull(comment);
        assertNotNull(comment.getAuthor());
        assertNotNull(comment.getPost());
        assertEquals(ID_VALUE, comment.getId());
        assertEquals(CONTENT, comment.getContent());
        assertEquals(BASE_APP_ACCOUNT_ID, comment.getAuthor().getId());
        assertEquals(POST_ID, comment.getPost().getId());
        assertEquals(CREATE_DATE, comment.getCreateDate());


    }
}