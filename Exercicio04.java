package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class Exercicio04 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercicio04);

        LinearLayout containerCheckBoxes = findViewById(R.id.containerCheckBoxes);
        EditText name = findViewById(R.id.editTextNome);
        Button btnGerar = findViewById(R.id.btnGerar);

        btnGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                containerCheckBoxes.removeAllViews();

                String nome = name.getText().toString().trim();

                if (nome.isEmpty()) {
                    name.setError("Digite um nome!");
                }

                for (char letra : nome.toCharArray()) {
                    CheckBox checkBox = new CheckBox(Exercicio04.this);

                    checkBox.setText(String.valueOf(letra));

                    containerCheckBoxes.addView(checkBox);
                }

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}