package com.firsttry.vallabh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);


        Thread thread = new Thread(){

            public void run()
            {
                try
                {
                    sleep(4000);
                }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                 finally {
                    Intent intent =new Intent(MainActivity.this , home.class);
                    startActivity(intent);
                    finish();
                }
            }


        };thread.start();

    }
}