package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Exercicio05 extends AppCompatActivity {

    private CheckBox checkNotificacoes, checkModoEscuro, checkLembrarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercicio05);

        checkNotificacoes = findViewById(R.id.checkNotificacoes);
        checkModoEscuro = findViewById(R.id.checkModoEscuro);
        checkLembrarLogin = findViewById(R.id.checkLembrarLogin);
        Button btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder preferencias = new StringBuilder();

                if (checkNotificacoes.isChecked()) {
                    preferencias.append("Receber notificações\n");
                }
                if (checkModoEscuro.isChecked()) {
                    preferencias.append("Modo escuro\n");
                }
                if (checkLembrarLogin.isChecked()) {
                    preferencias.append("Lembrar login\n");
                }

                String mensagem = preferencias.length() > 0 ? preferencias.toString() : "Nenhuma preferência foi escolhida";

                Toast.makeText(Exercicio05.this, mensagem, Toast.LENGTH_LONG).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}