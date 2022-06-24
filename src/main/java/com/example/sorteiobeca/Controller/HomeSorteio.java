package com.example.sorteiobeca.Controller;

import com.example.sorteiobeca.Classes.BancoParticipantesDeferidos;
import com.example.sorteiobeca.Classes.BancoParticipantesIndeferidos;
import com.example.sorteiobeca.interfaces.Banco;
import com.example.sorteiobeca.interfaces.Validacao;
import com.example.sorteiobeca.service.LerParticipanteDeArquivo;
import com.example.sorteiobeca.service.ValidaIndeferido;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@WebServlet(name = "Home", value = "")
public class HomeSorteio extends HttpServlet {

    @Override
    public void init() throws ServletException {
        BancoParticipantesDeferidos bancoDeferidos = new BancoParticipantesDeferidos();
        Banco bancoIndeferidos = new BancoParticipantesIndeferidos();




        List<Validacao> indeferidos = new ArrayList<>(
                Arrays.asList(new ValidaIndeferido(bancoIndeferidos)));

        bancoDeferidos.setValidacoes(indeferidos);

        LerParticipanteDeArquivo leitor = new LerParticipanteDeArquivo(bancoDeferidos);

        leitor.setCaminhoParaArquivo("E:\\Projetos IntelliJ\\IdeaProjects\\TesteProjetoSorteio\\SorteioBeca\\partcipantes2.txt");

        try{leitor.LerEAdicionar();}
        catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch (NoSuchElementException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Inicializei as variáveis");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {





        RequestDispatcher rd = req.getRequestDispatcher("/Tela_Sorteio.html");
        rd.forward(req, resp);
    }
}
