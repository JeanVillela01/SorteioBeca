package com.example.sorteiobeca.Controller;

import com.example.sorteiobeca.Classes.BancoParticipante;
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
        BancoParticipante banco = new BancoParticipante();

        Participante vencedor = novoSorteio.realizarSorteio(banco.getParticipantes());

        PrintWriter out = response.getWriter();

        out.println("<html><body> E o vencedor foi o: " + vencedor.getNome() +"<p>PARABENS!!</p></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
