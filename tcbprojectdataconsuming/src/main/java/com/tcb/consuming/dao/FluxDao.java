package com.tcb.consuming.dao;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import com.tcb.consuming.entities.Flux1;

public class FluxDao extends DAO<Flux1>{
	  private   Integer z = new Integer(1);
	  private   Integer p = new Integer(1);
	  Flux1 flux1 = new Flux1();
	  
	  
	public void storeDataHbase(Table table,String Qualifier,String familyname,String data) throws IOException 
	
	{ 
		 Put put = new Put(Bytes.toBytes(this.z.toString()));
	     put.addColumn(familyname.getBytes(), Qualifier.getBytes(), data.getBytes());// The first column of the data. 
	     table.put(put);
	     this.z ++;	
	}
	

	public void setZ(Integer z) {
		this.z = z;
	}

	

	public void setP(Integer p) {
		this.p = p;
	}

	public void getDateHbase(Table table ,String Qualifier,String familyname ) throws IOException{
		    
		    Get g = new Get(Bytes.toBytes(this.p.toString()));
		    Result result = table.get(g);
	        byte [] value = result.getValue(familyname.getBytes(),Qualifier.getBytes());
	        String name = Bytes.toString(value);        
	        System.out.println("data::::: "+ familyname + "::::::" + name );
	        this.p++;
		
		
	}
}
