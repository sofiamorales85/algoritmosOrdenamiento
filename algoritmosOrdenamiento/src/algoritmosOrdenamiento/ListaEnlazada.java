package algoritmosOrdenamiento;

import java.util.Arrays;

public class ListaEnlazada {
	NodoLista inicio, ultimo;
	int numElementos;

	// Constructor
	public ListaEnlazada() {
		inicio = null;
		ultimo = null;
		numElementos = 0;
	}

	/**
	 * Metodo para verificar si la lista es vacía
	 * 
	 * @return true o false según sea el caso.
	 */
	public boolean esVacia() {
		if (inicio == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Consulta cuantos elementos (nodos) tiene la lista.
	 */
	public int getTamanio() {
		return numElementos;
	}

	/**
	 * Metodo para agregar nodo al final
	 */
	public void insertar(int datoNodo) {
		NodoLista nuevo = new NodoLista(datoNodo, null);

		if (esVacia()) {
			inicio = nuevo;
			ultimo = nuevo;
			System.out.println("Valor nodo primero " + inicio.getDatoNodo());
			System.out.println("Valor nodo ultimo " + ultimo.getDatoNodo());

		} else {
			ultimo.setSiguiente(nuevo);
			ultimo = nuevo;
			System.out.println("Valor nodo primero " + inicio.getDatoNodo());
			System.out.println("Valor nodo ultimo " + ultimo.getDatoNodo());
		}
		numElementos++;
		System.out.println("Lista cantidad de elementos: " + getTamanio());
	}

	/**
	 * Metodo de ordenación Selection Sort, busca el nodo de menor valor y lo coloca
	 * al inicio
	 */
	public void selectionSort() {
		NodoLista actual = inicio;

		while (actual != null) {
			NodoLista minimo = actual;
			NodoLista temporal = actual.getSiguiente();

			while (temporal != null) {
				if (temporal.getDatoNodo() < minimo.getDatoNodo()) {
					minimo = temporal;
				}
				temporal = temporal.getSiguiente();
			}

			// Intercambiar los valores
			int temp = actual.getDatoNodo();
			actual.setDatoNodo(minimo.getDatoNodo());
			minimo.setDatoNodo(temp);

			actual = actual.getSiguiente();
		}
	}

	/**
	 * Metodo de ordenación Burbuja , recorre toda la lista uno por uno cambiando el
	 * primer nodo, si es mayor hasta llegar el ultimo y que todo este ordenado.
	 */
	public void bubbleSort() {
		boolean intercambiado;
		NodoLista actual;
		NodoLista siguiente = null;

		do {
			intercambiado = false;
			actual = inicio;

			while (actual.getSiguiente() != siguiente) {
				if (actual.getDatoNodo() > actual.getSiguiente().getDatoNodo()) {
					// Intercambiar los valores de los nodos
					int temp = actual.getDatoNodo();
					actual.setDatoNodo(actual.getSiguiente().getDatoNodo());
					actual.getSiguiente().setDatoNodo(temp);
					intercambiado = true;
				}
				actual = actual.getSiguiente();
			}
			siguiente = actual;
		} while (intercambiado);
	}

	/**
	 * Metodo de ordenación Insertion sort
	 */
	public void insertionSort() {
		NodoLista actual = inicio.getSiguiente();

		while (actual != null) {
			int valorActual = actual.getDatoNodo();
			NodoLista anterior = inicio;

			// Encontrar el nodo anterior al nodo actual
			while (anterior != actual && anterior.getDatoNodo() <= valorActual) {
				anterior = anterior.getSiguiente();
			}

			// Mover todos los elementos mayores que el valor actual hacia adelante
			while (anterior != actual) {
				int temp = anterior.getDatoNodo();
				anterior.setDatoNodo(valorActual);
				valorActual = temp;
				anterior = anterior.getSiguiente();
			}

			// Asignar el valor actual al nodo correspondiente
			actual.setDatoNodo(valorActual);

			// Mover al siguiente nodo
			actual = actual.getSiguiente();
		}
	}

	
	/**
	 * Metodo merge sort
	 * @return
	 */
	public void mergeSort() {
		inicio = mergeSortRecursivo(inicio);
	}

	private NodoLista mergeSortRecursivo(NodoLista inicio) {
		if (inicio == null || inicio.getSiguiente() == null) {
			return inicio;
		}

		NodoLista mitad = obtenerMitad(inicio);
		NodoLista siguienteMitad = mitad.getSiguiente();
		mitad.setSiguiente(null);

		NodoLista izquierda = mergeSortRecursivo(inicio);
		NodoLista derecha = mergeSortRecursivo(siguienteMitad);

		return merge(izquierda, derecha);
	}

	private NodoLista merge(NodoLista izquierda, NodoLista derecha) {
		NodoLista resultado = null;

		if (izquierda == null) {
			return derecha;
		}
		if (derecha == null) {
			return izquierda;
		}

		if (izquierda.getDatoNodo() <= derecha.getDatoNodo()) {
			resultado = izquierda;
			resultado.setSiguiente(merge(izquierda.getSiguiente(), derecha));
		} else {
			resultado = derecha;
			resultado.setSiguiente(merge(izquierda, derecha.getSiguiente()));
		}

		return resultado;
	}

	private NodoLista obtenerMitad(NodoLista inicio) {
		NodoLista rapido = inicio;
		NodoLista lento = inicio;

		while (rapido != null && rapido.getSiguiente() != null && rapido.getSiguiente().getSiguiente() != null) {
			lento = lento.getSiguiente();
			rapido = rapido.getSiguiente().getSiguiente();
		}

		return lento;
	}
	
	/**
	 * Algoritmo de counting sort 
	 * @return
	 */
	public void countingSortAlgo(int position) {
        final int limit = 10;
        int size = getTamanio();
        int[] result = new int[size];
        int[] count = new int[limit];
        
        Arrays.fill(count, 0); // Inicializar el arreglo de conteo con 0
        
        // Calculando el conteo de cada entero
        NodoLista temp = inicio;
        while (temp != null) {
            count[(temp.getDatoNodo() / position) % 10]++;
            temp = temp.getSiguiente();
        }
        
        // Calculando el conteo acumulativo
        for (int j = 1; j < limit; j++) {
            count[j] += count[j - 1];
        }
        
        // Ordenando los enteros
        temp = inicio;
        while (temp != null) {
            result[count[(temp.getDatoNodo() / position) % 10] - 1] = temp.getDatoNodo();
            count[(temp.getDatoNodo() / position) % 10]--;
            temp = temp.getSiguiente();
        }
        
        // Actualizando la lista original con la lista ordenada
        temp = inicio;
        for (int i = 0; i < size; i++) {
            temp.setDatoNodo(result[i]);
            temp = temp.getSiguiente();
        }
    }
	
	/**
	 * Metodo de ordenación radix Sort
	 */
    public void radixSort() {
        int maximum = getMaximum();
        for (int position = 1; maximum / position > 0; position *= 10)
            countingSortAlgo(position);
    }
    
    private int getMaximum() {
        int max = Integer.MIN_VALUE;
        NodoLista temp = inicio;
        while (temp != null) {
            max = Math.max(max, temp.getDatoNodo());
            temp = temp.getSiguiente();
        }
        return max;
    }

	public String mostrarLista() {
		String listaImprimir = "";
		// Verifica si la lista contiene elementoa.
		System.out.print("\n Número de elementos: " + getTamanio() + "\n");
		if (!esVacia()) {
			// Crea una copia de la lista.Lista
			NodoLista aux = inicio;
			System.out.print("\n---------------Lista ordenada-------------------\n");
			// Recorre la lista hasta llegar nuevamente al incio de la lista.
			while (aux != null) {
				listaImprimir = listaImprimir + "[ " + aux.getDatoNodo() + " ]";
				// Imprime en pantalla el valor del nodo.
				System.out.print("Valor nodo .[ " + aux.getDatoNodo() + " ]" + " ->  ");
				// Avanza al siguiente nodo.
				aux = aux.getSiguiente();
			}
		}
		return listaImprimir;
	}

}
