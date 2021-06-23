package com.example.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmDelete extends AppCompatActivity {

    TextView victim;
    Button btnNo;
    Button btnYes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_delete);

        victim = findViewById(R.id.victim);
        btnNo = findViewById(R.id.btnNo);
        btnYes = findViewById(R.id.btnYes);

        getSupportActionBar().setTitle("Confirm delete");

        victim.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}