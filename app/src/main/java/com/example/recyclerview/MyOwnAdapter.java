package com.example.recyclerview;


//We are creating this class to hold items of recycler view in an adapter.
//This is a blueprint and we can modify methods according to our needs.

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// com.example.recyclerview.MyOwnAdapter class is  made extending RecyclerView,Adapter which is generic type.
//generic type is an inner class of MyOwnHolder.The inner class should extend RecyclerView.viewHolder.

//We are creating an inner class which is a generic type to parent class RecyclerView.Adapter.
//myrow is a xml file which is a layout to all the items of Recycler view.

public class MyOwnAdapter extends RecyclerView.Adapter<MyOwnAdapter.MyOwnHolder> {

    String data1[],data2[];
    int img[];
    Context ctx;


    public MyOwnAdapter(String d1[],String d2[],int img[],Context ct)
    {
        data1=d1;
        data2=d2;
        this.img=img;
        ctx=ct;
    }

    //onCreateViewHolder is the first method which will be called.

    @NonNull
    @Override
    public MyOwnHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        //LayoutInflater will attach the layout file to java file.
        LayoutInflater myInflater = LayoutInflater.from(ctx);
        View myOwnView=myInflater.inflate(R.layout.myrow,parent,false);//ViewGroup is parent and we don't want to attach the parent to myrow.xml.
        return new MyOwnHolder(myOwnView);
    }

    //At last this method will be called to bind the data

    @Override
    public void onBindViewHolder(@NonNull MyOwnHolder holder, int position) {
        holder.t1.setText(data1[position]);
        holder.t2.setText(data2[position]);
        holder.image.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {

        return data1.length;
        //or return data2.length;
        //or return img.length;  All are same.

    }


    //This class will help to create an object to access views after inflating MainActivity.java with myrow.java.
    //This class holds the item of recycler view after inflating.
    public class MyOwnHolder extends RecyclerView.ViewHolder {

        TextView t1,t2;
        ImageView image;
        public MyOwnHolder(@NonNull View itemView) {
            super(itemView);

            t1=itemView.findViewById(R.id.pet_name);//findViewById will not directly work
            // as everything is inside an itemView after inflating.
            t2=itemView.findViewById(R.id.pet_desc);
            image=itemView.findViewById(R.id.imageView);

        }


    }
}
