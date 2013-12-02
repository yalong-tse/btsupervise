package com.dreaming.btsupervise.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper
{
  private static DBHelper mInstance;

  private DBHelper(Context paramContext)
  {
    super(paramContext, "renzhijian_btc", null, 2);
  }

  public static DBHelper getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null)
        mInstance = new DBHelper(paramContext);
      DBHelper localDBHelper = mInstance;
      return localDBHelper;
    }
    finally
    {
//      localObject = finally;
//      throw localObject;
    }
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS  btc ( _id INTEGEREGER PRIMARY KEY, id INTEGER,name VARCHAR(32), last DOUBLE,buy DOUBLE,sell DOUBLE ,high DOUBLE,low DOUBLE,vol DOUBLE,kind INTEGER,time VARCHAR(32),state INTEGER)");
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS btc");
    onCreate(paramSQLiteDatabase);
  }
}

/* Location:           C:\Users\Administrator\Desktop\classes_dex2jar\
 * Qualified Name:     com.renzhijian.btc.db.DBHelper
 * JD-Core Version:    0.6.2
 */