package com.example.myapplication;

import android.os.Bundle; //salva informações da aplicação
import android.util.Log; //importa a classe Log para ser usado

import androidx.activity.EdgeToEdge; //permite que a interface ocupe toda a tela
import androidx.appcompat.app.AppCompatActivity; //
import androidx.core.graphics.Insets; //representa espaços reservados para elementos específicos
import androidx.core.view.ViewCompat; //compatibilidade de telas
import androidx.core.view.WindowInsetsCompat; //Evita sobreposições de elementos do sistema

public class MainActivity extends AppCompatActivity {

    int mCurrentLevel = 0;
    int mCurrentScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("CicloDeVida", "onCreate() chmando");

        // Verifica se estamos recriando uma instancia que foi destruída
        if (savedInstanceState != null){
            mCurrentScore = savedInstanceState.getInt(STATE_SCORE);
            mCurrentLevel = savedInstanceState.getInt(STATE_LEVEL);
        }

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("CicloDeVida", "onStart() chamado");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("CicloDeVida", "onRestart() chamado");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("CicloDeVida", "onResume() chamado");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("CicloDeVida", "onPause() chamado");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("CicloDeVida", "onStop() chamado");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("CicloDeVida", "onDestroy() chamado");
    }

    static final String STATE_SCORE = "playerScore";
    static final String STATE_LEVEL = "playerLevel";
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(STATE_SCORE, mCurrentScore); // Salva o estado atual do jogador
        savedInstanceState.putInt(STATE_LEVEL, mCurrentLevel); // Invoca a super classe, para que seja possível salvar o estado
        super.onSaveInstanceState(savedInstanceState);
    }
}