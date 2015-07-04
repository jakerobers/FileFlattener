package com.jakerobers.flatten;

import java.io.File;
import java.util.Arrays;

import fs.*;

public abstract class Flattener {
	FileSystem fs;
	
	public abstract void execute(File source, String destination);
	
	public Flattener() {
		String os = System.getProperty("os.name");
		if ( os.startsWith("Windows") ) {
			this.fs = new Windows();
		} else {
			this.fs = new Unix();
		}
	}
	
	public void traverse(String source, String destination) throws Exception {
		File root = new File(source);
		File[] files = root.listFiles();
		if (files == null) {
			return;
		}
		
		for ( File f : files ) {
			if ( f.isDirectory() ) {
				recurse(source, f.getAbsolutePath(), destination);
			}
		}
		System.exit(0);
	}
	
	private void recurse(String root, String source, String destination) throws Exception {
		File folderToTraverse = new File(source);
		File[] files = folderToTraverse.listFiles();
		
		if ( files == null ) {
			return;
		}
		
		for ( File fileToBeMoved : files ) {
			if ( fileToBeMoved.isDirectory() ) {
				recurse(root, fileToBeMoved.getAbsolutePath(), destination);
			} else {	//is file
				if(!Arrays.asList(fs.getBlacklistedFiles()).contains(fileToBeMoved.getName())) {
					String newDestination = fs.newFileDestination(root, fileToBeMoved.getAbsolutePath());
					execute(fileToBeMoved, newDestination);
				}
			}
		}
	}
	
	public void move(String source) throws Exception {
		throw new Exception("Oops. Something went wrong. Error code: 3");
	}
	
	public void copy(String source) throws Exception {
		throw new Exception("Oops. Something went wrong. Error code: 4");
	}
}
