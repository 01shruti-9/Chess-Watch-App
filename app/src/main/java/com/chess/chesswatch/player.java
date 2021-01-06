package com.chess.chesswatch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class player extends AppCompatActivity {


  Button bt1;
  EditText SendValue,SendValue2;
  Context context;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_player);


    bt1 = findViewById(R.id.bt1);
    SendValue = (EditText)findViewById(R.id.wp7);
    SendValue2 = (EditText)findViewById(R.id.bp7);


    bt1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {


        Intent intent = new Intent(getApplicationContext(),Try.class);
        intent.putExtra("EdiTtEXTvALUE", SendValue.getText().toString());
        intent.putExtra("EdiTtEXTvALUE2", SendValue2.getText().toString());
        startActivity(intent);


      }
    });



  }
}
