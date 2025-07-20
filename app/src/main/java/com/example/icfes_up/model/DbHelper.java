package com.example.icfes_up.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "icfes_up.db";
    public static final int DB_VERSION = 2;

    private static DbHelper instance;
    private final SQLiteDatabase database;

    public static DbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DbHelper(context.getApplicationContext());
        }
        return instance;
    }

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE administradores (" +
                "idAdministrador INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT NULL, " +
                "apellido TEXT NOT NULL, " +
                "tipoDeDocumento TEXT NOT NULL, " +
                "numeroIdentidadAdministrador TEXT NOT NULL UNIQUE, " +
                "email TEXT NOT NULL UNIQUE, " +
                "password TEXT NOT NULL, " +
                "direccion TEXT, " +
                "institucion TEXT NOT NULL)");

        db.execSQL("CREATE TABLE usuarios (" +
                "identificacionUsuario INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "numeroIdentidadUsuario TEXT NOT NULL UNIQUE, " +
                "nombre TEXT NOT NULL, " +
                "apellido TEXT NOT NULL, " +
                "tipoDeDocumento TEXT NOT NULL, " +
                "email TEXT NOT NULL UNIQUE, " +
                "password TEXT NOT NULL, " +
                "institucion TEXT NOT NULL, " +
                "numeroIdentidadAdministrador TEXT NOT NULL, " +
                "idAdministrador INTEGER, " +
                "FOREIGN KEY(idAdministrador) REFERENCES administradores(idAdministrador))");

        Log.i("DbHelper", "Tablas creadas correctamente");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS administradores");
        onCreate(db);
    }

    public long insertarAdministrador(ContentValues values) {
        return database.insert("administradores", null, values);
    }

    public long insertarUsuario(ContentValues values) {
        return database.insert("usuarios", null, values);
    }

    public boolean validarUsuario(String correo, String contrasena) {
        String hash = hashPassword(contrasena);
        Cursor cursor = database.rawQuery(
                "SELECT * FROM usuarios WHERE email = ? AND password = ?",
                new String[]{correo, hash}
        );
        boolean existe = cursor.getCount() > 0;
        cursor.close();
        return existe;
    }

    public boolean validarAdministrador(String correo, String contrasena) {
        String hash = hashPassword(contrasena);
        Cursor cursor = database.rawQuery(
                "SELECT * FROM administradores WHERE email = ? AND password = ?",
                new String[]{correo, hash}
        );
        boolean existe = cursor.getCount() > 0;
        cursor.close();
        return existe;
    }

    public boolean restablecerContrasenaUsuario(String correo, String nuevaContrasena) {
        ContentValues values = new ContentValues();
        values.put("password", hashPassword(nuevaContrasena));
        int filas = database.update("usuarios", values, "email = ?", new String[]{correo});
        return filas > 0;
    }

    public boolean restablecerContrasenaAdministrador(String correo, String nuevaContrasena) {
        ContentValues values = new ContentValues();
        values.put("password", hashPassword(nuevaContrasena));
        int filas = database.update("administradores", values, "email = ?", new String[]{correo});
        return filas > 0;
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
