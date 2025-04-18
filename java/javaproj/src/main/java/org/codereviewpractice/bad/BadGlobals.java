package org.codereviewpractice.bad;

import java.util.HashMap;
import java.util.Map;

public class BadGlobals {
    public static int counter = 0;
    public static Map<String, Integer> results = new HashMap<>();
}
