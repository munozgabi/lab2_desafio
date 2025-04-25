public class PrincipalCandidatos {

    public static void ordenaCandidatosPorNome(Candidato [] candidato){

    }
    public static void ordenaCandidatosPorVotos(Candidato [] candidato){

    }
    public static void ordenaCandidatosPorPartido(Candidato [] candidato){

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
    public static void main(String[] args) {
        String[] nomes = {"Ana", "Bernardo", "Carol", "Douglas", "Eduarda"};
        String[] partidos = {"Partido 1", "Partido 2", "Partido 3"};
        int tamanho = (int) (Math.random() * 100);
        Candidato[] candidatos = new Candidato[tamanho];

        for(int i = 0; i < tamanho; i++){
            String nome = nomes[(int)(Math.random() * nomes.length)];
            String partido = partidos[(int)(Math.random() * partidos.length)];
            int intencoesVotos = (int)(Math.random() * 100);
            candidatos[i] = new Candidato(nome, partido, intencoesVotos);
        }

        for (Candidato candidato : candidatos) {
            System.out.println(candidato);
        }
        

    }
}
