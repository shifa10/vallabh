package com.firsttry.vallabh.adepter;
import com.firsttry.vallabh.maindbhelper;
import  com.firsttry.vallabh.detail;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firsttry.vallabh.R;
import com.firsttry.vallabh.model.oredermodel;

import java.util.ArrayList;

public class orederadepter extends  RecyclerView.Adapter<orederadepter.viewholder>{

   ArrayList<oredermodel> list;
   Context context;

    public orederadepter(ArrayList<oredermodel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.oredersample,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
            final  oredermodel model=list.get(position);
            holder.orederimage.setImageResource(model.getOrederimage());
            holder.solditem.setText(model.getSolditem());
            holder.ordernumber.setText(model.getOredernmber());
            holder.price.setText(model.getPrice());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {




                    Intent intent=new Intent(context, detail.class);
                    intent.putExtra("id",Integer.parseInt(model.getOredernmber()));
                    intent.putExtra("type",2);
                    context.startActivity(intent);
                }
            });


              holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                  @Override
                  public boolean onLongClick(View v) {

                      new AlertDialog.Builder(context)
                              .setTitle("DELETE ORDER")
                              .setMessage("are you sure to delete this oreder")
                              .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                  @Override
                                  public void onClick(DialogInterface dialog, int which) {
                                      maindbhelper helper= new maindbhelper(context);
                                      if(helper.deleteoreder(model.getOredernmber())>0) {

                                          Toast.makeText(context, "order cnacelled", Toast.LENGTH_SHORT).show();

                                      }
                                      else
                                      {
                                          Toast.makeText(context, "oreder can't cancelled", Toast.LENGTH_SHORT).show();
                                      }

                                  }
                              })
                              .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                  @Override
                                  public void onClick(DialogInterface dialog, int which) {

                                  }
                              }).show();


                      return false;
                  }
              });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public  class  viewholder extends RecyclerView.ViewHolder{


        ImageView orederimage;
        TextView solditem,ordernumber,price;

        public viewholder(@NonNull View itemView) {
            super(itemView);


            orederimage=itemView.findViewById(R.id.image);
            solditem=itemView.findViewById(R.id.salename);
             ordernumber=itemView.findViewById(R.id.number);
             price=itemView.findViewById(R.id.detailprice);
        }
    }
}
