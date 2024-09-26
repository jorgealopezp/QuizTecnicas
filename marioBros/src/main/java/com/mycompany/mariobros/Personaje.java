package com.mycompany.mariobros;

public class Personaje {

    private String nombre;
    private int vida;
    private double velocidad;
    private int salto;
    private int ataque;

    public Personaje(String nombre, int vida, double velocidad, int salto, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.velocidad = velocidad;
        this.salto = salto;
        this.ataque = ataque;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void reducirVida(int cantidad) {
        this.vida -= cantidad;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }

    public double getVelocidad() {
        return velocidad;
    }

    public int getSalto() {
        return salto;
    }

    public int getAtaque() {
        return ataque;
    }

    public void atacar(Personaje enemigo) {
        System.out.println(this.nombre + " ataca a " + enemigo.getNombre() + " con " + this.ataque + " de daño.");
        enemigo.reducirVida(this.ataque);
        System.out.println(enemigo.getNombre() + " ahora tiene " + enemigo.getVida() + " de vida.");
    }

    public void defenderse(int daño) {
        System.out.println(this.nombre + " recibe " + daño + " de daño.");
        reducirVida(daño);
        System.out.println(this.nombre + " ahora tiene " + this.vida + " de vida.");
    }

   
}
