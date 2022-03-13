import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        GitHub github = null;
        try {
            //Pedimos el token al usuario
            String token = JOptionPane.showInputDialog("Introduce el token de GitHub: ");
            //Creamos el fichero
            String pathAlFich = "/home/dam1/IdeaProjects/CrearProyecto/ficheroToken.propierties";
            //Escribimos el token en el fichero
            FileWriter fich = new FileWriter(pathAlFich, false);
            PrintWriter esc = new PrintWriter(fich);
            esc.println("oauth=" + token);
            github = new GitHubBuilder()
             //       .withOAuthToken(token)
                    .fromPropertyFile(pathAlFich)
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        GHRepository repo = null;
        try {
            //El usuario debe introducir el nombre del repositorio que quiera crear
            String nomRe = JOptionPane.showInputDialog("Introduce el nombre del repositorio: ");
            //GHRepository repo2 = github.createRepository("miRepo").create();
            repo = github.createRepository(
                    nomRe, "Este es el nuevo repositorio",
                    "https://www.kohsuke.org/", true/*public*/);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
