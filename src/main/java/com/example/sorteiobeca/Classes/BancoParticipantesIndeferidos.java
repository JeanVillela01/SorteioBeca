package com.example.sorteiobeca.Classes;

import com.example.sorteiobeca.interfaces.Banco;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BancoParticipantesIndeferidos implements Banco {

    private static Set<Participante> participantes = new HashSet<>();

    public void adiciona(Participante novoParticipante){

        BancoParticipantesIndeferidos.participantes.add(novoParticipante);

    }

    public Collection<Participante> getParticipantes(){
        return Collections.unmodifiableSet(BancoParticipantesIndeferidos.participantes);
    }

}
