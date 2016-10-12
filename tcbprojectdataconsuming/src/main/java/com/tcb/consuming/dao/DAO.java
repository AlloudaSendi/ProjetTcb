package com.tcb.consuming.dao;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Table;

public abstract class DAO <T> {
	

	public abstract void storeDataHbase(Table table,String Qualifier,String familyname,String data) throws IOException ;
	public abstract void getDateHbase(Table table ,String Qualifier,String familyname ) throws IOException;
	
}
