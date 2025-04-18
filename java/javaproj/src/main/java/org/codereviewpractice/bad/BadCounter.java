package org.codereviewpractice.bad;

import java.util.List;

public class BadCounter {
    public void count(List<String> data) {
        BadGlobals.counter += data.size();
    }
}
