package com.example.apprestaurante.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    String crear = "Create table comidas(id integer primary key autoincrement, nombre text, precio text, descripcion text, imagen integer)";

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(crear);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists comidas");
        db.execSQL(crear);

    }

    public Cursor traerTodo(SQLiteDatabase db){
        Cursor c = db.rawQuery("Select * from comidas", null);
        if(c.moveToFirst()){
            return c;
        }
        return null;
    }

    public void OrdenarComida(SQLiteDatabase db, String FoodName, String FoodPrice, String FoodDesc, int FoodImage) {
        db.execSQL("Insert into comidas (nombre, precio, descripcion,  imagen) values ('"+FoodName+"', '"+FoodPrice+"', '"+FoodDesc+"', '"+FoodImage+"')");
    }
}
