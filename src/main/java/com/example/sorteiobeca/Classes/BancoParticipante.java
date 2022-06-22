package com.example.sorteiobeca.Classes;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BancoParticipante {

    private static Set<Participante> participantes = new HashSet<>();

    /*static{
        participantes.add(new Participante("João", "joao@email.com"));
        participantes.add(new Participante("Ana", "ana@email.com"));
        participantes.add(new Participante("Pedro", "pedro@email.com"));
    }*/

    public void adicionar(Participante novoParticipante){

        BancoParticipante.participantes.add(novoParticipante);
    }

    public Collection<Participante> getParticipantes(){
        return Collections.unmodifiableSet(BancoParticipante.participantes);
    }
    public int qntdParticipantes() {
        return this.getParticipantes().size();
    }
}
