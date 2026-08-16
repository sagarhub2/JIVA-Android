package com.jiva.ai;

import android.content.Context;
import android.content.SharedPreferences;

public class JivaHistory {

    private static final String PREFS = "jiva_history";
    private static final String KEY_HISTORY = "history";

    private final SharedPreferences prefs;

    public JivaHistory(Context context) {
        prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public void add(String message) {
        String old = prefs.getString(KEY_HISTORY, "");
        String updated = old.isEmpty() ? message : old + "\n" + message;
        prefs.edit().putString(KEY_HISTORY, updated).apply();
    }

    public String load() {
        return prefs.getString(KEY_HISTORY, "");
    }

    public void clear() {
        prefs.edit().remove(KEY_HISTORY).apply();
    }
}
