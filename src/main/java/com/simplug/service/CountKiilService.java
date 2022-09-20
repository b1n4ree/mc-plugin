package com.simplug.service;

import java.util.HashMap;

public class CountKiilService {

    private final HashMap<String, Long> countKills;

    public CountKiilService() {
        countKills = new HashMap<>();
    }

    public HashMap setCountKills(String name, Long kill) {

        countKills.put(name, kill);
        return countKills;
    }

    public HashMap getCountKills(String name, Long kill) {
        return countKills;
    }
}
