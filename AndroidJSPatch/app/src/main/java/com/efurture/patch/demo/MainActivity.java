package com.efurture.patch.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.furture.demo.R;
import com.furture.patch.JSPatch;


/**
 *
 * Turn Off Android Studio Instant Run, Then Run Demo
 * */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        JSPatch.init(getApplicationContext());


        final Bug bug = new SubBug();

        final EditText editText = (EditText) findViewById(R.id.editText);

        editText.setText(AssetScript.read(this,"patch.js"));


        findViewById(R.id.patch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String script = AssetScript.transformScript(editText.getText().toString());
                JSPatch.execute(script);
            }
        });

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testBug();
                bug.bug(MainActivity.this);
            }
        });
    }


    public void  testBug(){
        Toast.makeText(getBaseContext(), "I'm Bug, Please Apply Patch Fix Me", Toast.LENGTH_SHORT).show();
    }
}
