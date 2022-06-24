package com.example.sorteiobeca.Controller;

import com.example.sorteiobeca.Classes.BancoParticipantesDeferidos;
import com.example.sorteiobeca.Classes.Participante;
import com.example.sorteiobeca.service.Sorteio;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RealizarOSorteioServlet", value = "/realizarSorteio")
public class RealizarOSorteioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Sorteio novoSorteio = new Sorteio();
        BancoParticipantesDeferidos banco = new BancoParticipantesDeferidos();

        Participante vencedor = novoSorteio.realizarSorteio(banco.getParticipantes());

        request.setAttribute("nomeSorteado", vencedor.getNome());
        RequestDispatcher rd = request.getRequestDispatcher("/Tela_Vencedor.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
