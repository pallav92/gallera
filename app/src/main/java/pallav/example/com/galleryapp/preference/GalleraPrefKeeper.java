package pallav.example.com.galleryapp.preference;

import android.content.Context;
import android.content.SharedPreferences;

import pallav.example.com.galleryapp.utils.GalleraConstant;

public class GalleraPrefKeeper {

    private static GalleraPrefKeeper plecoPrefKeeper;

    private final String PREF_NAME = "pleco_prefrence";
    private static SharedPreferences preferences;


    private GalleraPrefKeeper(Context context) {
        if (preferences == null)
            preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static GalleraPrefKeeper getInstance(Context context) {

        if (plecoPrefKeeper == null)
            plecoPrefKeeper = new GalleraPrefKeeper(context);

        return plecoPrefKeeper;
    }


    public void saveUserString(String userString) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(GalleraConstant.PreferenceKeeperNames.USER_DATA, userString);
        editor.apply();
    }

    public String getUserString() {
        return preferences.getString(GalleraConstant.PreferenceKeeperNames.USER_DATA, null);

    }
}
