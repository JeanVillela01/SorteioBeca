import com.example.sorteiobeca.Classes.BancoParticipantesDeferidos;
import com.example.sorteiobeca.Classes.BancoParticipantesIndeferidos;
import com.example.sorteiobeca.Classes.Participante;
import com.example.sorteiobeca.interfaces.Banco;
import com.example.sorteiobeca.interfaces.Validacao;
import com.example.sorteiobeca.service.ValidaIndeferido;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ValidaIndeferidoTest {

    public static void main(String[] args) {

        // TODO: 23/06/2022  Refazer a classe de testes quando as interfaces
        //  e classes de Banco estiverem prontas

        Banco bancoIndeferidos = new BancoParticipantesIndeferidos();
        bancoIndeferidos.adiciona(new Participante("Guilherme","g@telefonica.com"));

        Participante lucas = new Participante("Lucas", "l@telefonica.com");
        Participante gui = new Participante("Guilherme","g@telefonica.com");

        BancoParticipantesDeferidos bancoDeferidos = new BancoParticipantesDeferidos();

        List<Validacao> validacoes = new ArrayList<>();

        validacoes.add(new ValidaIndeferido(bancoIndeferidos));

        bancoDeferidos.setValidacoes(validacoes);

        bancoDeferidos.adiciona(lucas);
        bancoDeferidos.adiciona(gui);

        Collection<Participante> deferidos = bancoDeferidos.getParticipantes();

        deferidos.forEach( p -> System.out.println(p.getNome()));


    }
}
