package com.yandex.mandrik.launcher.util.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.yandex.mandrik.launcher.R;

import static com.yandex.mandrik.launcher.util.preference.constants.LauncherConstants.APP_PREFERENCE_MEMORABLE_URI;
import static com.yandex.mandrik.launcher.util.preference.constants.LauncherConstants.APP_PREFERENCE_RECYCLER_APPS_SETTINGS;
import static com.yandex.mandrik.launcher.util.preference.constants.LauncherConstants.COUNT_ELEMENTS_IN_ROW_LANDSCAPE;
import static com.yandex.mandrik.launcher.util.preference.constants.LauncherConstants.COUNT_ELEMENTS_IN_ROW_PORTRAIT;
import static com.yandex.mandrik.launcher.util.preference.constants.LauncherConstants.COUNT_MEMORABLE_URI;
import static com.yandex.mandrik.launcher.util.preference.constants.LauncherConstants.COUNT_URI_IN_SETTING;
import static com.yandex.mandrik.launcher.util.preference.constants.LauncherConstants.IS_HIDDEN_FAVORITES;
import static com.yandex.mandrik.launcher.util.preference.constants.LauncherConstants.THEME_OF_APPLICATION;
import static com.yandex.mandrik.launcher.util.preference.constants.LauncherConstants.URI_NUMBER;

/**
 * Class helper to work with shared preferences
 */

public class SharedPreferencesHelper {

    /**
     * get id resource of the theme saved in APP_PREFERENCE_RECYCLER_APPS_SETTINGS
     * @param context to use SharedPreferences
     * @return id of resource with theme
     */
    public static int getIdResTheme(Context context) {
        SharedPreferences appSettings = context.getSharedPreferences
                (APP_PREFERENCE_RECYCLER_APPS_SETTINGS, Context.MODE_PRIVATE);

        int idTheme = -1;
        String theme = appSettings.getString(THEME_OF_APPLICATION, "Theme.AmberTheme.Light");
        if(theme.equals("Theme.AmberTheme.Light")) {
            idTheme = R.style.Theme_AmberTheme_Light;
        }
        if(theme.equals("Theme.AmberTheme")) {
            idTheme = R.style.Theme_AmberTheme;
        }

        return idTheme;
    }


    /**
     * change theme saved in file APP_PREFERENCE_RECYCLER_APPS_SETTINGS
     * @param context to use SharedPreferences
     */
    public static void changeResTheme(Context context) {
        SharedPreferences appSettings = context.getSharedPreferences
                (APP_PREFERENCE_RECYCLER_APPS_SETTINGS, Context.MODE_PRIVATE);

        String theme = appSettings.getString(THEME_OF_APPLICATION, "Theme.AmberTheme.Light");

        String newTheme = theme;

        if(theme.equals("Theme.AmberTheme.Light")) {
            newTheme = "Theme.AmberTheme";
        }
        if(theme.equals("Theme.AmberTheme")) {
            newTheme = "Theme.AmberTheme.Light";
        }

        SharedPreferences.Editor e = appSettings.edit();
        e.putString(THEME_OF_APPLICATION, newTheme);
        e.apply();
    }














    /**
     * get count in row of recyclers view of portrait orientation saved in file APP_PREFERENCE_RECYCLER_APPS_SETTINGS
     * @param context to use SharedPreferences
     * @return count items in row of RecyclerView in portrait orientation
     */
    public static int getCountCeilsInRowPortrait(Context context) {
        SharedPreferences appSettings = context.getSharedPreferences
                (APP_PREFERENCE_RECYCLER_APPS_SETTINGS, Context.MODE_PRIVATE);

        int countElementsPortrait = appSettings.getInt(COUNT_ELEMENTS_IN_ROW_PORTRAIT, 4);

        return countElementsPortrait;
    }

    /**
     * get count in row of recyclers view of landscape orientation saved in file APP_PREFERENCE_RECYCLER_APPS_SETTINGS
     * @param context to use SharedPreferences
     * @return count items in row of RecyclerView in landscape orientation
     */
    public static int getCountCeilsInRowLandscape(Context context) {
        SharedPreferences appSettings = context.getSharedPreferences
                (APP_PREFERENCE_RECYCLER_APPS_SETTINGS, Context.MODE_PRIVATE);

        int countElementsLandscape = appSettings.getInt(COUNT_ELEMENTS_IN_ROW_LANDSCAPE, 6);

        return countElementsLandscape;
    }



    /**
     * change count ceils in row of RecyclerView in portrait orientation saved in file APP_PREFERENCE_RECYCLER_APPS_SETTINGS
     * @param context to use SharedPreferences
     */
    public static void changeCountCeilsInRowPortrait(Context context) {
        SharedPreferences appSettings = context.getSharedPreferences
                (APP_PREFERENCE_RECYCLER_APPS_SETTINGS, Context.MODE_PRIVATE);

        int countElementsPortrait = appSettings.getInt(COUNT_ELEMENTS_IN_ROW_PORTRAIT, 4);
        int newCountElementsPortrait = countElementsPortrait;

        if(countElementsPortrait == 5) {
            newCountElementsPortrait = 4;
        } else if(countElementsPortrait == 4) {
            newCountElementsPortrait = 5;
        }

        SharedPreferences.Editor e = appSettings.edit();
        e.putInt(COUNT_ELEMENTS_IN_ROW_PORTRAIT, newCountElementsPortrait);
        e.apply();

    }

    /**
     * change count ceils in row of RecyclerView in landscape orientation saved in file APP_PREFERENCE_RECYCLER_APPS_SETTINGS
     * @param context to use SharedPreferences
     */
    public static void changeCountCeilsInRowLandscape(Context context) {
        SharedPreferences appSettings = context.getSharedPreferences
                (APP_PREFERENCE_RECYCLER_APPS_SETTINGS, Context.MODE_PRIVATE);

        int countElementsLandscape = appSettings.getInt(COUNT_ELEMENTS_IN_ROW_LANDSCAPE, 6);

        int newCountElementsLandscape = countElementsLandscape;

        if(countElementsLandscape == 6) {
            newCountElementsLandscape = 7;
        } else if(countElementsLandscape == 7) {
            newCountElementsLandscape = 6;
        }

        SharedPreferences.Editor e = appSettings.edit();
        e.putInt(COUNT_ELEMENTS_IN_ROW_LANDSCAPE, newCountElementsLandscape);
        e.apply();
    }















    /**
     * get reverse URI's saved in file APP_PREFERENCE_MEMORABLE_URI
     * @param context to use SharedPreferences
     * @return latest Uri's
     */
    public static String[] getUris(Context context) {
        SharedPreferences uriSettings = context.getSharedPreferences
                (APP_PREFERENCE_MEMORABLE_URI, Context.MODE_PRIVATE);

        Integer countUri = uriSettings.getInt(COUNT_URI_IN_SETTING, 0);

        String[] data = new String[countUri];

        for(int i = 0; i < countUri; i++) {
            data[i] = uriSettings.getString(URI_NUMBER + new Integer(countUri - i).toString(), "none");
        }

        return data;
    }

    /**
     * save in file new uri and increase counter saved in APP_PREFERENCE_MEMORABLE_URI
     * @param context to use SharedPreferences
     * @param uri new saved uri
     */
    public static void addUri(Context context, String uri) {
        SharedPreferences appSettings =
                context.getSharedPreferences(APP_PREFERENCE_MEMORABLE_URI, Context.MODE_PRIVATE);

        int countUri = appSettings.getInt(COUNT_URI_IN_SETTING, 0);

        SharedPreferences.Editor e = appSettings.edit();
        e.putString(URI_NUMBER + new Integer(countUri + 1).toString(), uri);
        e.putInt(COUNT_URI_IN_SETTING, countUri+1);
        e.apply();
    }


    /**
     * get count of Uri's saved in file APP_PREFERENCE_MEMORABLE_URI
     * @param context to use SharedPreferences
     * @return count of saved Uri's
     */
    public static int getCountSavedUris(Context context) {
        SharedPreferences uriSettings = context.getSharedPreferences
                (APP_PREFERENCE_MEMORABLE_URI, Context.MODE_PRIVATE);

        Integer countUri = uriSettings.getInt(COUNT_URI_IN_SETTING, 0);

        return countUri;
    }

    /**
     * get count of visible Uri's saved in file APP_PREFERENCE_RECYCLER_APPS_SETTINGS
     * @param context to use SharedPreferences
     * @return count of visible Uri's
     */
    public static int getCountVisibleUris(Context context) {
        SharedPreferences appSettings =
                context.getSharedPreferences(APP_PREFERENCE_RECYCLER_APPS_SETTINGS, Context.MODE_PRIVATE);

        Integer countVisibleUris = appSettings.getInt(COUNT_MEMORABLE_URI, 5);
        return countVisibleUris;
    }


    /**
     * change count of visible URI's saved in file APP_PREFERENCE_RECYCLER_APPS_SETTINGS
     * @param context to use SharedPreferences
     */
    public static void changeCountVisibleUris(Context context, int count) {
        SharedPreferences appSettings =
                context.getSharedPreferences(APP_PREFERENCE_RECYCLER_APPS_SETTINGS, Context.MODE_PRIVATE);

        SharedPreferences.Editor e = appSettings.edit();
        e.putInt(COUNT_MEMORABLE_URI, count);
        e.apply();
    }


    /**
     * clear history of URI's saved in file APP_PREFERENCE_MEMORABLE_URI
     * @param context to use SharedPreferences
     */
    public static void clearHistoryUri(Context context) {
        SharedPreferences uriSettings = context.getSharedPreferences
                (APP_PREFERENCE_MEMORABLE_URI, Context.MODE_PRIVATE);

        Integer countUri = uriSettings.getInt(COUNT_URI_IN_SETTING, 0);

        SharedPreferences.Editor e = uriSettings.edit();
        for(int i = 1; i < countUri + 1; i++) {
            e.remove(URI_NUMBER + new Integer(countUri - i).toString());
        }
        e.putInt(COUNT_URI_IN_SETTING, 0);
        e.apply();
    }








    /**
     * hide or vise favorites
     * @param context to use SharedPreferences
     */
    public static void changeStatusOfHideFavorites(Context context) {
        SharedPreferences appSettings = context.getSharedPreferences
                (APP_PREFERENCE_RECYCLER_APPS_SETTINGS, Context.MODE_PRIVATE);

        boolean isHiddenFavorites = appSettings.getBoolean(IS_HIDDEN_FAVORITES, false);

        boolean newIsHiddenFavorites = !isHiddenFavorites;

        SharedPreferences.Editor e = appSettings.edit();
        e.putBoolean(IS_HIDDEN_FAVORITES, newIsHiddenFavorites);
        e.apply();
    }


    /**
     * get status of favorites
     * @param context to use SharedPreferences
     * @return true if favorites is hidden - else in other
     */
    public static boolean isHiddenFavorites(Context context) {
        SharedPreferences appSettings = context.getSharedPreferences
                (APP_PREFERENCE_RECYCLER_APPS_SETTINGS, Context.MODE_PRIVATE);

        boolean isHiddenFavorites = appSettings.getBoolean(IS_HIDDEN_FAVORITES, false);

        return isHiddenFavorites;
    }
}