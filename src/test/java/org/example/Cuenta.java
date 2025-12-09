package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Cuenta {

    private Cuenta cuenta;

    @BeforeEach
    void setUp(){
        cuenta = new Cuenta("1111111A", "José García");
    }

    @Test
    void ingresarDineroCuentaACero() {
        double ingreso = 200;
        Assertions.assertEquals(cuenta.getSaldo(), 0);

        cuenta.ingresarDinero(ingreso);
        Assertions.assertEquals(cuenta.getSaldo(), ingreso);
    }

    @Test
    void ingresarDineroCuentaConAhorros() {
        double ahorro = 1000;
        double ingreso = 200;

        cuenta.setSaldo(ahorro);
        Assertions.assertEquals(cuenta.getSaldo(), ahorro);

        cuenta.ingresarDinero(ingreso);
        Assertions.assertEquals(cuenta.getSaldo(), ahorro + ingreso);
    }

    @Test
    void sacarDineroHaySaldo() {
        double ahorro = 1000;
        double extracto = 200;

        cuenta.setSaldo(ahorro);
        Assertions.assertEquals(cuenta.getSaldo(), ahorro);

        boolean resultado = cuenta.sacarDinero(extracto);
        Assertions.assertEquals(cuenta.getSaldo(), ahorro - extracto);
        assertTrue(resultado);
    }

    @Test
    void sacarDineroNoHaySaldo() {
        double saldoInicial = 100;
        double extracto = 200;

        cuenta.setSaldo(saldoInicial);
        Assertions.assertEquals(cuenta.getSaldo(), saldoInicial);

        boolean resultado = cuenta.sacarDinero(extracto);
        assertFalse(resultado);
        Assertions.assertEquals(saldoInicial, cuenta.getSaldo());
    }

    @Test
    void sacarTodo() {
        int dinero = 300;
        cuenta.setSaldo(dinero);
        Assertions.assertEquals(dinero, cuenta.getSaldo());
        boolean sacado = cuenta.sacarDinero(dinero);
        Assertions.assertEquals(0, cuenta.getSaldo());
        assertTrue(sacado);
    }

    @Test
    void sacarDineroSuperiorLimite() {
        int saldoInicial = 1000, sacar = 500; //limite 399
        cuenta.setSaldo(saldoInicial);
        boolean resultado = cuenta.sacarDinero(sacar);
        Assertions.assertEquals(saldoInicial, cuenta.getSaldo());
        assertFalse(resultado);
    }

}