
import java.util.ArrayList;
import java.util.Scanner;

public class Urna {

    private String candidato;
    private int numPartido;
    private String nomePartido;

    private final ArrayList<Candidato> Candidato;

    public Urna(String candidato, int numPartido, String nomePartido) {
        this.Candidato = new ArrayList<>();
        this.candidato = candidato;
        this.nomePartido = nomePartido;
        this.numPartido = numPartido;

    }

    public Urna() {
        this.Candidato = new ArrayList<>();
    }

    public void menuOpcoes() {
       
        String resposta = " ";
        int opcao = 0;
        do {
            System.out.println("opção 1 : Cadastrar Candidatos" + "\n");
            System.out.println("Opção 2 : Realizar Votação" + "\n");
            System.out.println("Opçao 3 : Mostrar Resultado da votação" + "\n");
            System.out.println("Opção 4 : Encerrar o Programa " + "\n");
            
            System.out.println("Digite uma opção: ");
            opcao = entradaInt();
            switch (opcao) {
                

                case 1:
                    System.out.println("Deseja cadastro para Vereador ou para Prefeito?");
                    resposta = entradaString();

                    if (resposta.equalsIgnoreCase("Vereador")) {
                        cadastrarVereador();

                    } else {
                        cadastrarPrefeito();
                    }
                    break;

                case 2:

                    String nomeCandidato = "";
                    int numeroPartido = 0;

                    System.out.println("Digite o nome do candidato: ");
                    nomeCandidato = entradaString();
                    System.out.println("Digite o número do partido");
                    numeroPartido = entradaInt();

                    for (int i = 0; i < this.Candidato.size(); i++) {
                        boolean candidatoExiste = false;
                        if (this.Candidato.get(i).getNome().equalsIgnoreCase(nomeCandidato)) {
                            candidatoExiste = true;
                        }
                        if (this.Candidato.get(i).getPartido() == numeroPartido) {
                            candidatoExiste = true;
                        }

                        if (candidatoExiste) {
                            this.Candidato.get(i).adicionarVotoCandidato();
                        }
                    }

                    break;

                case 3:
               
                    System.out.println("Resultado Prefeitos");
                    String prefeitos = "";
                    for (int i = 0; i < this.Candidato.size(); i++) {
                        if (this.Candidato.get(i).getTipo().equalsIgnoreCase("Prefeito")) {
                            prefeitos += "Nome do Candidato " + this.Candidato.get(i).getNome() + "\n"
                                    + "Votos do Candidato: " + this.Candidato.get(i).getVotoCandidato() + "\n";
                                                       }
                        System.out.println(prefeitos);
                    }
                    String vereadores = "";
                    System.out.println("Resultado Vereadores");

                    for (int i = 0; i < this.Candidato.size(); i++) {
                        if (this.Candidato.get(i).getTipo().equalsIgnoreCase("Vereador")) {
                            vereadores += "Nome do Candidato " + this.Candidato.get(i).getNome() + "\n"
                                    + "Votos do Candidato: " + this.Candidato.get(i).getVotoCandidato() + "\n";
                                   
                        }
                    }
                    System.out.println(vereadores);

                    break;
                case 4:
                    System.out.println("SAINDO.....");
                    break;
                default:
                    break;

            }

        } while (opcao != 4);

    }

    public void cadastrarVereador() {
        
        String resposta = " ";
        int partido;
        String nome;

        System.out.println(" digite o número do partido: ");
        partido = entradaInt();
        System.out.println("Digite seu nome completo:");
        nome = entradaString();
        this.Candidato.add(new Candidato(partido, nome, "Vereador"));

        System.out.println(" cadastro completo!");

    }

    public void cadastrarPrefeito() {
        
        String resposta = " ";
        int partido;
        String nome;

        System.out.println(" digite o número do partido: ");
        partido = entradaInt();
        System.out.println("Digite seu nome completo:");
        nome = entradaString();
        this.Candidato.add(new Candidato(partido, nome, "Prefeito"));
        System.out.println(" cadastro completo!");

    }

    public String entradaString() {
        Scanner e = new Scanner(System.in);
        return e.nextLine();
    }

    public int entradaInt() {
        Scanner e = new Scanner(System.in);
        return e.nextInt();
    }

}
