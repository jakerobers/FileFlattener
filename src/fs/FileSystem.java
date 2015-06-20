package fs;

import java.io.File;

public interface FileSystem {

	String newFileDestination(String root, String source);
	
	/**
	 * Executed when the copy selector is active
	 * @param selectedFileLocation The directory name of the copied folder.
	 * @return The string of the new directory.
	 */
	String newDirectoryDestination(File selectedFileLocation);
	void makeDir(String filepath);
	String[] getBlacklistedFiles();
	void setBlacklistedFiles(String[] blacklistedFiles);
	
}
