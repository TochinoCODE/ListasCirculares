//Anthony Carhuacin Calixto
package listasCircular;

public class Nodo {
    //Atributos del Nodo
    private int dato;
    private Nodo siguiente;

    public Nodo() {
        dato = 0;
        siguiente = null;
    }
    
    public Nodo(int id ){
        dato = id;
        siguiente = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo obtenerSiguiente() {
        return siguiente;
    }
//metodo para enlazar nodos
    public void enlazarA(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
}
