package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class Aula03Activity extends AppCompatActivity {

    private List<CheckBox> checkBoxList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_aula03);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        TextView textViewMensagem = findViewById(R.id.textViewMensagem);
//        textViewMensagem.setText("Novo texto exibido!");
//
//        EditText editText = findViewById(R.id.editTextNome);
//        editText.setHint("Digite o seu nome: ");

        Button buttonEviar = findViewById(R.id.buttonEnviar);
        buttonEviar.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Botão pressionado!", Toast.LENGTH_SHORT).show();
        });

        ImageView imageViewLogo = findViewById(R.id.imageViewLogo);
        imageViewLogo.setImageResource(R.drawable.ic_launcher_foreground);

        CheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(getApplicationContext(), "Opção selecionada!", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Opção desmarcada!", Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayout checkBoxContainer = findViewById(R.id.checkBoxContainer);
        Button btnCheck = findViewById(R.id.btnCheck);
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3", "Opção 4", "Opção 5"};
        for (String opcao : opcoes)
        {
            CheckBox checkBox2 = new CheckBox(this);
            checkBox2.setText(opcao);
            checkBoxContainer.addView(checkBox2);
            checkBoxList.add(checkBox2);
        }
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder selecionados = new StringBuilder("Selecionado: ");
                for (CheckBox checkBox : checkBoxList) {
                    if (checkBox.isChecked()) {
                        selecionados.append(checkBox.getText()).append(", ");
                    }
                }
                if (selecionados.toString().equals("Selecionado: ")) {
                    selecionados = new StringBuilder("Nenhuma opção selecionada!");
                }
                else {
                    selecionados.setLength(selecionados.length() - 2);
                }
                Toast.makeText(getApplicationContext(), selecionados.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        Spinner spinner = findViewById(R.id.spinner);
        Button btnSpinner = findViewById(R.id.btnSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.opcoes_spinner, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btnSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String opcaoSelecionada = spinner.getSelectedItem().toString();
                Toast.makeText(Aula03Activity.this, "Selecionado: " +
                        opcaoSelecionada, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ClickBotao(View view){
        EditText editText = findViewById(R.id.editTextNome);
        Toast.makeText(this, "Seu nome é: " + editText.getText(), Toast.LENGTH_SHORT).show();
    }

    public void checkRadios(View view){
        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        int selectedId = radioGroup.getCheckedRadioButtonId();

        if(selectedId == -1){
            Toast.makeText(Aula03Activity.this,
                    "Selecione uma opção!", Toast.LENGTH_SHORT).show();
        }
        else {
            RadioButton selectedRadioButton = findViewById(selectedId);
            String selectedText = selectedRadioButton.getText().toString();

            Toast.makeText(Aula03Activity.this,
                    "Selecionado: " + selectedText, Toast.LENGTH_SHORT).show();
        }
    }
}