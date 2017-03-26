package com.example.alejandroguma.barbosa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class iglesiactivity extends AppCompatActivity {
    Button bAtrasigle;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iglesiactivity);

        bAtrasigle=(Button)findViewById(R.id.bAtrasigle);
        extras= getIntent().getExtras();
        bAtrasigle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(iglesiactivity.this,drawerMainActivity.class);
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
        Intent intent =new Intent(iglesiactivity.this,drawerMainActivity.class);
        intent.putExtra("username",extras.getString("username"));
        intent.putExtra("email",extras.getString("email"));
        startActivity(intent);
        finish();
    }
}
