package controller.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.ObjetivoDao;
import model.classes.Objetivo;

/**
 *
 * @author Tomatinho
 */

public class ObjetivoServlet extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjetivoDao objetivoDao = new ObjetivoDao();
        Gson gson = new Gson();
        String seq = request.getParameter("seq");
        try {
            if(objetivoDao.getObjetivo(seq)==null){
                response.sendError(404);
            }
            else{
                response.setContentType("application/json");
                response.getWriter().write(gson.toJson(objetivoDao.getObjetivo(seq)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObjetivoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjetivoDao objetivoDao = new ObjetivoDao();
        Gson gson = new Gson();
        try {
            objetivoDao.postObjetivo(gson.fromJson(request.getReader(), Objetivo.class));
        } catch (SQLException ex) {
            Logger.getLogger(ObjetivoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjetivoDao objetivoDao = new ObjetivoDao();
        Gson gson = new Gson();
        try {
            objetivoDao.putObjetivo(gson.fromJson(request.getReader(), Objetivo.class));
        } catch (SQLException ex) {
            Logger.getLogger(ObjetivoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjetivoDao objetivoDao = new ObjetivoDao();
        Gson gson = new Gson();
        objetivoDao.deleteObjetivo(gson.fromJson(request.getReader(), Objetivo.class));
        response.setStatus(200);
    }

}
