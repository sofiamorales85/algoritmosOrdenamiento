package algoritmosOrdenamiento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class GuiAlgoritmosOrdenamiento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textValorNodo;
	private JButton btnSelectionSort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiAlgoritmosOrdenamiento frame = new GuiAlgoritmosOrdenamiento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiAlgoritmosOrdenamiento() {
		setBackground(new Color(0, 167, 247));
		setTitle("Algoritmos de ordenamiento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 499);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		ListaEnlazada lista = new ListaEnlazada();

		JLabel lblNewLabel = new JLabel("Ingrese valor del nodo:");
		lblNewLabel.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		lblNewLabel.setBounds(38, 43, 153, 20);
		contentPane.add(lblNewLabel);

		textValorNodo = new JTextField();
		textValorNodo.setBounds(212, 44, 126, 19);
		contentPane.add(textValorNodo);
		textValorNodo.setColumns(10);

		JLabel lblMesaje = new JLabel("");
		lblMesaje.setForeground(new Color(128, 0, 64));
		lblMesaje.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		lblMesaje.setBounds(23, 73, 429, 20);
		contentPane.add(lblMesaje);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String entrada = textValorNodo.getText();
				if (entrada.equals("")) {
					lblMesaje.setText("Debe ingresar un valor.");
				} else {
					lista.insertar(Integer.valueOf(entrada));
					textValorNodo.setText("");
				}

			}
		});
		btnAgregar.setBounds(348, 43, 109, 21);
		contentPane.add(btnAgregar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(547, 10, 85, 21);
		contentPane.add(btnSalir);

		JLabel lblNewLabel2 = new JLabel("Seleccione una opcion para ordenar la lista:");
		lblNewLabel2.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		lblNewLabel2.setBounds(49, 118, 264, 20);
		contentPane.add(lblNewLabel2);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(113, 113, 113), 2));
		panel.setBounds(21, 103, 611, 342);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblMetodo = new JLabel("");
		lblMetodo.setForeground(new Color(0, 128, 192));
		lblMetodo.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		lblMetodo.setBounds(247, 55, 316, 21);
		panel.add(lblMetodo);

		JTextArea textAreaImprimir = new JTextArea();
		textAreaImprimir.setBounds(247, 84, 316, 160);
		panel.add(textAreaImprimir);
		textAreaImprimir.setLineWrap(true);

		JButton btnInsertionSort = new JButton("Inserción");
		btnInsertionSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lista.esVacia()) {
					lblMesaje.setText("Lista vacía, no hay valores a mostrar.");
				} else {
					lista.insertionSort();
					textAreaImprimir.setText(lista.mostrarLista());
					lblMetodo.setText("Algoritmo 'Insertion sort'");
				}
			}
		});
		btnInsertionSort.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		btnInsertionSort.setBounds(31, 117, 159, 21);
		panel.add(btnInsertionSort);

		JButton btnMergeSort = new JButton("Combinación");
		btnMergeSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lista.esVacia()) {
					lblMesaje.setText("Lista vacía, no hay valores a mostrar.");
				} else {
					lista.mergeSort();
					textAreaImprimir.setText(lista.mostrarLista());
					lblMetodo.setText("Algoritmo 'Merge sort'");
				}
			}
		});
		btnMergeSort.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		btnMergeSort.setBounds(31, 148, 159, 21);
		panel.add(btnMergeSort);

		JButton btnCountingSort = new JButton("Conteo");
		btnCountingSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lista.esVacia()) {
					lblMesaje.setText("Lista vacía, no hay valores a mostrar.");
				} else {
					lista.countingSortAlgo(1);;
					textAreaImprimir.setText(lista.mostrarLista());
					lblMetodo.setText("Algoritmo 'Counting sort'");
				}
			}
		});
		btnCountingSort.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		btnCountingSort.setBounds(31, 179, 159, 21);
		panel.add(btnCountingSort);

		JButton btnRadixSort = new JButton("Raíz");
		btnRadixSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lista.esVacia()) {
					lblMesaje.setText("Lista vacía, no hay valores a mostrar.");
				} else {
					lista.radixSort();
					textAreaImprimir.setText(lista.mostrarLista());
					lblMetodo.setText("Algoritmo 'Radix Sort'");
				}
			}
		});
		btnRadixSort.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		btnRadixSort.setBounds(31, 210, 159, 21);
		panel.add(btnRadixSort);

		btnSelectionSort = new JButton("Selección");
		btnSelectionSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lista.esVacia()) {
					lblMesaje.setText("Lista vacía, no hay valores a mostrar.");
				} else {
					lista.selectionSort();
					textAreaImprimir.setText(lista.mostrarLista());
					lblMetodo.setText("Algoritmo 'selection sort'");
				}
			}
		});

		btnSelectionSort.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		btnSelectionSort.setBounds(31, 55, 159, 21);
		panel.add(btnSelectionSort);

		JButton btnBubbleSort = new JButton("Burbuja");
		btnBubbleSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lista.esVacia()) {
					lblMesaje.setText("Lista vacía, no hay valores a mostrar.");
				} else {
					lista.bubbleSort();
					textAreaImprimir.setText(lista.mostrarLista());
					lblMetodo.setText("Algoritmo 'bubble sort'");
				}
			}
		});

		btnBubbleSort.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		btnBubbleSort.setBounds(31, 86, 159, 21);
		panel.add(btnBubbleSort);

		JButton btnImprimir = new JButton("Mostrar lista");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaImprimir.setText(lista.mostrarLista());
				lblMetodo.setText("");
			}
		});
		btnImprimir.setBounds(436, 24, 127, 21);
		panel.add(btnImprimir);

	}
}
