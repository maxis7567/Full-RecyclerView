package com.example.mahdisy.compeleterecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<DataType> list=new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            DataType data=new DataType();
            data.subject="subject"+i;
            data.describe="Describe ....";
            list.add(data);
        }
        RecyclerView recyclerView=findViewById(R.id.RecyclerView);
        Adapter adapter=new Adapter(MainActivity.this, list, new InterFaceForViewEvents() {
            @Override
            public void OnAction(List<DataType> list, DataType data, View v) {
                registerForContextMenu(v);
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"Ok",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.o1:
                break;
            case R.id.o2:
                break;
            case R.id.o3:
                break;

        }
        return super.onContextItemSelected(item);
    }
}