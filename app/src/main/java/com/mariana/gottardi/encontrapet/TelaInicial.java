package com.mariana.gottardi.encontrapet;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaInicial extends AppCompatActivity {

    Button bt_cadastrar, bt_procurar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        setTitle("Encontra Pet");


        bt_cadastrar = (Button) findViewById(R.id.bt_cadastrar);
        bt_procurar = (Button) findViewById(R.id.bt_procurar);

        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaInicial.this, CadastrarActivity.class);
                startActivity(i);
            }
        });

    }
}

