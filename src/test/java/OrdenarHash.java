import com.example.sorteiobeca.Classes.Participante;

import java.util.ArrayList;
import java.util.HashSet;

public class OrdenarHash {

    public static void main(String[] args) {
        HashSet<Participante> participantes = new  HashSet<>();
        participantes.add(new Participante("Lucas", "hbgjhg"));
        participantes.add(new Participante("Joao", "asas"));
        participantes.add(new Participante("Felipe", "hbgvasfvjhg"));
        participantes.add(new Participante("Maria", "hbsadsadasdgjhg"));

        System.out.println(participantes);

        ArrayList<Participante> arrayParticipantes = new ArrayList<>(participantes);

        System.out.println(arrayParticipantes);


        arrayParticipantes.sort((nome1, nome2) -> nome1.getNome().compareTo(nome2.getNome()));

        System.out.println(arrayParticipantes);



    }

}
