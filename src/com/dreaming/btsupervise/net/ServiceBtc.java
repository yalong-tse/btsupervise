package com.dreaming.btsupervise.net;

import org.json.JSONObject;

import com.dreaming.btsupervise.beans.Btc;
import com.dreaming.btsupervise.db.BtcService;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class ServiceBtc extends Service {
	 
    private static final String TAG = "MyService";
 
    /*
     * (non-Javadoc)
     * 
     * @see android.app.Service#onBind(android.content.Intent)
     */
    @Override
    public IBinder onBind(Intent arg0) {
    	Log.d("TEST","qianjinService");
        return null;
    }
 
    @Override
    public void onCreate() {
        Log.v(TAG, "onCreate");
        Log.d("TEST","qianjinService");
//        if (mediaPlayer == null) {
//            mediaPlayer = MediaPlayer.create(this, R.raw.tmp);
//            mediaPlayer.setLooping(false);
//        }
    }
 
    @Override
    public void onDestroy() {
        Log.v(TAG, "onDestroy");
        Log.d("TEST","qianjinService");
//        if (mediaPlayer != null) {
//            mediaPlayer.stop();
//            mediaPlayer.release();
//        }
    }
 
    @Override
    public void onStart(Intent intent, int startId) {
        Log.v(TAG, "onStart");
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
            	
            	Log.d("TEST","qianjinService");
            }
        }
    }
}