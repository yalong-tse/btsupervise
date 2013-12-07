package com.dreaming.btsupervise.net;
import java.util.Map;

public class Item {

	 private int ItemId;
	 private Map params;
	 
	 public static final int Item_LOGIN =1;
	 public static final int Item_GET_TIMELINE =2;
	 public static final int Item_NEW_WEIBO =3;
	 //增加任务，只需要在此增加常量标识

	 public Item() {
	  super();
	 }

	 public Item(int ItemId, Map params) {
	  super();
	  this.ItemId = ItemId;
	  this.params = params;
	 }

	 public int getItemId() {
	  return ItemId;
	 }

	 public void setItemId(int ItemId) {
	  this.ItemId = ItemId;
	 }

	 public Map getParams() {
	  return params;
	 }

	 public void setParams(Map params) {
	  this.params = params;
	 }

	}