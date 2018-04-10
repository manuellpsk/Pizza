package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Controlador extends HttpServlet {
    
    
        private static ArrayList<Agregado> agreg=new ArrayList();
        
    
    public static int preciop(String tam,String masa,String bebida){
    
    
        int costop=0;
        int [][] precios=new int [3][3];
        precios[0][0]=1000;precios[0][1]=2000;precios[0][2]=3000;
        precios[1][0]=1000;precios[1][1]=1500;
        precios[2][0]=800;precios[2][1]=700;precios[2][2]=750;
        
        
        int itam=0,imasa=0,ibebida=0;
        if(tam.startsWith("Median")){itam=1;}
        else if(tam.startsWith("Grande")){itam=2;}
        costop=costop+precios[0][itam];
        
        if(masa.startsWith("B")){imasa=1;}
        costop=costop+precios[1][imasa];
              
        if(bebida.startsWith("Pep")){ibebida=1;}
        else if(bebida.startsWith("Spr")){ibebida=2;}
        costop=costop+precios[2][ibebida];
        
        return costop;
    
    }
    public static String preciofinal(int costop,String[] agregados){
    
        int fin=costop;
        
        if(agregados!=null){
        
            for(String x:agregados){
            
                int ind=Integer.parseInt(x)-1;
                fin+=agreg.get(ind).getPrecio();
            }
        }
        return String.valueOf(fin);
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        agreg.add(new Agregado(1,"Queso",1000));
        agreg.add(new Agregado(2,"Champ",1500));
        agreg.add(new Agregado(3,"Papas",800));    
        String tam=request.getParameter("cboxtam");
        String  masa=request.getParameter("cboxmasa");
        String  bebida=request.getParameter("cboxbebida");
        String ar[]=request.getParameterValues("agre");
        int pp=preciop(tam, masa, bebida);
        String xx="hay algo";
        
        String pf=preciofinal(pp, ar);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><center>"+"Usted Solicito"+"</center></h1>");
            out.println("<pre>Tamaño de Pizza:   "+tam+"</pre>"+
                        "<pre>Tipo de Masa:      "+masa+"</pre>"+
                        "<pre>Bebida:            "+bebida+"</pre>"+
                        "<pre>Agregados:         ");
            if(ar!=null){
            for(String q:ar){
            
                out.println("                       "+agreg.get(Integer.parseInt(q)-1).getNombre()+
                            " - "+agreg.get(Integer.parseInt(q)-1).getPrecio()+
                            "<br>");
                
            }   out.println("</pre>");
            }else{out.println(
                         "                          No hay agregados"+"</pre>");}
            out.println("<br><hr noshade>Resutaldo de la Compra: "+pf);
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
        processRequest(request, response);
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
