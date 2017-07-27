package cn.buildworld.ahlive.utils;

import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.util.Log;

import fm.jiecao.jcvideoplayer_lib.JCMediaManager;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 作者：MiChong on 2017/7/26 0026 19:04
 * 邮箱：1564666023@qq.com
 *
 * 封装视频播放器，是为了在fragment中实现视频暂停的功能
 */
public class StandardVideoPlayer extends JCVideoPlayerStandard {
    // Set the flag for storing if user click the start button for pausing.
    // For fixing the bug about the invalidation of status switching between resume and pause.
    private static boolean isPauseByClick = false;
    private static AudioManager.OnAudioFocusChangeListener onOriginAudioFocusChangeListener;

    public StandardVideoPlayer(Context context) {
        this(context, null);
    }

    public StandardVideoPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);

        // Store the original listener.
        if (onOriginAudioFocusChangeListener == null) {
            onOriginAudioFocusChangeListener = onAudioFocusChangeListener;
        }
        // Sets the old logic and modifying the field {@link #isPauseByClick}.
        onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int focusChange) {
                switch (focusChange) {
                    // This logic is copied from the origin code.
                    // Remembering update the logic when updating the lib.
                    case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                        pauseVideo();
                        Log.d(TAG, "AUDIOFOCUS_LOSS_TRANSIENT [" + this.hashCode() + "]");
                        break;
                    default:
                        onOriginAudioFocusChangeListener.onAudioFocusChange(focusChange);
                        break;
                }
            }
        };
    }

    @Override
    public void setSystemUiVisibility(int visibility) {
        super.setSystemUiVisibility(visibility);
        switch (currentState) {
            case CURRENT_STATE_PAUSE:
                // It will enter this case when click the start button for pausing.
                isPauseByClick = true;
                break;
        }
    }

    /**
     * Pause the standard video player.
     * Used in the method such as onPause() in Activity or Fragment.
     */
    public static void pauseVideo() {
        try {
            if (JCMediaManager.instance().mediaPlayer != null &&
                    JCMediaManager.instance().mediaPlayer.isPlaying()) {

                JCMediaManager.instance().mediaPlayer.pause();
                isPauseByClick = false;
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    /**
     * Resume the standard video player.
     * Used in the method such as onResume() in Activity or Fragment.
     */
    public static void resumeVideo() {
        try {
            if (JCMediaManager.instance().mediaPlayer != null && !JCMediaManager.instance().mediaPlayer
                    .isPlaying() && !isPauseByClick ) {

                JCMediaManager.instance().mediaPlayer.start();

            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}