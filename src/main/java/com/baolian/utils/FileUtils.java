package com.baolian.utils;

/**
 * Created by tomxie on 2017/4/8 12:58.
 */
public class FileUtils {
    public final static long FILE_SIZE_LIMIT = 52428800;

    public static String getFileExtension(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

    public static void main(String[] args) {
        System.out.println(getFileExtension("adfasfd.sfa.xls"));
    }
}
