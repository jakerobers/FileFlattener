package com.jakerobers.flatten;

import java.io.File;

public class Flattener {
	
	public void traverse(String source, String destination) {
		File root = new File(source);
		File[] files = root.listFiles();
		
		if (files == null) {
			return;
		}
		
		for ( File f : files ) {
			if ( f.isDirectory() ) {
				recurse(source, f.getAbsolutePath(), destination);
			} else {
				execute(f, destination);
			}
		}
	}
	
	private void recurse(String prefix, String source, String destination) {
		File root = new File(source);
		File[] files = root.listFiles();
		
		if ( files == null ) {
			return;
		}
		
		for ( File f : files ) {
			if ( f.isDirectory() ) {
				recurse(prefix, f.getAbsolutePath(), destination);
			} else {
				execute(f, destination);
			}
		}
	}
	
	private void execute(File f, String destination) {
		// Should be overridden by subclass.
	}
}
