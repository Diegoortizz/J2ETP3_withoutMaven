/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
https://github.com/Diegoortizz/J2ETP3_withoutMaven
 */
package bowling;

//import bowling.MultiPlayerGame;
import java.util.Arrays;

//import bowling.SinglePlayerGame;
/**
 *
 * @author Utilisateur
 */
public class MultiPlayer implements MultiPlayerGame {

    SinglePlayerGame[] SPG;
    String[] PlayerNames;
    int indiceJoueurTour;
    int nbJoueur;

    public MultiPlayer() {
        SPG = null;
        indiceJoueurTour = 0;
    }

    @Override
    public String startNewGame(String[] playerName) throws Exception {
        nbJoueur = playerName.length;
        if (playerName.length == 0) {
            throw new UnsupportedOperationException("Il faut au moins un joueur");
        } else {
            SPG = new SinglePlayerGame[nbJoueur];
            PlayerNames = new String[nbJoueur];
            for (int i = 0; i < nbJoueur; i++) {
                SPG[i] = new SinglePlayerGame();
                PlayerNames[i] = playerName[i];
            }

            String intro = String.join(",", playerName);
            return "Entrée en jeu de" + " " + intro;
        }

    }

    public String Affichage(String nom, int tour, int boule) {
        return String.format("Prochain tir : joueur %s, tour n° %d, boule n° %d", nom, tour, boule);
    }

    @Override
    public String lancer(int nombreDeQuillesAbattues) throws Exception {
        if (SPG == null) {
            throw new UnsupportedOperationException("La partie n'a pas commencé");
        }

        if (SPG[indiceJoueurTour].getCurrentFrame().isFinished()) {
            indiceJoueurTour = (indiceJoueurTour + 1) % nbJoueur;
            System.out.println("\n");
//        System.out.println("!!!!!!!!!!" + " " + ((SPG[indiceJoueurTour].getCurrentFrame().frameNumber == 10) && (SPG[indiceJoueurTour].getCurrentFrame().isFinished())));
        }

        SPG[indiceJoueurTour].lancer(nombreDeQuillesAbattues);
        return Affichage(PlayerNames[indiceJoueurTour], SPG[indiceJoueurTour].getCurrentFrame().frameNumber, SPG[indiceJoueurTour].getCurrentFrame().ballsThrown) + " |||  " + SPG[indiceJoueurTour] + " " + SPG[indiceJoueurTour].getCurrentFrame().isFinished();

    }

    @Override
    public int scoreFor(String playerName) throws Exception {
        if (!(Arrays.stream(PlayerNames).anyMatch(playerName::equals))) {
            throw new UnsupportedOperationException("Ce joueur n'existe pas"); //To change body of generated methods, choose Tools | Templates.
        }
        return SPG[Arrays.asList(PlayerNames).indexOf(playerName)].score();


    }

    public static void main(String[] args) throws Exception {
        MultiPlayer M = new MultiPlayer();
        String[] L = {"Diego", "Pierre", "Matthias", "Maxime"};
        /* test 1 */
        System.out.println(M.startNewGame(L));
        System.out.println(M.lancer(5) + " $" + 5);
        System.out.println(M.lancer(4) + " $" + 4);

        System.out.println(M.lancer(8) + " $" + 8);
        System.out.println(M.lancer(1) + " $" + 1);

        System.out.println(M.lancer(2) + " $" + 2);
        System.out.println(M.lancer(8) + " $" + 8);

        System.out.println(M.lancer(1) + " $" + 1);
        System.out.println(M.lancer(6) + " $" + 6);

        System.out.println(M.lancer(4) + " $" + 4);
        System.out.println(M.lancer(6) + " $" + 6);

        System.out.println(M.lancer(10) + " $" + 10);

        System.out.println(M.lancer(10) + " $" + 10);

        System.out.println(M.lancer(1) + " $" + 1);
        System.out.println(M.lancer(2) + " $" + 2);

        System.out.println(M.lancer(8) + " $" + 8);
        System.out.println(M.lancer(1) + " $" + 1);

        System.out.println(M.lancer(0) + " $" + 0);
        System.out.println(M.lancer(7) + " $" + 7);

        System.out.println(M.lancer(4) + " $" + 4);
        System.out.println(M.lancer(4) + " $" + 4);

        System.out.println(M.lancer(5) + " $" + 5);
        System.out.println(M.lancer(5) + " $" + 5);

        System.out.println(M.lancer(5) + " $" + 5);
        System.out.println(M.lancer(4) + " $" + 4);

        System.out.println(M.lancer(8) + " $" + 8);
        System.out.println(M.lancer(1) + " $" + 1);

        System.out.println(M.lancer(2) + " $" + 2);
        System.out.println(M.lancer(8) + " $" + 8);

        System.out.println(M.lancer(1) + " $" + 1);
        System.out.println(M.lancer(6) + " $" + 6);

        System.out.println(M.lancer(4) + " $" + 4);
        System.out.println(M.lancer(6) + " $" + 6);

        System.out.println(M.lancer(10) + " $" + 10);

        System.out.println(M.lancer(10) + " $" + 10);

        System.out.println(M.lancer(1) + " $" + 1);
        System.out.println(M.lancer(2) + " $" + 2);

        System.out.println(M.lancer(8) + " $" + 8);
        System.out.println(M.lancer(1) + " $" + 1);

        System.out.println(M.lancer(0) + " $" + 0);
        System.out.println(M.lancer(7) + " $" + 7);

        System.out.println(M.lancer(4) + " $" + 4);
        System.out.println(M.lancer(4) + " $" + 4);

        System.out.println(M.lancer(5) + " $" + 5);
        System.out.println(M.lancer(5) + " $" + 5);

        System.out.println(M.lancer(5) + " $" + 5);
        System.out.println(M.lancer(4) + " $" + 4);

        System.out.println(M.lancer(8) + " $" + 8);
        System.out.println(M.lancer(1) + " $" + 1);

        System.out.println(M.lancer(2) + " $" + 2);
        System.out.println(M.lancer(8) + " $" + 8);

        System.out.println(M.lancer(1) + " $" + 1);
        System.out.println(M.lancer(6) + " $" + 6);

        System.out.println(M.lancer(4) + " $" + 4);
        System.out.println(M.lancer(6) + " $" + 6);

        System.out.println(M.lancer(10) + " $" + 10);

        System.out.println(M.lancer(10) + " $" + 10);

        System.out.println(M.lancer(1) + " $" + 1);
        System.out.println(M.lancer(2) + " $" + 2);

        System.out.println(M.lancer(8) + " $" + 8);
        System.out.println(M.lancer(1) + " $" + 1);

        System.out.println(M.lancer(0) + " $" + 0);
        System.out.println(M.lancer(7) + " $" + 7);

        System.out.println(M.lancer(4) + " $" + 4);
        System.out.println(M.lancer(4) + " $" + 4);

        System.out.println(M.lancer(5) + " $" + 5);
        System.out.println(M.lancer(5) + " $" + 5);

        System.out.println(M.lancer(8) + " $" + 8);
        System.out.println(M.lancer(1) + " $" + 1);

        System.out.println(M.lancer(0) + " $" + 0);
        System.out.println(M.lancer(7) + " $" + 7);

        System.out.println(M.lancer(4) + " $" + 4);
        System.out.println(M.lancer(6) + " $" + 6);
        System.out.println(M.lancer(10) + " $" + 10);

        System.out.println(M.lancer(10) + " $" + 10);
        System.out.println(M.lancer(10) + " $" + 10);
        System.out.println(M.lancer(10) + " $" + 10);

        System.out.println(M.scoreFor("Diego"));
        
        
        System.out.println(M.scoreFor("Bastide"));
        
        /* test 2 
        MultiPlayer M = new MultiPlayer();
        String[] L = {"Diego", "Pierre", "Matthias", "Maxime"};
        System.out.println(M.lancer(5) + " $" + 5);
         */
    }

}
