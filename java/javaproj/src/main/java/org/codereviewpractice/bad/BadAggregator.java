package org.codereviewpractice.bad;

import java.util.List;
import java.util.Map;

public class BadAggregator {
    public void add(List<String> data, Map<String, Integer> result) {
        for (String d : data) {
            if (result.containsKey(d)) {
                result.put(d, result.get(d) + 1);
            } else {
                result.put(d, 1);
            }
        }
    }
}
