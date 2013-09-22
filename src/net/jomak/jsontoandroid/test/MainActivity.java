package net.jomak.jsontoandroid.test;

import net.jomak.jsontoandroid.R;
import net.jomak.jsontoandroid.R.layout;
import net.jomak.jsontoandroid.R.menu;
import net.jomak.watup.datagrabber.CourseGrabber;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(new CourseGrabber().getCourseFromRoom("RCH307"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
