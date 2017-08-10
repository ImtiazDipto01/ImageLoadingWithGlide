package com.example.dipto.imageloadingwithglide;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    int network_falg = 1 ;
    AlertDialog.Builder internet_connection_faield ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo() ;

        if(networkInfo != null){
            if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI){
                network_falg = 0 ;
            }
            else if(networkInfo.getType() == ConnectivityManager.TYPE_MOBILE){
                network_falg = 0 ;
            }
        }
        else{
            network_falg = 1 ;
        }

        if(network_falg == 1){
            internetConnectFailedMessage();
            AlertDialog alertDialog = internet_connection_faield.create() ;
            alertDialog.show();
        }
        else if(network_falg == 0){

        }
    }

    private void internetConnectFailedMessage(){
        internet_connection_faield = new AlertDialog.Builder(MainActivity.this);
        internet_connection_faield.setTitle("Warning!") ;
        internet_connection_faield.setMessage("Please Check Your Internet Connection") ;
        internet_connection_faield.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
    }
}
