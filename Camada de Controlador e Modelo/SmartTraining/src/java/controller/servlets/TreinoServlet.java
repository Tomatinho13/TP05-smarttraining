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
import model.dao.TreinoDao;
import model.classes.Treino;

/**
 *
 * @author Tomatinho
 */

public class TreinoServlet extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TreinoDao treinoDao = new TreinoDao();
        Gson gson = new Gson();
        String cpf = request.getParameter("cpf");
        try {
            if(treinoDao.getTreino(cpf)==null){
                response.sendError(404);
            }
            else{
                response.setContentType("application/json");
                response.getWriter().write(gson.toJson(treinoDao.getTreino(cpf)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TreinoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TreinoDao treinoDao = new TreinoDao();
        Gson gson = new Gson();
        try {
            treinoDao.postTreino(gson.fromJson(request.getReader(), Treino.class));
        } catch (SQLException ex) {
            Logger.getLogger(TreinoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TreinoDao treinoDao = new TreinoDao();
        Gson gson = new Gson();
        try {
            treinoDao.putTreino(gson.fromJson(request.getReader(), Treino.class));
        } catch (SQLException ex) {
            Logger.getLogger(TreinoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TreinoDao treinoDao = new TreinoDao();
        Gson gson = new Gson();
        String nroFicha = request.getParameter("nroFicha");
        String nroTreino = request.getParameter("nroTreino");

        treinoDao.deleteTreino(gson.fromJson(request.getReader(), Treino.class), nroFicha, nroTreino);
        response.setStatus(200);
    }
}
