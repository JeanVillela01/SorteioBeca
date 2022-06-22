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

@WebServlet(name="Tela_Forms", value = "/Tela_Forms")
public class NovoParticipante extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("Tela_Forms.html");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String email = req.getParameter("email");

        BancoParticipante bancoParticipantes = new BancoParticipante();
        Participante novoParticipante = new Participante(nome, email);
        bancoParticipantes.adicionar(novoParticipante);

        RequestDispatcher rd = req.getRequestDispatcher("Tela_Forms.html");
        rd.forward(req,resp);

        System.out.println("Foi cadastrado o participante: " + nome);

    }
}
