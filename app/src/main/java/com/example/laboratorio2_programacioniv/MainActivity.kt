
package com.example.laboratorio2_programacioniv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var etNombre: EditText
    private lateinit var etnEdad: EditText
    private lateinit var etDepartamento: EditText
    private lateinit var lvNombres: ListView
    private lateinit var tvDatos: TextView

    private var nombres = arrayListOf<String>()
    private var edades = arrayListOf<String>()
    private var departamentos = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etNombre = findViewById(R.id.ett_nombre)
        etnEdad = findViewById(R.id.etn_edad)
        etDepartamento = findViewById(R.id.ett_depto)
        lvNombres = findViewById(R.id.lv_Datos)
        tvDatos = findViewById(R.id.tv_Seleccion)

    }
    fun registrar(v: View){

        val nombre = etNombre.text.toString()
        val edad = etnEdad.text.toString()
        val departamento = etDepartamento.text.toString()

        if(!nombre.isEmpty() && !edad.isEmpty() && !departamento.isEmpty()){
            nombres.add(nombre)
            edades.add(edad)
            departamentos.add(departamento)

            val adaptador: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.list_progra, nombres)
            lvNombres.adapter = adaptador

            lvNombres.onItemClickListener = object : AdapterView.OnItemClickListener{
                override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    tvDatos.text = " Nombre: ${lvNombres?.getItemAtPosition(position)}    Edad: ${edades[position]}años    Departamento: ${departamentos[position]}"
                }
            }


            etNombre.setText("")
            etnEdad.setText("")
            etDepartamento.setText("")

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}