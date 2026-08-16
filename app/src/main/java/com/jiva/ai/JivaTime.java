package com.jiva.ai;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class JivaTime {

    public static String getDateTime() {
        SimpleDateFormat format =
                new SimpleDateFormat(
                        "dd MMMM yyyy, hh:mm a",
                        Locale.getDefault());

        return format.format(new Date());
    }
}
