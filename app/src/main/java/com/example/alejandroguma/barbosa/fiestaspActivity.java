package com.example.alejandroguma.barbosa;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class fiestaspActivity extends AppCompatActivity {

    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiestasp);
        extras= getIntent().getExtras();



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent =new Intent(fiestaspActivity.this,drawerMainActivity.class);
        intent.putExtra("username",extras.getString("username"));
        intent.putExtra("email",extras.getString("email"));
        startActivity(intent);
        finish();

    }
}
