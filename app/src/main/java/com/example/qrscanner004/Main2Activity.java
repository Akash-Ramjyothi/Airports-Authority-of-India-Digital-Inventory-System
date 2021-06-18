package com.example.qrscanner004;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.zxing.Result;

import java.util.Scanner;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Main2Activity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView ScannerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main2);
        ScannerView=new ZXingScannerView(this);
        setContentView(ScannerView);
    }

    @Override
    public void handleResult(Result result) {

        MainActivity.textView1.setText(result.getText());
        //onBackPressed();

         String data = result.getText();

        //viewdata.textView4.setText(data);
       // Intent viewUpdate = new Intent(Main2Activity.this,ViewOrUpdateActivity.class);
       // viewUpdate.putExtra("qr_data",result.getText());
        //startActivity(viewUpdate);
        startActivity(new Intent(getApplicationContext(),ViewOrUpdateActivity.class));

    }


    @Override
    protected void onPause() {
        super.onPause();
        ScannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ScannerView.setResultHandler(this);
        ScannerView.startCamera();
    }
}
