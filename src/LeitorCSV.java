import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorCSV {

    public static List<Candidato> carregar(String caminhoArquivo) {
        List<Candidato> candidatos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha = br.readLine(); // lê e descarta o cabeçalho (nome,nota)

            while ((linha = br.readLine()) != null) {
                linha = linha.trim(); // remove \r e espaços extras no fim da linha

                if (linha.isEmpty()) continue; // ignora linhas em branco

                String[] partes = linha.split(",");

                String nome = partes[0].trim();
                double nota = Double.parseDouble(partes[1].trim());

                candidatos.add(new Candidato(nome, nota));
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return candidatos;
    }
}