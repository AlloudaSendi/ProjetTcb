package com.tcb.consuming.dao;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Table;

import com.tcb.consuming.entities.Flux3;

public class Flux3Dao  extends DAO<Flux3>{

	@Override
	public void storeDataHbase(Table table, String Qualifier, String familyname, String data) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getDateHbase(Table table, String Qualifier, String familyname) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
