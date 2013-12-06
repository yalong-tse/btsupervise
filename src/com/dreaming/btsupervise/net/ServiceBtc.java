package com.dreaming.btsupervise.net;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.util.Log;

public class ServiceBtc extends Service {
	 
    private static final String TAG = "MyService";
    public static final String ACTION = "com.dreaming.btsupervise.net.MainService";
    private Context context;
    private SharedPreferences sharedPrefs;
	private TaskParams taskParams;
    /*
     * (non-Javadoc)
     * 
     * @see android.app.Service#onBind(android.content.Intent)
     */
    @Override
    public IBinder onBind(Intent arg0) {
    	Log.d("TEST","qianjinService6");
        return null;
    }
 
    @Override
    public void onCreate() {
        Log.v(TAG, "onCreate");
        Log.d("TEST","qianjinService7");
//        if (mediaPlayer == null) {
//            mediaPlayer = MediaPlayer.create(this, R.raw.tmp);
//            mediaPlayer.setLooping(false);
//        }
    }
 
    @Override
    public void onDestroy() {
        Log.v(TAG, "onDestroy");
        Log.d("TEST","qianjinService8");
//        if (mediaPlayer != null) {
//            mediaPlayer.stop();
//            mediaPlayer.release();
//        }
    }
 
    @Override
    public void onStart(Intent intent, int startId) {
       Log.v(TAG, "onStart");
       Log.d("TEST","qianjinService9");

    }
}












