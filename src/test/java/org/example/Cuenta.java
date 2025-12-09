package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaCorrienteTest {

    private Cuenta cuenta;

    @BeforeEach
    void setUp(){
        cuenta = new Cuenta("1111111A", "José García");
    }

    @Test
    void ingresarDineroCuentaACero() {
        double ingreso = 200;
        assertEquals(cuenta.getSaldo(), 0);

        cuenta.ingresarDinero(ingreso);
        assertEquals(cuenta.getSaldo(), ingreso);
    }

    @Test
    void ingresarDineroCuentaConAhorros() {
        double ahorro = 1000;
        double ingreso = 200;

        cuenta.setSaldo(ahorro);
        assertEquals(cuenta.getSaldo(), ahorro);

        cuenta.ingresarDinero(ingreso);
        assertEquals(cuenta.getSaldo(), ahorro + ingreso);
    }

    @Test
    void sacarDineroHaySaldo() {
        double ahorro = 1000;
        double extracto = 200;

        cuenta.setSaldo(ahorro);
        assertEquals(cuenta.getSaldo(), ahorro);

        boolean resultado = cuenta.sacarDinero(extracto);
        assertEquals(cuenta.getSaldo(), ahorro - extracto);
        assertTrue(resultado);
    }

    @Test
    void sacarDineroNoHaySaldo() {
        double saldoInicial = 100;
        double extracto = 200;

        cuenta.setSaldo(saldoInicial);
        assertEquals(cuenta.getSaldo(), saldoInicial);

        boolean resultado = cuenta.sacarDinero(extracto);
        assertFalse(resultado);
        assertEquals(saldoInicial, cuenta.getSaldo());
    }

    @Test
    void sacarTodo() {
        int dinero = 300;
        cuenta.setSaldo(dinero);
        assertEquals(dinero, cuenta.getSaldo());
        boolean sacado = cuenta.sacarDinero(dinero);
        assertEquals(0, cuenta.getSaldo());
        assertTrue(sacado);
    }

    @Test
    void sacarDineroSuperiorLimite() {
        int saldoInicial = 1000, sacar = 500; //limite 399
        cuenta.setSaldo(saldoInicial);
        boolean resultado = cuenta.sacarDinero(sacar);
        assertEquals(saldoInicial, cuenta.getSaldo());
        assertFalse(resultado);
    }

}