package com.example.user.rulayounis;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {

    private MediaPlayer mp;
    private static boolean isRunning=false;
    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp=MediaPlayer.create(getApplicationContext(),R.raw.creativeminds);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp.setLooping(true);
        mp.start();
        isRunning= true;
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        mp.stop();
        isRunning = false;
        super.onDestroy();
    }
}
