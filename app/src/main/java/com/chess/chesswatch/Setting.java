package com.chess.chesswatch;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Setting extends AppCompatActivity {

    private ImageButton ButtonChecking,Buttonfeedback;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ButtonChecking=findViewById(R.id.checking);
        Buttonfeedback=findViewById(R.id.feedback);
        context=this;

        ButtonChecking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checking=new Intent(context,Checkmenu.class);
                context.startActivity(checking);

            }
        });

        Buttonfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checking=new Intent(context,Entertime.class);
                context.startActivity(checking);

            }
        });
    }
}
