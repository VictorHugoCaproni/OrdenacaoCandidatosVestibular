public class Candidato implements Comparable<Candidato> {
    private String nome;
    private double nota;

    public Candidato(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public int compareTo(Candidato outro) {
        // nota decrescente
        if (this.nota != outro.nota) {
            return Double.compare(outro.nota, this.nota); 
        }
        // nome crescente
        return this.nome.compareTo(outro.nome);
    }

    @Override
    public String toString() {
        return nome + " - Nota: " + nota;
    }
}