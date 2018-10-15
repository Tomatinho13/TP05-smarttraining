package br.cefetmg.inf.controller;

import javax.servlet.http.HttpServletRequest;

public class CadastrarFicha extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "/TelaInicialInstrutor";
        
        return defineView(request, jsp);
    }
}
