package com.jiva.ai;

import android.content.Context;
import android.content.SharedPreferences;

public class JivaNotes {

    private static final String PREFS = "jiva_notes";
    private static final String KEY_NOTES = "notes";

    private final SharedPreferences prefs;

    public JivaNotes(Context context) {
        prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public void add(String note) {
        String old = prefs.getString(KEY_NOTES, "");
        String updated = old.isEmpty()
                ? note
                : old + "\n" + note;

        prefs.edit().putString(KEY_NOTES, updated).apply();
    }

    public String load() {
        return prefs.getString(KEY_NOTES, "");
    }

    public void clear() {
        prefs.edit().remove(KEY_NOTES).apply();
    }
}
