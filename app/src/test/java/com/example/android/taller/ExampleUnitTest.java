package com.example.android.taller;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void sumar_precios_correcto(){
        assertEquals(180000, Principal.sumarTotal(80000, 100000), 0);
    }

    @Test
    public void sumar_precios_incorrecto(){
        assertNotEquals(150000, Principal.sumarTotal(80000, 100000), 0);
    }

    @Test
    public void validar_cantidad_correcto(){
        assertEquals(50000, Principal.validar_cantidad("50000"), 0);
    }

    @Test
    public void validar_cantidad_incorrecto(){
        assertNotEquals(80000, Principal.validar_cantidad("50000"), 0);
    }

    @Test
    public void multiplicar_precio_y_cantidad_correcto(){
        assertEquals(300000, Principal.multiplicar(150000, 2), 0);
    }

    @Test
    public void multiplicar_precio_y_cantidad_incorrecto(){
        assertNotEquals(330000, Principal.multiplicar(150000, 2), 0);
    }
}