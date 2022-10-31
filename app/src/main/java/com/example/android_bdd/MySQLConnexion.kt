package com.example.android_bdd

import android.util.Log
import java.sql.DriverManager
import java.sql.Connection
import java.sql.Driver
import java.sql.ResultSet
import java.sql.SQLException


object MySQLConnexion {


    @JvmStatic
    fun connection() {
        try {
            val c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root",
                ""
            )
            println("OK ! Tout est OK Vraiment tout ")
            val s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
            val r = s.executeQuery("SELECT * FROM `android_bdd` WHERE 1;")
        }
        catch (e: SQLException){
            e.printStackTrace()
        }

    }



}