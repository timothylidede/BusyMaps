package com.savala.busymaps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class StartActivity extends AppCompatActivity {

    //constants
    private static final String TAG = "StartActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;

    //widgets
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_start);

        if(isServicesOK()){
            init();
        }
    }

    private void init(){
        startButton = (Button) findViewById(R.id.start_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
    }

    //method that checks whether the user's Play services is up to date
    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK(): checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(StartActivity.this);

        if(available == ConnectionResult.SUCCESS){
            //everything is fine and the user can make map requests
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //an error occured but we can resolve it
            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(StartActivity.this, available,
                    ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "You cannot make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}