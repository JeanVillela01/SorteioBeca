package com.example.sorteiobeca.service;

import com.example.sorteiobeca.Classes.BancoParticipante;
import com.example.sorteiobeca.Classes.Participante;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import java.util.Random;
import java.util.Scanner;
import java.io.FileReader;


public class LerParticipanteDeArquivo {

    BancoParticipante banco;
    String caminhoParaArquivo;

    public LerParticipanteDeArquivo(BancoParticipante banco) {
        this.banco = banco;
    }

    public void setCaminhoParaArquivo(String caminhoParaArquivo) {
        this.caminhoParaArquivo = caminhoParaArquivo;
    }

    public void LerEAdicionar() throws IOException {

        try (FileReader arq = new FileReader(this.caminhoParaArquivo);
             Scanner entrada = new Scanner(arq) ) {

            while(entrada.hasNextLine()) {

                try (Scanner linhaEntrada =new Scanner(entrada.nextLine())){
                    linhaEntrada.useDelimiter(";");

                    String nome = linhaEntrada.next();
                    String email = linhaEntrada.next();

                    this.banco.adicionar(new Participante(nome, email));

                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                    throw new NoSuchElementException("Uma das linhas do arquivo tem itens faltantes!");
                }
            }

            } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new FileNotFoundException("Arquivo não encontrado!");

        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Encontrei o arquivo mas não consegui le-lo!");
        }
    }

}
