package algoritmosOrdenamiento;

/**
 * @author JennyMorales 7690-08-6790
 */

public class NodoLista {
	private NodoLista siguiente;
	private int datoNodo;
	
	//Constructor
	public NodoLista(int dato, NodoLista siguiente) {
		this.datoNodo = dato;
		this.siguiente = siguiente;
	}

	public NodoLista getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoLista siguiente) {
		this.siguiente = siguiente;
	}

	public int getDatoNodo() {
		return datoNodo;
	}

	public void setDatoNodo(int datoNodo) {
		this.datoNodo = datoNodo;
	}

}
