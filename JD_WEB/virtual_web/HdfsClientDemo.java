package hdfs24;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.apache.hadoop.conf.Configuration;//conf的包
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Before;
import org.junit.Test;

public class HdfsClientDemo {
	
	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		
		conf.set("dfs.replication", "2");
		conf.set("dfs.blocksize", "64m");
		
		FileSystem fs = FileSystem.get(new URI("hdfs://hdp-01:9000/"), conf, "root");
		
		fs.copyFromLocalFile(new Path("D:/install-pkgs/hbase-1.2.1-bin.tar.gz"), new Path("/aaa/"));
		
		fs.close();
	}
}
