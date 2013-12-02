package com.dreaming.btsupervise.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

  private boolean findIfExist(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    String[] arrayOfString1 = new String[0];
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = paramString;
    Cursor localCursor = paramSQLiteDatabase.query("btc", arrayOfString1, "name=?", arrayOfString2, null, null, null);
    if ((localCursor != null) && (localCursor.getCount() > 0))
      localCursor.close();
    for (boolean bool = true; ; bool = false)
    {
      localCursor.close();
      return bool;
    }
  }

  public boolean deleteByName(String paramString)
  {
    boolean bool = true;
    SQLiteDatabase localSQLiteDatabase = this.dbHelper.getWritableDatabase();
    String[] arrayOfString = new String[1000];//
    arrayOfString[0] = paramString;
    if (localSQLiteDatabase.delete("btc", "name=?", arrayOfString) > 0);
    while (true)
    {
    	bool = false;
      return bool;
    }
  }

  public boolean deleteByName(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    boolean bool = true;
    String[] arrayOfString = new String[1000];
    arrayOfString[0] = paramString;
    if (paramSQLiteDatabase.delete("btc", "name=?", arrayOfString) > 0);
    while (true)
    {
    	bool = false;
      return bool;
      
    }
  }

  public Btc findBtcByName(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.dbHelper.getReadableDatabase();
    Btc localBtc = null;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramString;
    Cursor localCursor = localSQLiteDatabase.query("btc", null, "name=?", arrayOfString, null, null, null);
    if ((localCursor != null) && (localCursor.getCount() > 0) && (localCursor.moveToNext()))
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
    }
    localCursor.close();
    return localBtc;
  }

  public List<Btc> findBtcs()
  {
    SQLiteDatabase localSQLiteDatabase = this.dbHelper.getReadableDatabase();
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = localSQLiteDatabase.query("btc", this.columns, null, null, null, null, "id asc");
    if ((localCursor != null) && (localCursor.getCount() > 0));
    while (true)
    {
      if (!localCursor.moveToNext())
      {
        localCursor.close();
        return localArrayList;
      }
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
      localArrayList.add(localBtc);
    }
  }

  public void save(Btc paramBtc, SQLiteDatabase paramSQLiteDatabase)
  {
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
      paramSQLiteDatabase.insert("btc", null, localContentValues);
  }

  public void saveOrUpdate(SQLiteDatabase paramSQLiteDatabase, Btc paramBtc)
  {
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
      if ((localBtc.last != 0.0D) && (paramBtc.last != 0.0D))
      {
        if (paramBtc.last <= localBtc.last)
        localContentValues.put("state", Integer.valueOf(1));
      }
    while (true)
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramBtc.name;
      paramSQLiteDatabase.update("btc", localContentValues, "name=?", arrayOfString);
      while (true)
      {
        if (paramBtc.last >= localBtc.last)
        	localContentValues.put("state", Integer.valueOf(-1));
        else{
	        paramSQLiteDatabase.insert("btc", null, localContentValues);
	        break;
        }
      }
    }
  }

  public void saveOrUpdate(Btc paramBtc)
  {
    saveOrUpdate(this.dbHelper.getWritableDatabase(), paramBtc);
  }
}

/* Location:           C:\Users\Administrator\Desktop\classes_dex2jar\
 * Qualified Name:     com.renzhijian.btc.db.BtcService
 * JD-Core Version:    0.6.2
 */