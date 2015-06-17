package com.jakerobers.flatten;

import java.io.File;

import fs.*;

public abstract class Flattener {
	FileSystem fs;
	
	public abstract void execute(File f, String destination);
	
	public Flattener() {
		String os = System.getProperty("os.name");
		if ( os.startsWith("Windows") ) {
			this.fs = new Windows();
		} else {
			this.fs = new Unix();
		}
	}
	
	public void traverse(String source, String destination) {
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
	}
	
	public void execute(String newName, File f, String destination) {
		// Overridden by subclasses.
	}
	
	private void recurse(String root, String source, String destination) {
		File folderToTraverse = new File(source);
		File[] files = folderToTraverse.listFiles();
		
		if ( files == null ) {
			return;
		}
		
		for ( File f : files ) {
			if ( f.isDirectory() ) {
				recurse(root, f.getAbsolutePath(), destination);
			} else {
				//String newName = getFilename(root, f.getAbsolutePath());
				//execute(newName, f, destination);
			}
		}
	}
}
