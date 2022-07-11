package Proyecto_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class cliente_funciones {
	PreparedStatement ps;
    ResultSet rs;
    Connection con;    
    Conexion acceso = new Conexion();
    Object [][] listar;
    
    
    
public Object[][] listar() {
    	
    	String sql="select*from cliente";
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
    			listar[y][2]=rs.getInt(3);
    			listar[y][3]=rs.getString(4);
    			listar[y][4]=rs.getString(5);
    			y++;
    		}
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	
    	return listar;
    }

}
