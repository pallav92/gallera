package pallav.example.com.galleryapp.utils;

import android.webkit.WebViewFragment;

import pallav.example.com.galleryapp.fragment.HomeFragment;

/**
 * Created by pallav on 17/1/17.
 */

public class GalleraConstant {
    public static final String GRAPH_TYPE = "graph_type" ;
    public static final int PIE_CHART = 0;
    public static final int BAR_CAHRT = 1;
    public static final int LINE_CHART = 2;
    public static final int MULTI_DATA_BAR_CHART = 3;
    public static final String USER_NAME = "user_name";
    public static final String PASSWORD = "password";
    public static final String HOCKEY_APPID = "e7e05719f1024f879c0e9fb333e25034";
    public static final String FRAGMENT_NAME = "frag_tag";
    public static final int ONE_DAY=101;
    public static final int ONE_WEEK=102;
    public static final int ONE_YEAR=103;
    public static final String TIME_HH_mm_FORMAT = "HH:mm";
    public static final String USER_DEVICE_LIST = "user_device_list";
    public static final String WEB_URL = "web_url";
    public static final String Server_Key = "AIzaSyCeiU5ixUNBVyQr7X69OHOcCWuamcIIzik"; // firebase
    public static final String NOTIFICATION_MSG_TYPE = "notification_msg_type";
    public static final String OVERLIMIT_MESSAGE = "overlimit_message";
    public static final String OLD_PW = "old_pw";
    public static final String NEW_PW = "new_pw";
    public static final String CONFIRM_PW = "confirm_pw";
    public static final String SHOW_CHANGE_PW_DIALOG = "show_dialog";
    public static final String CHANGE_PW_DATA = "change_pw_data";
    public static final String DATA_TYPE_SELECTION = "data_type";
    public static final String COMPARED_DATA = "comparison";
    public static final long TIMER_DELAY = 0; // amount of time in milliseconds before first execution
    public static final long TIMER_INTERVAL = 1000 * 60;  // 1 min
    public static final String TIMER_RUNNING = "timer_running_state";
    public static final String LINE_CHART_HASH_MAP = "line_chart_hash_map";
    public static final String KEY = "key";
    public static final String DATA = "data" ;
    public static final long MESSAGE_TIMER_INTERVAL = 5 *1000 ;
    public static final String date = "20161222" ;
    public static final int LEAK_DETECT_MSG = 4;
    public static final String PREV_ORIENTATION = "prev_orient";
    public static final int SHOWER = 10;
    public static final int FLUSH = 2;
    public static final int FAUCET = 8;
    public static final int OTHERS = 4;
    public static final int IRRIGATION = 20;


    public interface FRAGMENT_TAG {
        String HOME_FRAGMENT = HomeFragment.class.getName();
        String WEB_VIEW_FRAGMENT = WebViewFragment.class.getName();
    }

    public interface PreferenceKeeperNames {
        String USER_DATA = "user_data";
        String DEVICE_LIST = "device_list";
        String DEVICE_DATA_SAVED = "device_data_save";
        String DEVICE_ID = "dId";
        String DEVICE_NAME = "dName";
        String HOME_SCREEN_DATA = "home_screen_data";
        String START_TIME = "start_time";
        String END_TIME = "end_time";
        String UNIT = "unit";
        String GOAL = "goal";
        String LIMIT_INDEX = "limit_index";
        String LEAK_DETECT_STATUS = "leak_detect_status" ;
        String MESSAGE_LIST =  "message_list";
        String HARDCODE_DATA = "hardcode_data";
        String FIREBASE_TOKEN = "firebase_token";
    }

    public interface BroadcastNames {
        String MSG_NOTIFICATION_BROADCAST =  "msg_notification_broadcast";
        String NOTIFICATION_BROADCAST =  "notification_broadcast";
    }
    public interface PlecoWebUrl {
        String ABOUT_url ="http://staging.nudgesystems.com/website-pleco/about/";
        String HELP_url = "http://staging.nudgesystems.com/website-pleco/help/";
        String FAQ_url = "http://staging.nudgesystems.com/website-pleco/faq/";
        String TERMS_CONDITIONS_url = "http://staging.nudgesystems.com/website-pleco/terms-and-conditions/";
        String PRIVACY_POLICY_url = "http://staging.nudgesystems.com/website-pleco/privacy-policy/";
    }


    public interface DateTimeFormat {
        String DATE_TIME_FORMAT_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
        String DATE_TIME_FORMAT_yyyyMMdd = "yyyyMMdd";
        String MONTH_Format = "MM";
    }

    public interface TimeZone {
        String UTC_TIME_ZONE = "UTC";
    }

    public interface BarChartFilterType {
        // daily/ weekly/ monthly
        int DAILY = 1;
        int WEEKLY = 2;
        int YEARLY =3;
    }
    public interface PieChartFilterType {
        // daily/ weekly/ monthly
        int DAILY = 1;
        int WEEKLY = 2;
        int MONTHLY =3;
    }


    public interface DayDataFilter {
        int ONE_HOURS_INTERVAL = 1;
        int TWO_HOURS_INTERVAL = 2;
        int FOUR_HOURS_INTERVAL = 4;
    }


    public  interface  TimeInterval {
        int ONE_HOUR_IN_SEC = 3600 ;
        int TIME_INTERVAL_BETWEEN_START_AND_END_TIME = 3 * ONE_HOUR_IN_SEC;
        int TIME_INTERVAL_BETWEEN_DATA_DISPLAY_IN_LINE_CHART_SCREEN = 2 * ONE_HOUR_IN_SEC;
        int TIME_INTERVAL_BETWEEN_TWO_DATA = 10 ;  // 10 secs interval

    }
}
