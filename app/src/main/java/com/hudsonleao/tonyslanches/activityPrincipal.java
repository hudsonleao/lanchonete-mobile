package com.hudsonleao.tonyslanches;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class activityPrincipal extends AppCompatActivity {
    private Button BotaoLogin;
    private Button Cadastrar;
    private EditText Login;
    private EditText Senha;
    private static final String ARQUIVOS_PREFERENCES = "ARQUIVO_PREFERENCES_APP01";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Login = (EditText) findViewById(R.id.Login);
        Senha = (EditText) findViewById(R.id.Senhas);
        BotaoLogin = (Button) findViewById(R.id.BotaoLogin);
        Cadastrar = (Button) findViewById(R.id.Cadastrar);


        BotaoLogin.setOnClickListener(new View.OnClickListener() {
            SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVOS_PREFERENCES, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            @Override
            public void onClick(View v) {

                if (Login.getText().toString().isEmpty()) {
                    mostrarToast("Digite o usuário");
                    return;
                }
                if (Senha.getText().toString().isEmpty() ) {
                    mostrarToast("Digite a senha");
                    return;
                }

                    if (Login.getText().toString().equals("Admin") && Senha.getText().toString().equals("admin")) {
                        Intent intent = new Intent(activityPrincipal.this, activityMenu.class);
                        editor.putString("pknome", Login.getText().toString());
                        editor.commit();
                        startActivity(intent);
                        activityPrincipal.this.finish();
                    }
                    else {
                        mostrarToast("Usuário ou senha incorreto.");
                        return;
                    }
            }

            public void mostrarToast(String msg) {
                Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activityPrincipal.this, activityCadastro.class);
                startActivity(intent);
            }
        });
    }
}
