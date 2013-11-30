package com.dreaming.btsupervise.beans;

public class Market implements Comparable<Market> {
	public boolean checked;
	public String name;
	public int order;

	public Market(int paramInt, String paramString) {
		this.order = paramInt;
		this.name = paramString;
	}

	public Market(int paramInt, String paramString, boolean paramBoolean) {
		this.order = paramInt;
		this.name = paramString;
		this.checked = paramBoolean;
	}

	public Market(String paramString, boolean paramBoolean) {
		this.name = paramString;
		this.checked = paramBoolean;
	}

	public int compareTo(Market paramMarket) {
		
		return this.order - paramMarket.order;

	}
}
