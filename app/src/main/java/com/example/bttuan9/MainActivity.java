package com.example.bttuan9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Context context;
    ArrayList<Model> Data;
    CustomAdapter customAdapter;
    Model sModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        //getviews
        listView = findViewById(R.id.listView);
        Data = new ArrayList<>();
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);


        //add Data
        subjectData();

        customAdapter = new CustomAdapter(context, Data);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context, Data.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
   }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo i = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
       switch (item.getItemId()){
            case R.id.delete_id:
               Data.remove(i.position);
                customAdapter.notifyDataSetChanged();
                return true;

            default:
                return super.onContextItemSelected(item);
    }
    }


    private void subjectData() {
        //subject 1
        sModel = new Model();
        sModel.setId(1);
        sModel.setName("Android");
        sModel.setImage(R.drawable.android);
        sModel.setDesc("Android Description");
        Data.add(sModel);

        //subject 2
        sModel = new Model();
        sModel.setId(2);
        sModel.setName("Java");
        sModel.setImage(R.drawable.java);
        sModel.setDesc("Java Description");
        Data.add(sModel);

        //subject 3
        sModel = new Model();
        sModel.setId(1);
        sModel.setName("PHP");
        sModel.setImage(R.drawable.php1);
        sModel.setDesc("PHP Description");
        Data.add(sModel);

        //subject 4
        sModel = new Model();
        sModel.setId(1);
        sModel.setName("Python");
        sModel.setImage(R.drawable.python1);
        sModel.setDesc("Python Description");
        Data.add(sModel);

        //subject 5
        sModel = new Model();
        sModel.setId(1);
        sModel.setName("MySQL");
        sModel.setImage(R.drawable.mysql);
        sModel.setDesc("MySQL Description");
        Data.add(sModel);
    }

}