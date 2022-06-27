import java.io.IOException;

public class GravaVencedorTeste {
    
public static void main(String[] args){

    Participante vencedor = new Participante();
    GravaVencedor gravaVencedor = new GravaVencedor(vencedor);
    gravaVencedor.setCaminhoParaArquivo("blackList.txt");
    try {
        gravaVencedor.gravaNaBlackList();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
