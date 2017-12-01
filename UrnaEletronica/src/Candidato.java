
public class Candidato {

    private int partido;
    private String nome;

    private String tipo;
    private int votoCandidato = 0;

    public Candidato() {

    }

    public Candidato(int partido, String nome, String tipo) {
        this.partido = partido;
        this.nome = nome;
        this.tipo = tipo;
    }
    

  public void adicionarVotoCandidato(){
      this.votoCandidato++;
  }

    public int getPartido() {
        return partido;
    }

    public void setPartido(int partido) {
        this.partido = partido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVotoCandidato() {
        return votoCandidato;
    }

    public void setVotoCandidato(int votoCandidato) {
        this.votoCandidato = votoCandidato;
    }

    public String getTipo() {
        return tipo;
    }


}
