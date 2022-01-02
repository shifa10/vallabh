 package com.firsttry.vallabh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firsttry.vallabh.databinding.ActivityDetailBinding;

public class detail extends AppCompatActivity {

    ActivityDetailBinding binding;
    int count=0;
    int total;

    //Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // this.context=context;
        super.onCreate(savedInstanceState);


        binding = ActivityDetailBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();





        binding.backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), foodsearchpage.class);
                startActivity(intent);

            }
        });

        final maindbhelper helper = new maindbhelper(this);

        if (getIntent().getIntExtra("type", 0) == 1)
        {


            final int manchurian = getIntent().getIntExtra("manchurian", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("description");


            binding.detailimage.setImageResource(manchurian);
            binding.detailprice.setText(String.format("%d", price));
            binding.detailname.setText(name);
            binding.detaildescription.setText(description);
            



            binding.insertbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String name = binding.namebox.getText().toString();
                    String phonenm = binding.phonebox.getText().toString();
                    if (!name.matches("[a-zA-Z ]+")) {
                        Toast.makeText(detail.this, "ENTER ONLY ALPHABETICAL CHARACTER", Toast.LENGTH_SHORT).show();
                    } else if (name.length() == 0 || phonenm.length() == 0) {
                        Toast.makeText(detail.this, "PLEASE ENTER ALL THE FEILD!", Toast.LENGTH_SHORT).show();
                    }
                    else if(!phonenm.matches("[0-9]{10}")){

                        Toast.makeText(detail.this, "Please enter valid 10 digit phone number", Toast.LENGTH_SHORT).show();

                    }
                    else {

                        boolean isInserted = helper.insertorders(
                                binding.namebox.getText().toString(),
                                binding.phonebox.getText().toString(),
                                price,
                                manchurian,
                                name,
                                description,

                                Integer.parseInt(binding.quantity.getText().toString())
                        );
                        if (isInserted) {
                            Toast.makeText(detail.this, "orederd sucess fully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), thankyou.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(detail.this, "something went wrong!", Toast.LENGTH_SHORT).show();
                        }


                    }
                }
            });


        }
        else {



            final int id=getIntent().getIntExtra("id",0);
            Cursor cursor=helper.getorderbyid(id);
             final   int image=cursor.getInt(4);
            binding.detailimage.setImageResource(cursor.getInt(4));
            binding.detailprice.setText(String.format("%d", cursor.getInt(3)));
            binding.detailname.setText(cursor.getString(5));
            binding.detaildescription.setText(cursor.getString(6));
            binding.namebox.setText(cursor.getString(1));
            binding.phonebox.setText(cursor.getString(2));
            binding.insertbtn.setText("update now");
           binding.insertbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
             boolean isupdated =helper.updateorders(
                            binding.namebox.getText().toString(),
                            binding.phonebox.getText().toString(),
                          Integer.parseInt(binding.detailprice.getText().toString()),
                             image,
                            binding.detaildescription.getText().toString(),
                            binding.detailname.getText().toString(),
                            Integer.parseInt(binding.quantity.getText().toString()),

                            id

                            );
                    if(isupdated)
                    {
                        Toast.makeText(detail.this, "updated successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), thankyou.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(detail.this, "failed!", Toast.LENGTH_SHORT).show();

                }
            });



        }}




        public void increment(View view)
        {
              count++;
              binding.quantity.setText(""+count);



        }
    public void decrement(View view)
    {
        if(count<=0)count=0;
        else
         count--;
         binding.quantity.setText(""+count);

    }

    public void subtotal(View view)
    {
      
    }
}