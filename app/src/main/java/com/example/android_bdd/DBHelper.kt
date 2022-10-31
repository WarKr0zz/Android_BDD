package com.example.android_bdd

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    //Méthode pour créé la base de donnée
    override fun onCreate(db: SQLiteDatabase) {
        // Query pour créé les tables et les noméé

        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                NAME_COl + " TEXT," +
                AGE_COL + " TEXT" + ")")


        // Exécuté notre query
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        // Méthode pour vérifier si notre table existe deja
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    // Méthode pour ajouter a la database
    fun addName(name : String, age : String ){


        val values = ContentValues()


        values.put(NAME_COl, name)
        values.put(AGE_COL, age)


        val db = this.writableDatabase


        db.insert(TABLE_NAME, null, values)


        db.close()
    }

    //Méthode pour afficher la database
    fun getName(): Cursor? {


        val db = this.readableDatabase


        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)

    }

    companion object{



        private val DATABASE_NAME = "GEEKS_FOR_GEEKS"


        private val DATABASE_VERSION = 1


        val TABLE_NAME = "gfg_table"

        val ID_COL = "id"


        val NAME_COl = "name"


        val AGE_COL = "age"
    }
}
