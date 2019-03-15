package com.hudsonleao.tonyslanches;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.NumberFormat;

import static com.hudsonleao.tonyslanches.activitySanduiche.soma;

public class activityMenu extends AppCompatActivity {
    private Button BotaoPedido;
    private Button BotaoConsultar;
    private Button BotaoGarcom;
    private Button BotaoHistorico;
    private ImageButton BotaoPrato;
    private TextView tvBoasVindas;
    private static final String ARQUIVOS_PREFERENCES = "ARQUIVO_PREFERENCES_APP01";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        BotaoPedido = (Button) findViewById(R.id.BotaoPedido);
        BotaoGarcom = (Button) findViewById(R.id.BotaoGarcom);
        BotaoConsultar = (Button) findViewById(R.id.BotaoConsultar);
        BotaoHistorico = (Button) findViewById(R.id.BotaoHistorico);
        BotaoPrato = (ImageButton) findViewById(R.id.botaoPrato);
        tvBoasVindas = (TextView) findViewById(R.id.tvBoasVindas);

            SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVOS_PREFERENCES, MODE_PRIVATE);
            if (sharedPreferences.contains("pknome")) {
                String nome = sharedPreferences.getString("pknome", "[Nome não informado]");
                tvBoasVindas.setText(nome);
            } else {
                Intent intent = new Intent(activityMenu.this, activityPrincipal.class);
                startActivity(intent);
            }

        BotaoPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activityMenu.this, activitySanduiche.class);
                startActivity(intent);
            }
        });
        BotaoConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activityMenu.this, activityConsultar.class);
                startActivity(intent);
            }
        });
        BotaoGarcom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activityMenu.this, activityGarcom.class);
                startActivity(intent);
            }
        });
        BotaoHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activityMenu.this, activityHistorico.class);
                startActivity(intent);
            }
        });
        BotaoPrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVOS_PREFERENCES, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                activitySanduiche.total+="X-FRANGO (PROMOÇÃO)\n";

                double valorDouble = Double.valueOf("4.50");
                soma+=valorDouble;

                Intent intent = new Intent(activityMenu.this, activityFinalizarPedido.class);
                editor.putString("Sanduiche", String.valueOf(activitySanduiche.total));
                editor.putString("Valor", NumberFormat.getCurrencyInstance().format(soma));
                editor.commit();

                startActivity(intent);
            }
        });
    }
}
