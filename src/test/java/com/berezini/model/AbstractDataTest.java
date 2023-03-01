package com.berezini.model;

import org.junit.jupiter.api.Test;
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