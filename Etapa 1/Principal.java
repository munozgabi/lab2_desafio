public class Principal {
    public static void main(String[] args) {
        try{
        Labirinto labirinto = new Labirinto();
        labirinto.criaLabirinto("Etapa 1/labirinto.txt");
        if(labirinto.percorreLabirinto()){
            System.out.println("Saída encontrada!");
        }
        else{
            System.out.println("Nenhuma saída encontrada!");
        }
        }catch(IllegalArgumentException e){
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
