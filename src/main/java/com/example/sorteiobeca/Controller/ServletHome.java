package com.example.sorteiobeca.Controller;

import com.example.sorteiobeca.Classes.BancoParticipante;
import com.example.sorteiobeca.service.LerParticipanteDeArquivo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

@WebServlet(name = "Home", value = "")
public class ServletHome extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BancoParticipante banco = new BancoParticipante();
        LerParticipanteDeArquivo leitor = new LerParticipanteDeArquivo(banco);

        leitor.setCaminhoParaArquivo("E:\\Projetos IntelliJ\\IdeaProjects\\TesteProjetoSorteio\\SorteioBeca\\partcipantes2.txt");

        try{leitor.LerEAdicionar();
            System.out.println("Encontrei o arquivo");
        } catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        RequestDispatcher rd = req.getRequestDispatcher("/homeSorteio.html");
        rd.forward(req, resp);
    }
}
