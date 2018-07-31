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
import model.dao.RegiaoCorporalDao;
import model.classes.RegiaoCorporal;

/**
 *
 * @author Tomatinho
 */

public class RegiaoCorporalServlet extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegiaoCorporalDao regiaoCorporalDao = new RegiaoCorporalDao();
        Gson gson = new Gson();
        String seq = request.getParameter("seq");
        try {
            if(regiaoCorporalDao.getRegiaoCorporal(seq)==null){
                response.sendError(404);
            }
            else{
                response.setContentType("application/json");
                response.getWriter().write(gson.toJson(regiaoCorporalDao.getRegiaoCorporal(seq)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegiaoCorporalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegiaoCorporalDao regiaoCorporalDao = new RegiaoCorporalDao();
        Gson gson = new Gson();
        try {
            regiaoCorporalDao.postRegiaoCorporal(gson.fromJson(request.getReader(), RegiaoCorporal.class));
        } catch (SQLException ex) {
            Logger.getLogger(RegiaoCorporalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegiaoCorporalDao regiaoCorporalDao = new RegiaoCorporalDao();
        Gson gson = new Gson();
        try {
            regiaoCorporalDao.putRegiaoCorporal(gson.fromJson(request.getReader(), RegiaoCorporal.class));
        } catch (SQLException ex) {
            Logger.getLogger(RegiaoCorporalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegiaoCorporalDao regiaoCorporalDao = new RegiaoCorporalDao();
        Gson gson = new Gson();
        regiaoCorporalDao.deleteRegiaoCorporal(gson.fromJson(request.getReader(), RegiaoCorporal.class));
        response.setStatus(200);
    }
}
