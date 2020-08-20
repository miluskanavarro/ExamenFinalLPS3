package Controlador;

import Modelo.Area;
import Modelo.Persona;
import modeloDAO.AreaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloDAO.PersonaDAO;

public class Controlador extends HttpServlet {
    
    //Controlador para tabla Persona
    String listarpersona = "vista/ListarPersona.jsp";
    String agregarpersona = "vista/AgregarPersona.jsp";
    String editarpersona = "vista/EditarPersona.jsp";
    Persona persona = new Persona();
    PersonaDAO personaDAO = new PersonaDAO();
    
    
    //Controlador para tabla Area
    String listararea = "vista/ListarArea.jsp";
    String agregararea = "vista/AgregarArea.jsp";
    String editararea = "vista/EditarArea.jsp";
    Area area = new Area();
    AreaDAO areaDAO = new AreaDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String s_accion = request.getParameter("f_accion");
        
        //Persona
        if (s_accion.equalsIgnoreCase("listarpersona")) {
            acceso = listarpersona;
        }else if (s_accion.equalsIgnoreCase("agregarpersona01")) {
            acceso = agregarpersona;
        
        }else if(s_accion.equalsIgnoreCase("agregarpersona02")){
            String s_nombre = request.getParameter("f_nombre");
            String s_apellidos = request.getParameter("f_apellidos");
            String s_dni = request.getParameter("f_dni");
            String s_direccion = request.getParameter("f_direccion");
            String s_estado = request.getParameter("f_estado");
            persona.setNombre(s_nombre);
            persona.setApellidos(s_apellidos);
            persona.setDni(s_dni);
            persona.setDireccion(s_direccion);
            persona.setEstado(s_estado);
            personaDAO.agregarpersona(persona);
            acceso = listarpersona;
        }else if (s_accion.equalsIgnoreCase("editarpersona01")) {
            request.setAttribute("f_idpersona", request.getParameter("f_idpersona"));
            acceso = editarpersona;
        }else if (s_accion.equalsIgnoreCase("editarpersona02")) {
            int s_idpersona = Integer.valueOf(request.getParameter("f_idpersona"));
            String s_nombre = request.getParameter("f_nombre");
            String s_apellidos = request.getParameter("f_apellidos");
            String s_dni = request.getParameter("f_dni");
            String s_direccion = request.getParameter("f_direccion");
            String s_estado = request.getParameter("f_estado");
            persona.setIdpersona(s_idpersona);
            persona.setNombre(s_nombre);
            persona.setApellidos(s_apellidos);
            persona.setDni(s_dni);
            persona.setDireccion(s_direccion);
            persona.setEstado(s_estado);
            personaDAO.editarpersona(persona);
            acceso = listarpersona;
        }else if (s_accion.equalsIgnoreCase("eliminarpersona")) {
            int s_idpersona = Integer.valueOf(request.getParameter("f_idpersona"));
            personaDAO.eliminarpersona(s_idpersona);
            acceso = listarpersona;
            
        //Area
        }else if (s_accion.equalsIgnoreCase("listararea")) {
            acceso = listararea;
        }else if (s_accion.equalsIgnoreCase("agregararea01")) {
            acceso = agregararea;
        }else if (s_accion.equalsIgnoreCase("agregararea02")) {
            String s_nombre = request.getParameter("f_nombre");
            String s_estado = request.getParameter("f_estado");
            area.setNombre(s_nombre);
            area.setEstado(s_estado);
            areaDAO.agregararea(area);
            acceso = listararea;

        }else if (s_accion.equalsIgnoreCase("editararea01")) {
        request.setAttribute("f_idarea", request.getParameter("f_idarea"));
        acceso = editararea;
        }else if (s_accion.equalsIgnoreCase("editararea02")) {
            int s_idarea = Integer.valueOf(request.getParameter("f_idarea"));            
            String s_nombre = request.getParameter("f_nombre");  
            String s_estado = request.getParameter("f_estado");
            area.setIdarea(s_idarea);
            area.setNombre(s_nombre);
            area.setEstado(s_estado);            
            areaDAO.editararea(area);
            acceso = listararea;
        }else if (s_accion.equalsIgnoreCase("eliminararea")) {
            int s_idarea = Integer.valueOf(request.getParameter("f_idarea"));
            areaDAO.eliminararea(s_idarea);
            acceso = listararea;
        }
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
