package com.dreaming.btsupervise.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * 
 * 数据库操作的基础类
 * 
 * */
public class BaseService 
{
	public DBHelper dbHelper;

	public BaseService(Context paramContext) 
	{
		this.dbHelper = DBHelper.getInstance(paramContext);
	}

	public SQLiteDatabase beginTransaction() 
	{
		SQLiteDatabase localSQLiteDatabase = this.dbHelper.getWritableDatabase();
		localSQLiteDatabase.beginTransaction();
		return localSQLiteDatabase;
	}

	public void clearDB() 
	{
		this.dbHelper.getWritableDatabase().delete("btc", null, null);
	}

	public void deleteTableData(String paramString) 
	{
		this.dbHelper.getWritableDatabase().delete(paramString, null, null);
	}

	public void endTransaction(SQLiteDatabase paramSQLiteDatabase) 
	{
		paramSQLiteDatabase.endTransaction();
	}
}
