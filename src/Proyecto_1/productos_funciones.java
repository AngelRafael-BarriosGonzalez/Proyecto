package Proyecto_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class productos_funciones {
	PreparedStatement ps;
    ResultSet rs;
    Connection con;    
    Conexion acceso = new Conexion();
    Producto p = new Producto();
    Object [][] listar;
    
    
    public void crear (String nombre, String descripcion, int cantidad, int precio) {
    	String sql = "insert into productos(nombre,descripcion,cantidad,precio)values(?,?,?,?)";
    	
    	try {
    		con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setInt(3, cantidad);
            ps.setInt(4, precio);
            ps.executeUpdate();
    	}
    	catch (Exception e) {
			System.out.println(e);
		}
    	
        
    }
    
    public void modificar(Producto p) {
    	String sql = "update productos set nombre=?, descripcion=?, cantidad=?, precio=? where codigo=?";
        
    	try {
    		con = acceso.Conectar();
            ps = con.prepareStatement(sql);            
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setInt(3, p.getCantidad());
            ps.setInt(4, p.getPrecio());
            ps.setInt(5, p.getCodigo());
            ps.executeUpdate();
    	}
    	catch (Exception e) {
			System.out.println(e);
		}
    	
    }
    
    public void eliminar(int id) {
        String sql = "delete from productos where codigo=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        	System.out.println(e);
        }
    }    
    
    public Object[][] listar() {
    	
    	String sql="select*from productos";
    	int filas=0;
    	
    	try {
    		con=acceso.Conectar();
    		ps=con.prepareStatement(sql);
    		rs=ps.executeQuery();
    		
    		while(rs.next()) {
    			filas++;
    			
    		}
    		
    		listar=new Object[filas][5];
    		int y=0;
    		con=acceso.Conectar();
    		ps=con.prepareStatement(sql);
    		rs=ps.executeQuery();
    		
    		while (rs.next()) {
    			
    			listar[y][0]=rs.getInt(1);
    			listar[y][1]=rs.getString(2);
    			listar[y][2]=rs.getString(3);
    			listar[y][3]=rs.getInt(4);
    			listar[y][4]=rs.getInt(5);
    			y++;
    		}
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	
    	return listar;
    }

}
