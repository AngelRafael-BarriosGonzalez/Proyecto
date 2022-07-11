package Proyecto_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javax.swing.*;

public class Inicio implements Serializable{
	//Atributo
	JFrame Inicio=new JFrame();
	JPanel p1=new JPanel();
	JLabel l1=new JLabel();
	JLabel l2=new JLabel();
	JTextField t1=new JTextField();
	JPasswordField t2=new JPasswordField();
	JButton b1=new JButton();
	Object [][]vendedores=new Object[400][6];
	
	
	//Metodo
	public void frame() {
		Inicio.setTitle("Login");
		Inicio.setLocationRelativeTo(null);
		
		//x y ancho alto
		Inicio.setBounds(400,100,500,500);
		Inicio.setVisible(true);
		p1.setBackground(Color.orange);
		p1.setBounds(300,100,800,500);
		p1.setLayout(null);
		Inicio.add(p1);
		etiquetas();
		
	}
	
	//etiquetas y jtextfield
	public void etiquetas() {
		//etiquetas
		l1.setText("Usuario: ");
		l1.setFont(new Font("Serig", Font.PLAIN, 25));
		l1.setBounds(50,100,110,80);
		l1.setVisible(true);
		p1.add(l1);
		
		l2.setText("Contraseña: ");
		l2.setFont(new Font("Serig", Font.PLAIN, 25));
		l2.setBounds(50,245,180,80);
		l2.setVisible(true);
		p1.add(l2);
		
		//jtextfield
		t1.setBounds(200,115,200,50);
		t2.setBounds(200,255,200,50);
		
		p1.add(t1);
		p1.add(t2);
		
	}
	
	public void botones() {
		b1.setText("Ingresar");
		b1.setBounds(200,380,100,40);
		p1.add(b1);
		
		// Funcionalidad
		ActionListener ingresar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//cargar archivo
				try {
					
					ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("tabla_vendedores.dat"));
					
					vendedores = (Object[][]) recuperar.readObject();
					recuperar.close();
					
					} 
				
				catch (IOException o) {
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}

				if (t1.getText().equals("Admin") && t2.getText().equals("Admin")) {
					JOptionPane.showMessageDialog(null, "Bienvenido");
					Inicio.setVisible(false);
					
					Menu_Principal mp=new Menu_Principal();
					
					try {
						mp.ejecutar();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
					
				
				else {
					Boolean acceso=false;
					for (int i = 0; i < vendedores.length; i++) {
						if(t1.getText().equals(vendedores[i][1]) && t2.getText().equals(vendedores[i][5])) {
							acceso=true;
							break;
						}
					}
					if(acceso==true) {
						JOptionPane.showMessageDialog(null, "Bienvenido");
						Inicio.setVisible(false);
						Menu_Vendedores mv=new Menu_Vendedores();
						
						try {
							mv.ejecutar();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Usuario Equivocado, no existente");
					}
				}
			}
		};

		// Acción del evento
		b1.addActionListener(ingresar);
	}
	
	public void ejecutar( ) {
		frame();
		etiquetas();
		botones();
	}

	public static void main(String[] args) {
		Inicio p1=new Inicio();
		p1.ejecutar();
	}
}
