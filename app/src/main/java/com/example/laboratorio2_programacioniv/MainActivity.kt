
package com.example.laboratorio2_programacioniv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var ett_nombre: EditText
    private lateinit var etn_edad: EditText
    private lateinit var ett_depto: EditText
    private lateinit var lv_Datos: ListView
    private lateinit var tv_Seleccion: TextView

    private var nombres = arrayListOf<String>()
    private var edades = arrayListOf<String>()
    private var departamentos = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ett_nombre = findViewById(R.id.ett_nombre)
        etn_edad = findViewById(R.id.etn_edad)
        ett_depto = findViewById(R.id.ett_depto)
        lv_Datos = findViewById(R.id.lv_Datos)
        tv_Seleccion = findViewById(R.id.tv_Seleccion)

    }
    fun Guardar(v: View){

        val name = ett_nombre.text.toString()
        val age = etn_edad.text.toString()
        val department = ett_depto.text.toString()

        if(!name.isEmpty() && !age.isEmpty() && !department.isEmpty()){
            nombres.add(name)
            edades.add(age)
            departamentos.add(department)

            val adaptador: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.list_progra, nombres)
            lv_Datos.adapter = adaptador

            lv_Datos.onItemClickListener = object : AdapterView.OnItemClickListener{
                override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    tv_Seleccion.text = " Nombre: ${lv_Datos?.getItemAtPosition(position)}    Edad: ${edades[position]}años    Departamento: ${departamentos[position]}"
                }
            }


            ett_nombre.setText("")
            etn_edad.setText("")
            ett_depto.setText("")

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}