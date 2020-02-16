package com.example.admin_rakshak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_viewReport;
    private Button btn_addPost;
    private Button btn_viewPost;
    private Button btn_viewVehicles;
    private Button btn_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_viewReport = (Button)findViewById(R.id.viewReport_button);
        btn_addPost = (Button) findViewById(R.id.addPost_button);
        btn_viewPost = (Button) findViewById(R.id.viewPost_button);
        btn_viewVehicles = (Button) findViewById(R.id.viewVehicles_button);
        btn_help = (Button) findViewById(R.id.help_button);

        btn_viewReport.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, viewReport.class);
                startActivity(intent);
            }
        });
        btn_addPost.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, addPost.class);
                startActivity(intent);
            }
        });
        btn_viewPost.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, viewPost.class);
                startActivity(intent);
            }
        });
        btn_viewVehicles.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewPatrollingVehicle.class);
                startActivity(intent);
            }
        });
        btn_help.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, help.class);
                startActivity(intent);
            }
        });



    }
}
