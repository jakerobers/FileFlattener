package com.jakerobers.flatten;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MoveFlattener extends Flattener {

	public void execute(File source, String destination) {
		try {
			Files.move(source.toPath(), new File(destination).toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void move(String source) throws Exception {
		traverse(source, source);	//use source as destination as well.
	}
	
	public void copy(String source) throws Exception {
		throw new Exception("Oops.Something went wrong. Error code: 2");
	}
}
