import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path projeto = Paths.get(System.getProperty("user.dir"));
        Path csv = procurarCsv(projeto);

        
        List<Candidato> candidatos = LeitorCSV.carregar(csv.toString());
        Candidato[] array = candidatos.toArray(new Candidato[0]);

        System.out.println("Lista antes da ordenacao");
        imprimirLista(array);

        Sorts<Candidato> sorts = new Sorts<>();
        sorts.bubbleSort(array);

        System.out.println("\n Lista apos a ordenacao");
        imprimirLista(array);
    }

    private static Path procurarCsv(Path projeto) {
        Path[] tentativas = {
            projeto.resolve("src").resolve("candidatos_vestibular.csv"),
            projeto.resolve("candidatos_vestibular.csv"),
            projeto.resolve("bin").resolve("candidatos_vestibular.csv")
        };

        for (Path caminho : tentativas) {
            if (Files.exists(caminho)) {
                return caminho;
            }
        }

        throw new IllegalStateException(
            "Arquivo CSV não encontrado. Verifique se o arquivo 'candidatos_vestibular.csv' está em src/, na raiz do projeto ou em bin/."
        );
    }

    private static void imprimirLista(Candidato[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println((i + 1) + ". " + array[i]);
        }
    }
}