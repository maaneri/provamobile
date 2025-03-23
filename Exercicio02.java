package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Exercicio02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercicio02);

        EditText editTextNumber1 = findViewById(R.id.editTextNumber1);
        EditText editTextNumber2 = findViewById(R.id.editTextNumber2);

        Button btnMais = findViewById(R.id.btnMais);
        Button btnMenos = findViewById(R.id.btnMenos);
        Button btnDiv = findViewById(R.id.btnDiv);
        Button btnMulti = findViewById(R.id.btnMulti);

        btnMais.setOnClickListener(v -> {
            String input1 = editTextNumber1.getText().toString();
            String input2 = editTextNumber2.getText().toString();

            if (input1.isEmpty() || input2.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Digite dois números!", Toast.LENGTH_SHORT).show();
            }

            int num1 = Integer.parseInt(input1);
            int num2 = Integer.parseInt(input2);
            int result = num1 + num2;

            Toast.makeText(getApplicationContext(), "Resultado: " + result, Toast.LENGTH_SHORT).show();
        });

        btnMenos.setOnClickListener(v -> {
            String input1 = editTextNumber1.getText().toString();
            String input2 = editTextNumber2.getText().toString();

            if (input1.isEmpty() || input2.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Digite dois números!", Toast.LENGTH_SHORT).show();
            }

            int num1 = Integer.parseInt(input1);
            int num2 = Integer.parseInt(input2);
            int result = num1 - num2;

            Toast.makeText(getApplicationContext(), "Resultado: " + result, Toast.LENGTH_SHORT).show();
        });

        btnDiv.setOnClickListener(v -> {
            String input1 = editTextNumber1.getText().toString();
            String input2 = editTextNumber2.getText().toString();

            if (input1.isEmpty() || input2.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Digite dois números!", Toast.LENGTH_SHORT).show();
            }

            int num1 = Integer.parseInt(input1);
            int num2 = Integer.parseInt(input2);
            int result = num1 / num2;

            Toast.makeText(getApplicationContext(), "Resultado: " + result, Toast.LENGTH_SHORT).show();
        });

        btnMulti.setOnClickListener(v -> {
            String input1 = editTextNumber1.getText().toString();
            String input2 = editTextNumber2.getText().toString();

            if (input1.isEmpty() || input2.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Digite dois números!", Toast.LENGTH_SHORT).show();
            }

            int num1 = Integer.parseInt(input1);
            int num2 = Integer.parseInt(input2);
            int result = num1 * num2;

            Toast.makeText(getApplicationContext(), "Resultado: " + result, Toast.LENGTH_SHORT).show();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}