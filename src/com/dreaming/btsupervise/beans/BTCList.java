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


	public static void setBtcs(List<Btc> btcs) {
		BTCList.btcs = btcs;
	}

	
}
