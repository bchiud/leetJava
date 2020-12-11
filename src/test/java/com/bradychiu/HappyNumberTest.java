package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HappyNumberTest {

    @Test
    void hashSet() {
        assertEquals(true, HappyNumber.isHappyHashSet(19));
    }

    @Test
    void floyd() {
        assertEquals(true, HappyNumber.isHappyFloyd(19));
    }

}