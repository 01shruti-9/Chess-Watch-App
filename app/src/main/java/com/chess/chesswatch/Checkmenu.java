package com.chess.chesswatch;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class Checkmenu extends AppCompatActivity {

    CheckBox cb1,cb2,cb3,cb4,cb5;
    int count = 0;
    TextView rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkmenu);

        cb1=(CheckBox)findViewById(R.id.checkBox2);
        cb2=(CheckBox)findViewById(R.id.checkBox5);
        cb3=(CheckBox)findViewById(R.id.checkBox);
        cb4=(CheckBox)findViewById(R.id.checkBox4);
        cb5=(CheckBox)findViewById(R.id.checkBox3);
        rec = (TextView) findViewById(R.id.textView4);

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNot(isChecked);
                rec.setText("     "+count+" Selected ");
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNot(isChecked);
                rec.setText("     "+count+" Selected ");
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNot(isChecked);
                rec.setText("     "+count+" Selected ");
            }
        });
        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNot(isChecked);
                rec.setText("     "+count+" Selected ");
            }
        });
        cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNot(isChecked);
                rec.setText("     "+count+" Selected ");
            }
        });



    }

    private void isCheckedOrNot(boolean isChecked) {
        if (isChecked) {
            count++;
        } else {
            if (count > 0) {
                count--;
            }
        }
    }

}
