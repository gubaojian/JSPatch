package com.efurture.patch.demo;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by furture on 16/9/20.
 */
public class Bug {

    public void bug(Activity activity){
        Toast.makeText(activity, "Bug", Toast.LENGTH_SHORT).show();
    }
}
