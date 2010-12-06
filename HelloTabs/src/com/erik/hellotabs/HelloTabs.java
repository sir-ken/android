package com.erik.hellotabs;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class HelloTabs extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, NewsActivity.class);

        // Initialize a TabSpec for each tab and add it to the TabHost

        
        spec = tabHost.newTabSpec("artists").setIndicator("Nyheter")
                      .setContent(intent);
        tabHost.addTab(spec);

        // Do the same for the other tabs
        intent = new Intent().setClass(this, RedActivity.class);
        spec = tabHost.newTabSpec("albums").setIndicator("Rött")
                      .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, WhiteActivity.class);
        spec = tabHost.newTabSpec("songs").setIndicator("Vitt")
                      .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, SparkActivity.class);
        spec = tabHost.newTabSpec("songs").setIndicator("Bubbel")
                      .setContent(intent);
        tabHost.addTab(spec);

        tabHost.getTabWidget().getChildAt(0).getLayoutParams().height = 45;
        tabHost.getTabWidget().getChildAt(1).getLayoutParams().height = 45;
        tabHost.getTabWidget().getChildAt(2).getLayoutParams().height = 45;
        tabHost.getTabWidget().getChildAt(3).getLayoutParams().height = 45;
        tabHost.setCurrentTab(0);
    }
}

