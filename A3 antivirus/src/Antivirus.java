
import java.io.*;
import java.util.*;

class FindFile 
{
    public void findFile(String name, File file)
    {
        File[] list = file.listFiles();
        if (list != null)
            for (File fil : list)
            {
                if (fil.isDirectory())
                {
                    findFile(name, fil);
                }
                else if (name.equalsIgnoreCase(fil.getName()))
                {
                    System.out.println(fil.getParentFile());
                }
            }
    }

    public static void main(String[] args) 
    {
        FindFile ff = new FindFile();
        Scanner scan = new Scanner(System.in);

        System.out.println("Coloque o nome do arquivo a procurar");
        String name = scan.next();

        System.out.println("Coloque o diretorio aonde deseja buscar");
        String directory = scan.next();

        // Verificação se o diretório existe e é um diretório válido
        File dir = new File(directory);
        if (!dir.exists()) {
            System.out.println("O diretorio nao existe");
        } else if (!dir.isDirectory()) {
            System.out.println("Caminho nao encontrado");
        } else {
            // Se o diretório for válido, chama a função de busca
            ff.findFile(name, dir);
        }
    }
}