/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica2;

import java.util.Scanner;

/**
 *
 * @author felix
 */
public class ControlJuego {
    
    private Mazo mazo;
    private Pila<Carta> pozo;
    private Pila<Carta> mano;
    public ControlJuego ()
    {
        mazo = new Mazo();
        pozo = new Pila(10);
        mano = new Pila(10);
    }
    //Pozo
    public void llenarPozo ()
    {
        vaciarPozo();
        descartarMano();
        Carta aux;
        int contador = 1;
        while (contador <= 10)
        {
            aux = mazo.darCartaRandom();
            aux.setPos(contador);
            pozo.push(aux);
            contador += 1;
        }
    }
    public void vaciarPozo  ()
    {
        while (pozo.peek() != null)
        {
            pozo.pop();
        }
    }
    //Mano
    public void añadirAMano (Carta carta)
    {
        //System.out.println(mano.isFull() + " 77777777");
        if (mano.isFull() )
        {
            System.out.println("Mano llena.");
        }
        else if (mano.peek() == null)
        {
            //System.out.println("No habia nada");
            mano.push(carta);
        }
        else
        {
            //System.out.println("Hay cosas");
            Pila <Carta> aux = new Pila(10);
            while (mano.peek() != null)
            {
                if (mano.peek().getPos() > carta.getPos())
                {
                    //System.out.println("Hubo mayor");
                    mano.push(carta);
                    break;
                }
                else
                {
                    //System.out.println("No hubo mayor");
                    aux.push(mano.pop());
                    if (mano.peek() == null)
                    {
                        //System.out.println("No hay mayor");
                        mano.push(carta);
                        break;
                    }
                }
            }
            while (aux.peek() != null)
            {
                mano.push(aux.pop());
            }
        }
    }
    public void descartarMano ()
    {
        while (mano.isEmpty() != true)
        {
            mano.pop();
        }
    }
    //Pozo
    public void sacarDePozo (String tipo)
    {
        Carta aux;
        Pila<Carta> pozoAux = new Pila(10);
        while (pozo.peek() != null)
        {
            aux = pozo.pop();
            if (aux.getPalo().equals(tipo))
            {
                añadirAMano(aux);
            }
            else
            {
                pozoAux.push(aux);
            }
        }
        while (pozoAux.peek() != null)
        {
            aux = pozoAux.pop();
            pozo.push(aux);
        }
    }
    public void añadirAPozo (Pila<Carta> pila)
    {
        //En esta función asumimos que pila esta ordenado
        //de mayor a menor en el tope
        //Vaciamos el pozo.
        Pila<Carta> pozoAux = new Pila(10);
        Pila<Carta> auxPila = new Pila(10);
        System.out.println("INVERTIMOS AMBAS PILAS: ");
        while (pila.isEmpty() == false)
        {
            auxPila.push(pila.pop());
        }
        while (pozo.isEmpty() == false)
        {
            pozoAux.push(pozo.pop());
        }
        System.out.println("BUCLE PRINCIPAL: ");
        while (pozoAux.isEmpty() == false && auxPila.isEmpty() == false)
        {
            
            if (pozoAux.peek().getPos() < auxPila.peek().getPos())
            {
                System.out.println("CARTA A METER de POZO: " + pozoAux.peek());
                
                pozo.push(pozoAux.pop());
            }
            else
            {
                System.out.println("CARTA A METER de AUZ: " + auxPila.peek());
                pozo.push(auxPila.pop());
            }
        }
        //System.out.println(pila.isEmpty());
        //System.out.println();
        System.out.println("EVALUACIOÓN: ");
        if (auxPila.isEmpty() == true)
        {
            System.out.println("EMPTY");
            while (pozoAux.isEmpty() != true)
            {
                System.out.println("Es añadirAPozo.");
                System.out.println("SOMETHING: " + pozoAux.peek().toString());
                pozo.push(pozoAux.pop());
                
            }
        }
        else
        {
            System.out.println("AUX NO EMPTY");
            while (auxPila.isEmpty() != true)
            {
                //System.out.println("NOTSOMETHING: " + pila.peek().toString());
                pozo.push(auxPila.pop());
            }
        }
        //Hasta que ambos esten vacios
            //Comparamos cual es el menor
            //Y ponemos el mayor en el mazo
    }
    public void sacarDePozo (char valor)
    {
        Carta aux;
        Pila<Carta> pozoAux = new Pila(10);
        while (pozo.peek() != null)
        {
            aux = pozo.pop();
            if (aux.getValor() == valor)
            {
                //this.mano.push(aux);
                añadirAMano(aux);
            }
            else
            {
                pozoAux.push(aux);
            }
        }
        while (pozoAux.peek() != null)
        {
            pozo.push(pozoAux.pop());
        }
    }
    public void meterAlPozo (String palo)
    {
        Pila<Carta> auxMano = new Pila(10);
        Pila<Carta> cartasMeter = new Pila(10);
        System.out.println("ANTES DEL BUCLE " + mano.peek());
        
        while (mano.peek() != null)
        {
            System.out.println("METERPOZO: " + mano.peek());
            if (mano.peek().getPalo().equals(palo))
            {
                cartasMeter.push(mano.pop());
            }
            else
            {
           
                auxMano.push(mano.pop());
            }
        }
        System.out.println("BUCLE DE DEVOLUCIÓN");
        while (auxMano.isEmpty() != true)
        {
            System.out.println("PILA AUX: " + auxMano.peek());
            mano.push(auxMano.pop());
        }
        System.out.println("AÑADIR POZO, AQUI LO LLAMAMOS");
        this.añadirAPozo(cartasMeter);
    }
    public void meterAlPozo (char valor)
    {
        Pila<Carta> auxMano = new Pila(10);
        Pila<Carta> cartasMeter = new Pila(10);
        while (mano.isEmpty() != true)
        {
            System.out.println("Meter al pozo ");
            if (mano.peek().getValor() == valor)
            {
                cartasMeter.push(mano.pop());
            }
            else
            {
                auxMano.push(mano.pop());
            }
        }
        while (auxMano.isEmpty() != true)
        {
            mano.push(auxMano.pop());
        }
        while (cartasMeter.isEmpty() == false)
        {
            auxMano.push(cartasMeter.pop());
        }
        this.añadirAPozo(auxMano);
    }
    //Getters
    public Mazo getMazo() {
        return mazo;
    }

    public Pila<Carta> getPozo() {
        return pozo;
    }

    public Pila<Carta> getMano() {
        return mano;
    }
    //Impresión
    public void imprimirPozo ()
    {
        Pila<Carta> auxImpresión = new Pila(10);
        while (pozo.peek() != null)
        {
            auxImpresión.push(pozo.pop());
            //System.out.println(auxImpresión.peek().toString());
        }
        
        System.out.println("ASDFISDJIDSOFSD");
        while (auxImpresión.peek() != null)
        {
            
            pozo.push(auxImpresión.pop());
            System.out.println(pozo.peek().toString());
        }
    }
    public void imprimirMazo()
    {
        System.out.println(mazo.toString());
    }
    public void imprimirMano ()
    {
        Pila<Carta> auxImpresión = new Pila(10);
        
        while (mano.peek() != null)
        {
            auxImpresión.push(mano.pop());
            //System.out.println(auxImpresión.peek().toString());
        }
        while (auxImpresión.peek() != null)
        {
            mano.push(auxImpresión.pop());
            System.out.println(mano.peek().toString());
        }
        
    }
    public static void main(String[] args) {
        //Atributos
        Scanner sc = new Scanner(System.in);
        ControlJuego control = new ControlJuego();
        String aux;
        int opt = 6;
        //Llenamos el pozo y la primera 
        control.llenarPozo();
        //Loop principal
        do 
        {
            System.out.println("1.Ver pozo");
            System.out.println("2.Descartar pozo y mano");
            System.out.println("3.Ver mano");
            System.out.println("4.Agarrar de la mano");
            System.out.println("5.Añadir al pozo");
            System.out.println("6.Salir");
            System.out.println("Elija: ");
            opt = sc.nextInt();
            sc.nextLine();
            switch (opt)
            {
                case 1:
                    System.out.println("Pozo: POZO POZO POZO POZO POZO POZO");
                    control.imprimirPozo();
                    break;
                case 2:
                    System.out.println("Pozo lleno: ");
                    control.llenarPozo();
                    System.out.println("Pozo: POZO POZO POZO POZO POZO");
                    control.imprimirPozo();
                    break;
                case 3:
                    System.out.println("Mano: MANO MANO MANO MANO MANO MANO");
                    control.imprimirMano();
                    break;
                case 4:
                    System.out.println("Sacar del pozo:");
                    aux = sc.nextLine();
                    if (aux.length() == 1)
                    {
                        control.sacarDePozo(aux.charAt(0));
                    }
                    else{
                        control.sacarDePozo(aux);
                    }
                    System.out.println("Mano: MANO MANO MANO MANO MANO");
                    control.imprimirMano();
                    System.out.println("Pozo: POZO POZO POZO POZO POZO");
                    control.imprimirPozo();
                    break;
                case 5:
                    System.out.println("Meter al pozo: ");
                    aux = sc.nextLine();
                    if (aux.length() == 1)
                    {
                        control.meterAlPozo(aux.charAt(0));
                    }
                    else
                    {
                        control.meterAlPozo(aux);
                    }
                    System.out.println("Mano: MANO MANO MANO MANO MANO MANO MANO MANO");
                    control.imprimirMano();
                    System.out.println("Pozo: POZO POZO POZO POZO POZO");
                    control.imprimirPozo();
                    break;
                default:
                    System.out.println("Saliendo");
            }
        } while (opt != 6); 
        /*ControlJuego a = new ControlJuego();
        a.llenarPozo();
        a.imprimirPozo();
        System.out.println("-----------------------------------------------------------A");
        a.sacarDePozo("pica");
        //a.imprimirPozo();
        //System.out.println("-----------------------------------------------------------B");
        //a.imprimirMano();
        //System.out.println("-----------------------------------------------------------C");
        a.sacarDePozo("corazon");
        a.sacarDePozo('3');
        //a.imprimirPozo();
        System.out.println("-----------------------------------------------------------D");
        a.imprimirMano();
        System.out.println("-----------------------------------------------------------E");
        a.imprimirPozo();
        System.out.println("-----------------------------------------------------------F");
        a.añadirAPozo(a.mano);
        a.imprimirPozo();
        */
       
        /*Carta aux = new Carta ('3', "corazon");
        aux.setPos(0);
        a.añadirAMano(aux);
        Carta aux2 = new Carta ('4', "corazon");
        aux2.setPos(1);
        a.añadirAMano(aux2);
        Carta aux3 = new Carta('8', "pica");
        aux3.setPos(3);
        a.añadirAMano(aux3);
        Carta aux4 = new Carta('9', "estrella");
        aux4.setPos(2);
        a.añadirAMano(aux4);
        Carta aux5 = new Carta('9', "estrella");
        aux5.setPos(8);
        a.añadirAMano(aux5);
        Carta aux6 = new Carta('9', "estrella");
        aux6.setPos(5);
        a.añadirAMano(aux6);
        Carta aux7 = new Carta('9', "estrella");
        aux7.setPos(10);
        a.añadirAMano(aux7);
        Carta aux8 = new Carta('9', "estrella");
        aux8.setPos(6);
        a.añadirAMano(aux8);
        Carta aux9 = new Carta('9', "estrella");
        aux9.setPos(9);
        a.añadirAMano(aux9);
        Carta aux10 = new Carta('9', "estrella");
        aux10.setPos(7);
        a.añadirAMano(aux10);
        Carta aux11 = new Carta('9', "estrella");
        aux11.setPos(11);
        a.añadirAMano(aux11);
        System.out.println("Mano: ----------------------");
        a.imprimirMano();*/
        
    }
}
