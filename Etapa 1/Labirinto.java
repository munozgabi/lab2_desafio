import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto{

    private char[][] labirinto;
    private int linhas;
    private int colunas;


    public void criaLabirinto(String filename){
    // Este método abre o arquivo filename para leitura e preenche o labirinto
        try{
            FileReader fr = new FileReader(filename);
            BufferedReader in = new BufferedReader(fr);
            int contLinhas = 0;
            int maiorColuna = 0;
            String line;
            for(int i = 0; (line = in.readLine()) != null; i++){
                contLinhas++;
                if(line.length() > maiorColuna){
                    maiorColuna = line.length();
                }
            }

            this.linhas = contLinhas;
            this.colunas = maiorColuna;
            this.labirinto = new char[linhas][colunas];

            FileReader fr2 = new FileReader(filename);
            BufferedReader in2 = new BufferedReader(fr2);
            for(int i = 0; (line = in2.readLine()) != null; i++){
                for(int j = 0; j<line.length(); j++){
                    labirinto[i][j] = line.charAt(j);
                }
                for(int j = line.length(); j<colunas; j++){
                    labirinto[i][j] = ' ';
                }
            }

            in.close();
            fr.close();
            in2.close();
            fr2.close();

        }catch(IOException e){
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public boolean percorreLabirinto() throws IllegalArgumentException{
        if(labirinto == null){
            throw new IllegalArgumentException();
        }
        return percorreLabirinto(0,0);
    }
    private boolean percorreLabirinto(int x, int y){
        if(x < 0 || x >= linhas || y < 0 || y >= colunas){ //verifica se é válido
            return false;
        }
        if(labirinto[x][y] == 'D'){ //encontrou a saída
            return true;
        }
        if(labirinto[x][y] == 'X' || labirinto[x][y] == 'V'){ //não encontrou
            return false;
        }

        labirinto[x][y] = 'V'; //local visitado

        return percorreLabirinto(x + 1, y) || percorreLabirinto(x - 1, y) || percorreLabirinto(x, y + 1) || percorreLabirinto(x, y - 1);
    }
  

    

}