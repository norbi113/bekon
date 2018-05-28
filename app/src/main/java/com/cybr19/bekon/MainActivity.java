package com.cybr19.bekon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private TextView rolloReadOut;
    private DatabaseReference refRollo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rolloReadOut = (TextView) findViewById(R.id.rollo);

        refRollo = FirebaseDatabase.getInstance().getReference().child("rollo");
        refRollo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String lightValue = dataSnapshot.getValue(String.class);
                rolloReadOut.setText(lightValue);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
