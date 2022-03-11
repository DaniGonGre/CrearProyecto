import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        GitHub github = null;
        try {
            //Pedimos el token al usuario
            String token = JOptionPane.showInputDialog("Introduce el token de GitHub: ");
        //    String pathAlFich = "/home/dam1/IdeaProjects/CrearProyecto/ficheroToken.propierties";
            github = new GitHubBuilder()
                    .withOAuthToken(token)
             //       .fromPropertyFile(pathAlFich)
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
