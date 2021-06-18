package com.example.qrscanner004;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class viewdata extends AppCompatActivity {

    public static TextView textView4,srno,doi,dns,lrd,ns,sd,nst,lc;
    public static Button buttonh1,buttons1;
    public static ImageView imageView1;
    DatabaseReference reference;

    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference=firebaseDatabase.getReference();
    private DatabaseReference first = databaseReference.child("Baggage Carousel").child("link");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_viewdata);
        textView4=(TextView)findViewById(R.id.textView4);
        imageView1=(ImageView) findViewById(R.id.imageView1);

        srno=(TextView) findViewById(R.id.srno);
        doi=(TextView) findViewById(R.id.doi);
        dns=(TextView) findViewById(R.id.dns);
        lrd=(TextView) findViewById(R.id.lrd);
        ns=(TextView) findViewById(R.id.ns);
        sd=(TextView) findViewById(R.id.sd);
        nst=(TextView) findViewById(R.id.nst);
        lc=(TextView) findViewById(R.id.lc);
        //-------------------------------------------------------------------------------------------------------
         final String copier=MainActivity.textView1.getText().toString();
         //------------------------------------------------------------------------------------------------------
         textView4.setText(copier);

        buttonh1=(Button) findViewById(R.id.buttonh1);
        buttons1=(Button) findViewById(R.id.buttons1);
        reference= FirebaseDatabase.getInstance().getReference().child(copier);
        reference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/qrscanner004.appspot.com/o/baggage_carousel001.jpg?alt=media&token=c4952ef7-074f-4aa8-aa2c-1aa1bf043703").into(imageView1);
            String srnov=dataSnapshot.child("Serial Number").getValue().toString();
            String doiv=dataSnapshot.child("Date of Installation").getValue(String.class);
            String dnsv=dataSnapshot.child("Date of next service due").getValue(String.class);
            String lrdv=dataSnapshot.child("Last Repair Date").getValue(String.class);
            String nsv=dataSnapshot.child("Nature of Service").getValue(String.class);
            String sdv=dataSnapshot.child("Service Description").getValue(String.class);
            String nstv=dataSnapshot.child("Name of Service Technician").getValue(String.class);
            String lcv=dataSnapshot.child("Location").getValue(String.class);

            srno.setText(srnov);
            doi.setText(doiv);
            dns.setText(dnsv);
            lrd.setText(lrdv);
            ns.setText(nsv);
            sd.setText(sdv);
            nst.setText(nstv);
            lc.setText(lcv);

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
        buttonh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),MainActivity.class));


            }
        });
        buttons1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),service_history.class));


            }
        });

    }



}
