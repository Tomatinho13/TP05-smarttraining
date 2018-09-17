/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.controller;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author gabriel
 */
public abstract class Controller {
    public abstract String execute(HttpServletRequest request);
    
    public String defineView(HttpServletRequest request, String caminho){
        if(request.getAttribute("tipoView").equals("json")){
            caminho = caminho.concat("JSON.jsp");
        }else if(request.getAttribute("tipoView").equals("html")){
           caminho = caminho.concat(".jsp");
        }else{
            String erro="TipoView nao definido!";
            caminho = "erro.jsp";
            request.setAttribute("erro", erro);
        }
        return caminho;
    }
}
