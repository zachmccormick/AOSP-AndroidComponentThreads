package com.example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;

public class TestRemoteBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("PROCESS", "pid: " + Process.myPid());
		Log.i("THREAD", "RemoteBroadcastReceiver: " + Thread.currentThread().getName());
	}

}
