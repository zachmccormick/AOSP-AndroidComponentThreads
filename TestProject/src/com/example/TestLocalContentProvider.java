package com.example;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class TestLocalContentProvider extends ContentProvider {

	static final String PROVIDER_NAME = "com.example.localprovider";
	static final String URL = "content://" + PROVIDER_NAME + "/localdata";
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
		Log.i("THREAD", "LocalContentProvider: "
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
