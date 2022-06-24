package com.example.sorteiobeca.Classes;

import com.example.sorteiobeca.interfaces.Banco;
import com.example.sorteiobeca.interfaces.Validacao;

import java.util.*;

public class BancoParticipantesDeferidos implements Banco {

    private static Set<Participante> participantes = new HashSet<>();

    private static List<Validacao> listaValidacoes;

    public void setValidacoes(List<Validacao> listaValidacoes) {
        BancoParticipantesDeferidos.listaValidacoes= listaValidacoes;
    }


    public void adiciona(Participante novoParticipante){

        boolean podeAdicionar = true;

        try {
            for (Validacao validacao : BancoParticipantesDeferidos.listaValidacoes) {
                podeAdicionar = (podeAdicionar && validacao.validar(novoParticipante));

            }
        }catch (NullPointerException e){
            System.out.println("Não foi feita nenhuma validação ao adicionar os participantes");
        }

        if(podeAdicionar) {
        BancoParticipantesDeferidos.participantes.add(novoParticipante);
        }
    }

    public Collection<Participante> getParticipantes(){

        return Collections.unmodifiableSet(BancoParticipantesDeferidos.participantes);
    }

    public int qntdParticipantes() {
        return this.getParticipantes().size();

    }
}
