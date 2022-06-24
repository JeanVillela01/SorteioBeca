import com.example.sorteiobeca.Classes.BancoParticipantesDeferidos;
import com.example.sorteiobeca.Classes.Participante;
import com.example.sorteiobeca.service.LerParticipanteDeArquivo;

import java.io.IOException;
import java.util.ArrayList;

public class TesteOrdenar {

    public static void main(String[] args) {
        BancoParticipantesDeferidos banco = new BancoParticipantesDeferidos();
        LerParticipanteDeArquivo leitor = new LerParticipanteDeArquivo(banco);
        leitor.setCaminhoParaArquivo("partcipantes2.txt");
        try{
            leitor.LerEAdicionar();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ArrayList<Participante> lista = new ArrayList<>(banco.getParticipantes());

        lista.sort((participante1,participante2) -> participante1.getNome().compareTo(participante2.getNome()));

        lista.forEach(participante -> System.out.println(participante.getNome()));
    }

}
