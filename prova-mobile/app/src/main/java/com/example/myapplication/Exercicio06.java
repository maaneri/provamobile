package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Exercicio06 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercicio06);

        //Declarando os botões
        Button btnExercicio01 = findViewById(R.id.button1);
        Button btnExercicio02 = findViewById(R.id.button2);
        Button btnExercicio03 = findViewById(R.id.button3);
        Button btnExercicio04 = findViewById(R.id.button4);
        Button btnExercicio05 = findViewById(R.id.button5);

        //Navegando entre as telas
        btnExercicio01.setOnClickListener(v -> {startActivity(new Intent(this, Exercicio01.class));});
        btnExercicio02.setOnClickListener(v -> {startActivity(new Intent(this, Exercicio02.class));});
        btnExercicio03.setOnClickListener(v -> {startActivity(new Intent(this, Exercicio03.class));});
        btnExercicio04.setOnClickListener(v -> {startActivity(new Intent(this, Exercicio04.class));});
        btnExercicio05.setOnClickListener(v -> {startActivity(new Intent(this, Exercicio05.class));});

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}