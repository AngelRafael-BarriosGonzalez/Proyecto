package Proyecto_1;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.*;

import org.json.simple.parser.ParseException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Vendedores_Menu implements Serializable{
	
	//botones
	JButton crear=new JButton();
	JButton carga=new JButton();
	JButton actualizar=new JButton();
	JButton eliminar=new JButton();
	JButton pdf=new JButton();
	
	//Matriz
	Object [][]vendedores=new Object [400][6];
	
	//tabla y complemento
	JTable tabla;
	JScrollPane sp;
	
	private void botones() {
		crear.setText("Crear");
		crear.setBounds(550,10,130,70);
		
		//Funcion crear
		ActionListener funcion_crear = new ActionListener() {

		 @Override
		public void actionPerformed(ActionEvent e) {

		 crear();

		 }
		};

		 // Acción del evento
		crear.addActionListener(funcion_crear);
		
		carga.setText("Carga Masiva");
		carga.setBounds(730,10,130,70);
		
		//Funcion Cargar
				ActionListener funcion_carga = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						try {
							carga_masiva();
						} catch (IOException | ParseException e1) {
							e1.printStackTrace();
						}

					}
				};

				//Acción del evento
				carga.addActionListener(funcion_carga);

		
		actualizar.setText("Actualizar");
		actualizar.setBounds(550,120,130,70);
		
		//Funcion actualizar
		ActionListener funcion_actualisar = new ActionListener() {

		 @Override
		public void actionPerformed(ActionEvent e) {

		 modificar();

		 }
		};

		 // Acción del evento
		actualizar.addActionListener(funcion_actualisar);
		
		eliminar.setText("Eliminar");
		eliminar.setBounds(730,120,130,70);
		
		//Funcion eliminar
		ActionListener funcion_eliminar = new ActionListener() {

		 @Override
		public void actionPerformed(ActionEvent e) {

		 eliminar();

		 }
		};

		 // Acción del evento
		eliminar.addActionListener(funcion_eliminar);
		
		pdf.setText("Exportar PDF");
		pdf.setBounds(550,230,310,70);
		
		//Funcion pdf
				ActionListener funcion_pdf = new ActionListener() {

				 @Override
				public void actionPerformed(ActionEvent e) {

				 try {
					generar_pdf();
				} catch (FileNotFoundException | DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				 }
				};

				 // Acción del evento
				pdf.addActionListener(funcion_pdf);
	}
	
	private void tabla() throws ClassNotFoundException {
		String [] datos= {"Codigo","Nombre","Caja","Ventas","Genero"};
		
		vendedores_funciones vf=new vendedores_funciones();
		vendedores=vf.listar();
		tabla = new JTable(vendedores,datos);
		sp = new JScrollPane(tabla);
		sp.setBounds(10,10,500,600);
	}
	
	private void crear() {
		
		JFrame crear=new JFrame();
		JPanel p1=new JPanel();
		p1.setLayout(null);
		
		//etiquetas
		JLabel l1=new JLabel();
		JLabel l2=new JLabel();
		JLabel l3=new JLabel();
		JLabel l4=new JLabel();
		JLabel l5=new JLabel();
		JLabel l6=new JLabel();

		//cajas de texto
		JTextField t1=new JTextField();
		JTextField t2=new JTextField();
		JTextField t3=new JTextField();
		JTextField t4=new JTextField();
		JTextField t5=new JTextField();
		JPasswordField t6=new JPasswordField();
		
		//Boton
		JButton b1 = new JButton();
		
		l1.setText("Codigo: ");
		l1.setFont(new Font("Serig", Font.PLAIN, 25));
		l1.setBounds(45,-8,110,80);
		l1.setVisible(true);
		p1.add(l1);
		
		l2.setText("Nombre: ");
		l2.setFont(new Font("Serig", Font.PLAIN, 25));
		l2.setBounds(45,52,110,80);
		l3.setVisible(true);
		p1.add(l2);
		
		l3.setText("Caja: ");
		l3.setFont(new Font("Serig", Font.PLAIN, 25));
		l3.setBounds(45,112,160,80);
		l3.setVisible(true);
		p1.add(l3);
		
		l4.setText("Ventas: ");
		l4.setFont(new Font("Serig", Font.PLAIN, 25));
		l4.setBounds(45,172,160,80);
		l4.setVisible(true);
		p1.add(l4);
		
		l5.setText("Genero: ");
		l5.setFont(new Font("Serig", Font.PLAIN, 25));
		l5.setBounds(45,232,160,80);
		l5.setVisible(true);
		p1.add(l5);
		
		l6.setText("Password: ");
		l6.setFont(new Font("Serig", Font.PLAIN, 25));
		l6.setBounds(45,292,160,80);
		l6.setVisible(true);
		p1.add(l6);
		
		crear.setTitle("Crear");
		crear.setLocationRelativeTo(null);
		crear.setBounds(400,100,500,500);
		crear.setVisible(true);
		p1.setBackground(Color.blue);
		crear.add(p1);
		
		//jtextfields
		t1.setBounds(200,15,200,40);
		t2.setBounds(200,75,200,40);
		t3.setBounds(200,135,200,40);
		t4.setBounds(200,195,200,40);
		t5.setBounds(200,255,200,40);
		t6.setBounds(200,315,200,40);
		
		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(t5);
		p1.add(t6);
		
		//boton
				b1.setText("Guardar");
				b1.setBounds(165, 390, 150, 60);
				p1.add(b1);

				// Funcionalidad
				ActionListener ingresar = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						vendedores_funciones vf=new vendedores_funciones();
						vf.crear(t2.getText(), Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()), t5.getText(), t6.getText());
						crear.setVisible(false);
					}
				};

				// Acción del evento
				b1.addActionListener(ingresar);
	}
	
	private String leerarchivo() {

		JPanel c1 = new JPanel();
		JFileChooser fc = new JFileChooser();
		int op = fc.showOpenDialog(c1);
		String content = "";
		if (op == JFileChooser.APPROVE_OPTION) {

		File pRuta = fc.getSelectedFile();
		String ruta = pRuta.getAbsolutePath();
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		 try {
		archivo = new File(ruta);
		fr = new FileReader(archivo);
		br = new BufferedReader(fr);
		String linea = "";

		 while ((linea = br.readLine()) != null) {

		 content += linea + "\n";
		}
		return content;

		 } catch (FileNotFoundException ex) {
		String resp = (String) JOptionPane.showInputDialog(null, "No se encontro el archivo");
		} catch (IOException ex) {
		String resp = (String) JOptionPane.showInputDialog(null, "No se pudo abrir el archivo");
		} finally {
		try {
		if (null != fr) {
		fr.close();
		}
		} catch (Exception e2) {
		String resp = (String) JOptionPane.showInputDialog(null, "No se encontro el archivo");
		return "";
		}

		 }
		return content;

		 }
		return null;
		}
	
	private void carga_masiva() throws FileNotFoundException, IOException, ParseException {
		String archivo_retorno = leerarchivo();

		JsonParser parse = new JsonParser();
		JsonArray matriz = parse.parse(archivo_retorno).getAsJsonArray();

		for (int i = 0; i < matriz.size(); i++) {
		JsonObject objeto = matriz.get(i).getAsJsonObject();
		vendedores_funciones vf=new vendedores_funciones();
		vf.crear(objeto.get("nombre").getAsString(),objeto.get("cajas").getAsInt(),objeto.get("ventas").getAsInt(),objeto.get("genero").getAsString(),objeto.get("password").getAsString());
		}
	}
	
	private void eliminar() {
		int posicion = tabla.getSelectedRow();
		
		if (posicion!=-1) {
			
			vendedores_funciones vf=new vendedores_funciones();
			vf.eliminar(Integer.parseInt(vendedores[posicion][0].toString()));
			
		} else {
			JOptionPane.showMessageDialog(null,"Debe seleccionar una Fila");
			}
		tabla.repaint();
		sp.repaint();
	}
	
    private void modificar() {
		
    	int seleccionar=tabla.getSelectedRow();
    	if (seleccionar!=-1) {
    	
    	JFrame crear=new JFrame("Modificar");
		JPanel p3=new JPanel();
		p3.setLayout(null);
		
		//etiquetas
		JLabel l1=new JLabel();
		JLabel l2=new JLabel();
		JLabel l3=new JLabel();
		JLabel l4=new JLabel();
		JLabel l5=new JLabel();
		JLabel l6=new JLabel();

		//cajas de texto
		JTextField t1=new JTextField();
		JTextField t2=new JTextField();
		JTextField t3=new JTextField();
		JTextField t4=new JTextField();
		JTextField t5=new JTextField();
		JPasswordField t6=new JPasswordField();
		
		//Boton
		JButton b1 = new JButton();
		
		l1.setText("Codigo: ");
		l1.setFont(new Font("Serig", Font.PLAIN, 25));
		l1.setBounds(45,-8,110,80);
		l1.setVisible(true);
		p3.add(l1);
		
		l2.setText("Nombre: ");
		l2.setFont(new Font("Serig", Font.PLAIN, 25));
		l2.setBounds(45,52,110,80);
		l3.setVisible(true);
		p3.add(l2);
		
		l3.setText("Caja: ");
		l3.setFont(new Font("Serig", Font.PLAIN, 25));
		l3.setBounds(45,112,160,80);
		l3.setVisible(true);
		p3.add(l3);
		
		l4.setText("Ventas: ");
		l4.setFont(new Font("Serig", Font.PLAIN, 25));
		l4.setBounds(45,172,160,80);
		l4.setVisible(true);
		p3.add(l4);
		
		l5.setText("Genero: ");
		l5.setFont(new Font("Serig", Font.PLAIN, 25));
		l5.setBounds(45,232,160,80);
		l5.setVisible(true);
		p3.add(l5);
		
		l6.setText("Password: ");
		l6.setFont(new Font("Serig", Font.PLAIN, 25));
		l6.setBounds(45,292,160,80);
		l6.setVisible(true);
		p3.add(l6);
		
		crear.setTitle("Crear");
		crear.setLocationRelativeTo(null);
		crear.setBounds(400,100,500,500);
		crear.setVisible(true);
		p3.setBackground(Color.blue);
		crear.add(p3);
		
		//jtextfields
		t1.setBounds(200,15,200,40);
		t2.setBounds(200,75,200,40);
		t3.setBounds(200,135,200,40);
		t4.setBounds(200,195,200,40);
		t5.setBounds(200,255,200,40);
		t6.setBounds(200,315,200,40);
		
		t1.setText(vendedores[seleccionar][0].toString());
		t2.setText(vendedores[seleccionar][1].toString());
		t3.setText(vendedores[seleccionar][2].toString());
		t4.setText(vendedores[seleccionar][3].toString());
		t5.setText(vendedores[seleccionar][4].toString());
		t6.setText(vendedores[seleccionar][5].toString());
		
		p3.add(t1);
		p3.add(t2);
		p3.add(t3);
		p3.add(t4);
		p3.add(t5);
		p3.add(t6);
		
		//boton
				b1.setText("Actualizar");
				b1.setBounds(165, 390, 150, 60);
				p3.add(b1);

				// Funcionalidad
				ActionListener ingresar = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						Vendedor objeto=new Vendedor();
						objeto.setCodigo(Integer.parseInt(t1.getText()));
						objeto.setNombre(t2.getText());
						objeto.setCaja(Integer.parseInt(t3.getText()));
						objeto.setVentas(Integer.parseInt(t4.getText()));
						objeto.setGenero(t5.getText());
						objeto.setPassword(t6.getText());
						
						vendedores_funciones vf=new vendedores_funciones();
						vf.modificar(objeto);
					}
				};

				// Acción del evento
				b1.addActionListener(ingresar);
	} else {
		JOptionPane.showMessageDialog(null,"Debe seleccionar una Fila");
	}
}
    
    private void generar_pdf() throws FileNotFoundException, DocumentException {

   	 FileOutputStream gen = new FileOutputStream("Vendedores.pdf");
   	Document documento = new Document();

   	 PdfWriter.getInstance(documento, gen);
   	documento.open();

   	 Paragraph parrafo = new Paragraph("Vendedores");
   	parrafo.setAlignment(1);
   	documento.add(parrafo);
   	documento.add(new Paragraph("\n"));

   	 for (int i = 0; i < vendedores.length; i++) {

   	 if (vendedores[i][0] == null) {
   	break;
   	} else {
   	documento.add(new Paragraph("Código: " + vendedores[i][0] + " " + "Nombre: " + vendedores[i][1] + " "
   	+ "Caja: " + vendedores[i][2] + " " + "Ventas: " + vendedores[i][3] + " " + "Genero: "
   	+ vendedores[i][4] + " " + "Password: " + vendedores[i][3]));
   	documento.add(new Paragraph("\n\n"));
   	}

   	 }
   	documento.close();
   	JOptionPane.showMessageDialog(null, "El archivo se creo correctamente");
   	try {
   	File vendedores_doc = new File("Vendedores.pdf");
   	Desktop.getDesktop().open(vendedores_doc);
   	} catch (Exception e) {
   	}
   	}
	
	public void ejecutar() throws ClassNotFoundException{
		botones();
		tabla();
	}
}
