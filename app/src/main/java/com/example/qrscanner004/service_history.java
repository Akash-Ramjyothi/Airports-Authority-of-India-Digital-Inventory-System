package com.example.qrscanner004;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class service_history extends AppCompatActivity {

    public static TextView name1,id1,service1,name2,id2,service2,name3,id3,service3,name4,id4,service4;
    public static ImageView imageView1,imageView2,imageView3,imageView4;
    DatabaseReference reference;

    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference=firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_history);

        imageView1=(ImageView) findViewById(R.id.imageView1);
        imageView2=(ImageView) findViewById(R.id.imageView2);
        imageView3=(ImageView) findViewById(R.id.imageView3);
        imageView4=(ImageView) findViewById(R.id.imageView4);

        name1=(TextView) findViewById(R.id.name1);
        id1=(TextView) findViewById(R.id.id1);
        service1=(TextView) findViewById(R.id.service1);
        name2=(TextView) findViewById(R.id.name2);
        id2=(TextView) findViewById(R.id.id2);
        service2=(TextView) findViewById(R.id.service2);
        name3=(TextView) findViewById(R.id.name3);
        id3=(TextView) findViewById(R.id.id3);
        service3=(TextView) findViewById(R.id.service3);
        name4=(TextView) findViewById(R.id.name4);
        id4=(TextView) findViewById(R.id.id4);
        service4=(TextView) findViewById(R.id.service4);

        reference= FirebaseDatabase.getInstance().getReference().child("Baggage Carousel").child("Service History");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/qrscanner004.appspot.com/o/akashrecycler.jpeg?alt=media&token=e8cbebe5-a03d-420a-b945-69db490ac49a").into(imageView1);
                Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/qrscanner004.appspot.com/o/pp%20(3).jfif?alt=media&token=27912690-9628-46f5-93b6-d29b34da3102").into(imageView2);
                Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/qrscanner004.appspot.com/o/anushkarecycler%20(2).jfif?alt=media&token=995ab81a-a044-4169-9c54-7ec8acd134af").into(imageView3);
                Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/qrscanner004.appspot.com/o/dineshrecycler.jpeg?alt=media&token=9e1eeee7-3e70-4859-9001-b0f86f7099a0").into(imageView4);

                String name1v=dataSnapshot.child("name1").getValue(String.class);
                String id1v=dataSnapshot.child("id1").getValue(String.class);
                String service1v=dataSnapshot.child("service1").getValue(String.class);
                String name2v=dataSnapshot.child("name2").getValue(String.class);
                String id2v=dataSnapshot.child("id2").getValue(String.class);
                String service2v=dataSnapshot.child("service2").getValue(String.class);
                String name3v=dataSnapshot.child("name3").getValue(String.class);
                String id3v=dataSnapshot.child("id3").getValue(String.class);
                String service3v=dataSnapshot.child("service3").getValue(String.class);
                String name4v=dataSnapshot.child("name4").getValue(String.class);
                String id4v=dataSnapshot.child("id4").getValue(String.class);
                String service4v=dataSnapshot.child("service4").getValue(String.class);

                name1.setText(name1v);
                id1.setText(id1v);
                service1.setText(service1v);
                name2.setText(name2v);
                id2.setText(id2v);
                service2.setText(service2v);
                name3.setText(name3v);
                id3.setText(id3v);
                service3.setText(service3v);
                name4.setText(name4v);
                id4.setText(id4v);
                service4.setText(service4v);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
