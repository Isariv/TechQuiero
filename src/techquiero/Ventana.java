/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquiero;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Isabel
 */
public class Ventana extends JFrame {
    //Campos
private JPanel panelDatos;
private JButton jbtAgregar;
private JTextField jtfLibro ;
private JLabel jlblEtiquitaLibro;
private JScrollPane panelChat;
private JLabel jlblEtiquitaPanelChat;
private JList jls;
private JComboBox jcbLibro;
private JLabel jlbLibro;
private JTable tabla;
private DefaultTableModel dtm;
private String[] nombreCols= {"Nombre del libro"};     
private Object[][] datos = {};    
   
    public Ventana (String titulo){
        super(titulo);
        
        this.setLayout(new FlowLayout());

        //Crear el panel de captutrar datos y agragarla a la ventana
        panelDatos = new JPanel(new GridLayout(1,3));
        this.add(panelDatos);


        //Crear cajas de los nombres de los libros
        jtfLibro = new JTextField();
        jbtAgregar = new JButton("Agregar");
        
        //Crear arreglo de Libros
        String libros[] = { "Microservicios : Christian Posta : $45.98",
                            "Patrones de diseño: Markus Eisele: $72.80",
                            "Programación Orientada a Objetos: Richard Warbuton: $36.72",
                            "Aprendiendo Java: Ben Evans: $66.81",
                            "Aprendiendo Python: David Mertz: $43.27",
                            "Big Data con Hadoop: Donald Miner: $39.60",
                            "IOS con Swift: Tim Nugent: $24.18",
                            "Programación reactiva: Konrad Malawski: $58.70",
                            "Programación con C: Joel Falcou: $67.93",
                            "Diseño de sistemas: Doug Davis: $55.67",


                                                                };
        //Crear caja combo
        jcbLibro = new JComboBox(libros);
        
        //Agregar caja combo al panel
        this.add(jcbLibro);
        
        //Crear caja de texto
        jtfLibro = new JTextField(18);
        
        //Agregar caja de texto a la ventana
        this.add(jtfLibro);
        
        jcbLibro.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                //Verificar si entró en la parte de selección 
                if(ie.getStateChange()==ItemEvent.SELECTED){
                    System.out.println("SELECTED");
                    
                    //Obtener elemento seleccionado y ponerlo en caja de texto
                    jtfLibro.setText((String)jcbLibro.getSelectedItem());
                    
                }else if (ie.getStateChange()==ItemEvent.DESELECTED){
                }
            }
        });

        //Agregar a panel de Datos los elementos
        panelDatos.add(jbtAgregar); 
       // Crear objeto del modelo
        dtm = new DefaultTableModel(datos, nombreCols);
        // Crear tabla a partir del modelo
        tabla = new JTable(dtm);
        // Establecer tamaño a visualizar
        tabla.setPreferredScrollableViewportSize(new Dimension(800, 200));
        // Agregar tabla a ventana dentro de un panel de desplazamiento
        panelChat = new JScrollPane(tabla);
        this.add(panelChat);
      
         // Gestión de eventos botón Agregar
        jbtAgregar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                //Obtener los textos de las cajas de texto
                String lib = jtfLibro.getText();
                //anadir el los textos a la Tabla
                // Nueva fila
                Object[] nuevaFila={lib};
                // Agregar fila al modelo
                dtm.addRow(nuevaFila);
            }
           
        });
        
    crearArchivo("Libros.txt",datos.toString());  
    
        
    }//Fin del Constructor

    @Override
    public String toString() {
        return "Ventana{" + "datos=" + datos + '}';
    }
     
	public static void crearArchivo(String nombreArchivo, String texto) {
		
		FileWriter  fichero = null;
		PrintWriter pw = null;
		
		try {
			fichero = new FileWriter("C://Users//Isabel//Desktop//"+ nombreArchivo );
			
			pw = new PrintWriter(fichero);
			pw.println(texto);
				
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			if(fichero != null) {
			
				try {
					fichero.close();
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
				
				}
			}
		}	

	}
    
}
