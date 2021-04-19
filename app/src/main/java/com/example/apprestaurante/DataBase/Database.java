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
        db.execSQL("Create table usuarios(id integer primary key autoincrement, nombreApellido text, telefono text, correo text, clave text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists comidas");
        db.execSQL("Drop table if exists ordenes");
        db.execSQL("Drop table if exists usuarios");

        onCreate(db);

    }

    public Cursor traerTodoComidasPedidas(SQLiteDatabase db) {
        Cursor c = db.rawQuery("Select * from comidas", null);
        if (c.moveToFirst()) {
            return c;
        }
        return null;
    }

    public Cursor traerTodoOrdenes(SQLiteDatabase db) {
        Cursor c = db.rawQuery("Select * from ordenes", null);
        if (c.moveToFirst()) {
            return c;
        }
        return null;
    }

    public void CrearUsuarios(SQLiteDatabase db, String nombreApellido, String telefono, String correo, String clave) {
        db.execSQL("Insert into usuarios (nombreApellido, telefono, correo, clave) values ('" + nombreApellido + "', '" + telefono + "', '" + correo + "', '" + clave + "')");
    }

    public void OrdenarComida(SQLiteDatabase db, String FoodName, String FoodPrice, String FoodDesc, int FoodImage) {
        db.execSQL("Insert into comidas (nombre, precio, descripcion,  imagen) values ('" + FoodName + "', '" + FoodPrice + "', '" + FoodDesc + "', '" + FoodImage + "')");
    }

    public void CrearOrden(SQLiteDatabase db, String FoodName, String FoodPrice, String FoodDesc, int FoodImage) {
        db.execSQL("Insert into ordenes (name, price, descripcion,  imagen) values ('" + FoodName + "', '" + FoodPrice + "', '" + FoodDesc + "', '" + FoodImage + "')");
    }

    public void EditarComidas(SQLiteDatabase db, int id, String FoodName, String FoodPrice, String FoodDesc, int FoodImage) {
        db.execSQL("Update ordenes set name = '" + FoodName + "', price = '" + FoodPrice + "', descripcion = '" + FoodDesc + "',  imagen = '" + FoodImage + "' where id = '" + id + "'");
    }

    public void EliminarComidas(SQLiteDatabase db, int id) {
        db.execSQL("Delete from ordenes where id = '" + id + "'");
    }

    public boolean revisarClave(String clave, String clave2) {
        if(clave.equals(clave2)){
            return true;
        }
        return false;
    }
}