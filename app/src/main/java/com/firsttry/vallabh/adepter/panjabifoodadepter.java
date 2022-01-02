package com.firsttry.vallabh.adepter;
import com.firsttry.vallabh.R;
import com.firsttry.vallabh.model.panjabifoodmodel;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.firsttry.vallabh.detail;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class panjabifoodadepter extends RecyclerView.Adapter< panjabifoodadepter.panjabifoodviewholder>implements Filterable
{

    Context context;
    List<panjabifoodmodel>panjabifoodmodelList;
    List<panjabifoodmodel>filteruserdatalist;
    //List<String>searchlist;

    public panjabifoodadepter(Context context, List<panjabifoodmodel> panjabifoodmodelList)
    {
        this.context = context;
        this.panjabifoodmodelList = panjabifoodmodelList;
        this.filteruserdatalist=panjabifoodmodelList;


    }


    @NonNull
    @Override
    public panjabifoodviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.panjabi_food_raw_item, parent, false);
        return new panjabifoodadepter.panjabifoodviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull panjabifoodadepter.panjabifoodviewholder holder, int position) {

        final  panjabifoodmodel model=panjabifoodmodelList.get(position);

        holder.manchurian.setImageResource(model.getImageurl());
        holder.name.setText(model.getName());
        holder.rprice.setText(model.getPrice());
        holder.price.setText(model.getPricetag());
        holder.description.setText(model.getDescriptioin()
        );


       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(context,detail.class);
               intent.putExtra("manchurian",model.getImageurl());
               intent.putExtra("price",model.getPricetag());
               intent.putExtra("name",model.getName());
               intent.putExtra("description",model.getDescriptioin());
               intent.putExtra("type",1);
               context.startActivity(intent);

           }
       });


    }



    @Override
    public int getItemCount() {
        return panjabifoodmodelList.size();


    }

    @Override
    public Filter getFilter() {

        return filter;
    }


    Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword) {

             ArrayList<panjabifoodmodel>filterddara = new ArrayList<>();
             if(keyword.toString().isEmpty())

                 filterddara.addAll(filteruserdatalist);
             else
                 {
                 for (panjabifoodmodel food : filteruserdatalist)
                 {
                     if (food.getName().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
                         filterddara.add(food);

                 }
             }
                 FilterResults results1=new FilterResults();
                 results1.values=filterddara;
                 return  results1;



        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results1) {

            panjabifoodmodelList.clear();
            panjabifoodmodelList.addAll((ArrayList<panjabifoodmodel>)results1.values);
            notifyDataSetChanged();


        }
    };

    public static final class panjabifoodviewholder extends RecyclerView.ViewHolder{

           ImageView manchurian;
           TextView price,name,description,rprice;

    public panjabifoodviewholder(@NonNull View itemView) {
        super(itemView);

        manchurian =itemView.findViewById(R.id.pnimage);
        price =itemView.findViewById(R.id.pnprice);
        rprice=itemView.findViewById(R.id.pnrprice);
        name =itemView.findViewById(R.id.pnname);
        description=itemView.findViewById(R.id.pndesc);


    }


}
}


