package com.example.sorteiobeca.service;

import com.example.sorteiobeca.Classes.Participante;
import com.example.sorteiobeca.interfaces.Validacao;

public class ValidaEmail implements Validacao {

    @Override
    public boolean validar(Participante participante) {
        // TODO: 23/06/2022
        return true;

    }
}
