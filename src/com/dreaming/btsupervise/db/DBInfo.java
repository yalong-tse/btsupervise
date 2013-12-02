package com.dreaming.btsupervise.db;

public class DBInfo
{
  public static class DB
  {
    public static final String DB_NAME = "renzhijian_btc";
    public static final int VERSION = 2;
  }

  public static class Table
  {
    public static final String BTC_CREATE = "CREATE TABLE IF NOT EXISTS  btc ( _id INTEGEREGER PRIMARY KEY, id INTEGER,name VARCHAR(32), last DOUBLE,buy DOUBLE,sell DOUBLE ,high DOUBLE,low DOUBLE,vol DOUBLE,kind INTEGER,time VARCHAR(32),state INTEGER)";
    public static final String BTC_TB_NAME = "btc";
  }
}

/* Location:           C:\Users\Administrator\Desktop\classes_dex2jar\
 * Qualified Name:     com.renzhijian.btc.db.DBInfo
 * JD-Core Version:    0.6.2
 */