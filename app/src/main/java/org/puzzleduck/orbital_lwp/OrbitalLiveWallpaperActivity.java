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

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
//pc mod
public class OrbitalLiveWallpaperActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        findViewById(R.id.appsButton).setOnClickListener((OnClickListener) this);
        findViewById(R.id.githubButton).setOnClickListener( (OnClickListener) this);
        findViewById(R.id.contactDevButton).setOnClickListener( (OnClickListener) this);
        findViewById(R.id.configOrbitButton).setOnClickListener( (OnClickListener) this);
        findViewById(R.id.configWallpaperButton).setOnClickListener( (OnClickListener) this);
        
    }
    
    

	@Override
	public void onClick(View v) {
		
        if(v.getId() == R.id.contactDevButton)
        {
          Intent intent = new Intent(Intent.ACTION_SEND);
          intent.setType("plain/text");
          intent.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.feedback_email)});
          intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.feedback_email_subject));
          intent = Intent.createChooser(intent, getString(R.string.feedback_pick_email_prompt));
        	startActivity(intent);
        }//if contact button

        
        if(v.getId() == R.id.appsButton)
        {
        	Intent intent = new Intent(Intent.ACTION_VIEW);
        	intent.setData(Uri.parse(getString(R.string.search_apps_uri)));
        	startActivity(intent);
        }//if apps button


        if(v.getId() == R.id.githubButton)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(getString(R.string.source_url)));
            startActivity(intent);
        }//if apps button

        if(v.getId() == R.id.configOrbitButton)
        {
            Intent intent = new Intent();
            intent.setClass(this, OrbitalLiveWallpaperSettings.class);
            startActivity(intent);
        }//if cfg button

        if(v.getId() == R.id.configWallpaperButton)
        {
            Intent intent = new Intent(Intent.ACTION_SET_WALLPAPER );
            startActivity(intent);
        }//if wallpaper button

	}
    
}
