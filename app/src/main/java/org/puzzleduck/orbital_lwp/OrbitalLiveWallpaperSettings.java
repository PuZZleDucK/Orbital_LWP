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

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.Log;

public class OrbitalLiveWallpaperSettings extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    protected static String dotColor;
    protected static String orbitCount;
    protected static String orbitSpeed;
    protected static String dotSize;
    protected static String transitionType;
    protected static String orbitType;
    protected static String orbitDirection;


    @Override
    protected void onCreate(Bundle newBundle) {
        super.onCreate(newBundle);
        getPreferenceManager().setSharedPreferencesName(OrbitalLiveWallpaper.SHARED_PREFS_NAME);
        addPreferencesFromResource(R.xml.orbital_lwp_settings);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        cycleOrbitType = sharedPreferences.getBoolean("orbit_pattern_cycle_on", true);
        dotColor = sharedPreferences.getString("orbit_color_cycle_on", "Random");
        orbitCount = sharedPreferences.getString("orbit_count_cycle_on", "Random");
        orbitSpeed = sharedPreferences.getString("orbit_speed_cycle_on", "Random");
        dotSize = sharedPreferences.getString("orbit_size_cycle_on", "Random");
//        transitionType = sharedPreferences.getString("orbit_transition_cycle_on", "Random");
        orbitType = sharedPreferences.getString("fixed_orbit_type", "Random");
        transitionType = sharedPreferences.getString("fixed_transitions", "Random");

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
            case "orbit_type":
                orbitType = sharedPreferences.getString("orbit_type", "Random");
                Log.d("TYPE","fixedOrbit = "+orbitType);
                break;
            case "orbit_speed":
                orbitSpeed = sharedPreferences.getString("orbit_speed", "Random");
                break;
            case "orbit_direction":
                orbitDirection = sharedPreferences.getString("orbit_direction", "Random");
                break;
            case "dot_color":
                orbitCount = sharedPreferences.getString("orbit_count_cycle_on", "Random");
                break;
            case "orbit_speed_cycle_on":
                orbitSpeed = sharedPreferences.getString("orbit_speed_cycle_on", "Random");
                break;
            case "orbit_transition_cycle_on":
                //transitionType = sharedPreferences.getString("orbit_transition_cycle_on", "Random");
                transitionType = sharedPreferences.getString("fixed_transitions", "Random");
                break;

            default: break;
        }

    	
    }
    
    
}
