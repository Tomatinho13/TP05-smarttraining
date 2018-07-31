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
import model.dao.ExercicioDao;
import model.classes.Exercicio;


/**
 *
 * @author Tomatinho
 */

public class ExercicioServlet extends HttpServlet {
    
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExercicioDao exercicioDao = new ExercicioDao();
        Gson gson = new Gson();
        String cod = request.getParameter("cod");
        try {
            if(exercicioDao.getExercicio(cod)==null){
                response.sendError(404);
            }
            else{
                response.setContentType("application/json");
                response.getWriter().write(gson.toJson(exercicioDao.getExercicio(cod)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExercicioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExercicioDao exercicioDao = new ExercicioDao();
        Gson gson = new Gson();
        try {
            exercicioDao.postExercicio(gson.fromJson(request.getReader(), Exercicio.class));
        } catch (SQLException ex) {
            Logger.getLogger(ExercicioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExercicioDao exercicioDao = new ExercicioDao();
        Gson gson = new Gson();
        try {
            exercicioDao.putExercicio(gson.fromJson(request.getReader(), Exercicio.class));
        } catch (SQLException ex) {
            Logger.getLogger(ExercicioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExercicioDao exercicioDao = new ExercicioDao();
        Gson gson = new Gson();
        exercicioDao.deleteExercicio(gson.fromJson(request.getReader(), Exercicio.class));
        response.setStatus(200);
    }
   
}
