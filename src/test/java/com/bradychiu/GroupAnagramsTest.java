package com.bradychiu;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class GroupAnagramsTest {
    @Test
    void one() {
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = new ArrayList<List<String>>() {{
            add(Arrays.asList("bat"));
            add(Arrays.asList("nat", "tan"));
            add(Arrays.asList("ate", "eat", "tea"));
        }};

        List<List<String>> output = GroupAnagrams.groupAnagrams(input);
        for (List<String> l : output)
            Collections.sort(l);

        assertTrue(expected.size() == output.size()
                && expected.containsAll(output)
                && output.containsAll(expected));
    }

    @Test
    void two() {
        String[] input = new String[]{""};
        String[][] expected = new String[][]{{""}};
    }

    @Test
    void three() {
        String[] input = new String[]{"a"};
        String[][] expected = new String[][]{{"a"}};
    }
}