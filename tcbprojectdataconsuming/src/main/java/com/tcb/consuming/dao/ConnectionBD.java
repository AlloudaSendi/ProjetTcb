package com.tcb.consuming.dao;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.kafka.clients.consumer.KafkaConsumer;
/** 
 * @singleton 
 * 
 * 
 * */
public class ConnectionBD {
	
	private static Configuration confighbase ;
	private static Connection connectionhbase;
	private static KafkaConsumer<String, String> kafkaConsumer;
	private ConnectionBD(){
		
		// constructeur privéé a ne pas appeler
	}
	
	public static Connection getInstanceHbase() throws IOException	
	{
		  if (connectionhbase == null)
			  try {
				  confighbase = HBaseConfiguration.create();
				  confighbase.set("zookeeper.znode.parent", "/hbase-unsecure");
				  connectionhbase = ConnectionFactory.createConnection(confighbase);
				  
			  }
		  catch(Exception e)
		  {
				  
				System.out.println(e.getMessage());  
		  }
		     	      
	       
		return connectionhbase;
		
	}
	public static void connectElastic()
	
	{
		
		
	}
	public static KafkaConsumer<String, String> getInstanceKafka(String groupeconsumer)
	{ 
		KafkaConsumer<String, String> kafkaConsumer = null;
		if (kafkaConsumer == null)
	 
	     {	 
		 Properties props = new Properties();
	     props.put("bootstrap.servers", "Latitude:6667");
	     props.put("group.id", groupeconsumer);
	     props.put("enable.auto.commit", "true");
	     props.put("auto.commit.interval.ms", "1000");
	     props.put("auto.offset.reset", "earliest");
	     props.put("session.timeout.ms", "30000");
	     props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	       kafkaConsumer = new KafkaConsumer<String, String>(props);
	       kafkaConsumer.subscribe(Arrays.asList("est"));
	     
	     }
		
		
		
		return kafkaConsumer;
		
		
		
		
		
	}

}
