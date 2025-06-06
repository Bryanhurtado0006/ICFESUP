package com.example.icfes_up.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "usuarios.db";
    public static final int DB_VERSION = 2; // Si ya tenías 1, sube a 2 para que onUpgrade se active

    public static final String TABLE_USUARIOS = "usuarios";
    public static final String COL_ID = "id";
    public static final String COL_CORREO = "correo";
    public static final String COL_CONTRASENA = "contrasena";  // Sin ñ aquí

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear tabla usuarios
        String sql = "CREATE TABLE " + TABLE_USUARIOS + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_CORREO + " TEXT NOT NULL UNIQUE, " +  // UNIQUE para que no se repita correo
                COL_CONTRASENA + " TEXT NOT NULL)";
        db.execSQL(sql);

        // Insertar datos precargados
        db.execSQL("INSERT INTO " + TABLE_USUARIOS + " (" + COL_CORREO + ", " + COL_CONTRASENA + ") VALUES ('prueba@gmail.com', '12345678');");
        db.execSQL("INSERT INTO " + TABLE_USUARIOS + " (" + COL_CORREO + ", " + COL_CONTRASENA + ") VALUES ('usuario2@gmail.com', '12345678');");
        // Puedes agregar más usuarios aquí si quieres
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Si actualizas versión borra tabla y crea otra
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIOS);
        onCreate(db);
    }

    // Método para validar usuario en base de datos
    public boolean validarUsuario(String correo, String contrasena) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABLE_USUARIOS + " WHERE " + COL_CORREO + " = ? AND " + COL_CONTRASENA + " = ?",
                new String[]{correo, contrasena}
        );
        boolean existe = cursor.getCount() > 0;
        cursor.close();
        return existe;
    }
}
