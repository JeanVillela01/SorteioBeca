package com.example.sorteiobeca.service;

import com.example.sorteiobeca.Classes.BancoParticipantesDeferidos;
import com.example.sorteiobeca.Classes.Participante;
import com.example.sorteiobeca.interfaces.Banco;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import java.util.Scanner;
import java.io.FileReader;


public class LerParticipanteDeArquivo {

    Banco banco;
    String caminhoParaArquivo;

    public LerParticipanteDeArquivo(Banco banco) {
        this.banco = banco;
        System.setProperty("file.encoding", "UTF-8");
    }

    public LerParticipanteDeArquivo(){
        //Construtor default
        System.setProperty("file.encoding", "UTF-8");
    }

    public void setCaminhoParaArquivo(String caminhoParaArquivo) {
        this.caminhoParaArquivo = caminhoParaArquivo;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public void LerEAdicionar() throws IOException {

        try (FileReader arq = new FileReader(this.caminhoParaArquivo);
             Scanner entrada = new Scanner(arq) ) {

            while(entrada.hasNextLine()) {

                try (Scanner linhaEntrada =new Scanner(entrada.nextLine())){
                    linhaEntrada.useDelimiter(";");

                    String nome = linhaEntrada.next();
                    String email = linhaEntrada.next();

                    this.banco.adiciona(new Participante(nome, email));

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
