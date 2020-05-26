package com.mariana.gottardi.encontrapet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UsuarioDAO {

    private SQLiteDatabase database;
    private BaseDAO dbHelper;

    public UsuarioDAO(Context context) {
        dbHelper = new BaseDAO(context);
    }

    public void openDB() {
        database = dbHelper.getWritableDatabase();
    }

    public void closeDB() {
        dbHelper.close();
    }


    public long add(Usuario usuario) {
        ContentValues cv = new ContentValues();

        cv.put(BaseDAO.USUARIO_KEY, usuario.getIdUsuario());
        cv.put(BaseDAO.USUARIO_NOME, usuario.getNome());
        cv.put(BaseDAO.USUARIO_NOMEPET, usuario.getNomePet());
        cv.put(BaseDAO.USUARIO_RACAPET, usuario.getRacaPet());

        return database.insert(BaseDAO.TBL_USUARIO, null, cv);
    }

    public long update(Usuario usuario) {

        Long id = usuario.getIdUsuario();

        ContentValues cv = new ContentValues();
        cv.put(BaseDAO.USUARIO_NOME, usuario.getNome());
        cv.put(BaseDAO.USUARIO_NOMEPET, usuario.getNomePet());
        cv.put(BaseDAO.USUARIO_RACAPET, usuario.getRacaPet());

        return database.update(
                BaseDAO.TBL_USUARIO,
                cv,
                BaseDAO.USUARIO_KEY + "=?",
                new String[]{String.valueOf(id)});
    }

    public int remove(Usuario usuario) {

        Long id = usuario.getIdUsuario();

        return database.delete(
                BaseDAO.TBL_USUARIO,
                BaseDAO.USUARIO_KEY + "=?",
                new String[]{String.valueOf(id)});
    }

    public ArrayList<Usuario> query() {

        ArrayList<Usuario> prodAux = new ArrayList<>();

        /* Consulta para trazer todos os dados de todas as
         *  colunas da tabela produto ordenados pelo nome */
        Cursor cursor = database.query(
                BaseDAO.TBL_USUARIO,
                BaseDAO.TBL_USUARIO_COLUNAS,
                null,
                null,
                null,
                null,
                BaseDAO.USUARIO_NOME); //order by

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Usuario p = new Usuario();
            p.setIdUsuario(cursor.getLong(0));
            p.setNome(cursor.getString(1));
            p.setNomePet(cursor.getString(2));
            p.setRacaPet(cursor.getString(3));
            cursor.moveToNext();
            prodAux.add(p);
        }
        cursor.close();
        return prodAux;
    }
}
