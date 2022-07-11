package Proyecto_1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.*;

import com.itextpdf.text.DocumentException;

public class Menu_Principal {
	
	JFrame principal=new JFrame(); 
	JTabbedPane pestañas=new JTabbedPane();
	
	//Paneles para pestañas
	JPanel sucursales=new JPanel();
	JPanel productos=new JPanel();
	JPanel clientes=new JPanel();
	JPanel vendedores=new JPanel();
	
	Sucursales_Menu sm=new Sucursales_Menu();
	Productos_Menu pp=new Productos_Menu();
	Clientes_Menu cm=new Clientes_Menu();
	Vendedores_Menu vm=new Vendedores_Menu();
	
	private void valores_iniciales() throws ClassNotFoundException {
		
		//Frame datos
		principal.setTitle("Modulo Administrador");
		principal.setLocationRelativeTo(null);
		principal.setBounds(200,20,900,700);
		principal.setVisible(true);
		JButton cerrar=new JButton("Cerrar Sesion");
		cerrar.setBackground(Color.red);
		cerrar.setForeground(Color.white);
		cerrar.setBounds(670,0,200,20);
		
		//Funcion cerrar
		ActionListener funcion_cerrar = new ActionListener() {

		 @Override
		public void actionPerformed(ActionEvent e) {

		 Inicio log=new Inicio();
		 log.ejecutar();
		 
		 principal.setVisible(false);

		 }
		};

		 // Acción del evento
		cerrar.addActionListener(funcion_cerrar);
		
		principal.add(cerrar);
		principal.add(pestañas);
		
		
		
		//color de los paneles
		sucursales.setBackground(Color.cyan);
		productos.setBackground(Color.yellow);
		clientes.setBackground(Color.gray);
		vendedores.setBackground(Color.blue);
		
		sucursales.setLayout(null);
		productos.setLayout(null);
		clientes.setLayout(null);
		vendedores.setLayout(null);
		
		//agregamos los paneles
		pestañas.addTab("Sucursales", sucursales);
		pestañas.addTab("Productos", productos);
		pestañas.addTab("Clientes", clientes);
		pestañas.addTab("Vendedores", vendedores);
		
		sm.ejecutar();
		sucursales.add(sm.crear);		
		sucursales.add(sm.carga);
		sucursales.add(sm.actualizar);
		sucursales.add(sm.eliminar);
		sucursales.add(sm.pdf);
		sucursales.add(sm.sp);
		
		pp.ejecutar();
		productos.add(pp.crear);		
		productos.add(pp.carga);
		productos.add(pp.actualizar);
		productos.add(pp.eliminar);
		productos.add(pp.pdf);
		productos.add(pp.sp);
		
		cm.ejecutar();
		clientes.add(cm.crear);		
		clientes.add(cm.carga);
		clientes.add(cm.actualizar);
		clientes.add(cm.eliminar);
		clientes.add(cm.pdf);
		clientes.add(cm.sp);
		
		vm.ejecutar();
		vendedores.add(vm.crear);		
		vendedores.add(vm.carga);
		vendedores.add(vm.actualizar);
		vendedores.add(vm.eliminar);
		vendedores.add(vm.pdf);
		vendedores.add(vm.sp);
	}
	
	public void cerrar() {
		principal.setVisible(false);
		
	}
	
	public void ejecutar() throws ClassNotFoundException{
		valores_iniciales();
	}
	
}
