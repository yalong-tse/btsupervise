package com.dreaming.btsupervise.beans;

import java.util.ArrayList;
import java.util.List;

public class BTCList {
	
	private static List<Btc> btcs = new ArrayList<Btc>();

	private static BTCList instance;
	
	
	public static BTCList getInstance()
	{
		if(instance==null)
			instance = new BTCList();
		return instance;
	}
	
	
	/**
	 * 获取btc的list
	 * */
	public List<Btc> getBtcs()
	{
		return btcs;
	}
	
	/**
	 * 测试类
	 * */
	public void test()
	{
		Btc btc = new Btc();
		btc.buy =6391.02;
		btc.sell = 6393.99;
		btc.name = Btc.BTCCHINA;
		btc.high = 6449.00;
		btc.low = 6022.99;
		btc.last = 6385.00;
		btc.vol = 68183.03200000;
		btcs.add(btc);
		
		
		Btc btc1 = new Btc();
		btc1.buy =6391.02;
		btc1.sell = 6393.99;
		btc1.name = Btc.BTCTRADE;
		btc1.high = 6449.00;
		btc1.low = 6022.99;
		btc1.last = 6385.00;
		btc1.vol = 68183.03200000;
		btcs.add(btc1);
	}
	

}
