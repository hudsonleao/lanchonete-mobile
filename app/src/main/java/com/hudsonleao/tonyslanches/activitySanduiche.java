package com.hudsonleao.tonyslanches;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class activitySanduiche extends AppCompatActivity {
    int[] imagens = {R.drawable.tudo, R.drawable.tudo, R.drawable.tudo, R.drawable.tudo, R.drawable.tudo, R.drawable.tudo, R.drawable.tudo, R.drawable.tudo, R.drawable.tudo, R.drawable.tudo, R.drawable.tudo, R.drawable.tudo, R.drawable.tudo};

    public static String[] sabor = {"HAMBÚRGUER", "X-BURGUER", "X-EGG", "X-BACON", "X-EGG-BACON", "ESPECIAL", "X-FRANGO", "X-SALADA", "X-LOMBO", "X-BAURU", "X-MILHO", "X-TUDO", "MISTO"};

    String[] ingredientes = {"Pão, bife, tomate, alface, maionese", "Pão, bife, queijo, tomate, alface, maionese", "Pão, bife, queijo, ovo, tomate, alface, maionese", "Pão, bife, bacon, queijo, tomate, alface, maionese",
    "Pão, bife, ovo, bacon, queijo, tomate, alface, maionese", "Pão, bife, ovo, presunto, queijo, alface, barbecue", "Pão, frango, queijo, tomate, alface, maionese", "Pão integral, frango, tomate, alface, maionese",
    "Pão, lombo, queijo, alface, tomate, abacaxi, milho, maionese", "Pão de forma, bife, queijo, presunto, alface, maionese", "Pão, bife, milho, queijo, tomate, alface, batata, maionese", "Pão, bife, bacon, frango, ovo, queijo, milho, batata, tomate, alface, maionese",
    "Pão de forma, queijo, presunto, alface, maionese"};

    public static String[] valor = {"5.50", "6.00", "6.50", "8.50", "9.00", "6.50", "8.50", "8.50", "8.00", "5.50", "6.00", "10.50", "4.20"};


    ListView lView;
    ListAdapter lAdapter;
    private ImageButton pedidos;
    private static final String ARQUIVOS_PREFERENCES = "ARQUIVO_PREFERENCES_APP01";
    public static double soma = 0;
    public static String total="";
    public List<String> lista = new ArrayList<String>();
    public static List<String> listavalor = new ArrayList<String>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanduiche);
        pedidos = (ImageButton) findViewById(R.id.pedidos);

        lView = (ListView) findViewById(R.id.androidList);

        lAdapter = new ListAdapter(activitySanduiche.this, sabor, ingredientes, valor, imagens);

        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVOS_PREFERENCES, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                    total+=sabor[i]+"\n";

                    double valorDouble = Double.valueOf(valor[i]);
                    soma+=valorDouble;
                    String somaString = String.valueOf(soma);
                    listavalor.add(somaString);

                Intent intent = new Intent(activitySanduiche.this, activityFinalizarPedido.class);
                editor.putString("Sanduiche", String.valueOf(total));
                editor.putString("Valor", NumberFormat.getCurrencyInstance().format(soma));
                editor.commit();
                startActivity(intent);

            }
        });
        pedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activitySanduiche.this, activityFinalizarPedido.class);
                startActivity(intent);
            }
        });
    }
}