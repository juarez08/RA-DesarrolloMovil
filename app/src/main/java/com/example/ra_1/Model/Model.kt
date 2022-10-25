package com.example.ra_1.Model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel()
{
    private val _text = mutableStateOf("")
    val text: State<String> = _text

    private val _texto = mutableStateOf("")
    val texto: State<String> = _texto

    private val _nombre = mutableStateOf("")
    val nombre: State<String> = _nombre

    val _modelo = mutableStateOf("")
    val modelo: State<String> = _modelo

    private val _val = mutableStateOf(0.0)
    val valor: State<Double> = _val


    private val _descuento = mutableStateOf(0)
    val descuento: State<Int> = _descuento

    private val _enganche = mutableStateOf(0.0)
    val enganche: State<Double> = _enganche


    private val _carro1 = mutableStateOf(678026.22)
    val carro1: State<Double> = _carro1

    private val _carro2 = mutableStateOf(879266.15)
    val carro2: State<Double> = _carro2

    private val _carro3 = mutableStateOf(1025366.87)
    val carro3: State<Double> = _carro3

    private val _carro4 = mutableStateOf(988641.02)
    val carr4: State<Double> = _carro4


    private val _descuento20 = mutableStateOf(20)
    val descuento20: State<Int> = _descuento20

    private val _descuento40 = mutableStateOf(40)
    val descuento40: State<Int> = _descuento40

    private val _descuento60 = mutableStateOf(60)
    val descuento60: State<Int> = _descuento60


    private val _financiamiento = mutableStateOf(0.0)
    val financiamiento: State<Double> = _financiamiento

    private val _pagoanual = mutableStateOf(0)
    val pagoanual: State<Int> = _pagoanual

    private val _plazo = mutableStateOf("")
    val plazo: State<String> = _plazo

    private val _interes = mutableStateOf(0.0)
    val interes: State<Double> = _interes

    private val _tasa = mutableStateOf(0.0)
    val tasa: State<Double> = _tasa

    private val _total = mutableStateOf(0.0)
    val total: State<Double> = _total

    private val _meses = mutableStateOf(0)
    val meses: State<Int> = _meses

    private val _mes = mutableStateOf(0.0)
    val mes: State<Double> = _mes

    val pagomensual: State<Double> = _mes

    private val _preciototal = mutableStateOf(0.0)
    val preciototal: State<Double> = _preciototal


    fun definirnombre(nombre: String) {
        _nombre.value = nombre
    }

    fun definirModelo(modelo: String) {
        _modelo.value = modelo
    }


    fun carro1() {
        _modelo.value = "Honda Accord =  $ ${_carro1.value.toString()}"
        _val.value = _carro1.value

    }

    fun carro2() {
        _modelo.value = "Vw Touareg =    $ ${_carro2.value.toString()}"
        _val.value = _carro2.value

    }

    fun carro3() {
        _modelo.value = "BMW X5 =   $ ${_carro3.value.toString()}"
        _val.value = _carro3.value

    }

    fun carro4() {
        _modelo.value = "Mazda CX7 =   $ ${_carro4.value.toString()}"
        _val.value = _carro4.value

    }

    fun descuento20() {
        _descuento.value = _descuento20.value
        calEnganche(_descuento.value, _val.value)
    }

    fun descuento40() {
        _descuento.value = _descuento40.value
        calEnganche(_descuento.value, _val.value)
    }

    fun descuento60() {
        _descuento.value = _descuento60.value
        calEnganche(_descuento.value, _val.value)
    }

    fun calEnganche(porce: Int, valor: Double) {
        _enganche.value = porce * valor / 100
        Financiamiento(_val.value, _enganche.value)

    }
    fun calInteres(tasa: Double, financiamiento: Double, anios: Int) {
        _interes.value = tasa * financiamiento / 100 * anios
        caltotal()
    }


    fun Financiamiento(valor: Double, enganche: Double) {
        _financiamiento.value = valor - enganche

    }

    fun plan1anual() {
        _plazo.value = "1 año, tasa 7.5%"
        _pagoanual.value = 1
        _tasa.value = 7.5
        _meses.value = 12
        calInteres(_tasa.value, _financiamiento.value, _pagoanual.value)

    }


    fun plan2anual() {
        _plazo.value = "2 años, tasa 9.5%"
        _pagoanual.value = 2
        _tasa.value = 9.5
        _meses.value = 24
        calInteres(_tasa.value, _financiamiento.value, _pagoanual.value)

    }


    fun plan3anual() {
        _plazo.value = "3 años, tasa 10.3%"
        _pagoanual.value = 3
        _tasa.value = 10.3
        _meses.value = 36
        calInteres(_tasa.value, _financiamiento.value, _pagoanual.value)

    }



    fun plan4anual() {
        _plazo.value = "4 años, tasa 12.6%"
        _pagoanual.value = 4
        _tasa.value = 12.6
        _meses.value = 48
        calInteres(_tasa.value, _financiamiento.value, _pagoanual.value)

    }


    fun plan5anual() {
        _plazo.value = "5 años, tasa 13.5%"
        _pagoanual.value = 5
        _tasa.value = 13.5
        _meses.value = 60
        calInteres(_tasa.value, _financiamiento.value, _pagoanual.value)

    }

    fun caltotal() {
        _total.value = _financiamiento.value + _interes.value
        _mes.value = _total.value / _meses.value
    }

    fun marca(index: Int) {
        when (index) {
            0 -> carro1()
            1 -> carro2()
            2 -> carro3()
            3 -> carro4()
            else -> {
                null
            }
        }
    }
    fun selecfinanciamiento(index: Int) {
        when (index) {
            0 -> plan1anual()
            1 -> plan2anual()
            2 -> plan3anual()
            3 -> plan4anual()
            4 -> plan5anual()
            else -> {
                null
            }
        }
    }
    fun selectporcentaje(index: Int) {
        when (index) {
            0 -> descuento20()
            1 -> descuento40()
            2 -> descuento60()
            else -> {
                print("")
            }
        }
    }

    fun reset() {
        _nombre.value = ""
        _modelo.value = ""
        _descuento.value = 0
        _enganche.value = 0.0
        _financiamiento.value = 0.0
        _plazo.value = ""
        _pagoanual.value = 0
        _interes.value = 0.0
        _total.value = 0.0
        _mes.value = 0.0
        fun definirnombre() = ""
    }
}
