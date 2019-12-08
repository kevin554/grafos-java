/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author L855
 */
public class Grafo<E, A> {

    private ArrayList<Nodo<E, A>> ListaNodos;

    public ArrayList<Nodo<E, A>> getListaNodos() {
        return ListaNodos;
    }

    public ArrayList<E> encontrarCamino(E origen, E destino, ArrayList<E> array) {
        ArrayList<E> Nodos;
//        System.out.println(origen);
        if (array == null) {
            Nodos = new ArrayList<>();
            Nodos.add(origen);
        } else {
            Nodos = array;
        }
        Nodo<E, A> PrimerNodo = BuscarNodo(origen);
        ArrayList<Arista<E, A>> aristas = PrimerNodo.getAristas();
        Arista<E, A> arista = aristas.get(0);
        Nodo<E, A> Nodo = arista.getNodoDestino();
        if (destino == Nodo.getIdNodo()) {
            Nodos.add(Nodo.getIdNodo());
            return Nodos;
        } else {
            Nodos.add(Nodo.getIdNodo());
            return encontrarCamino(Nodo.getIdNodo(), destino, Nodos);
        }
    }

    public void setListaNodos(ArrayList<Nodo<E, A>> ListaNodos) {
        this.ListaNodos = ListaNodos;
    }

    public Grafo() {
        this.ListaNodos = new ArrayList();
    }

    public Grafo(ArrayList<Nodo<E, A>> ListaNodos) {
        this.ListaNodos = ListaNodos;
    }

    public void InsertarNodo(E id) {
        Nodo<E, A> Aux = BuscarNodo(id);
        if (Aux == null) {
            ListaNodos.add(new Nodo(id));
        }
    }

    public void EliminarNodo(E id) {
        Nodo<E, A> Aux = BuscarNodo(id);
        if (Aux != null) {
            ListaNodos.remove(Aux);
        }
    }

    public Nodo<E, A> BuscarNodo(E id) {
        for (Nodo<E, A> nodo : ListaNodos) {
            if (nodo.getIdNodo() == id) {
                return nodo;
            }
        }
        return null;
    }

    public void InsertarArista(E IdOrigen, E idDestino, A valor, boolean doble) {
        Nodo<E, A> NodoA = BuscarNodo(IdOrigen);
        Nodo<E, A> NodoB = BuscarNodo(idDestino);
        if (NodoA != null && NodoB != null) {
            if (doble) {
                NodoA.ConectarDoble(NodoB, valor);
            } else {
                NodoA.Conectar(NodoB, valor);
            }
        }
    }

    public ArrayList<E> BFS(E Nodo) {
        Queue<Nodo<E, A>> cola = new LinkedList();
        ArrayList<E> resultado = new ArrayList<>();
        Nodo<E, A> Aux = BuscarNodo(Nodo);
        cola.add(Aux);
        while (!cola.isEmpty()) {
            Nodo<E, A> Aux2 = cola.poll();
            if (Aux2.isUsado() == false) {
                resultado.add(Aux2.getIdNodo());
                Aux2.setUsado(true);
            } else {
                continue;
            }
            ArrayList<Arista<E, A>> Aristas = Aux2.getAristas();
            for (Arista<E, A> Arista1 : Aristas) {
                if (Arista1.getNodoDestino().isUsado() == false) {
                    cola.add(Arista1.getNodoDestino());
//                    Arista1.getNodoDestino().setUsado(true);
                }
            }
        }
        return resultado;
    }

    public ArrayList<E> DFS(E Nodo) {
        Stack<Nodo<E, A>> Pila = new Stack<>();
        ArrayList<E> resultado = new ArrayList<>();
        Nodo<E, A> Aux = BuscarNodo(Nodo);
        Pila.push(Aux);
        while (!Pila.isEmpty()) {
            Nodo<E, A> Aux2 = Pila.pop();
            if (Aux2.isUsado() == false) {
                resultado.add(Aux2.getIdNodo());
                Aux2.setUsado(true);
            } else {
                continue;
            }
            ArrayList<Arista<E, A>> Aristas = Aux2.getAristas();
            for (Arista<E, A> Arista1 : Aristas) {
                if (Arista1.getNodoDestino().isUsado() == false) {
                    Pila.push(Arista1.getNodoDestino());
                }
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        String ToS = "";
        for (Nodo<E, A> ListaNodo : ListaNodos) {
            ToS += ListaNodo + "\n";
        }
        return ToS;
    }
}
