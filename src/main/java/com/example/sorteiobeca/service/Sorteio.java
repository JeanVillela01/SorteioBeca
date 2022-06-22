package com.example.sorteiobeca.service;

import com.example.sorteiobeca.Classes.Participante;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;


public class Sorteio {

    Random geradorAleatorio;

    public Sorteio(){
        this.geradorAleatorio=new Random();
    }

    public Participante realizarSorteio(Collection<Participante> participantes) {

        ArrayList<Participante> listaDeParticipantes = new ArrayList<>(participantes);
        int numeroSorteado = this.geradorAleatorio.nextInt(listaDeParticipantes.size());

        return listaDeParticipantes.get(numeroSorteado);
    }



}
