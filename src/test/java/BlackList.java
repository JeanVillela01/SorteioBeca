import com.example.sorteiobeca.Classes.BancoParticipantesDeferidos;
import com.example.sorteiobeca.Classes.BancoParticipantesIndeferidos;
import com.example.sorteiobeca.Classes.Participante;
import com.example.sorteiobeca.interfaces.Banco;
import com.example.sorteiobeca.interfaces.Validacao;
import com.example.sorteiobeca.service.LerParticipanteDeArquivo;
import com.example.sorteiobeca.service.ValidaIndeferido;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackList {

    public static void main(String[] args) {
        BancoParticipantesDeferidos bancoDeferidos = new BancoParticipantesDeferidos();
        Banco bancoIndeferidos = new BancoParticipantesIndeferidos();
        LerParticipanteDeArquivo leitor = new LerParticipanteDeArquivo();
        leitor.setCaminhoParaArquivo("E:\\blacklist.txt");
        leitor.setBanco(bancoIndeferidos);

        try{
            leitor.LerEAdicionar();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        List<Validacao> indeferidos = new ArrayList<>(
                Arrays.asList(new ValidaIndeferido(bancoIndeferidos)));

        bancoDeferidos.setValidacoes(indeferidos);
        bancoDeferidos.adiciona(new Participante("Marcelo", "marcelinho@telefonica.com"));

        bancoDeferidos.adiciona(new Participante
                ("Marcelo", "marcia.cappellesso@telefonica.com"));

        bancoDeferidos.adiciona(new Participante
                ("Fabiano Stein", "fabiano.stein@telefonica.com"));

        System.out.println("Inicializei as variáveis");

        bancoDeferidos.getParticipantes().forEach(participante ->
                System.out.println(participante.getNome() + "-" + participante.getEmail()));
    }

}

