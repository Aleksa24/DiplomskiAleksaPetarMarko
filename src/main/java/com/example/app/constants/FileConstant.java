package com.example.app.constants;

import java.io.File;

public class FileConstant {

    public static final String CHANNEL_FOLDER = System.getProperty("user.home") + File.separator + "DiplomskiAplikacija" + File.separator + "channel" + File.separator;
    public static final String USER_FOLDER = System.getProperty("user.home") + File.separator + "DiplomskiAplikacija" + File.separator + "user" + File.separator;
    public static final String POST_FOLDER = System.getProperty("user.home") + File.separator + "DiplomskiAplikacija" + File.separator + "post" + File.separator;
    public static final String COMMENT_FOLDER = System.getProperty("user.home") + File.separator + "DiplomskiAplikacija" + File.separator + "comment" + File.separator;
    public static final String USER_IMAGE_PATH = "/user/image/";
    public static final String JPG_EXTENSION = "jpg";
    public static final String DIRECTORY_CREATED = "Created directory for: ";
    public static final String DEFAULT_USER_IMAGE_PATH = "/user/image/profile/";
    public static final String FILE_SAVED_IN_FILE_SYSTEM = "Saved file in file system by name: ";
    public static final String DOT = ".";
    public static final String FORWARD_SLASH = "/";
    public static final String TEMP_PROFILE_IMAGE_BASE_URL = "https://robohash.org/";
}
