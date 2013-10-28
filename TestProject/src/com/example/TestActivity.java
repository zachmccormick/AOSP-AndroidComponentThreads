package com.example;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;

import com.example.TestLocalService.LocalBinder;

public class TestActivity extends Activity {

	/**
	 * We test threads by printing the thread name in each of the following 1.
	 * Activity operations 2. Local Service operations 3. Remote Service
	 * operations 4. Local ContentProvider operations 5. Remote ContentProvider
	 * operations 6. Local BroadcastReceiver operations 7. Remote
	 * BroadcastReceiver operations
	 * 
	 * Uncomment what you want to look at. It gets messy if you uncomment them
	 * all
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// // part 1
		// Log.i("Activity", "Activity: " + Thread.currentThread().getName());
		//
		// // part 2
		// bindService(new Intent(this, TestLocalService.class), mConnection,
		// BIND_AUTO_CREATE);
		//
		// // part 3
		// bindService(new Intent(this, TestRemoteService.class), mConnection2,
		// BIND_AUTO_CREATE);
		//
		// // part 4
		// Log.i("LocalContentProvider", "activity onCreate");
		// getContentResolver().insert(TestLocalContentProvider.CONTENT_URI,
		// new ContentValues());
		// (new Thread() {
		// @Override
		// public void run() {
		// Log.i("LocalContentProvider", "in a new thread");
		// getContentResolver().insert(
		// TestLocalContentProvider.CONTENT_URI,
		// new ContentValues());
		// }
		// }).start();
		//
		// // part 5
		// Log.i("RemoteContentProvider", "activity onCreate");
		// getContentResolver().insert(TestRemoteContentProvider.CONTENT_URI,
		// new ContentValues());
		// (new Thread() {
		// @Override
		// public void run() {
		// Log.i("RemoteContentProvider", "in a new thread");
		// getContentResolver().insert(
		// TestRemoteContentProvider.CONTENT_URI,
		// new ContentValues());
		// }
		// }).start();

		// // part 6
		// Log.i("LocalBroadcastReceiver", "activity onCreate");
		// sendBroadcast(new Intent("com.example.local"));
		// (new Thread() {
		// @Override
		// public void run() {
		// Log.i("LocalBroadcastReceiver", "in a new thread");
		// sendBroadcast(new Intent("com.example.local"));
		// }
		// }).start();

		// // part 7
		// Log.i("activityProcess", "pid: " + Process.myPid());
		// Log.i("RemoteBroadcastReceiver", "activity onCreate");
		// sendBroadcast(new Intent("com.example.remote"));
		// (new Thread() {
		// @Override
		// public void run() {
		// Log.i("RemoteBroadcastReceiver", "in a new thread");
		// sendBroadcast(new Intent("com.example.remote"));
		// }
		// }).start();
	}

	TestLocalService mTestLocalService;
	private ServiceConnection mConnection = new ServiceConnection() {
		public void onServiceConnected(ComponentName className, IBinder service) {
			mTestLocalService = ((LocalBinder) service).getService();
			Log.i("LocalService", "onServiceConnected callback");
			mTestLocalService.go();
			(new Thread() {
				@Override
				public void run() {
					Log.i("LocalService", "in a new thread");
					mTestLocalService.go();
				}
			}).start();
		}

		public void onServiceDisconnected(ComponentName className) {
			mTestLocalService = null;
		}
	};

	ITestRemoteService mITestRemoteService;
	private ServiceConnection mConnection2 = new ServiceConnection() {
		public void onServiceConnected(ComponentName className, IBinder service) {
			mITestRemoteService = ITestRemoteService.Stub.asInterface(service);
			try {
				Log.i("RemoteService", "onServiceConnected callback");
				mITestRemoteService.go();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			(new Thread() {
				@Override
				public void run() {
					Log.i("RemoteService", "in a new thread");
					try {
						mITestRemoteService.go();
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}

		public void onServiceDisconnected(ComponentName className) {
			mITestRemoteService = null;
		}
	};

}
