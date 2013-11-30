package com.dreaming.btsupervise.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Btc
{
  public static final String BITSTAMP = "Bitstamp";
  public static final String BTC100 = "BTC100";
  public static final String BTCCHINA = "比特币中国";
  public static final String BTCE = "btc-e";
  public static final String BTCE_LTC = "btc-e(ltc)";
  public static final String BTCTRADE = "btcTrade";
  public static final String BTCTRADE_LTC = "btcTrade(ltc)";
  public static final String BTER = "比特儿Bter";
  public static final String FXBTC = "FXBTC";
  public static final String FXBTC_LTC = "FXBTC(ltc)";
  public static final String GOXBTC = "GoXBTC";
  public static final String HUOBI = "火币网";
  public static final int KIND_BTC_CNY = 1;
  public static final int KIND_BTC_USD = 2;
  public static final int KIND_LTC_CNY = 3;
  public static final int KIND_LTC_USD = 4;
  public static final String MTGOX = "Mt.Gox";
  public static final String OKCOIN = "OkCoin";
  public static final String OKCOIN_LTC = "OkCoin(ltc)";
  public static final String QIJIULIU = "796期货";
  public static final String RMBTB = "人盟比特币";
  
  public double buy;
  public double high;
  public int kind;
  public double last;
  public double low;
  public String name;
  public int order;
  public double sell;
  public int state;
  public String time;
  public double vol;

  public Btc()
  {
  }

  public Btc(int paramInt1, String paramString, int paramInt2)
  {
    this.order = paramInt1;
    this.name = paramString;
    this.kind = paramInt2;
    this.time = new SimpleDateFormat("MM-dd HH:mm:ss").format(new Date());
  }
}
