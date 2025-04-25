import java.util.Scanner;

public class PrincipalCandidatos {
    public static void main(String[] args) {
        //Informações dos candidatos
        String[] nomes = {"Ana", "Bernardo", "Carol", "Douglas", "Eduarda", "Fabricio", "Gabriela"};
        String[] partidos = {"Partido 1", "Partido 2", "Partido 3", "Partido 4"};

        int tamanho = 1 + (int) (Math.random() * 100);
        Candidato[] candidatos = new Candidato[tamanho];

        //Sorteia e adiciona candidatos no array
        for(int i = 0; i < tamanho; i++){
            String nome = nomes[(int)(Math.random() * nomes.length)];
            String partido = partidos[(int)(Math.random() * partidos.length)];
            int intencoesVotos = (int)(Math.random() * 100);
            candidatos[i] = new Candidato(nome, partido, intencoesVotos);
        }

        //Ordenação
        ordenaCandidatosPorPartido(candidatos); 
        ordenaCandidatosPorVotos(candidatos);   
        ordenaCandidatosPorNome(candidatos);

        //Impressão candidatos
        System.out.println("\n- Lista de candidatos -\n");
        for (Candidato candidato : candidatos) {
            System.out.println(candidato);
        }

        //Pesquisa binária
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nDigite o nome do candidato que deseja pesquisar: ");
        String nomeCandidato = teclado.nextLine();
        int resultado = pesquisaBinariaCandidatos(candidatos, nomeCandidato);
        if(resultado != -1){
            System.out.println("\nCandidato encontrado! \n" + candidatos[resultado]);
        }
        else{
            System.out.println("Candidado não encontrado.");
        }
        
        teclado.close();
    }

    //Métodos de ordenação
    public static void ordenaCandidatosPorNome(Candidato [] candidatos){
        for(int i = 1; i < candidatos.length; i++){
            Candidato candidato = candidatos[i];
            int j = i - 1;
            while(j >= 0 && candidatos[j].getNome().compareToIgnoreCase(candidato.getNome()) > 0){
                candidatos[j + 1] = candidatos[j]; //empurra o nome para frente
                j--;
            }
            candidatos[j + 1] = candidato; //empurra o nome para tras

        }
    }
    public static void ordenaCandidatosPorVotos(Candidato [] candidatos){
        for(int i = 0; i < candidatos.length-1; i++){
            int max = i;
            for(int j = i+1; j < candidatos.length; j++){
                if(candidatos[j].getIntencoesVotos() > candidatos[max].getIntencoesVotos()){
                    max = j;
                }
            }
            Candidato aux = candidatos[i];
            candidatos[i] = candidatos[max];
            candidatos[max] = aux;
        }
    }
    public static void ordenaCandidatosPorPartido(Candidato [] candidatos){
        for(int i = 1; i < candidatos.length; i++){
            Candidato candidato = candidatos[i];
            int j = i - 1;
            while(j >= 0 && candidatos[j].getPartido().compareToIgnoreCase(candidato.getPartido()) > 0){
                candidatos[j + 1] = candidatos[j]; //empurra o nome para frente
                j--;
            }
            candidatos[j + 1] = candidato; //empurra o nome para tras

        }
    }

    public static int pesquisaBinariaCandidatos(Candidato [] candidatos, String nome){
        int inf = 0;
        int sup = candidatos.length - 1;
        int med, comparacao;
        while(inf <= sup){
            med = (inf + sup) / 2;
            comparacao = candidatos[med].getNome().compareToIgnoreCase(nome);
            if(comparacao == 0){
                return med; //encontrou
            }
            else if(comparacao < 0){
                inf = med + 1; //nome vem depois
            }
            else{
                sup = med - 1; //vem antes
            }
        }

        return -1; //não encontrou
    }
}
