package fs;

import java.io.File;

public interface FileSystem {

	File newFileDestination(String unwantedRoot, String source);
	File newDirectoryDestination(File selectedFileLocation);
	
}
