package com.Tcb.ElasticSearch.FiltreHbase;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.client.Result;
/**
 * Hello world!
 *
 */
public class App 
{     
     
      
      public static void main( String[] args ) throws IOException 
    
    {
    	  Configuration confighbase = HBaseConfiguration.create();
    	  confighbase.set("zookeeper.znode.parent", "/hbase-unsecure");
    	 Connection connectionhbase = ConnectionFactory.createConnection(confighbase);
    	
    	 Table table = connectionhbase.getTable(TableName.valueOf("fluxa"));
    	 Scan scan = new Scan();
    	 scan.addColumn(Bytes.toBytes("flux1"), Bytes.toBytes("MONTANT_TTC"));
    	

    	 ResultScanner scanner = table.getScanner(scan);
    	
    	
    	 for (Result result = scanner.next(); result != null; result = scanner.next())
    	 {  
    		  
    		  
    		  String key = Bytes.toString(result.getRow());
    		  Iterator<KeyValue> iter = result.list().iterator();
    		  
    		  String header = "Key:\t";
  			String data = key + "\t";

  			while (iter.hasNext()) {
  				KeyValue kv = iter.next();
  				header += Bytes.toString(kv.getFamily()) + ":"
  						+ Bytes.toString(kv.getQualifier()) + "\t";
  				data += Bytes.toString(kv.getValue()) + "\t";
  				
  				  System.out.println(header );
  	    	      System.out.println(data);
  					
  				
  			}
    	     
    	 }
    	  scanner.close();
    	  table.close();
    
    
    }
}
