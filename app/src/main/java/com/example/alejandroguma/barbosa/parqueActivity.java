package com.example.alejandroguma.barbosa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class parqueActivity extends AppCompatActivity {
    Button bAtrasparque;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parque);
        bAtrasparque=(Button)findViewById(R.id.bAtrasparque);
        extras= getIntent().getExtras();
        bAtrasparque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(parqueActivity.this,drawerMainActivity.class);
                intent.putExtra("username",extras.getString("username"));
                intent.putExtra("email",extras.getString("email"));
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent =new Intent(parqueActivity.this,drawerMainActivity.class);
        intent.putExtra("username",extras.getString("username"));
        intent.putExtra("email",extras.getString("email"));
        startActivity(intent);
        finish();
    }
}
