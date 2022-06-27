package com.example.sorteiobeca.Classes;

import java.util.Objects;

public class Participante {

    private String nome;
    private String email;


    public Participante(String nome, String email) {
        this.nome = nome;
        this.email = email;

    }

    public String getNome() {
        return this.nome;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participante)) return false;
        Participante p = (Participante) o;
        return this.getEmail().equals(p.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail());
    }

    public String getEmail() {
        return email;

    }

    @Override
    public String toString() {
        return "Participante{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
