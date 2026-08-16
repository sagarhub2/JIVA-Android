package com.jiva.ai;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;

public class JivaScreenCapture {

    public static final int REQUEST_SCREEN_CAPTURE = 5001;

    private final Activity activity;

    public JivaScreenCapture(Activity activity) {
        this.activity = activity;
    }

    public void requestCapturePermission() {
        MediaProjectionManager manager =
                (MediaProjectionManager)
                activity.getSystemService(
                        Context.MEDIA_PROJECTION_SERVICE);

        if (manager != null) {
            Intent intent =
                    manager.createScreenCaptureIntent();

            activity.startActivityForResult(
                    intent,
                    REQUEST_SCREEN_CAPTURE);
        }
    }
}
