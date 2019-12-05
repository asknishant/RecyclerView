package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView text;
    RecyclerView myRecycler;
    String pet[],desc[];
    int imageResource[]={R.drawable.dog,R.drawable.dog,R.drawable.dog,R.drawable.dog, R.drawable.dog, R.drawable.dog};

    MyOwnAdapter myOwnAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=findViewById(R.id.text);
        myRecycler=findViewById(R.id.myRecycler);

        pet=getResources().getStringArray(R.array.pet);
        desc=getResources().getStringArray(R.array.description);

        myOwnAdapter= new MyOwnAdapter(pet,desc,imageResource,this);

        myRecycler.setAdapter(myOwnAdapter);
        //providing layout
        myRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
}
