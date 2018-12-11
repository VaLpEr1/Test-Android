package com.valper.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button btn;
    float num;
    Button floatingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClick();
    }

    public void btnClick(){
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        btn = findViewById(R.id.btn_convert);
        floatingBtn = findViewById(R.id.floatingBtn);

        floatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.valper.myapplication.LoginPageActivity");
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (!text.matches("")) {
                    num = Float.parseFloat(editText.getText().toString());
                    num *= 1.61;
                    textView.setText(Float.toString(num) + " км");
                    btn.setText("Готово");
                    btn.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Хотите умножить число на 2");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            num *= 2f;
                            textView.setText(Float.toString(num) + " км");
                        }
                    });
                    builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    AlertDialog alert = builder.create();
                    alert.show();

                } else {
                    Toast.makeText(MainActivity.this, "Введите число",
                            Toast.LENGTH_LONG).show();
                    btn.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                }
            }
        });
        }
    }
