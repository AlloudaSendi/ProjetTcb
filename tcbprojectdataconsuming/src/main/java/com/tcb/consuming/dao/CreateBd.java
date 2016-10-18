package com.tcb.consuming.dao;

import java.io.IOException;

import org.apache.commons.cli.ParseException;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.RegionSplitter;

public class CreateBd {
	

	public static Table createHbase(String tablename) throws IOException{
//	  
//	   Connection connection = ConnectionBD.getInstanceHbase();
//       Admin admin =  connection.getAdmin();
//       
//       
//       
//       if (admin.isTableAvailable(TableName.valueOf(tablename)))
//	      
//           {	    	   
//	    	   admin.disableTable(TableName.valueOf(tablename));	       
//	    	   admin.deleteTable(TableName.valueOf(tablename));
//	    	   System.out.println("table supprimeé");
//	       }
//	        
//                             HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(tablename)); 
//                             tableDescriptor.addFamily(new HColumnDescriptor("flux1")); 
//                             tableDescriptor.addFamily(new HColumnDescriptor("flux2"));
//                             admin.createTable(tableDescriptor);    
//                             Table table = connection.getTable(TableName.valueOf(tablename));
//                             System.out.println("table crée");
//       
//       
//                   return table;
		 Connection connection = ConnectionBD.getInstanceHbase();
       Admin admin =  connection.getAdmin();
       
       
       
       if (admin.isTableAvailable(TableName.valueOf("Fluxa")))
	      
           {	    	   
	    	   admin.disableTable(TableName.valueOf("Fluxa"));	       
	    	   admin.deleteTable(TableName.valueOf("Fluxa"));
	    	   System.out.println("table supprimeé");
	       }
		
		 String[] argz = {};
		 argz = "Fluxa HexStringSplit -c 2 -f flux1:flux2  --firstrow 0000000000 -lastrow FFFFFFFFFF -Dzookeeper.znode.parent=/hbase-unsecure".split(" ");
         try {
			RegionSplitter.main(argz);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	    
 	    
         Table table = connection.getTable(TableName.valueOf("Fluxa"));
         
         System.out.println("table crée avec deux colonne");
		return table;
    
	}
		
	public static void createElastic(String tablename) throws IOException	{
		
		
		
		
	}
		
		
	
}
