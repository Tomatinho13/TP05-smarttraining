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
import model.dao.MusculoDao;
import model.classes.Musculo;

/**
 *
 * @author Tomatinho
 */

public class MusculoServlet extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MusculoDao musculoDao = new MusculoDao();
        Gson gson = new Gson();
        String seq = request.getParameter("seq");
        try {
            if(musculoDao.getMusculo(seq)==null){
                response.sendError(404);
            }
            else{
                response.setContentType("application/json");
                response.getWriter().write(gson.toJson(musculoDao.getMusculo(seq)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MusculoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MusculoDao musculoDao = new MusculoDao();
        Gson gson = new Gson();
        try {
            musculoDao.postMusculo(gson.fromJson(request.getReader(), Musculo.class));
        } catch (SQLException ex) {
            Logger.getLogger(MusculoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MusculoDao musculoDao = new MusculoDao();
        Gson gson = new Gson();
        try {
            musculoDao.putMusculo(gson.fromJson(request.getReader(), Musculo.class));
        } catch (SQLException ex) {
            Logger.getLogger(MusculoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MusculoDao musculoDao = new MusculoDao();
        Gson gson = new Gson();
        musculoDao.deleteMusculo(gson.fromJson(request.getReader(), Musculo.class));
        response.setStatus(200);
    }

}
