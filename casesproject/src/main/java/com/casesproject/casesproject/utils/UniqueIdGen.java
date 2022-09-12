package com.casesproject.casesproject.utils;

import java.util.UUID;

public class UniqueIdGen {
    public long idGen() {
        long val;
        do {
            val = UUID.randomUUID().getMostSignificantBits();
        } while (val < 0);

        return val;
    }
}
