package com.firsttry.vallabh.adepter;
import com.firsttry.vallabh.R;
import com.firsttry.vallabh.model.specialfoodmodel;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class specialfoodadepter extends RecyclerView.Adapter< specialfoodadepter.specialfoodviewholder> {

    Context context;
    List<specialfoodmodel>specialfoodmodelList;
    

    public specialfoodadepter(Context context, List<specialfoodmodel> specialfoodmodelList)
    {
        this.context = context;
        this.specialfoodmodelList = specialfoodmodelList;
    }

    @NonNull
    @Override
    public specialfoodviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.special_food_raw_item,parent,false);
        return new specialfoodviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull specialfoodviewholder holder, int position) {

        holder.manchurian.setImageResource(specialfoodmodelList.get(position).getImageurl());
        holder.name.setText(specialfoodmodelList.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return specialfoodmodelList.size();
    }

    public static final class specialfoodviewholder extends RecyclerView.ViewHolder{

        ImageView manchurian;
        TextView name;

        public specialfoodviewholder(@NonNull View itemView) {
            super(itemView);

            manchurian =itemView.findViewById(R.id.spimage);

            name =itemView.findViewById(R.id.spname);
        }
    }
}
