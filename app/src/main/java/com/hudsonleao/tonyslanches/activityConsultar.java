package com.hudsonleao.tonyslanches;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class activityConsultar extends AppCompatActivity {

    private TextView produto;
    private TextView pedido;
    private TextView pagamento;
    private static final String ARQUIVOS_PREFERENCES = "ARQUIVO_PREFERENCES_APP01";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVOS_PREFERENCES, MODE_PRIVATE);

        produto = (TextView) findViewById(R.id.produto);
        pagamento = (TextView) findViewById(R.id.pagamento);
        pedido = (TextView) findViewById(R.id.pedido);
        final String sanduiche = sharedPreferences.getString("Pedido", "Nenhum produto pedido");
        final String pagamentos = sharedPreferences.getString("Pagamento", "-");
        final String numero = sharedPreferences.getString("Numero", "-");


            produto.setText(sanduiche);
            pagamento.setText(pagamentos);
            pedido.setText("Pedido: "+numero);


    }
}
