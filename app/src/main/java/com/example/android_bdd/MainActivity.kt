package com.example.android_bdd
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var addName: Button
    lateinit var printName: Button
    lateinit var Age: TextView
    lateinit var enterName : EditText
    lateinit var enterPrenom : EditText
    lateinit var Name : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addName = findViewById(R.id.addName)
        printName = findViewById(R.id.printName)
        Age = findViewById(R.id.Age)
        enterName = findViewById(R.id.enterName)
        enterPrenom = findViewById(R.id.enterPrenom)
        Name = findViewById(R.id.Name)


        addName.setOnClickListener{

            // below we have created
            // a new DBHelper class,
            // and passed context to it
            val db = DBHelper(this, null)

            // On créé nos variables pour envoyer a la base de donnée
            val name = enterName.text.toString()
            val age = enterPrenom.text.toString()

            // On utilise la méthode addName depuis la classe DBHelper en passant nos variable en parametre
            db.addName(name, age)

            // On informe a l'utilisateur que l'ajout a été effectué
            Toast.makeText(this, name + " added to database", Toast.LENGTH_LONG).show()

            // Enfin on renitialise l'interieur des edit box
            enterName.text.clear()
            enterPrenom.text.clear()
        }


        printName.setOnClickListener{


            val db = DBHelper(this, null)


            val cursor = db.getName()


            cursor!!.moveToFirst()
            Name.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)) + "\n")
            Age.append(cursor.getString(cursor.getColumnIndex(DBHelper.AGE_COL)) + "\n")

            // on va effecteur cela tant qu'il y aura des valeur 
            while(cursor.moveToNext()){
                Name.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)) + "\n")
                Age.append(cursor.getString(cursor.getColumnIndex(DBHelper.AGE_COL)) + "\n")
            }


            cursor.close()
        }
    }
}