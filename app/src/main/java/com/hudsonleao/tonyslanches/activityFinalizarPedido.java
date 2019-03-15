package com.hudsonleao.tonyslanches;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.RadioAccessSpecifier;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class activityFinalizarPedido extends AppCompatActivity {

    private TextView tvProduto;
    private TextView tvValor;
    private Button botaoLimpar;
    private Button finalizar;
    private RadioButton MPago;
    private RadioButton Dinheiro;
    private RadioButton Cartao;
    private RadioGroup Pagamento;

    private static final String ARQUIVOS_PREFERENCES = "ARQUIVO_PREFERENCES_APP01";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizar_pedido);

        tvProduto = (TextView) findViewById(R.id.Produto);
        tvValor = (TextView) findViewById(R.id.Valor);
        botaoLimpar = (Button) findViewById(R.id.botaoLimpar);
        MPago = (RadioButton) findViewById(R.id.MercadoPago);
        Dinheiro = (RadioButton) findViewById(R.id.Dinheiro);
        Cartao = (RadioButton) findViewById(R.id.Cartao);
        Pagamento = (RadioGroup) findViewById(R.id.Pagamento);
        finalizar = (Button) findViewById(R.id.finalizar);
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVOS_PREFERENCES, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final String sanduiche = sharedPreferences.getString("Sanduiche", "[Sanduiche não informado]");
        if(sharedPreferences.contains("Sanduiche")) {
            tvProduto.setText("Produtos:\n" + sanduiche);
        }

        if(sharedPreferences.contains("Valor")) {
            String valor = sharedPreferences.getString("Valor", "[Valor não informado]");
            tvValor.setText("Valor total: " +valor);

        }

        Pagamento.check(R.id.Cartao);

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activityFinalizarPedido.this, activityConsultar.class);
                switch (Pagamento.getCheckedRadioButtonId()) {
                    case R.id.Dinheiro:
                        editor.putString("Pedido", String.valueOf(sanduiche));
                        editor.putString("Pagamento", "Dinheiro");
                        editor.putString("Numero", "45544");
                        editor.commit();
                        startActivity(intent);
                        break;
                    case R.id.Cartao:
                        editor.putString("Pedido", String.valueOf(sanduiche));
                        editor.putString("Pagamento", "Cartão de Crédito");
                        editor.putString("Numero", "45545");
                        editor.commit();
                        startActivity(intent);
                        break;
                    case R.id.MercadoPago:
                        editor.putString("Pedido", String.valueOf(sanduiche));
                        editor.putString("Pagamento", "Mercado Pago");
                        editor.putString("Numero", "45546");
                        editor.commit();
                        startActivity(intent);
                        break;
                }
            }
        });

        botaoLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(activityFinalizarPedido.this, activityFinalizarPedido.class);
                activitySanduiche.total="";
                activitySanduiche.soma=0.00;
                editor.remove("Sanduiche");
                editor.remove("Valor");
                editor.commit();
                startActivity(intent);
                activityFinalizarPedido.this.finish();

            }
            public void mostrarToast(String msg) {
                Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

}
