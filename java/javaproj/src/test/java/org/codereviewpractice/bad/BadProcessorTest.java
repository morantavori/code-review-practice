package org.codereviewpractice.bad;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BadProcessorTest {

    @Test
    public void testNormal() {
        BadProcessor p = new BadProcessor();
        List<String> list = Arrays.asList("a", "b");
        Set<String> known = new HashSet<>(Arrays.asList("a"));
        List<String> extras = Arrays.asList("b");
        Set<String> enrich = new HashSet<>();
        String user = "admin";

        Map<String, Integer> result = p.process(list, true, known, extras, enrich, true, user);
        assertTrue(result.containsKey("b"));
    }

    @Test
    public void testReverse() {
        BadProcessor p = new BadProcessor();
        Map<String, Integer> result = p.process(
                Arrays.asList("dog"),
                false,
                new HashSet<>(),
                new ArrayList<>(),
                new HashSet<>(),
                false,
                "user"
        );
        assertTrue(result.containsKey("god"));
    }
}
