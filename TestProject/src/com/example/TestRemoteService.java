package com.example;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class TestRemoteService extends Service {
	
	private final ITestRemoteService.Stub mBinder = new ITestRemoteService.Stub() {
		@Override
		public void go() throws RemoteException {
			Log.i("THREAD", "RemoteService: " + Thread.currentThread().getName());
		}
	};

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}

}
