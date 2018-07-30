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
import model.classes.Usuario;
import model.dao.AlunoDao;

public class AlunoServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlunoDao alunoDao = new AlunoDao();
        Gson gson = new Gson();
        String cpf = request.getParameter("cpf");
        try {
            if(alunoDao.getAluno(cpf)==null){
                response.sendError(404);
            }
            else{
                response.setContentType("application/json");
                response.getWriter().write(gson.toJson(alunoDao.getAluno(cpf)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlunoDao alunoDao = new AlunoDao();
        Gson gson = new Gson();
        try {
            alunoDao.postAluno(gson.fromJson(request.getReader(), Usuario.class));
        } catch (SQLException ex) {
            Logger.getLogger(AlunoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlunoDao alunoDao = new AlunoDao();
        Gson gson = new Gson();
        try {
            alunoDao.putAluno(gson.fromJson(request.getReader(), Usuario.class));
        } catch (SQLException ex) {
            Logger.getLogger(AlunoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlunoDao alunoDao = new AlunoDao();
        Gson gson = new Gson();
        alunoDao.deleteAluno(gson.fromJson(request.getReader(), Usuario.class));
        response.setStatus(200);
    }

}
