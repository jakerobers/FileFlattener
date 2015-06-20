package com.jakerobers.flatten;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;

public class CopyFlattener extends Flattener {

	public void execute(File source, String destination) {
		try {
			Files.copy(source.toPath(), new File(destination).toPath());
		} catch(FileAlreadyExistsException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void copy(String source) throws Exception {
		String destination = super.fs.newDirectoryDestination(new File(source));
		traverse(source, destination);
	}
	
	public void move(String source) throws Exception {
		throw new Exception("Oops.Something went wrong. Error code: 1");
	}
}
