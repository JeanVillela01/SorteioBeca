package com.example.sorteiobeca.Controller;

import com.example.sorteiobeca.Classes.BancoParticipantesDeferidos;
import com.example.sorteiobeca.Classes.Participante;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


@WebServlet(name = "ListaParticipantes", value = "/ListaParticipantes")
public class ListarParticipantes extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BancoParticipantesDeferidos banco = new BancoParticipantesDeferidos();
        Collection<Participante> participantes = banco.getParticipantes();

        ArrayList<Participante> arrayParticipantes = new ArrayList<>(participantes);
        arrayParticipantes.sort((nome1, nome2) -> nome1.getNome().compareTo(nome2.getNome()));



        req.setAttribute("participantesSorteio", arrayParticipantes);
        RequestDispatcher rd = req.getRequestDispatcher("/Tabela_Participantes.jsp");
        rd.forward(req, resp);

    }
}
