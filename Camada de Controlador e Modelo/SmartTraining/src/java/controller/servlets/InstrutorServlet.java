package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.classes.Instrutor;
import model.dao.InstrutorDao;

public class InstrutorServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InstrutorDao instrutorDao = new InstrutorDao();
        Gson gson = new Gson();
        String cpf = request.getParameter("cpf");
        try {
            if(instrutorDao.getInstrutor(cpf)==null){
                response.sendError(404);
            }
            else{
                response.setContentType("application/json");
                response.getWriter().write(gson.toJson(instrutorDao.getInstrutor(cpf)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstrutorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InstrutorDao instrutorDao = new InstrutorDao();
        Gson gson = new Gson();
        try {
            instrutorDao.postInstrutor(gson.fromJson(request.getReader(), Instrutor.class));
        } catch (SQLException ex) {
            Logger.getLogger(InstrutorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InstrutorDao instrutorDao = new InstrutorDao();
        Gson gson = new Gson();
        try {
            instrutorDao.putInstrutor(gson.fromJson(request.getReader(), Instrutor.class));
        } catch (SQLException ex) {
            Logger.getLogger(InstrutorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InstrutorDao instrutorDao = new InstrutorDao();
        Gson gson = new Gson();
        instrutorDao.deleteInstrutor(gson.fromJson(request.getReader(), Instrutor.class));
        response.setStatus(200);
    }

}
