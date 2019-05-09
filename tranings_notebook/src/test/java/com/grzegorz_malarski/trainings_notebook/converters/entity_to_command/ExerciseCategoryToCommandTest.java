package com.grzegorz_malarski.trainings_notebook.converters.entity_to_command;

import com.grzegorz_malarski.trainings_notebook.commands.ExerciseCategoryCommand;
import com.grzegorz_malarski.trainings_notebook.model.ExerciseCategory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExerciseCategoryToCommandTest {


    private final Long EXERCISE_CATEGORY_ID = 1L;
    private final String DESCRIPTION = "some exercise category description";
    ExerciseCategoryToCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new ExerciseCategoryToCommand();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new ExerciseCategory()));
    }

    @Test
    public void convert() {
        ExerciseCategory entity = new ExerciseCategory();
        entity.setId(EXERCISE_CATEGORY_ID);
        entity.setDescription(DESCRIPTION);

        //when
        ExerciseCategoryCommand command = converter.convert(entity);

        //then
        assertNotNull(command);
        assertEquals(EXERCISE_CATEGORY_ID, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());


    }
}