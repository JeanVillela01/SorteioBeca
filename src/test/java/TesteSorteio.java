import com.example.sorteiobeca.Classes.BancoParticipantesDeferidos;
import com.example.sorteiobeca.Classes.Participante;
import com.example.sorteiobeca.service.Sorteio;
import java.util.Collection;

public class TesteSorteio {

    public static void main(String[] args) {

        BancoParticipantesDeferidos bancoParticipante = new BancoParticipantesDeferidos();
        Sorteio novoSorteio = new Sorteio();
        Collection<Participante> colecaoParticipante = bancoParticipante.getParticipantes();

        for (int i=0; i<10; i++) {
            Participante pessoaSorteada = novoSorteio.realizarSorteio(colecaoParticipante);
            System.out.println(pessoaSorteada.getNome());

        }

    }

}