package com.dep.demo.utils;

import java.io.File;

public class GeneralUtils {
    /**
     * Check the file path, if not exits make dir.
     * @param path
     */
    public static void mkDir(final String path){
			File objPathFile = new File(path);
			if (!objPathFile.exists()) {
				objPathFile.mkdirs();
			}
    }
}
