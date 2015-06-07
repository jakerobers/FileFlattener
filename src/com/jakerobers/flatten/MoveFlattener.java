package com.jakerobers.flatten;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MoveFlattener extends Flattener {

	public void execute(File f, String destination) {
		try {
			Files.move(f.toPath(), new File(destination).toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
