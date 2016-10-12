package com.tcb.consuming.service;

import java.io.IOException;


import org.apache.hadoop.hbase.client.Table;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.tcb.consuming.dao.ConnectionBD;
import com.tcb.consuming.dao.FluxDao;

public class ConsumeData {
	private static final CharSequence FLUX_1 = "flux1";
	public String key = null ;
	public String value = null ;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void Consume(String groupeconsumer,Table tablename,String arguments) throws IOException
	{
		FluxDao flux1 = new FluxDao();
	    Integer p = new Integer(1);
	    Integer k = new Integer(1);
	    Integer l = new Integer(1);
	    Integer m = new Integer(1);
	    
	    String [] resu = null;
	    String fields1 = "NUMERO;IDENTIFIANT;CODE_MESSAGE;MONTANT_TTC;DATE_ECHEANCE_FACTURE;DATE_ECHEANCE_APUREMENT;MARQUEUR4;MARQUEUR5";
	    String fields2 = "NUMERO;IDENTIFIANT;CODE_MESSAGE;;DATE_ACTION_COMMERCIALE;;CIVILITE;NOM";
	    String[] field1 =  fields1.split("\\;", -1);
	    String[] field2 =  fields2.split("\\;", -1);
	    KafkaConsumer<String, String> kafkaConsumer =ConnectionBD.getInstanceKafka(groupeconsumer);
	    while (true) {
	    	 ConsumerRecords<String, String> records = null;
	    	try {
	    		
	    		 records = kafkaConsumer.poll(100);
	    	}catch(Exception e)
	    	
	    	{
	    		System.out.println("getInstaceKafka est null");
	    	}
	    	
	      for (ConsumerRecord<String, String> record : records) {
	    	  resu = record.value().toString().split("\\;", -1);
	    	  if (record.key().contains(FLUX_1))
	    	  {
	    		  for (int i = 0 ;i<resu.length;i++)
	    		  {
	    			  flux1.setZ(p);
	    			  flux1.setP(l);
	    			  l++ ;
	    			  p++;
	    			  flux1.storeDataHbase(tablename, field1[i], record.key(), resu[i]);  
	    			  flux1.getDateHbase(tablename, field1[i], record.key());
	    			  
	    		  }
	    		  
	    		  
	    		  
	    	  }
	    	  
	    	  else 
	    	   
	    	  {
	    		  for (int i = 0 ;i<resu.length;i++)
	    		   
	    		  {  
    			      flux1.setZ(k);
    			      flux1.setP(m);
    			        m++ ;
    			       k++;
	    			  flux1.storeDataHbase(tablename, field2[i], record.key(), resu[i]);
	    			  flux1.getDateHbase(tablename, field2[i], record.key());
	    			  
	    			 
	    			  
	    		  }
	    		  
	    		  
	    	  }
	    	  
	    	  
	    	// verifier le type du flux
	    	  
	    	  
	    	
	    	
	    	
	    	
	    	
	    	
	    
	      }		
		
	}

	
	}}
