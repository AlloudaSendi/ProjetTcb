package com.tcb.consuming.test;

import java.io.IOException;


import org.apache.hadoop.hbase.client.Table;


import com.tcb.consuming.dao.CreateBd;

import com.tcb.consuming.service.ConsumeData;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
	
    ConsumeData consomer = new ConsumeData();
    Table tablename=  CreateBd.createHbase("fluxar");
    consomer.Consume("zdi", tablename,"gfdd");
    
    
   
    		
    	
    	
	
    }
}
