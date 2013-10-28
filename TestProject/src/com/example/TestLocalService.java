package com.example;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class TestLocalService extends Service {

	public class LocalBinder extends Binder {
		TestLocalService getService() {
			return TestLocalService.this;
		}
	}
	
	private final LocalBinder mBinder = new LocalBinder();

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}

	public void go() {
		Log.i("THREAD", "LocalService: " + Thread.currentThread().getName());
	}
}
