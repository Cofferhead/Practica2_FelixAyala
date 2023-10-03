/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica2;

/**
 *
 * @author felix
 */
public class Pila <T> {
    private T[] pila;
    private int tope = -1;
    public Pila (int max)
    {
        pila = (T[]) new Object[max];
    }
    public void push (T object)
    {
        if (revisarSiPilaLlena())
        {
            System.out.println("Desbordando");
        }
        else
        {
            tope += 1;
            pila[tope] = object;
        }
    }
    public T pop ()
    {
        if (tope == -1)
        {
            System.out.println("Subdesbordamiento");
            return null;
        }
        else
        {
            T aux = pila[tope];
            pila[tope] = null;
            tope -= 1;
            return aux;
        }
    }
    public T peek ()
    {
        if (tope != -1)
        {
            return pila[tope];
        }
        else
        {
            return null;
        }
    }
    private boolean estaVacia ()
    {
        if (tope == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    private boolean revisarSiPilaLlena ()
    {
        if (tope == pila.length)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean isEmpty ()
    {
        return (tope == -1);
    }
    //isFull
    public boolean isFull ()
    {
        return (tope == pila.length-1);
    }
    
   
    
    
}

