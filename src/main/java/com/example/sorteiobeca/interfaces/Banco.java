package com.example.sorteiobeca.interfaces;
import com.example.sorteiobeca.Classes.Participante;
import java.util.Collection;


public interface Banco {

    void adiciona(Participante novoParticipante);
    Collection<Participante> getParticipantes();

}

