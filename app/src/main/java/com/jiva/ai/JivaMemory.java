package com.jiva.ai;

import android.content.Context;
import android.content.SharedPreferences;

public class JivaMemory {

    private static final String PREFS = "jiva_memory";
    private static final String KEY_MEMORY = "memory";

    private final SharedPreferences prefs;

    public JivaMemory(Context context) {
        prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public void save(String text) {
        prefs.edit().putString(KEY_MEMORY, text).apply();
    }

    public String load() {
        return prefs.getString(KEY_MEMORY, "");
    }

    public void clear() {
        prefs.edit().remove(KEY_MEMORY).apply();
    }
}
