package com.dreaming.btsupervise.net;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.telephony.TelephonyManager;


/**
 * 网络状态探测
 * */

public class NetworkProber {
	public static boolean is3G(Context paramContext) {
		NetworkInfo localNetworkInfo = ((ConnectivityManager) paramContext
				.getSystemService("connectivity")).getActiveNetworkInfo();
		if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 0))
			return false;
		else
			return true;
	}

	public static boolean isGpsEnabled(Context paramContext) {
		return ((LocationManager) paramContext.getSystemService("location"))
				.isProviderEnabled("gps");
	}

	public static boolean isNetworkAvailable(Context paramContext) {
		int i = 0;
		try {
			ConnectivityManager localConnectivityManager = (ConnectivityManager) paramContext.getSystemService("connectivity");
			if (localConnectivityManager != null) {
				NetworkInfo localNetworkInfo = localConnectivityManager
						.getActiveNetworkInfo();
				if ((localNetworkInfo != null)
						&& (localNetworkInfo.isConnected())) {
					if (localNetworkInfo.getState() == NetworkInfo.State.CONNECTED)
						return true;
				}
			}
			return false;
		} catch (Exception localException) {
			localException.getMessage();
			return false;
		}
	}

	public static boolean isWifi(Context paramContext) {
		NetworkInfo localNetworkInfo = ((ConnectivityManager) paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
		if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1))
			return true;
		else
			return false;
	}

	public static boolean isWifiEnabled(Context paramContext) {
		ConnectivityManager localConnectivityManager = (ConnectivityManager) paramContext.getSystemService("connectivity");
		TelephonyManager localTelephonyManager = (TelephonyManager) paramContext.getSystemService("phone");
		
		if ((((localConnectivityManager.getActiveNetworkInfo() == null) || (localConnectivityManager
				.getActiveNetworkInfo().getState() != NetworkInfo.State.CONNECTED)))
				&& (localTelephonyManager.getNetworkType() != 3))
			return true;
		else
			return false;
	}
}
