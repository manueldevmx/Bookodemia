package com.example.bookodemia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    private val TAG = LoginActivity::class.qualifiedName
    private lateinit var til_correo: TextInputLayout
    private lateinit var tiet_correo: TextInputEditText
    private lateinit var til_contrasena: TextInputLayout
    private lateinit var tiet_contrasena: TextInputEditText
    private lateinit var btn_iniciar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        if (validarSesion(applicationContext)){
            lanzarActivity()
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

       fun init(){
           til_correo = findViewById(R.id.til_correo)
           tiet_correo = findViewById(R.id.tiet_correo)
           til_contrasena = findViewById(R.id.til_contrasena)
           tiet_contrasena = findViewById(R.id.tiet_contrasena)
           btn_iniciar.setOnClickListener{
               if (validarCorreo() && validarContrasena()){
                   realizarPeticion()
               }
           }

       }



    }
    private fun validarCorreo(): Boolean{
        return if(tiet_correo.text.toString().isEmpty()){
            til_correo.error = getString(R.string.campo_vacio)
            false
        }
        else{
            if(android.util.Patterns.EMAIL_ADDRESS.matcher(tiet_correo.text.toString()).matches()){
                til_correo.isErrorEnabled = false
                true
            }
            else{
                til_correo.error = getString(R.string.error_correo)
                false
            }
        }
    }

    private fun validarContrasena(): Boolean{
        return if(tiet_contrasena.text.toString().isEmpty()){
            til_contrasena.error = getString(R.string.campo_vacio)
            false
        }
        else{
            til_contrasena.isErrorEnabled = false
            true
        }
    }
}