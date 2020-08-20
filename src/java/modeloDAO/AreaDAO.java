
package modeloDAO;

import Config.bd.ConectaBd;
import Interfaces.CRUD_Area;
import Modelo.Area;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AreaDAO implements CRUD_Area {
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Area e = new Area();

    @Override
    public List listaarea() {
        ArrayList<Area> areas = new ArrayList<>();
        String consulta = " select * "
                        + " from area ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                Area area = new Area();
                area.setIdarea(rs.getInt("idarea"));
                area.setNombre(rs.getString("nombre"));
                area.setEstado(rs.getString("estado"));
                areas.add(area);
            }
        } catch (Exception e) {
        }
        return areas;
    }

    @Override
    public Area buscararea(int idarea) {
        String consulta = " select * "
                        + " from area  "
                        + " where idarea = "+ idarea +" ; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                e.setIdarea(rs.getInt("idarea"));
                e.setNombre(rs.getString("nombre"));
                e.setEstado(rs.getString("estado"));                
            }
        } catch (Exception e) {
        }
        return e;
    }

    @Override
    public boolean agregararea(Area area) {
        String consulta = " insert into area(nombre, estado) "
                        + " values(  "
                        + "'"+ area.getNombre() +"',  "
                        + "'"+ area.getEstado() +"'); ";

        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean editararea(Area area) {
         String consulta =   " update area  "
                        +   " set "
                        +   " nombre = '"+ area.getNombre() +"',"
                        +   " estado = '"+ area.getEstado() +"'  "
                        +   " where "
                        +   " idarea = "+ area.getIdarea() +" ; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminararea(int idarea) {
        String consulta =   " delete from area "
                        +   " where " 
                        +   " idarea = "+ idarea +" ; ";

        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
        
    }
    
    public boolean validareliminacion(int idarea) {
        boolean valido = true;
        String consulta = "select * from sugerencia where idarea = "+idarea;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            
            if(rs.last()){
                valido = false;
            }
            
        } catch (Exception e) {
        }
        return valido;
    }


    
}

