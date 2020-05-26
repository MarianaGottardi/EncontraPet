package com.mariana.gottardi.encontrapet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDAO extends SQLiteOpenHelper {


    //Tabela
    public static final String TBL_USUARIO = "usuario";
    public static final String USUARIO_KEY = "chave";
    public static final String USUARIO_NOME = "nome";
    public static final String USUARIO_NOMEPET = "nomePet";
    public static final String USUARIO_RACAPET = "racaPet";



    /* Colunas da Tabela PRODUTO. São públicos para qualquer classe. */
    public static final String[] TBL_USUARIO_COLUNAS = {
            BaseDAO.USUARIO_KEY,
            BaseDAO.USUARIO_NOME,
            BaseDAO.USUARIO_NOMEPET,
            BaseDAO.USUARIO_RACAPET};

    //Banco + name + version
    public static final String DATABASE_NAME = "encontraPet.sqlite";
    public static final int DATABASE_VERSION = 1;

    //DDL - criação da(s) tabela(s)
    public static final String CREATE_USUARIO =
            "create table "+TBL_USUARIO+"(" +
                    USUARIO_KEY+" text primary key, "+
                    USUARIO_NOME+" text not null, "+
                    USUARIO_NOMEPET+" text not null, "+
                    USUARIO_RACAPET+" text not null);";

    //DDL - exclusão da(s) tabela(s)
    public static final String DROP_USUARIO =
            "drop table if exists " + TBL_USUARIO;

    public BaseDAO(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
