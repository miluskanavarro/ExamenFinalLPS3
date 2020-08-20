<%@page import="modeloDAO.PersonaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Area"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.AreaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Areas</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Listado de Areas</h1>
            <a class="btn btn-success" href="Controlador?f_accion=agregararea01">Agregar Area</a>
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
                        AreaDAO AreaDAO = new AreaDAO();
                        List<Area> areas = AreaDAO.listaarea();
                        Iterator<Area> iterator = areas.iterator();
                        Area area = null;
                        while (iterator.hasNext()) {
                            area = iterator.next();

                    %>
                    <tr>
                        <td class="text-center"><% out.print(area.getIdarea()); %></td>
                        <td><% out.print(area.getNombre()); %></td>
                        <td class="text-center"><% out.print(area.getEstado()); %></td>                        
                        <td class="text-center">
                            <a class="btn btn-warning" href="Controlador?f_accion=editararea01&f_idarea=<% out.print(area.getIdarea()); %>">
                                Editar
                            </a>
                            <%
                                if(AreaDAO.validareliminacion(area.getIdarea())==true){
                            %>
                            <a class="btn btn-danger" href="Controlador?f_accion=eliminararea&f_idarea=<% out.print(area.getIdarea()); %>">
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
