//Anthony Carhuacin Calixto
package listasCircular;

import java.util.Random;

public class listaCircular {

    private Nodo cabeza;
    private Nodo cola;
    private int tamaño;
    final Random r = new Random();

    public listaCircular() {
        cabeza = null;
        cola = null;
        tamaño = 0;
    }

    public boolean estaVacio() {
        return cabeza == null;
    }

    public int crearAleatorios() {
        int valor = (int) r.nextInt(91) + 10;
        return valor;
    }

    public void ingresarInicio() {
        Nodo nuevo = new Nodo();
        nuevo.setDato(crearAleatorios());

        if (estaVacio()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.enlazarA(cabeza);
            cabeza = nuevo;
        }
        cola.enlazarA(cabeza);
        tamaño++;
    }

    public void ingresarFinal() {
        Nodo nuevo = new Nodo();
        nuevo.setDato(crearAleatorios());

        if (estaVacio()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.enlazarA(nuevo);
            cola = nuevo;
        }
        cola.enlazarA(cabeza);
        tamaño++;
    }

    public void recorrido() {
        int contador = 0;
        if (estaVacio()) {
            System.out.println("La lista esta vacia");
        } else {
            Nodo temp = cabeza;
//            do {
//                System.out.println("[" + temp.getDato() + "] -> ");
//                temp = temp.obtenerSiguiente();
//            } while (temp != cabeza);
        while (contador < tamaño){
            System.out.print("["+temp.getDato()+"] -> ");
            temp = temp.obtenerSiguiente();
            contador++;
        }    
        }
    }

    public int getTamaño() {
        return this.tamaño;
    }

    public void contarPrimos() {
        if (estaVacio()) {
            System.out.println("**Lista vacia**");
        } else {
            int contador = 0;
            int primo = 0;
            Nodo temp = cabeza;
            do {
                for (int i = 0; i <= 100; i++) {
                    if (temp.getDato() % i == 0) {
                        contador++;
                    }
                }

                if (contador == 2) {
                    primo++;
                    System.out.print("[" + temp.getDato() + "] -->");
                }

                contador = 0;
                temp = temp.obtenerSiguiente();
            } while (temp != cabeza);
            System.out.println("Hay " + primo + " numero(s) primo(s)");
        }
    }

    public void modificarPar(int numero) {
        int contador = 0;
        if (estaVacio()) {
            System.out.println("**Lista vacia**");
        } else {
            Nodo temp = cabeza;
            while (contador < tamaño) {
                if (temp.getDato() % 2 == 0) {
                    temp.setDato(numero);
                }
                temp = temp.obtenerSiguiente();
                contador++;
            }
        }
    }

    //Metodos para eliminar*****************************************************
    public void eliminarInicio() {
        if (estaVacio()) {
            System.out.println("**Lista vacia**");
        } else {
            System.out.println("Se elimino el numero : " + cabeza.getDato());
            cabeza = cabeza.obtenerSiguiente();
            tamaño--;
        }

    }

    public void eliminarUltimo() {
        if (estaVacio()) {
            System.out.println("**Lista vacia**");
        } else {
            System.out.println("Se elimon el numero : " + cola.obtenerSiguiente().getDato());
            cola = cola.obtenerSiguiente();
            tamaño--;
        }
    }

    public void eliminarPos(int pos) {
        int contador = 0;
        Nodo temp = cabeza;
        if (estaVacio()) {
            System.out.println("**Lista vacia**");
        } else {
            while (contador < pos - 1) {
                temp = temp.obtenerSiguiente();
                contador++;
            }
            System.out.println("Se elimon el numero : " + temp.obtenerSiguiente().getDato());
            temp.enlazarA(temp.obtenerSiguiente().obtenerSiguiente());
            tamaño--;
        }
    }
    //**************************************************************************

    //Metodo para buscar elemento***********************************************
    public boolean buscarElemento(int numero) {
        int contador = 0;
        Nodo temp = cabeza;
        if (estaVacio()) {
            System.out.println("**Lista vacia**");
        } else {
            while (contador < tamaño) {
                if (numero == temp.getDato()) {
                    System.out.println("Buscando ....");
                    System.out.println("Resultados");
                    System.out.println("[" + temp.getDato() + "] Se encuntra en la posicion (" + contador + ")");
                    return true;
                }

                temp = temp.obtenerSiguiente();
                contador++;
            }
        }
        return false;
    }

    //Metodo para ordenar de menor a mayor *************************************
    //por insercion **** falta trabajar  **********
    public void ordenarInsercion() {
        int contador = 0;
        Nodo temp = cabeza;
        Nodo izquierda = null;
        int pos;
        if (estaVacio()) {
            System.out.println("**Lista vacia**");
        } else {
            while (contador < tamaño) {
                pos = contador;
                Nodo aux = cabeza;
                while ((pos > 0) && (izquierda.getDato() > aux.getDato())) {
                    temp = izquierda;
                    pos--;
                }
                temp = aux;
                temp = temp.obtenerSiguiente();
                contador++;
            }
        }
    }

    //ordenando mediante el metodo burbuja*****falta trabajar
    public void ondenarBurbuja() {
        Nodo temp = cabeza;
        Nodo temp2 = cabeza;
        Nodo aux = new Nodo();
        for (int i = 0; i < (tamaño); i++) {
            for (int j = 0; j < (tamaño); j++) {
                if (temp.getDato() < temp.obtenerSiguiente().getDato()) {//si numeroActual es mayor al numeroSiguiente
                    //cambio
                    //guardamos en aux el dato del snumeroSigueine
                    aux.setDato(temp.obtenerSiguiente().getDato());
                    
                    //a numeroSiguiente asignamos el valor del numeroActual
                    temp.obtenerSiguiente().setDato(temp.getDato());
                    
                    //a numeroActual asignamos el valor del numeroSiguiente
                    temp.setDato(aux.getDato());
                }
                temp = temp.obtenerSiguiente();
            }
//            temp = cabeza;
            temp2 = temp2.obtenerSiguiente();
            temp = temp2;
        }
        System.out.println("Se logro el ordenamiento...");
    }

    //Metodo para modificar elemento********************************************
    public void modificarElemento(int numero, int nuevo) {
        int contador = 0;
        Nodo temp = cabeza;
        if (estaVacio()) {
            System.out.println("**Lista vacia**");
        } else {
            while (contador < tamaño) {
                if (temp.getDato() == numero) {
                    //hacer el cambio
                    temp.setDato(nuevo);
                }
                temp = temp.obtenerSiguiente();
                contador++;
            }
        }
    }

    //metodo para intercambiar el elemento mayor con el ultimo elemento +*******
    public void intercambioMayorConUltimo() {
        int contador = 0;
        int mayor = 0;
        Nodo temp = cabeza;
        Nodo aux = new Nodo();
        Nodo aux2 = new Nodo();
        if (estaVacio()) {
            System.out.println("**Lista vacia**");
        } else {
            while (contador < tamaño) {
                if (temp.getDato() > mayor) {
                    mayor = temp.getDato();
                    aux = temp;
                }
                temp = temp.obtenerSiguiente();
                contador++;
            }
            aux2.setDato(cola.getDato());
            cola.setDato(mayor);
            aux.setDato(aux2.getDato());
            System.out.println("Se cambio con exito...");
        }
    }

    //metodo para intercambiar el elemento menor con el primer elemento +*******
    public void intercambioMenorConPrimer() {
        int contador = 0;
        int menor = cabeza.getDato();
        Nodo temp = cabeza;
        Nodo aux = new Nodo();
        Nodo aux2 = new Nodo();
        if (estaVacio()) {
            System.out.println("**Lista vacia**");
        } else {
            while (contador < tamaño) {
                if (temp.getDato() < menor) {
                    menor = temp.getDato();
                    aux = temp;
                }
                temp = temp.obtenerSiguiente();
                contador++;
            }
            aux2.setDato(cabeza.getDato());
            cabeza.setDato(menor);
            aux.setDato(aux2.getDato());
            System.out.println("Se cambio con exito...");
        }
    }

    //metodo para intercambiar el elemento menor con el primer elemento +*******
    public void intercambioParConImpar() {
        int contador = 0;
        int par = 0;
        int impar = 0;
        Nodo temp = cabeza;
        Nodo aux = new Nodo();
        Nodo aux2 = new Nodo();
        if (estaVacio()) {
            System.out.println("**Lista vacia**");
        } else {
            while (contador < tamaño) {
                if (temp.getDato() % 2 == 0) {
                    par = temp.getDato();
                    aux = temp;
                    break;
                }

                temp = temp.obtenerSiguiente();
                contador++;
            }
            contador = 0;
            temp = cabeza;
            while (contador < tamaño) {
                if (temp.getDato() % 2 != 0) {
                    impar = temp.getDato();
                    aux2 = temp;
                    break;
                }
                temp = temp.obtenerSiguiente();
                contador++;
            }

            aux.setDato(impar);
            aux2.setDato(par);
            System.out.println("Se cambio con exito...");
        }
    }

}
