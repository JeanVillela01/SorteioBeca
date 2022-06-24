package com.example.sorteiobeca.service;

import com.example.sorteiobeca.Classes.Participante;
import com.example.sorteiobeca.interfaces.Banco;
import com.example.sorteiobeca.interfaces.Validacao;

import java.util.HashSet;

public class ValidaIndeferido implements Validacao {

    private Banco participantesIndeferidos;

    public ValidaIndeferido(Banco bancoDeIndeferidos) {
        this.participantesIndeferidos = bancoDeIndeferidos;
    }

    @Override
    public boolean validar(Participante possivelParticipante) {
       return !(this.participantesIndeferidos.getParticipantes().contains(possivelParticipante));
    }

}