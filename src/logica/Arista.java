/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author L855
 */
public class Arista <E,A> {
    private Nodo<E,A> nodoDestino; 
    private Nodo<E,A> nodoOrigen;
    private A valor;

    public Arista(Nodo<E, A> nodoDestino, Nodo<E, A> nodoOrigen, A valor) {
        this.nodoDestino = nodoDestino;
        this.nodoOrigen = nodoOrigen;
        this.valor = valor;
    }

    public Nodo<E, A> getNodoDestino() {
        return nodoDestino;
    }

    public void setNodoDestino(Nodo<E, A> nodoDestino) {
        this.nodoDestino = nodoDestino;
    }

    public Nodo<E, A> getNodoOrigen() {
        return nodoOrigen;
    }

    public void setNodoOrigen(Nodo<E, A> nodoOrigen) {
        this.nodoOrigen = nodoOrigen;
    }

    public A getValor() {
        return valor;
    }

    public void setValor(A valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "["+nodoDestino.getIdNodo() +":"+valor+"]";
    }
    
}
