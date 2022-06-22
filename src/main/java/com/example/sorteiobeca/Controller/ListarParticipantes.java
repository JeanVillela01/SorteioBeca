package com.example.sorteiobeca.Controller;

import com.example.sorteiobeca.Classes.BancoParticipante;
import com.example.sorteiobeca.Classes.Participante;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;


@WebServlet(name = "ListaParticipantes", value = "/ListaParticipantes")
public class ListarParticipantes extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BancoParticipante banco = new BancoParticipante();

        System.out.println("Tentei ler o arquivo!");

        Collection<Participante> participantes = banco.getParticipantes();

        PrintWriter saida = resp.getWriter();

        saida.println("<html><body><h1>Temos até o momento " + participantes.size() +" Participantes</h1><ul>");

        participantes.forEach(participante -> saida.print("<li>" + participante.getNome() +
                " - "+ participante.getEmail() + "</li>"));
        saida.println("</html></body></ul>");

        /*RequestDispatcher rd = req.getRequestDispatcher("/Tabela_Participantes.html");
        rd.forward(req, resp);*/

    }
}
