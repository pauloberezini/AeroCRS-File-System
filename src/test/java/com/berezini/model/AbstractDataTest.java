package com.berezini.model;

import com.berezini.model.AbstractData;
import org.junit.jupiter.api.Test;
import com.berezini.model.Category;
import com.berezini.model.File;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbstractDataTest {

    @Test
    public void testAbstractData() {
        String name = "test";
        long id = 1;
        Category category = Category.MUSIC;
        AbstractData data = new File(name, id, category);

        assertEquals(name, data.getName());
        assertEquals(id, data.getId());
        assertEquals(category, data.getCategory());
    }
}