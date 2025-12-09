package org.example;

///    CAMBIOS PARA RAMA CAMBIO_2

/** Clase cuentaCorriente*/
public class Cuenta {
    String dni;
    String nombreTitular;
    double saldo;

    /**
     * Constructor
     * @param dni dni del titular de la cuenta
     * @param nombreTitular nombre del titular de la cuenta
     */
    Cuenta(String dni, String nombreTitular) {
        this.dni = dni;
        this.nombreTitular = nombreTitular;
        this.saldo = 0;

    }

    /**
     *
     * @param ingreso dinero que se va a ingresar en la cuenta
     */
    public void ingresarDinero(double ingreso) {
        this.saldo = this.saldo + ingreso;
    }

    /**
     *
     * @param saldoASacar cantidad de dinero que se quiere sacar
     * @return true si había suficiente dinero disponible para sacarlo
     */
    public boolean sacarDinero(double saldoASacar) {
        boolean esPosible = false;
        if (saldoASacar <= 400 && saldoASacar <= this.saldo) {
            this.saldo = this.saldo - saldoASacar;
            esPosible = true;
        }
        return esPosible;
    }


    public String mostrarInformacion(){
        return  this.dni + " " +  this.nombreTitular + " " + this.saldo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
