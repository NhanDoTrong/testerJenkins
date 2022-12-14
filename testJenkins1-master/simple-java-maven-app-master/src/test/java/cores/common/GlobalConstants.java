package cores.common;

import java.io.File;

public class GlobalConstants {
    //System infor
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    // App infor User
    public static final String DEV_USER_URL = "http://live.techpanda.org/";
    public static final String STAGING_USER_URL = "http://live.techpanda.org/";
    public static final String LIVE_USER_URL = "https://blueimp.github.io/jQuery-File-Upload/";
    //http://live.techpanda.org/

    // App infor Admin
    public static final String DEV_ADMIN_URL = "http://live.techpanda.org/index.php/backendlogin";
    public static final String STAGING_ADMIN_URL = "http://live.techpanda.org/index.php/backendlogin";
    public static final String LIVE_ADMIN_URL = "http://live.techpanda.org/index.php/backendlogin";


    public static final String ADMIN_USERNAME = "user01";
    public static final String ADMIN_PASSWORD = "guru99com";


    // Wait
    public static final long SHORT_TIMEOUT = 10;
    public static final long LONG_TIMEOUT = 30;
    // Dowload/ Upload File
    public static final String UPLOAD_PATH = PROJECT_PATH+ File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_PATH = PROJECT_PATH+"/downloadFiles/";

    // Retry Case Failed
    public static final int ReTRY_NUMBER = 3;

    // Browser Logs

    // HTML Report Folder
    public static final String PEPORTNG_SCREENSHOT_PATH = PROJECT_PATH+ File.separator + "reportTestNGScreenShot" + File.separator;
    public static final String EXTENT_PATH = PROJECT_PATH + File.separator +"htmlExtent" + File.separator;
    public static final String JAVA_VERSION = System.getProperty("java.version");
}
