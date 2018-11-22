package com.example.albert.lesson2toast;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText pass;
    private Button btn,btn_alert, act_change;
    private RatingBar rating;
    private TextView text_show;

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
        btn_alert = (Button)findViewById(R.id.alert);
        act_change = (Button)findViewById(R.id.act_change);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(View v) {
                        //При нажатие кнопки, кнопка изменится на красный с надписью Done
                        // НЕ заработал на моем смартфоне
                        btn.setText("Done");
                        //btn.setBackground(getColor(android.R.color.holo_red_dark));
                        Toast.makeText( MainActivity.this, pass.getText(), Toast.LENGTH_SHORT).show();
                    }
                }
        );

        //Переход след-му страницу
        act_change.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(".SecondActivity");
                        startActivity(intent);
                    }
                }
        );
//      Рейтинг бар
//        rating = (RatingBar)findViewById(R.id.ratingBar);
//        text_show = (TextView)findViewById(R.id.textView);
//
//        rating.setOnRatingBarChangeListener(
//                new RatingBar.OnRatingBarChangeListener() {
//                    @Override
//                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//                        text_show.setText("Значение " + String.valueOf(rating));
//                    }
//                }
//        );


        btn_alert.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //При нажатие кнопки, кнопка изменится на красный с надписью Done
                        // НЕ заработал на моем смартфоне
//                        Toast.makeText( MainActivity.this, "Мы все поменяли", Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                        a_builder.setMessage("Вы хотите выйти ?")
                                .setCancelable(false)
                                .setPositiveButton("Да" , new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick (DialogInterface dialog, int which){
                                        finish();
                                    }
                                })
                                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick (DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Закрытие приложения");
                        alert.show();

                    }
                }
        );
    }
}
