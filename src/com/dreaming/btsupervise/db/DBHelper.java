package com.dreaming.btsupervise.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * DB操作的基础类
 * */
public class DBHelper extends SQLiteOpenHelper {
	private static DBHelper mInstance;

	private DBHelper(Context paramContext) {
		super(paramContext, "btcdatabase", null, 2);
	}

	public static DBHelper getInstance(Context paramContext) {
		try 
		{
			if (mInstance == null)
				mInstance = new DBHelper(paramContext);
			return mInstance;
		} finally {
			// localObject = finally;
			// throw localObject;
		}
	}

	public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
		paramSQLiteDatabase
				.execSQL("CREATE TABLE IF NOT EXISTS  btc ( _id INTEGEREGER PRIMARY KEY, id INTEGER,name VARCHAR(32), last DOUBLE,buy DOUBLE,sell DOUBLE ,high DOUBLE,low DOUBLE,vol DOUBLE,kind INTEGER,time VARCHAR(32),state INTEGER)");
	}

	public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1,
			int paramInt2) {
		paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS btc");
		onCreate(paramSQLiteDatabase);
	}
}
