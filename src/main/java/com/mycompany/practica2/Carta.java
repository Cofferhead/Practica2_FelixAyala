/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica2;

/**
 *
 * @author felix
 */
public class Carta {
    private char valor;
    private String palo;
    private int pos;
    public Carta (char valor, String color)
    {
        this.valor = valor;
        this.palo = color;
    }
    public Carta ()
    {
        this.valor = 3;
        this.palo = "Azul";
    }
    public void setPos (int pos)
    {
        this.pos = pos;
    }
    public char getValor() {
        return valor;
    }

    public String getPalo() {
        return palo;
    }
    public int getPos ()
    {
        return this.pos;
    }
    
    @Override
    public String toString ()
    {
        String salida = "[" + valor + " | " + palo + "]" + " #" + pos;
        return salida;
    }
}
