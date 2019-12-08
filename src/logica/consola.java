/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author L855
 */
public class consola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Grafo<Integer,Integer> grafo = new Grafo();
        grafo.InsertarNodo(1);
        grafo.InsertarNodo(2);
        grafo.InsertarNodo(3);
        grafo.InsertarNodo(4);
        grafo.InsertarNodo(5);
        grafo.InsertarNodo(6);
        grafo.InsertarNodo(7);
        grafo.InsertarNodo(8);
        grafo.InsertarArista(6,1,50, false);
        grafo.InsertarArista(6,5,80, false);
        grafo.InsertarArista(4,5,20, false);
        grafo.InsertarArista(4,6,10, false);
        grafo.InsertarArista(4,3,40, true);
        grafo.InsertarArista(2,4,50, false);
        grafo.InsertarArista(2,3,30, false);
        grafo.InsertarArista(7,2,20, false);
        grafo.InsertarArista(2,8,20, false);
        System.out.println(grafo.BFS(7));
//        System.out.println(grafo);
//        System.out.println(grafo.encontrarCamino(5,1,null));
    }    
}
