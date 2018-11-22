package com.example.albert.lesson2toast;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText pass;
    private Button btn,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenOnButton();
    }


    //Эту функцию вызваем внутри OnCreate и он автоматический реагирует на нажатия кнопки
    public void addListenOnButton (){
        pass = (EditText)findViewById(R.id.editText);
        btn = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(View v) {
                        //При нажатие кнопки, кнопка изменится на красный с надписью Done
                        // НЕ заработал на моем смартфоне
                        btn.setText("Done");
                        btn.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        Toast.makeText( MainActivity.this, pass.getText(), Toast.LENGTH_SHORT).show();
                    }
                }
        );


        btn2.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(View v) {
                        //При нажатие кнопки, кнопка изменится на красный с надписью Done
                        // НЕ заработал на моем смартфоне
                        btn.setText("Done");
                        btn.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
                        Toast.makeText( MainActivity.this, "Мы все поменяли", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
