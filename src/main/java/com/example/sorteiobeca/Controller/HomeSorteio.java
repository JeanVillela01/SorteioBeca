package com.example.sorteiobeca.Controller;

import com.example.sorteiobeca.Classes.BancoParticipantesDeferidos;
import com.example.sorteiobeca.Classes.BancoParticipantesIndeferidos;
import com.example.sorteiobeca.Classes.Vencedor;
import com.example.sorteiobeca.interfaces.Banco;
import com.example.sorteiobeca.interfaces.Validacao;
import com.example.sorteiobeca.service.GravaVencedor;
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

        LerParticipanteDeArquivo leitor = new LerParticipanteDeArquivo();
        List<Validacao> indeferidos = new ArrayList<>(
                Arrays.asList(new ValidaIndeferido(bancoIndeferidos)));
        bancoDeferidos.setValidacoes(indeferidos);

        try{
            leitor.setCaminhoParaArquivo("E:\\blacklist.txt");
            leitor.setBanco(bancoIndeferidos);
            leitor.LerEAdicionar();

            leitor.setBanco(bancoDeferidos);
            leitor.setCaminhoParaArquivo("E:\\Projetos IntelliJ\\" +
                    "IdeaProjects\\TesteProjetoSorteio\\SorteioBeca\\partcipantes2.txt");
            leitor.LerEAdicionar();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Inicializei as variáveis");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Banco bancoIndeferidos = new BancoParticipantesIndeferidos();
        int tamanho = bancoIndeferidos.getParticipantes().size();
        req.setAttribute("numeroParticipantes", tamanho);
        RequestDispatcher rd = req.getRequestDispatcher("/Tela_Sorteio.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("botaoConfirmar") != null){
            // TODO: 27/06/2022 Gravar na blackList o vencedor (No padrão NOME ; EMAIL)
            RequestDispatcher rd = req.getRequestDispatcher("/Tela_Sorteio.html");
            rd.forward(req, resp);
            System.out.println(Vencedor.getVencedor());
            GravaVencedor gravaVencedor = new GravaVencedor(Vencedor.getVencedor());
            gravaVencedor.setCaminhoParaArquivo("C:\\blackList.txt");
            gravaVencedor.gravaNaBlackList();
            init();
        }
        if(req.getParameter("botaoRefazer") != null){
            resp.sendRedirect("realizarSorteio");
        }
    }
}
