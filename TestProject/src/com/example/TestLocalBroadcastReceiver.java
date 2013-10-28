package com.example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TestLocalBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("THREAD", "LocalBroadcastReceiver: " + Thread.currentThread().getName());
	}

}
