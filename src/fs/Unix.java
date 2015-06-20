package fs;

import java.io.File;

public class Unix implements FileSystem {
	
	private String[] blacklistedFiles = {".DS_Store"};
	
	@Override
	public String newFileDestination(String root, String source) {
		//process new filename
		char c = root.charAt(root.length()-1);
		if ( root.charAt(root.length()-1) != '/' ) {
			root += '/';
		}

		return root + source.replace(root, "").replace("/", "-");

	}

	public String newDirectoryDestination(File selectedFileLocation) {
		File f = new File(selectedFileLocation.getParent() 
				+ "/" + "flattened-" + selectedFileLocation.getName());
		return f.getAbsolutePath();
	}

	@Override
	public void makeDir(String filepath) {
		new File(filepath).mkdir();
	}

	@Override
	public String[] getBlacklistedFiles() {
		return this.blacklistedFiles;
	}

	@Override
	public void setBlacklistedFiles(String[] blacklistedFiles) {
		this.blacklistedFiles = blacklistedFiles;
		
	}
	
	
}
