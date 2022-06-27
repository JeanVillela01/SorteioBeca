package com.example.sorteiobeca.service;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.example.sorteiobeca.Classes.Participante;

public class GravaVencedor {

    private Participante vencedor;
    private String caminhoParaArquivo;
    
    public GravaVencedor(Participante vencedor) {
        this.vencedor = vencedor;
    }

    public void setCaminhoParaArquivo(String caminhoParaArquivo) {
        this.caminhoParaArquivo = caminhoParaArquivo;
    }

    public void gravaNaBlackList()throws IOException{
        try (
            FileWriter writer = new FileWriter(this.caminhoParaArquivo, true);
            BufferedWriter bw = new BufferedWriter(writer);
            PrintWriter pw = new PrintWriter(bw)) {
        String resultado = vencedor.getNome() + ";" + vencedor.getEmail();
        pw.println();
        pw.print(resultado);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        throw new FileNotFoundException("Não encontrei o arquivo com o nome " + this.caminhoParaArquivo);
    }
    }
}

