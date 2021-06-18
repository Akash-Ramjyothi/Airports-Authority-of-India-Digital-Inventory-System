package com.example.qrscanner004;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class updatedata extends AppCompatActivity {

    public static Button buttonh1,buttons1;
    public static EditText textView4,srno,doi,dns,lrd,ns,sd,nst,lc;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedata);

        buttonh1=(Button) findViewById(R.id.buttonh1);
        buttons1=(Button) findViewById(R.id.buttons1);

        srno=(EditText) findViewById(R.id.srno);
        doi=(EditText) findViewById(R.id.doi);
        dns=(EditText) findViewById(R.id.dns);
        lrd=(EditText) findViewById(R.id.lrd);
        ns=(EditText) findViewById(R.id.ns);
        sd=(EditText) findViewById(R.id.sd);
        nst=(EditText) findViewById(R.id.nst);
        lc=(EditText) findViewById(R.id.lc);

        reference= FirebaseDatabase.getInstance().getReference().child("Baggage Carousel");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                final String srnov=dataSnapshot.child("Serial Number").getValue().toString();
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

                buttons1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myRef1 = database.getReference("Baggage Carousel").child("Serial Number");
                        myRef1.setValue(srno);
                        //DatabaseReference myRef2 = database.getReference("Baggage Carousel").child("Date of Installation");
                        //myRef2.setValue(doi);

                    }

                });

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
        /*buttons1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef1 = database.getReference("Baggage Carousel").child("Serial Number");
                myRef1.setValue(12345678);
                //DatabaseReference myRef2 = database.getReference("Baggage Carousel").child("Date of Installation");
                //myRef2.setValue(doi);

            }

        });*/
    }

}
