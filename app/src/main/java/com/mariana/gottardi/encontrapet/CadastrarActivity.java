package com.mariana.gottardi.encontrapet;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastrarActivity extends AppCompatActivity {


    private EditText etNomeDono;
    private EditText etNomePet;
    private EditText etNomeRaca;

    private Button btnRegistrar;
    private Button btnLimpar;
    private Button btProcurar;


    //banco
    private UsuarioDAO UDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        setTitle("Cadastro");

        //Refs

        etNomeDono = findViewById(R.id.etNomeDono);
        etNomePet= findViewById(R.id.etNomePet);
        etNomeRaca =findViewById(R.id.etNomeRaca);
        btnRegistrar = findViewById(R.id.bt_registrar);
        btnLimpar = findViewById(R.id.bt_limpar);
        btProcurar = findViewById(R.id.bt_procurar);

        //Criando o BANCO DE DADOS
        UDAO = new UsuarioDAO(CadastrarActivity.this);
        UDAO.openDB();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                  Usuario usuario = new Usuario();

                    if(Validacao.verificarNome(etNomeDono.getText().toString())){
                        usuario.setNome(etNomeDono.getText().toString());
                    }else{
                        throw new Exception("\nNome inválido !");
                    }//fecha if else

                    if(Validacao.verificarNome(etNomePet.getText().toString())){
                        usuario.setNomePet(etNomePet.getText().toString());
                    }else{
                        throw new Exception("\nNome do Pet inválido !");
                    }//fecha if else

                    if(Validacao.verificarNome(etNomeRaca.getText().toString())){
                        usuario.setRacaPet(etNomeRaca.getText().toString());
                    }else{
                        throw new Exception("\nNome da Raça inválido !");
                    }//fecha if else



                    AlertDialog.Builder msg = new AlertDialog.Builder(CadastrarActivity.this);
                    msg.setTitle("Sucesso");
                    msg.setMessage("Cadastro efetuado com sucesso!");
                    msg.setNeutralButton("OK", null);
                    msg.show();

                    //Enviando para o método cadastrar
                    UDAO.add(usuario);
                    limpar();

                }catch(Exception e){

                    AlertDialog.Builder msg = new AlertDialog.Builder(CadastrarActivity.this);
                    msg.setTitle("Erro ao cadastrar");
                    msg.setMessage("Houve o seguinte erro: " + e.getMessage());
                    msg.setNeutralButton("Ok", null);
                    msg.show();

                }//fecha try-catch

            }


        });

        //EXCLUIR

        btnLimpar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                limpar();
            }
        });


        btProcurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String GEO_URI="geo:-25.4089185,-49.3222402";
                Intent mapaIntent =new Intent(Intent.ACTION_VIEW, Uri.parse(GEO_URI));
                startActivity(mapaIntent);
            }
        });

    }//fecha oncreate

    private void limpar(){
        etNomeDono.setText(null);
        etNomePet.setText(null);
        etNomeRaca.setText(null);
    }//fecha limpar

    @Override
    protected void onPause() {
        super.onPause();
        UDAO.closeDB();
    }

    @Override
    protected void onResume() {
        super.onResume();
        UDAO.openDB();
    }

}