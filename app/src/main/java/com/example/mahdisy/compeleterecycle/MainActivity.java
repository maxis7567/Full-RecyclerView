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

public class MainActivity extends AppCompatActivity  implements Adapter.InterFaceForViewEvents{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<DataModel> list=new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            DataModel data=new DataModel();
            data.subject="subject"+i;
            data.describe="Describe ....";
            list.add(data);
        }
        RecyclerView recyclerView=findViewById(R.id.RecyclerView);
        Adapter adapter=new Adapter(this, list, this);
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

    @Override
    public void OnAction(List<DataModel> list, final DataModel data, View v) {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Ok"+data.subject,Toast.LENGTH_SHORT).show();

            }
        });


    }
}
