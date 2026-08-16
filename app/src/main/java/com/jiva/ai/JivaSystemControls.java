package com.jiva.ai;

import android.content.Context;
import android.media.AudioManager;

public class JivaSystemControls {

    private final AudioManager audioManager;

    public JivaSystemControls(Context context) {
        audioManager =
                (AudioManager) context.getSystemService(
                        Context.AUDIO_SERVICE);
    }

    public void volumeUp() {
        if (audioManager != null) {
            audioManager.adjustVolume(
                    AudioManager.ADJUST_RAISE, 0);
        }
    }

    public void volumeDown() {
        if (audioManager != null) {
            audioManager.adjustVolume(
                    AudioManager.ADJUST_LOWER, 0);
        }
    }
}
