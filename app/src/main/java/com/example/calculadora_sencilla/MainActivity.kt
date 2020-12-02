package com.example.calculadora_sencilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        unoBoton.setOnClickListener{ numeroPresionado("1")}
        dosBoton.setOnClickListener{ numeroPresionado("2")}
        tresBoton.setOnClickListener{ numeroPresionado("3")}
        cuatroBoton.setOnClickListener{ numeroPresionado("4")}
        cincoBoton.setOnClickListener{ numeroPresionado("5")}
        seisBoton.setOnClickListener{ numeroPresionado("6")}
        sieteBoton.setOnClickListener{ numeroPresionado("7")}
        ochoBoton.setOnClickListener{ numeroPresionado("8")}
        nueveBoton.setOnClickListener{ numeroPresionado("9")}
        ceroBoton.setOnClickListener{ numeroPresionado("0")}
        puntoBoton.setOnClickListener{ numeroPresionado(".")}

        sumaBoton.setOnClickListener{operacionPresionada(SUMA)}
        restaBoton.setOnClickListener{operacionPresionada(RESTA)}
        multiplicacionBoton.setOnClickListener{operacionPresionada(MULTIPLICACION)}
        divisionBoton.setOnClickListener{operacionPresionada(DIVISION)}

        borrarBoton.setOnClickListener{
            num1=0.0
            num2=0.0
            resultadoTextView.text= "0"
            operacion= NO_OPERACION
        }

        igualBoton.setOnClickListener{
            var resultado= when(operacion){
                SUMA->num1+num2
                RESTA->num1-num2
                MULTIPLICACION->num1*num2
                DIVISION->num1/num2
                else->0
            }
            resultadoTextView.text=resultado.toString()
        }
    }

    private fun numeroPresionado(digito: String){
        if(resultadoTextView.text == "0" && digito != ".") {
            resultadoTextView.text = "$digito"
        } else {
            resultadoTextView.text = "${resultadoTextView.text}$digito"
        }

        if(operacion == NO_OPERACION){
            num1 = resultadoTextView.text.toString().toDouble()
        } else {
            num2 = resultadoTextView.text.toString().toDouble()
        }

    /* resultadoTextView.text="{$resultadoTextView.text}$digito"
        if (operacion == NO_OPERACION){
            num1= resultadoTextView.text.toString().toDouble()
        }else{
            num2= resultadoTextView.text.toString().toDouble()
        }*/
    }

    private fun operacionPresionada(operacion: Int){
        this.operacion=operacion
        num1 = resultadoTextView.text.toString().toDouble()
        resultadoTextView.text = "0"
    }

    companion object{
        const val SUMA=1
        const val RESTA=2
        const val MULTIPLICACION=3
        const val DIVISION=4
        const val NO_OPERACION=5
    }
}