package com.example.sorteiobeca.Classes;

public class Vencedor {

    private static Participante vencedor;

    public static void setVencedor(Participante vencedor) {
        Vencedor.vencedor = vencedor;
    }
    public static Participante getVencedor() {
        return vencedor;
    }
}
