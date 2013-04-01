package com.duckduckgo.mobile.android.util;

import com.duckduckgo.mobile.android.DDGApplication;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PreferencesManager {
	
	/* Settings */
	
	public static String getThemeName() {
		return DDGApplication.getSharedPreferences().getString("themePref", "DDGDark");
	}
	
	public static String getStartScreen() {
		return DDGApplication.getSharedPreferences().getString("startScreenPref", "0");
	}
	
	public static String getRegion() {
		return DDGApplication.getSharedPreferences().getString("regionPref", "wt-wt");
	}
	
	public static boolean getReadable() {
		return DDGApplication.getSharedPreferences().getBoolean("readablePref", true);
	}
	
	public static boolean getExternalBrowser() {
		return DDGApplication.getSharedPreferences().getBoolean("externalBrowserPref", false);
	}
	
	public static boolean getTurnOffAutocomplete() {
		return DDGApplication.getSharedPreferences().getBoolean("turnOffAutocompletePref", false);
	}
	
	public static boolean getRecordHistory() {
		return DDGApplication.getSharedPreferences().getBoolean("recordHistoryPref", true);
	}
	
	public static boolean getDirectQuery() {
		return DDGApplication.getSharedPreferences().getBoolean("directQueryPref", true);
	}
	
	public static boolean containsSourcesetSize() {
		return DDGApplication.getSharedPreferences().contains("sourceset_size");
	}
	
	public static int getSourcesetSize() {
		return DDGApplication.getSharedPreferences().getInt("sourceset_size", 0);
	}
	
	public static int getFontPrevProgress(int defaultValue) {
		return DDGApplication.getSharedPreferences().getInt("fontPrevProgress", defaultValue);
	}
	
	/* Text sizes */
	public static float getMainFontSize(float defaultValue) {
		return DDGApplication.getSharedPreferences().getFloat("mainFontSize", defaultValue);
	}
	
	public static float getRecentFontSize(float defaultValue) {
		return DDGApplication.getSharedPreferences().getFloat("recentFontSize", defaultValue);
	}
	
	public static int getWebviewFontSize() {
		return DDGApplication.getSharedPreferences().getInt("webViewFontSize", -1);
	}
	
	public static float getLeftTitleTextSize(float defaultValue) {
		return DDGApplication.getSharedPreferences().getFloat("leftTitleTextSize", defaultValue);
	}
	
	public static int getPtrHeaderTextSize(int defaultValue) {
		return DDGApplication.getSharedPreferences().getInt("ptrHeaderTextSize", defaultValue);
	}
	
	public static int getPtrHeaderSubTextSize(int defaultValue) {
		return DDGApplication.getSharedPreferences().getInt("ptrHeaderSubTextSize", defaultValue);
	}
	
	public static int getAppVersionCode() {
		return DDGApplication.getSharedPreferences().getInt("appVersionCode", 0);
	}
	
	public static void saveAppVersionCode(int appVersionCode) {
		Editor editor = DDGApplication.getSharedPreferences().edit();
		editor.putInt("appVersionCode", appVersionCode);
		editor.commit();
	}
	
	public static void saveAdjustedTextSizes() {
		Editor editor = DDGApplication.getSharedPreferences().edit();
		editor.putInt("fontPrevProgress", DDGControlVar.fontPrevProgress);
		editor.putFloat("mainFontSize", DDGControlVar.mainTextSize);
		editor.putFloat("recentFontSize", DDGControlVar.recentTextSize);
		editor.putInt("webViewFontSize", DDGControlVar.webViewTextSize);
		editor.putInt("ptrHeaderTextSize", DDGControlVar.ptrHeaderSize);
		editor.putInt("ptrHeaderSubTextSize", DDGControlVar.ptrSubHeaderSize);
		editor.putFloat("leftTitleTextSize", DDGControlVar.leftTitleTextSize);
		editor.commit();
	}
	
	public static void clearValues() {
		Editor editor = DDGApplication.getSharedPreferences().edit();
		editor.putInt("fontPrevProgress", DDGConstants.FONT_SEEKBAR_MID);
		editor.remove("mainFontSize");
		editor.remove("recentFontSize");
		editor.remove("webViewFontSize");
		editor.remove("ptrHeaderTextSize");
		editor.remove("ptrHeaderSubTextSize");
		editor.remove("leftTitleTextSize");
		editor.commit();
	}
	
	/* Events */
    public static void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals("startScreenPref")){
            DDGControlVar.START_SCREEN = SCREEN.getByCode(Integer.valueOf(sharedPreferences.getString(key, "0")));
        }
        else if(key.equals("regionPref")){
            DDGControlVar.regionString = sharedPreferences.getString(key, "wt-wt");
        }
        else if(key.equals("appSearchPref")){
            DDGControlVar.includeAppsInSearch = sharedPreferences.getBoolean(key, false);
        }
        else if(key.equals("externalBrowserPref")){
            DDGControlVar.alwaysUseExternalBrowser = sharedPreferences.getBoolean(key, false);
        }
        else if(key.equals("turnOffAutocompletePref")){
            DDGControlVar.isAutocompleteActive = !sharedPreferences.getBoolean(key, false);
        }
    }
    
    /* Collections */
    public static String getReadArticles() {
		return DDGApplication.getSharedPreferences().getString("readarticles", null);
	}
    
    public static void saveReadArticles(String combinedArticles) {
    	Editor editor = DDGApplication.getSharedPreferences().edit();
		editor.putString("readarticles", combinedArticles);
		editor.commit();
	}
}