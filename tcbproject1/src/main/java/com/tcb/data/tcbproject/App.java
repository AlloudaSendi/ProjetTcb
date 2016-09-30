package com.tcb.data.tcbproject;

import org.apache.hadoop.conf.Configuration;

/**
 * Hello world!
 *
 */
public class App 

{
	public static final String HDFS = "hdfs://latitude:8020/";
	public static  String URL =null;
	public static  String TOPICNAME =null;
    public static void main( String[] args )
    { 
    	
    	
    	URL = args[1];
    	TOPICNAME =args[0];
    	Configuration conf = new Configuration();
        FonctianalityImpl fon = new FonctianalityImpl();
        fon.readDatahdfs(HDFS, URL, conf, TOPICNAME);
        
    }
}
