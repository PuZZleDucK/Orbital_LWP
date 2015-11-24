/*
 * Orbital Live Wallpaper
 *
 * Copyright (C) 2012 PuZZleDucK (PuZZleDucK@gmail.com)
 * 
 *	This program is free software; you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License version
 *	3 as published by the Free Software Foundation.
 *
 * This live wallpaper was originally based on the target live wallpaper by PuZZleDucK
 *
 */

package org.puzzleduck.orbital_lwp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.Log;

public class OrbitalLiveWallpaperSettings extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private static SharedPreferences sharedPreferences;
    protected static String orbitType;
    protected static String orbitSpeed;
    protected static String orbitDirection;
    protected static String dotColor;
    protected static String dotSize;
    protected static String orbitCount;
    protected static String transitionTypes;
    protected static String transitionSpeeds;

    private static final String PREF_O_TYPE = "orbit_type";
    private static final String PREF_O_SPEED = "orbit_speed";
    private static final String PREF_O_DIR = "orbit_direction";
    private static final String PREF_D_COLOR = "dot_color";
    private static final String PREF_D_SIZE = "dot_size";
    private static final String PREF_D_COUNT = "dot_count";
    private static final String PREF_T_TYPE = "transition_types";
    private static final String PREF_T_SPEED = "transition_speeds";

    @Override
    protected void onCreate(Bundle newBundle) {
        super.onCreate(newBundle);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        getPreferenceManager().setSharedPreferencesName(OrbitalLiveWallpaper.SHARED_PREFS_NAME);
        addPreferencesFromResource(R.xml.orbital_lwp_settings);

        Log.d("OLP", "Prefs create");
        setDefaultPrefHandler();
    }

    public static void setDefaultValues(Context targetEngine) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(targetEngine);
        orbitType = sharedPreferences.getString(PREF_O_TYPE, "Random");
        orbitSpeed = sharedPreferences.getString(PREF_O_SPEED, "Random");
        orbitDirection = sharedPreferences.getString(PREF_O_DIR, "Random");
        dotColor = sharedPreferences.getString(PREF_D_COLOR, "Random");
        dotSize = sharedPreferences.getString(PREF_D_SIZE, "Random");
        orbitCount = sharedPreferences.getString(PREF_D_COUNT, "Random");
        transitionTypes = sharedPreferences.getString(PREF_T_TYPE, "Random");
        transitionSpeeds = sharedPreferences.getString(PREF_T_SPEED, "Random");
    }

    protected void setDefaultPrefHandler() { //OrbitalLiveWallpaperSettings olwps
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroy();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        switch(key) {
            case PREF_O_TYPE:
                orbitType = sharedPreferences.getString(PREF_O_TYPE, "Random");
                break;
            case PREF_O_SPEED:
                orbitSpeed = sharedPreferences.getString(PREF_O_SPEED, "Random");
                break;
            case PREF_O_DIR:
                orbitDirection = sharedPreferences.getString(PREF_O_DIR, "Random");
                break;
            case PREF_D_COLOR:
                dotColor = sharedPreferences.getString(PREF_D_COLOR, "Random");
                break;
            case PREF_D_SIZE:
                dotSize = sharedPreferences.getString(PREF_D_SIZE, "Random");
                break;
            case PREF_D_COUNT:
                orbitCount = sharedPreferences.getString(PREF_D_COUNT, "Random");
                break;
            case PREF_T_TYPE:
                transitionTypes = sharedPreferences.getString(PREF_T_TYPE, "Random");
                break;
            case PREF_T_SPEED:
                transitionSpeeds = sharedPreferences.getString(PREF_T_SPEED, "Random");
                break;
            default: break;
        }
    }

}
