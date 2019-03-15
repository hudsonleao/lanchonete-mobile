package com.hudsonleao.tonyslanches;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class activityHistorico extends AppCompatActivity {

    String[] sanduiche = {"HAMBÚRGUER", "X-BURGUER", "X-EGG"};

    String[] data = {"28/09/2018", "15/08/2018", "14/07/2018"};

    String[] valor = {"R$5,50", "R$6,00", "R$6,50"};

    ListView lView;

    listaHistorico lAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);
        lView = (ListView) findViewById(R.id.androidLista);

        lAdapter = new listaHistorico(activityHistorico.this, sanduiche, data, valor);

        lView.setAdapter(lAdapter);
     }
}
