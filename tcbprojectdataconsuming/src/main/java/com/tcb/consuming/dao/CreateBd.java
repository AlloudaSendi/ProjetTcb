package com.tcb.consuming.dao;

import java.io.IOException;

import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Table;

public class CreateBd {
	

	public static Table createHbase(String tablename) throws IOException{
	  
	   Connection connection = ConnectionBD.getInstanceHbase();
       Admin admin =  connection.getAdmin();
       
       
       
       if (admin.isTableAvailable(TableName.valueOf(tablename)))
	      
           {	    	   
	    	   admin.disableTable(TableName.valueOf(tablename));	       
	    	   admin.deleteTable(TableName.valueOf(tablename));
	    	   System.out.println("table supprimeé");
	       }
	        
                             HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(tablename)); 
                             tableDescriptor.addFamily(new HColumnDescriptor("flux1")); 
                             tableDescriptor.addFamily(new HColumnDescriptor("flux2"));
                             admin.createTable(tableDescriptor);    
                             Table table = connection.getTable(TableName.valueOf(tablename));
                             System.out.println("table crée");
       
       
                   return table;
    
	}
		
	public static void createElastic(String tablename) throws IOException	{
		
		
		
		
	}
		
		
	
}
