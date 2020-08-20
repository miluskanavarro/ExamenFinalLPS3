<%@page import="Modelo.Rol"%>
<%@page import="modeloDAO.RolDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Rol</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Listado de Rol</h1>
            <a class="btn btn-success" href="Controlador?f_accion=agregarrol01">Agregar Rol</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Estado</th>
                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        RolDAO RolDAO = new RolDAO();
                        List<Rol> roles = RolDAO.listarol();
                        Iterator<Rol> iterator = roles.iterator();
                        Rol rol = null;
                        while (iterator.hasNext()) {
                            rol = iterator.next();

                    %>
                    <tr>
                        <td class="text-center"><% out.print(rol.getIdrol()); %></td>
                        <td><% out.print(rol.getNombre()); %></td>
                        <td class="text-center"><% out.print(rol.getEstado()); %></td>                        
                        <td class="text-center">
                            <a class="btn btn-warning" href="Controlador?f_accion=editarrol01&f_idrol=<% out.print(rol.getIdrol()); %>">
                                Editar
                            </a>
                            <%
                                if(RolDAO.validareliminacion(rol.getIdrol())==true){
                            %>
                            <a class="btn btn-danger" href="Controlador?f_accion=eliminarrol&f_idrol=<% out.print(rol.getIdrol()); %>">
                                Eliminar
                            </a>
                            <%}else{
                            %>
                            <a class="btn btn-danger disabled">
                                    Eliminar
                            </a>
                            <% } %>
                        </td>
                    </tr>
                    <% 
                        }
                    %>
                </tbody>
            </table>
            <table border="0" cellspacing="0" cellpagging="0" align="center">

                <tr>
                    <td> </td>
                    <td colspan="2"><a class="btn btn-success"href="index.html"><FONT COLOR="white">Regresar</a></td>
                </tr>
                    
            </table>
        </div>
    </body>
</html>
