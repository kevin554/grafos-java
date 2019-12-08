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
public class Nodo <E,A>{
    private E IdNodo;
    private ArrayList<Arista<E,A>> Aristas;
    private boolean usado= false;
    public ArrayList<Arista<E, A>> getAristas() {
        return Aristas;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    public Nodo(E IdNodo, ArrayList<Arista<E,A>> Aristas) {
        this.IdNodo = IdNodo;
        this.Aristas = Aristas;
    }
    public Nodo(E IdNodo) {
        Aristas=new ArrayList<>();
        this.IdNodo = IdNodo;
    }

    public E getIdNodo() {
        return IdNodo;
    }

    public void setIdNodo(E IdNodo) {
        this.IdNodo = IdNodo;
    }
    public void Conectar(Nodo<E, A> nodoDestino,A valor) {
        Arista<E, A> NuevaArista = BuscarArista(nodoDestino.getIdNodo());
        if(NuevaArista==null)
            Aristas.add(new Arista(nodoDestino, this, valor));
    }
    public void ConectarDoble(Nodo<E, A> nodoDestino,A valor) {
        this.Conectar(nodoDestino, valor);
        nodoDestino.Conectar(this, valor);
    }
    public Arista<E, A> BuscarArista(E Id){
        if(Aristas.isEmpty())
            return null;
        for (Arista<E, A> Arista1 : Aristas) {
            if(Id==Arista1.getNodoDestino().getIdNodo()){
                return Arista1;
            }
        }
        return null;
    }
    public void EliminarArista(E Destino){
        Arista<E, A> AristaRemove = BuscarArista(Destino);
        if(AristaRemove!= null)
        Aristas.remove(AristaRemove);
    }
    @Override
    public String toString() {
        String Nodo= IdNodo.toString();
        String resultado= Nodo;
        for (Arista<E, A> Arista1 : Aristas) {
            resultado += "->"+ Arista1;
        }
        return resultado;
    }
}
