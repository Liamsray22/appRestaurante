package com.example.apprestaurante.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table ordenes(id integer primary key autoincrement, name text, price text, descripcion text, imagen integer);");
        db.execSQL("Create table comidas(id integer primary key autoincrement, nombre text, precio text, descripcion text, imagen integer);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists comidas");
        db.execSQL("Drop table if exists ordenes");

        onCreate(db);

    }

    public Cursor traerTodoComidasPedidas(SQLiteDatabase db){
        Cursor c = db.rawQuery("Select * from comidas", null);
        if(c.moveToFirst()){
            return c;
        }
        return null;
    }
    public Cursor traerTodoOrdenes(SQLiteDatabase db){
        Cursor c = db.rawQuery("Select * from ordenes", null);
        if(c.moveToFirst()){
            return c;
        }
        return null;
    }

    public void OrdenarComida(SQLiteDatabase db, String FoodName, String FoodPrice, String FoodDesc, int FoodImage) {
        db.execSQL("Insert into comidas (nombre, precio, descripcion,  imagen) values ('"+FoodName+"', '"+FoodPrice+"', '"+FoodDesc+"', '"+FoodImage+"')");
    }

    public void CrearOrden(SQLiteDatabase db, String FoodName, String FoodPrice, String FoodDesc, int FoodImage) {
        db.execSQL("Insert into ordenes (name, price, descripcion,  imagen) values ('"+FoodName+"', '"+FoodPrice+"', '"+FoodDesc+"', '"+FoodImage+"')");
    }

    public void EditarComidas(SQLiteDatabase db, int id, String FoodName, String FoodPrice, String FoodDesc, int FoodImage) {
        db.execSQL("Update ordenes set name = '"+FoodName+"', price = '"+FoodPrice+"', descripcion = '"+FoodDesc+"',  imagen = '"+FoodImage+"' where id = '"+id+"'");
    }

    public void EliminarComidas(SQLiteDatabase db, int id) {
        db.execSQL("Delete from ordenes where id = '"+id+"'");
    }
}
