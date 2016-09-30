package com.tcb.data.tcbproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.zip.GZIPInputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;







public class FonctianalityImpl implements Fonctionality 
  
 
  {
	// private  static String typeflux = null ;
	 

public void readDatahdfs(String hdfs,String url,Configuration conf,String topicName ){
		  
		   String line = null;
		   MonClass monClass = new MonClass();
		   KafkaProducer<String, String> producer =FonctianalityImpl.initProducer();
			 
		 
		
  try
  	    {
       
  		Path pt=new Path(hdfs +url);
  		FileSystem fs = FileSystem.get(conf);
        FSDataInputStream fin = new FSDataInputStream(fs.open(pt));
        GZIPInputStream gzis = new GZIPInputStream(fin);
        InputStreamReader xover = new InputStreamReader(gzis);
        BufferedReader    is = new BufferedReader(xover);
      
       while ((line = is.readLine()) != null)
	    	
	    	 {
    	        
    	 if (line.contains(".txt")|| line.contains("END"))
         	      {
       	
       		       	    
         	      }
       	else 
       	       { 
       		  
       		if (FonctianalityImpl.typeFlux(line)!= null)
    			   
       			monClass.setTypeflux(FonctianalityImpl.typeFlux(line));
       		    FonctianalityImpl.productDataKafka(monClass.typeflux, line, topicName,producer);
      		    System.out.println( monClass.typeflux +"::::" + line);
      		   
      		   
         	  
       	       }
    	 
	    	  }
       producer.close();
       is.close();
       
      }
 catch(Exception e)
           {
	
           }
 
  	                       
}

	public static void productDataKafka(String typeFlux ,String line,String topicName,KafkaProducer<String, String> producer) {
		if (line.equals("NUMERO;IDENTIFIANT;CODE_MESSAGE;MONTANT_TTC;DATE_ECHEANCE_FACTURE;DATE_ECHEANCE_APUREMENT;MARQUEUR4;MARQUEUR5")||line.equals("NUMERO;IDENTIFIANT;CODE_MESSAGE;;DATE_ACTION_COMMERCIALE;;CIVILITE;NOM"))
		{

			//nothing 
			
		}
		else 
			{ 
			producer.send(new ProducerRecord<String, String>(topicName, typeFlux,line));
			System.out.println(typeFlux + ":::::" + line);
			
			}

		}
		
	

	public void saveDataHbase() {
		// TODO Auto-generated method stub
		
	}

	public void saveDataKafka() {
		// TODO Auto-generated method stub
		
	}


	public static String typeFlux(String key) {
		
		String Key1 ="NUMERO;IDENTIFIANT;CODE_MESSAGE;MONTANT_TTC;DATE_ECHEANCE_FACTURE;DATE_ECHEANCE_APUREMENT;MARQUEUR4;MARQUEUR5";
		String Key2 ="NUMERO;IDENTIFIANT;CODE_MESSAGE;;DATE_ACTION_COMMERCIALE;;CIVILITE;NOM";
		//String Key3= "";
		String typeFlux = null;
		
		if       (key != null && key.equals(Key1)) {typeFlux="flux1";}
		else if  (key != null && key.equals(Key2)) {typeFlux="flux2";}
//		else if  (key.equals(Key3)) {typeFlux="flux1";}
		
		return typeFlux;
		
		
	}

	public static KafkaProducer<String, String> initProducer()
	   {  
		  
		 
		    Properties props = new Properties();
		    props.put("bootstrap.servers", "latitude:6667");
		    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		    KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
		    System.out.println("objet cree");
			return producer;

	}
	

	
}
