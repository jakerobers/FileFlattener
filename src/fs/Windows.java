package fs;

import java.io.File;

public class Windows implements FileSystem {

	@Override
	public File newFileDestination(String root, String source) {
		//process new filename
		if ( root.charAt(root.length()-1) != '\\' ) {
			root += '\\';
		}
		String relativeSource = source.replace(root, "").replace("\\", "-");

		//construct the new file
		File newFile = new File(root + relativeSource);
		return newFile;
	}
	
	public File newDirectoryDestination(File selectedFileLocation) {
		File f = new File(selectedFileLocation.getParent() 
				+ "\\" + "flattened-" + selectedFileLocation.getName());
		f.mkdir();
		return f;
	}
}
