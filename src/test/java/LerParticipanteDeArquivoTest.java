import com.example.sorteiobeca.Classes.BancoParticipantesDeferidos;
import com.example.sorteiobeca.service.LerParticipanteDeArquivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;

public class LerParticipanteDeArquivoTest {
    public static void main(String[] args) {

        BancoParticipantesDeferidos banco = new BancoParticipantesDeferidos();

        LerParticipanteDeArquivo leitor = new LerParticipanteDeArquivo(banco);
        leitor.setCaminhoParaArquivo("partcipantes2.txt");

        try{leitor.LerEAdicionar();
        } catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        ArrayList<String> array = new ArrayList<>(new HashSet<>());

        banco.getParticipantes().forEach(participante -> System.out.println(participante.getNome()));
    }
}
