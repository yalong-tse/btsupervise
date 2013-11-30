package com.dreaming.btsupervise.net;

import java.util.List;
import com.dreaming.btsupervise.beans.Btc;
import com.dreaming.btsupervise.beans.Trade;
import com.dreaming.btsupervise.beans.Trust;

public class ResultData {
	public Btc btc;
	public List<Trust> buys;
	public double maxTrade;
	public double maxTrust;
	public int result;
	public List<Trust> sells;
	public int taskId;
	public TaskParams taskParams;
	public List<Trade> trades;
}
