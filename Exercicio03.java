package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Exercicio03 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercicio03);

        EditText nome = findViewById(R.id.editTextNome);
        EditText idade = findViewById(R.id.editTextAge);
        EditText estado = findViewById(R.id.editTextEstado);
        EditText cidade = findViewById(R.id.editTextCidade);
        EditText telefone = findViewById(R.id.editTextPhone);
        EditText email = findViewById(R.id.editTextEmail);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        CheckBox checkRed = findViewById(R.id.check_red);
        CheckBox checkOrange = findViewById(R.id.check_orange);
        CheckBox checkYellow = findViewById(R.id.check_yellow);
        CheckBox checkGreen = findViewById(R.id.check_green);
        CheckBox checkBlue = findViewById(R.id.check_blue);
        CheckBox checkIndigo = findViewById(R.id.check_indigo);
        CheckBox checkViolet = findViewById(R.id.check_violet);

        Button btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(v -> {

            if (nome.getText().toString().trim().isEmpty() ||
                    idade.getText().toString().trim().isEmpty() ||
                    estado.getText().toString().trim().isEmpty() ||
                    cidade.getText().toString().trim().isEmpty() ||
                    telefone.getText().toString().trim().isEmpty() ||
                    email.getText().toString().trim().isEmpty()) {

                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            }
            else if (radioGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Selecione um tamanho!", Toast.LENGTH_SHORT).show();
            }
            else if (!checkRed.isChecked() && !checkOrange.isChecked() &&
                    !checkYellow.isChecked() && !checkGreen.isChecked() &&
                    !checkBlue.isChecked() && !checkIndigo.isChecked() &&
                    !checkViolet.isChecked()) {

                Toast.makeText(this, "Selecione pelo menos uma cor!", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Dados enviados com sucesso!", Toast.LENGTH_SHORT).show();
            }

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}