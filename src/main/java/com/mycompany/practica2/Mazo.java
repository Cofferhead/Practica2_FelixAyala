/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author felix
 */
public class Mazo {
    private ArrayList<Carta> mazo;
    public Mazo ()
    {
        mazo = new ArrayList();
        Integer aux;
        for (int i = 2; i < 9; i++)
        {
            
            mazo.add(new Carta((char) (i+1 + '0'), "corazon"));
            mazo.add(new Carta((char) (i+1 + '0'), "pica"));
            mazo.add(new Carta((char) (i+1 + '0'), "trebol"));
            mazo.add(new Carta((char) (i+1 + '0'), "estrella"));
            mazo.add(new Carta((char) (i+1 + '0'), "diamante"));
        }
        mazo.add(new Carta('0', "corazon"));
        mazo.add(new Carta('0', "pica"));
        mazo.add(new Carta('0', "trebol"));
        mazo.add(new Carta('0', "estrella"));
        mazo.add(new Carta('0', "diamante"));
        mazo.add(new Carta('J', "corazon"));
        mazo.add(new Carta('J', "pica"));
        mazo.add(new Carta('J', "trebol"));
        mazo.add(new Carta('J', "estrella"));
        mazo.add(new Carta('J', "diamante"));
        mazo.add(new Carta('Q', "corazon"));
        mazo.add(new Carta('Q', "pica"));
        mazo.add(new Carta('Q', "trebol"));
        mazo.add(new Carta('Q', "estrella"));
        mazo.add(new Carta('Q', "diamante"));
        mazo.add(new Carta('K', "corazon"));
        mazo.add(new Carta('K', "pica"));
        mazo.add(new Carta('K', "trebol"));
        mazo.add(new Carta('K', "estrella"));
        mazo.add(new Carta('K', "diamante"));
        mazo.add(new Carta('j', "joker"));
        mazo.add(new Carta('j', "joker"));
        mazo.add(new Carta('j', "joker"));
        mezclarMazo();
    }
    public Carta darCartaRandom()
    {
        Carta aux = mazo.get(0);
        mazo.remove(0);
        return aux;
    }
    public void añadirCarta (Carta newCard)
    {
        mazo.add(newCard);
    }
    public void mezclarMazo()
    {
        Collections.shuffle(mazo, new Random());
    }
    @Override
    public String toString ()
    {
        String salida = "";
        for (Carta i:mazo)
        {
            salida += i.toString() + "\n";
        }
        return salida;
    }
}
