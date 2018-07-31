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
import model.classes.Aparelho;
import model.dao.AparelhoDao;

/**
 *
 * @author Tomatinho
 */

public class AparelhoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AparelhoDao aparelhoDao = new AparelhoDao();
        Gson gson = new Gson();
        String numero = request.getParameter("numero");
        try {
            if(aparelhoDao.getAparelho(numero)==null){
                response.sendError(404);
            }
            else{
                response.setContentType("application/json");
                response.getWriter().write(gson.toJson(aparelhoDao.getAparelho(numero)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AparelhoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AparelhoDao aparelhoDao = new AparelhoDao();
        Gson gson = new Gson();
        try {
            aparelhoDao.postAparelho(gson.fromJson(request.getReader(), Aparelho.class));
        } catch (SQLException ex) {
            Logger.getLogger(AparelhoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AparelhoDao aparelhoDao = new AparelhoDao();
        Gson gson = new Gson();
        try {
            aparelhoDao.putAparelho(gson.fromJson(request.getReader(), Aparelho.class));
        } catch (SQLException ex) {
            Logger.getLogger(AparelhoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AparelhoDao aparelhoDao = new AparelhoDao();
        Gson gson = new Gson();
        aparelhoDao.deleteAparelho(gson.fromJson(request.getReader(), Aparelho.class));
        response.setStatus(200);
    }

}
