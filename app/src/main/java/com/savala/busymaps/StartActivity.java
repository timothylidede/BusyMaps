package com.savala.busymaps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.google.android.gms.common.GoogleApiAvailability;

public class StartActivity extends AppCompatActivity {

    private static final String TAG = "StartActivity";

    private static final int ERROR_DIALOG_REQUEST = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.splash_screen);
    }

    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK(): checking google services version");

        int available = GoogleApiAvailability
    }
}