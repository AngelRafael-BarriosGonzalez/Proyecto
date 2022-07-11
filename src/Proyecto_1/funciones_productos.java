package Proyecto_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class funciones_productos {
	PreparedStatement ps;
    ResultSet rs;
    Connection con;    
    Conexion acceso = new Conexion();
    Producto p = new Producto();
    
    public Producto buscar_producto(int id, int cantidad) {
    	
    	String sql = "select * from productos"; 
    	
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
            	if(id == rs.getInt(1)) {            		
            		if(cantidad < rs.getInt(4)) {
            			p.setCodigo(rs.getInt(1));
                		p.setNombre(rs.getString(2));            		
                		p.setCantidad(rs.getInt(4));
                		p.setPrecio(rs.getInt(5));
                		return p;
            		}else {
            			JOptionPane.showMessageDialog(null, "Cantidad solicitada mayor al inventario, se cuenta con:"+ rs.getInt(4));
            			break;
            		}            		
            	}
            	
            }
            
        } catch (Exception e) {        	
            System.out.println(e);
        }
        return null;
    	
    	
    	
    }
    
    //al realizar la venta
    public void modificar() {}



}