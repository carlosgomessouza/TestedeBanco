package br.com.etecia.bancodedados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


//classe ussando extends para SQLhelper, com apenas contexto de parametro
public class Sanguedb extends SQLiteOpenHelper {
    public Sanguedb(@Nullable Context context) {
        super(context, "ClienteDB", null, 1);
    }

    //onCreat, metodo para criar a tabela, recebendo como parametro SQLdata
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table tbcliente(email text primary key, senha text, tipoDeSangue text)");
    }


    //onUpgrade, serve para apagar o banco e criar outro, caso autalize a versão
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists tbcliente");
    }

    //inserindo valores na tabela, com contentValues, this é usado para se referir a classe
    //put serve para inserir os nomes da colunas e os nomes do parametro

    public boolean inserir (String email, String senha, String tipoDesangue){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put("email", email);
        valores.put("senha", senha);
        valores.put("tipoDesangue", tipoDesangue);

        long inserido = db.insert("tbcliente", null, valores);

        if (inserido == 1){

            return false;

        }else{

            return true;

        }



    }

    //metodo para fazer select, usando email como chave
    //cursor serve para seguir pela tabela

    public boolean selectEmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from tbcliente where email = ?", new String[]{email});

        if(cursor.getCount()> 0){

           return true;

        }else {

            return false;
        }


    }

    public boolean checardados ()
}





