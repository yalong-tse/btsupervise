package com.dreaming.btsupervise.net;

public class TaskParamsManager
{
  private static TaskParamsManager taskParamsManager = new TaskParamsManager();
  private String bitstampDeepUrl = "https://www.bitstamp.net/api/order_book/";
  private String bitstampTradeUrl = "https://www.bitstamp.net/api/transactions/";
  private String bitstampUrl = "https://www.bitstamp.net/api/ticker/";
  private String btc100DeepUrl = "https://btc100.org/api/depth.php";
  private String btc100TradeUrl = "https://btc100.org/api/trades.php";
  private String btc100Url = "https://btc100.org/api/ticker.php";
  private String btcchinaDeepUrl = "https://data.btcchina.com/data/orderbook";
  private String btcchinaTradeUrl = "https://data.btcchina.com/data/historydata";
  private String btcchinaUrl = "https://data.btcchina.com/data/ticker";
  private String btceDeepUrl = "https://btc-e.com/api/2/btc_usd/depth";
  private String btceLtcDeepUrl = "https://btc-e.com/api/2/ltc_usd/depth";
  private String btceLtcTradeUrl = "https://btc-e.com/api/2/ltc_usd/trades";
  private String btceLtcUrl = "https://btc-e.com/api/2/ltc_usd/ticker";
  private String btceTradeUrl = "https://btc-e.com/api/2/btc_usd/trades";
  private String btceUrl = "https://btc-e.com/api/2/btc_usd/ticker";
  private String btctradeDeepUrl = "http://www.btctrade.com/api/depth";
  private String btctradeLtcDeepUrl = "http://www.btctrade.com/api/depth?coin=2";
  private String btctradeLtcTradeUrl = "http://www.btctrade.com/api/trades?coin=2";
  private String btctradeLtcUrl = "http://www.btctrade.com/api/ticker?coin=2";
  private String btctradeTradeUrl = "http://www.btctrade.com/btc_trades";
  private String btctradeUrl = "http://www.btctrade.com/api/ticker";
  private String bterDeepUrl = "https://bter.com/api/1/depth/btc_cny";
  private String bterTradeUrl = "https://bter.com/api/1/trade/btc_cny";
  private String bterUrl = "https://bter.com/api/1/ticker/btc_cny";
  private String chbtcDeepUrl = "http://api.chbtc.com/data/depth";
  private String chbtcTradeUrl = "http://api.chbtc.com/data/trades";
  private String fxbtcDeepUrl = "https://data.fxbtc.com/api?op=query_depth&symbol=btc_cny";
  private String fxbtcLtcDeepUrl = "https://data.fxbtc.com/api?op=query_depth&symbol=ltc_cny";
  private String fxbtcLtcTradeUrl = "https://data.fxbtc.com/api?op=query_last_trades&symbol=ltc_cny&count=100";
  private String fxbtcLtcUrl = "https://data.fxbtc.com/api?op=query_ticker&symbol=ltc_cny";
  private String fxbtcTradeUrl = "https://data.fxbtc.com/api?op=query_last_trades&symbol=btc_cny&count=100";
  private String fxbtcUrl = "https://data.fxbtc.com/api?op=query_ticker&symbol=btc_cny";
  private String goxbtcDeepUrl = "https://goxbtc.com/api/new/btc_cny/depth.htm";
  private String goxbtcTradeUrl = "https://goxbtc.com/api/new/btc_cny/trade.htm";
  private String goxbtcUrl = "https://goxbtc.com/api/new/btc_cny/ticker.htm";
  private String huobiDeepUrl = "https://www.huobi.com/market/huobi.php?a=depth";
  private String huobiTradeUrl = "https://www.huobi.com/market/huobi.php?a=trades";
  private String huobiUrl = "https://www.huobi.com/market/huobi.php?a=ticker";
  private String mtgoxDeepUrl = "http://data.mtgox.com/code/data/getDepth.php?Currency=USD";
  private String mtgoxTradeUrl = "http://data.mtgox.com/api/0/data/getTrades.php?Currency=USD";
  private String mtgoxUrl = "http://data.mtgox.com/api/2/BTCUSD/money/ticker";
  private String okcoinDeepUrl = "https://www.okcoin.com/api/depth.do";
  private String okcoinLtcDeepUrl = "https://www.okcoin.com/api/depth.do?symbol=ltc_cny";
  private String okcoinLtcTradeUrl = "https://www.okcoin.com/api/trades.do?symbol=ltc_cny";
  private String okcoinLtcUrl = "https://www.okcoin.com/api/ticker.do?symbol=ltc_cny";
  private String okcoinTradeUrl = "https://www.okcoin.com/api/trades.do";
  private String okcoinUrl = "https://www.okcoin.com/api/ticker.do";
  private String qijiuliuDeepUrl = "http://api.796.com/apiV2/depth/100.html?op=futures";
  private String qijiuliuTradeUrl = "http://api.796.com/apiV2/trade/100.html?op=futures";
  private String qijiuliuUrl = "http://api.796.com/apiV2/ticker.html?op=futures";
  private String rmbtbDeepUrl = "http://www.rmbtb.com/api/thirdparty/depth/";
  private String rmbtbTradeUrl = "http://www.rmbtb.com/api/thirdparty/lasttrades/";
  private String rmbtbUrl = "http://www.rmbtb.com/api/thirdparty/ticker/";

  public static TaskParamsManager getInstance()
  {
    return taskParamsManager;
  }

  public TaskParams get796DeepUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.qijiuliuDeepUrl;
    localTaskParams.taskId = 212;
    return localTaskParams;
  }

  public TaskParams get796TradeUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.qijiuliuTradeUrl;
    localTaskParams.taskId = 308;
    return localTaskParams;
  }

  public TaskParams get796UrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.qijiuliuUrl;
    localTaskParams.singletonName = "796期货";
    localTaskParams.taskId = 109;
    return localTaskParams;
  }

  public TaskParams getBitstampDeepUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.bitstampDeepUrl;
    localTaskParams.taskId = 206;
    return localTaskParams;
  }

  public TaskParams getBitstampParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.bitstampUrl;
    localTaskParams.singletonName = "Bitstamp";
    localTaskParams.taskId = 106;
    return localTaskParams;
  }

  public TaskParams getBitstampTradeUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.bitstampTradeUrl;
    localTaskParams.taskId = 311;
    return localTaskParams;
  }

  public TaskParams getBtc100DeepUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.btc100DeepUrl;
    localTaskParams.taskId = 210;
    return localTaskParams;
  }

  public TaskParams getBtc100Params()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.btc100Url;
    localTaskParams.singletonName = "BTC100";
    localTaskParams.taskId = 111;
    return localTaskParams;
  }

  public TaskParams getBtc100TradeUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.btc100TradeUrl;
    localTaskParams.taskId = 310;
    return localTaskParams;
  }

  public TaskParams getBtcchinaDeepUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.btcchinaDeepUrl;
    localTaskParams.taskId = 200;
    return localTaskParams;
  }

  public TaskParams getBtcchinaParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.btcchinaUrl;
    localTaskParams.singletonName = "比特币中国";
    localTaskParams.taskId = 100;
    return localTaskParams;
  }

  public TaskParams getBtcchinaTradeUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.btcchinaTradeUrl;
    localTaskParams.taskId = 300;
    return localTaskParams;
  }

  public TaskParams getBtceDeepUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.btceDeepUrl;
    localTaskParams.taskId = 207;
    return localTaskParams;
  }

  public TaskParams getBtceLtcDeepUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.btceLtcDeepUrl;
    localTaskParams.taskId = 220;
    return localTaskParams;
  }

  public TaskParams getBtceLtcParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.btceLtcUrl;
    localTaskParams.singletonName = "btc-e(ltc)";
    localTaskParams.taskId = 120;
    return localTaskParams;
  }

  public TaskParams getBtceLtcTradeUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.btceLtcTradeUrl;
    localTaskParams.taskId = 320;
    return localTaskParams;
  }

  public TaskParams getBtceTradeUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.btceTradeUrl;
    localTaskParams.taskId = 306;
    return localTaskParams;
  }

  public TaskParams getBtceUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.btceUrl;
    localTaskParams.singletonName = "btc-e";
    localTaskParams.taskId = 107;
    return localTaskParams;
  }

  public TaskParams getBtctradeDeepUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.btctradeDeepUrl;
    localTaskParams.taskId = 201;
    return localTaskParams;
  }

  public TaskParams getBtctradeLtcDeepUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.btctradeLtcDeepUrl;
    localTaskParams.taskId = 222;
    return localTaskParams;
  }

  public TaskParams getBtctradeLtcParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.btctradeLtcUrl;
    localTaskParams.singletonName = "btcTrade(ltc)";
    localTaskParams.taskId = 122;
    return localTaskParams;
  }

  public TaskParams getBtctradeLtcTradeUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.btctradeLtcTradeUrl;
    localTaskParams.taskId = 322;
    return localTaskParams;
  }

  public TaskParams getBtctradeParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.btctradeUrl;
    localTaskParams.singletonName = "btcTrade";
    localTaskParams.taskId = 101;
    return localTaskParams;
  }

  public TaskParams getBtctradeTradeUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.btctradeTradeUrl;
    localTaskParams.taskId = 301;
    return localTaskParams;
  }

  public TaskParams getBterDeepUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.bterDeepUrl;
    localTaskParams.taskId = 203;
    return localTaskParams;
  }

  public TaskParams getBterParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.bterUrl;
    localTaskParams.singletonName = "比特儿Bter";
    localTaskParams.taskId = 103;
    return localTaskParams;
  }

  public TaskParams getBterTradeUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.bterTradeUrl;
    localTaskParams.taskId = 303;
    return localTaskParams;
  }

  public TaskParams getChbtcDeepUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.chbtcDeepUrl;
    localTaskParams.taskId = 208;
    return localTaskParams;
  }

  public TaskParams getChbtcTradeUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.chbtcTradeUrl;
    localTaskParams.taskId = 307;
    return localTaskParams;
  }

  public TaskParams getFxbtcDeepUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.fxbtcDeepUrl;
    localTaskParams.taskId = 202;
    return localTaskParams;
  }

  public TaskParams getFxbtcLtcDeepUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.fxbtcLtcDeepUrl;
    localTaskParams.taskId = 221;
    return localTaskParams;
  }

  public TaskParams getFxbtcLtcParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.fxbtcLtcUrl;
    localTaskParams.singletonName = "FXBTC(ltc)";
    localTaskParams.taskId = 121;
    return localTaskParams;
  }

  public TaskParams getFxbtcLtcTradeUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.fxbtcLtcTradeUrl;
    localTaskParams.taskId = 321;
    return localTaskParams;
  }

  public TaskParams getFxbtcParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.fxbtcUrl;
    localTaskParams.singletonName = "FXBTC";
    localTaskParams.taskId = 102;
    return localTaskParams;
  }

  public TaskParams getFxbtcTradeUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.fxbtcTradeUrl;
    localTaskParams.taskId = 302;
    return localTaskParams;
  }

  public TaskParams getGoxbtcDeepUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.goxbtcDeepUrl;
    localTaskParams.taskId = 213;
    return localTaskParams;
  }

  public TaskParams getGoxbtcParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.goxbtcUrl;
    localTaskParams.singletonName = "GoXBTC";
    localTaskParams.taskId = 113;
    return localTaskParams;
  }

  public TaskParams getGoxbtcTradeUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.goxbtcTradeUrl;
    localTaskParams.taskId = 313;
    return localTaskParams;
  }

  public TaskParams getHuobiDeepUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.huobiDeepUrl;
    localTaskParams.taskId = 209;
    return localTaskParams;
  }

  public TaskParams getHuobiParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.huobiUrl;
    localTaskParams.singletonName = "火币网";
    localTaskParams.taskId = 110;
    return localTaskParams;
  }

  public TaskParams getHuobiTradeUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.huobiTradeUrl;
    localTaskParams.taskId = 309;
    return localTaskParams;
  }

  public TaskParams getMtgoxDeepUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.mtgoxDeepUrl;
    localTaskParams.taskId = 205;
    return localTaskParams;
  }

  public TaskParams getMtgoxParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.mtgoxUrl;
    localTaskParams.singletonName = "Mt.Gox";
    localTaskParams.taskId = 105;
    return localTaskParams;
  }

  public TaskParams getMtgoxTradeUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.mtgoxTradeUrl;
    localTaskParams.taskId = 305;
    return localTaskParams;
  }

  public TaskParams getOkcoinDeepUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.okcoinDeepUrl;
    localTaskParams.taskId = 204;
    return localTaskParams;
  }

  public TaskParams getOkcoinLtcDeepUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.okcoinLtcDeepUrl;
    localTaskParams.taskId = 223;
    return localTaskParams;
  }

  public TaskParams getOkcoinLtcParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.okcoinLtcUrl;
    localTaskParams.singletonName = "OkCoin(ltc)";
    localTaskParams.taskId = 123;
    return localTaskParams;
  }

  public TaskParams getOkcoinLtcTradeUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.okcoinLtcTradeUrl;
    localTaskParams.taskId = 323;
    return localTaskParams;
  }

  public TaskParams getOkcoinParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.okcoinUrl;
    localTaskParams.singletonName = "OkCoin";
    localTaskParams.taskId = 104;
    return localTaskParams;
  }

  public TaskParams getOkcoinTradeUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.okcoinTradeUrl;
    localTaskParams.taskId = 304;
    return localTaskParams;
  }

  public TaskParams getRmbtbDeepUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.rmbtbDeepUrl;
    localTaskParams.taskId = 211;
    return localTaskParams;
  }

  public TaskParams getRmbtbParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.rmbtbUrl;
    localTaskParams.singletonName = "人盟比特币";
    localTaskParams.taskId = 112;
    return localTaskParams;
  }

  public TaskParams getRmbtbTradeUrlParams()
  {
    TaskParams localTaskParams = new TaskParams();
    localTaskParams.url = this.rmbtbTradeUrl;
    localTaskParams.taskId = 312;
    return localTaskParams;
  }
}

