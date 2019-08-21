package com.grzegorz_malarski.trainings_notebook.converters.command_to_entity;

import com.grzegorz_malarski.trainings_notebook.commands.ExerciseCategoryCommand;
import com.grzegorz_malarski.trainings_notebook.model.ExerciseCategory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExerciseCategoryCommandToEntityTest {


    private final Long EXERCISE_CATEGORY_ID = 1L;
    private final String DESCRIPTION = "some exercise category description";

    ExerciseCategoryCommandToEntity converter;

    @Before
    public void setUp() throws Exception {
        converter = new ExerciseCategoryCommandToEntity();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new ExerciseCategoryCommand()));
    }

    @Test
    public void convert() {
        ExerciseCategoryCommand command = new ExerciseCategoryCommand();
        command.setId(EXERCISE_CATEGORY_ID);
        command.setDescription(DESCRIPTION);

        //when
        ExerciseCategory exerciseCategory = converter.convert(command);

        //then
        assertNotNull(exerciseCategory);
        assertEquals(EXERCISE_CATEGORY_ID, exerciseCategory.getId());
        assertEquals(DESCRIPTION, exerciseCategory.getDescription());
    }
}