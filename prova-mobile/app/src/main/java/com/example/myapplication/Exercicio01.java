package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Exercicio01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercicio01);

        //Declarando as variáveis
        EditText editTextNumber = findViewById(R.id.editTextNumber);
        Button btnCheckAge = findViewById(R.id.buttonAge);

        //Evento de clique do botão
        btnCheckAge.setOnClickListener(v -> {

            //Obtendo o valor do EditText
            String input = editTextNumber.getText().toString();

            //Verificando se o valor é vazio
            if (input.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Digite sua idade!", Toast.LENGTH_SHORT).show();
            }

            //Verificando se o valor é maior ou menor de idade
            if (Integer.parseInt(input) >= 18){
                Toast.makeText(getApplicationContext(), "Você é maior de idade!", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Você é menor de idade!", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}