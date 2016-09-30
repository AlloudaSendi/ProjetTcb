package com.tcb.data.tcbproject;

import org.apache.hadoop.conf.Configuration;

public interface Fonctionality {

	public void readDatahdfs(String hdfs,String url,Configuration conf,String topicName );
	public void saveDataHbase();
	public void saveDataKafka();

	}
