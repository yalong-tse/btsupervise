package com.dreaming.btsupervise.db;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dreaming.btsupervise.beans.Btc;

public class BtcService extends BaseService 
{
	private String[] columns;

	public BtcService(Context paramContext) 
	{
		super(paramContext);
		String[] arrayOfString = new String[11];
		arrayOfString[0] = "id";
		arrayOfString[1] = "name";
		arrayOfString[2] = "last";
		arrayOfString[3] = "buy";
		arrayOfString[4] = "sell";
		arrayOfString[5] = "high";
		arrayOfString[6] = "low";
		arrayOfString[7] = "vol";
		arrayOfString[8] = "kind";
		arrayOfString[9] = "time";
		arrayOfString[10] = "state";
		this.columns = arrayOfString;
	}

	/**
	 * 查看记录是否存在
	 * */
	private boolean findIfExist(SQLiteDatabase paramSQLiteDatabase,String paramString) {
		boolean result = false;
		String[] arrayOfString1 = new String[0];
		String[] arrayOfString2 = new String[1];
		arrayOfString2[0] = paramString;
		Cursor localCursor = paramSQLiteDatabase.query("btc", arrayOfString1,"name=?", arrayOfString2, null, null, null);
		
		if ((localCursor != null) && (localCursor.getCount() > 0))
		{
			localCursor.close();
			result = true;
		}

		return result;
	}

	/**
	 * 根据名称删除数据
	 * */
	public boolean deleteByName(String paramString) 
	{
		boolean result = false;
		SQLiteDatabase localSQLiteDatabase = this.dbHelper.getWritableDatabase();
		String[] arrayOfString = new String[]{paramString};
		if (localSQLiteDatabase.delete("btc", "name=?", arrayOfString) > 0)
		{
			result = true;
		}
		return result;
	}

	/**
	 * 
	 * */
	public boolean deleteByName(String paramString,SQLiteDatabase paramSQLiteDatabase) {
		boolean bool = false;
		String[] arrayOfString = new String[] { paramString };
		if (paramSQLiteDatabase.delete("btc", "name=?", arrayOfString) > 0) {
			bool = true;
		}
		return bool;

	}

	/**
	 * 根据名称查找
	 * */
	public Btc findBtcByName(String paramString) 
	{
		SQLiteDatabase localSQLiteDatabase = this.dbHelper.getReadableDatabase();
		Btc localBtc = null;
		Cursor localCursor = localSQLiteDatabase.query("btc", null, "name=?",new String[]{paramString}, null, null, null);
		if ((localCursor != null) && (localCursor.getCount() > 0)&& (localCursor.moveToNext())) 
		{
			localBtc = new Btc();
			localBtc.order = localCursor.getInt(localCursor.getColumnIndex("id"));
			localBtc.name = localCursor.getString(localCursor.getColumnIndex("name"));
			localBtc.time = localCursor.getString(localCursor.getColumnIndex("time"));
			localBtc.last = localCursor.getDouble(localCursor.getColumnIndex("last"));
			localBtc.buy = localCursor.getDouble(localCursor.getColumnIndex("buy"));
			localBtc.sell = localCursor.getDouble(localCursor.getColumnIndex("sell"));
			localBtc.high = localCursor.getDouble(localCursor.getColumnIndex("high"));
			localBtc.low = localCursor.getDouble(localCursor.getColumnIndex("low"));
			localBtc.vol = localCursor.getDouble(localCursor.getColumnIndex("vol"));
			localBtc.kind = localCursor.getInt(localCursor.getColumnIndex("kind"));
			localBtc.state = localCursor.getInt(localCursor.getColumnIndex("state"));
			localCursor.close();
		}
		
		return localBtc;
	}

	/**
	 * 获取所有的btc
	 * */
	public List<Btc> findBtcs() {
		SQLiteDatabase localSQLiteDatabase = this.dbHelper.getReadableDatabase();
		List<Btc> btcList  = new ArrayList<Btc>();
		
		Cursor localCursor = localSQLiteDatabase.query(DBHelper.BTC_TABLE_NAME, this.columns,null, null, null, null, "id asc");
		
		Log.d("DB","query database");
		
		while (localCursor.moveToNext())
		{
			Btc localBtc = new Btc();
			localBtc.order = localCursor.getInt(localCursor.getColumnIndex("id"));
			localBtc.name = localCursor.getString(localCursor.getColumnIndex("name"));
			localBtc.time = localCursor.getString(localCursor.getColumnIndex("time"));
			localBtc.last = localCursor.getDouble(localCursor.getColumnIndex("last"));
			localBtc.buy = localCursor.getDouble(localCursor.getColumnIndex("buy"));
			localBtc.sell = localCursor.getDouble(localCursor.getColumnIndex("sell"));
			localBtc.high = localCursor.getDouble(localCursor.getColumnIndex("high"));
			localBtc.low = localCursor.getDouble(localCursor.getColumnIndex("low"));
			localBtc.vol = localCursor.getDouble(localCursor.getColumnIndex("vol"));
			localBtc.kind = localCursor.getInt(localCursor.getColumnIndex("kind"));
			localBtc.state = localCursor.getInt(localCursor.getColumnIndex("state"));
			Log.d("DB","query database: " + localBtc.name);
			btcList.add(localBtc);
			//if(!localCursor.isLast()) localCursor.moveToNext();
		}
		
		Log.d("DB","query database finish");
		return btcList;
	}

	/**
	 * 保存
	 * */
	public void save(Btc paramBtc, SQLiteDatabase paramSQLiteDatabase) {
		ContentValues localContentValues = new ContentValues();
		localContentValues.put("id", Integer.valueOf(paramBtc.order));
		localContentValues.put("name", paramBtc.name);
		localContentValues.put("last", Double.valueOf(paramBtc.last));
		localContentValues.put("buy", Double.valueOf(paramBtc.buy));
		localContentValues.put("sell", Double.valueOf(paramBtc.sell));
		localContentValues.put("high", Double.valueOf(paramBtc.high));
		localContentValues.put("low", Double.valueOf(paramBtc.low));
		localContentValues.put("vol", Double.valueOf(paramBtc.vol));
		localContentValues.put("kind", Integer.valueOf(paramBtc.kind));
		localContentValues.put("time", paramBtc.time);
		localContentValues.put("state", Integer.valueOf(paramBtc.state));
		if (!findIfExist(paramSQLiteDatabase, paramBtc.name))
		{
			paramSQLiteDatabase.insert("btc", null, localContentValues);
		}
	}

	
	/**
	 *  
	 * */
	public void saveOrUpdate(SQLiteDatabase paramSQLiteDatabase, Btc paramBtc) {
		ContentValues localContentValues = new ContentValues();
		localContentValues.put("id", Integer.valueOf(paramBtc.order));
		localContentValues.put("name", paramBtc.name);
		localContentValues.put("last", Double.valueOf(paramBtc.last));
		localContentValues.put("buy", Double.valueOf(paramBtc.buy));
		localContentValues.put("sell", Double.valueOf(paramBtc.sell));
		localContentValues.put("high", Double.valueOf(paramBtc.high));
		localContentValues.put("low", Double.valueOf(paramBtc.low));
		localContentValues.put("vol", Double.valueOf(paramBtc.vol));
		localContentValues.put("kind", Integer.valueOf(paramBtc.kind));
		localContentValues.put("time", paramBtc.time);
		localContentValues.put("state", Integer.valueOf(0));
		Btc localBtc = findBtcByName(paramBtc.name);
		
		if (localBtc != null)
		{
			if ((localBtc.last != 0.0D) && (paramBtc.last != 0.0D)) 
			{
				if (paramBtc.last <= localBtc.last)
					localContentValues.put("state", Integer.valueOf(1));
				else if(paramBtc.last >= localBtc.last)
				{
					localContentValues.put("state", Integer.valueOf(-1));
				}
			}

			paramSQLiteDatabase.update("btc", localContentValues, "name=?",new String[]{paramBtc.name});
			
		}
		else
		{
			paramSQLiteDatabase.insert("btc", null, localContentValues);
		}
	}

	public void saveOrUpdate(Btc paramBtc) {
		saveOrUpdate(this.dbHelper.getWritableDatabase(), paramBtc);
	}
}
