package controller.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.AvaliacaoDao;
import model.classes.Avaliacao;

/**
 *
 * @author Tomatinho
 */

public class AvaliacaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
        Gson gson = new Gson();
        String cpf = request.getParameter("cpf");
        try {
            if(avaliacaoDao.getAvaliacao(cpf)==null){
                response.sendError(404);
            }
            else{
                response.setContentType("application/json");
                response.getWriter().write(gson.toJson(avaliacaoDao.getAvaliacao(cpf)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
        Gson gson = new Gson();
        try {
            avaliacaoDao.postAvaliacao(gson.fromJson(request.getReader(), Avaliacao.class));
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
        Gson gson = new Gson();
        try {
            avaliacaoDao.putAvaliacao(gson.fromJson(request.getReader(), Avaliacao.class));
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
        Gson gson = new Gson();
        try {
            avaliacaoDao.deleteAvaliacao(gson.fromJson(request.getReader(), Avaliacao.class));
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus(200);
    }


}
