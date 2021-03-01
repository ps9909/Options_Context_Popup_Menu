package com.example.optionsmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;
    Button button;
    String[] data = {
            "List Item 1",
            "List Item 2",
            "List Item 3",
            "List Item 4",
            "List Item 5"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);
        button=findViewById(R.id.button);

        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, data);

        listView.setAdapter(adapter);

        registerForContextMenu(listView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(MainActivity.this,v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_items, popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this, "You have clicked on "+item.getTitle()+" Menu Item", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete:
                Toast.makeText(this, "You have clicked on Delete Menu Item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search:
                Toast.makeText(this, "You have clicked on Search Menu Item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rateUs:
                Toast.makeText(this, "You have clicked on Rate Us Menu Item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contactUs:
                Toast.makeText(this, "You have clicked on Contact Us Menu Item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.feedback:
                Toast.makeText(this, "You have clicked on Feedback Menu Item", Toast.LENGTH_SHORT).show();
                break;


        }
        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_items, menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete:
                Toast.makeText(this, "You have clicked on Delete Menu Item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search:
                Toast.makeText(this, "You have clicked on Search Menu Item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rateUs:
                Toast.makeText(this, "You have clicked on Rate Us Menu Item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contactUs:
                Toast.makeText(this, "You have clicked on Contact Us Menu Item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.feedback:
                Toast.makeText(this, "You have clicked on Feedback Menu Item", Toast.LENGTH_SHORT).show();
                break;


        }
        return true;
    }
}