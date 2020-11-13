package com.example.organizerapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.organizerapp.R;

import org.w3c.dom.Text;

public class AddCardsActivity extends AppCompatActivity {
Context context;
    String createCardDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cards);
        context = getApplicationContext();
        final TextView startAtText = findViewById(R.id.insertStartAt);
        final TextView endAtText = findViewById(R.id.insertEndAt);
        final TextView text = findViewById(R.id.insertText);

        Button dismisButton = findViewById(R.id.dismisButton);
        Bundle bundle = getIntent().getExtras();

        if(bundle!= null){

             createCardDate = bundle.getString("createDate");
            Toast.makeText(context, createCardDate, Toast.LENGTH_SHORT).show();
        }
        dismisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });

        Button acceptButton = findViewById(R.id.acceptButton);
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, MainActivity.class);
                intent.putExtra("createDate",createCardDate );
                intent.putExtra("startAt",startAtText.getText().toString());
                intent.putExtra("endAt",endAtText.getText().toString());
                intent.putExtra("text",text.getText().toString());
                startActivity(intent);

            }
        });
        }


    }
