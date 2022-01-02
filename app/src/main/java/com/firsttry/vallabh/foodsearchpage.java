package com.firsttry.vallabh;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import com.firsttry.vallabh.adepter.specialfoodadepter;
import  com.firsttry.vallabh.model.specialfoodmodel;
import  com.firsttry.vallabh.adepter.panjabifoodadepter;
import com.firsttry.vallabh.model.panjabifoodmodel;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class foodsearchpage extends AppCompatActivity {



     BottomNavigationView bottomNavigationView;
    RecyclerView specialfood_recycler,panjabifood_recycler;
    specialfoodadepter specialfoodadepter;
    panjabifoodadepter panjabifoodadepter;
     //private  Object searchview;



   // private Object BottomNavigationView;
    Context context;

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setMessage("are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        moveTaskToBack(true);
                       foodsearchpage.super.onBackPressed();
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });

        AlertDialog  alertDialog=builder.create();
        alertDialog.show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        this.context=context;
        setContentView(R.layout.activity_foodsearchpage);


        bottomNavigationView=findViewById(R.id.bootom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();


                if(id==R.id.history)
                {
                    Intent intent=new Intent(getApplicationContext(),history.class);
                    startActivity(intent);
                }
                else if(id==R.id.aboutus)
                {
                    Intent intent=new Intent(getApplicationContext(),aboutus.class);
                    startActivity(intent);
                }
                else if(id==R.id.home)
                {
                    Intent intent=new Intent(getApplicationContext(),foodsearchpage.class);
                    startActivity(intent);
                }

                return true;

            }



        });
       SearchView searchview=findViewById(R.id.searchView);

        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                panjabifoodadepter.getFilter().filter(newText);
                return false;
            }
        });



        List<specialfoodmodel>specialfoodmodelList= new ArrayList<>();

        specialfoodmodelList.add(new specialfoodmodel("Paneer panjabi",R.drawable.paneer_panjabi));
        specialfoodmodelList.add(new specialfoodmodel("Sandwich",R.drawable.sandwich));
        specialfoodmodelList.add(new specialfoodmodel("Dhosa",R.drawable.dhosa));
        specialfoodmodelList.add(new specialfoodmodel("Spl.Daal",R.drawable.spldal));
        specialfoodmodelList.add(new specialfoodmodel("Machurian",R.drawable.manchu));
        specialfoodmodelList.add(new specialfoodmodel("Noodles",R.drawable.noodles));
        specialfoodmodelList.add(new specialfoodmodel("Basmati Rice",R.drawable.rice));

        setSpecialfood_recycler(specialfoodmodelList);





        List<panjabifoodmodel>panjabifoodmodelList= new ArrayList<>();
        panjabifoodmodelList.add(new panjabifoodmodel("Manchurian","₹",R.drawable.manchu,"Veg Manchurian is a tasty Chinese \n dish of fried veggie balls in a spicy.","140"));
        panjabifoodmodelList.add(new panjabifoodmodel("Cheesy pizza","₹",R.drawable.cheesypizza,"yummay delicious creemy pizza ","180"));
        panjabifoodmodelList.add(new panjabifoodmodel("panir panjsbi","₹",R.drawable.paneer_panjabi,"Delicious with paneer panjabi","110"));
        panjabifoodmodelList.add(new panjabifoodmodel("sandwich","₹",R.drawable.sandwich,"Veg sandwich that you found for","60"));
        panjabifoodmodelList.add(new panjabifoodmodel("noodles","₹",R.drawable.noodles,"Noodles that make you lost","100"));
        panjabifoodmodelList.add(new panjabifoodmodel("dhosa","₹",R.drawable.sandwich,"Veg sandwich that you found for","80"));
        panjabifoodmodelList.add(new panjabifoodmodel("basmati rice","₹",R.drawable.rice,"Noodles that make you lost","70"));
        panjabifoodmodelList.add(new panjabifoodmodel("Italian pizza","₹",R.drawable.italianpizza,"your yummy italian pizza","190"));
        panjabifoodmodelList.add(new panjabifoodmodel("malai kofta","₹",R.drawable.malaikofta,"Veg sandwich that you found for","160"));
        panjabifoodmodelList.add(new panjabifoodmodel("mombey bhel","₹",R.drawable.mombaybhel,"Delicious bobey spicy bhel","80"));
        panjabifoodmodelList.add(new panjabifoodmodel("choumin boodles","₹",R.drawable.chouminnoodles,"spicy daal with tadkaa","180"));
        panjabifoodmodelList.add(new panjabifoodmodel("frydaal","₹",R.drawable.spldal,"spicy daal with tadkaa","60"));
        setpanjabifood_recycler(panjabifoodmodelList);





    }
    private void setSpecialfood_recycler(List<specialfoodmodel>specialfoodmodelList) {

        specialfood_recycler = findViewById(R.id.specialfood_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        specialfood_recycler.setLayoutManager(layoutManager);
        specialfoodadepter = new specialfoodadepter(this, specialfoodmodelList);
        specialfood_recycler.setAdapter(specialfoodadepter);
    }

    private void setpanjabifood_recycler(List<panjabifoodmodel>panjabifoodmodelList) {

       panjabifood_recycler = findViewById(R.id.panjabifood_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        panjabifood_recycler.setLayoutManager(layoutManager);
        panjabifoodadepter = new panjabifoodadepter(this, panjabifoodmodelList);
        panjabifood_recycler.setAdapter(panjabifoodadepter);
    }





}



