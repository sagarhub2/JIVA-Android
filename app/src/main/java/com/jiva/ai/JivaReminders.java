package com.jiva.ai;

import android.content.Context;
import android.content.SharedPreferences;

public class JivaReminders {

    private static final String PREFS = "jiva_reminders";
    private static final String KEY_REMINDERS = "reminders";

    private final SharedPreferences prefs;

    public JivaReminders(Context context) {
        prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public void add(String reminder) {
        String old = prefs.getString(KEY_REMINDERS, "");
        String updated = old.isEmpty()
                ? reminder
                : old + "\n" + reminder;

        prefs.edit().putString(KEY_REMINDERS, updated).apply();
    }

    public String load() {
        return prefs.getString(KEY_REMINDERS, "");
    }

    public void clear() {
        prefs.edit().remove(KEY_REMINDERS).apply();
    }
}
