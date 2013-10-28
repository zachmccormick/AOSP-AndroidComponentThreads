package com.example;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class TestRemoteContentProvider extends ContentProvider {

	static final String PROVIDER_NAME = "com.example.remoteprovider";
	static final String URL = "content://" + PROVIDER_NAME + "/remotedata";
	static final Uri CONTENT_URI = Uri.parse(URL);

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		Log.i("THREAD", "RemoteContentProvider: "
				+ Thread.currentThread().getName());
		return null;
	}

	@Override
	public boolean onCreate() {
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		return null;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		return 0;
	}

}
