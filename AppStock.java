import java.util.*;

public class AppStock {
    static int MAX_PRODUIT = 10;
    static int nbProduits = 0;
    static int codeProduit[] = new int[MAX_PRODUIT];
    static int qteProduit[] = new int[MAX_PRODUIT];
    static String nomProduit[] = new String[MAX_PRODUIT];
    static float prixProduit[] = new float[MAX_PRODUIT];
    static int choix;
    static Scanner clavier = new Scanner(System.in);
    static int codeARechercher = -1;
    static int code;
   static String nom;
    static int qte;
   static float prix;

    public static void main(String... args) {
        do {
            System.out.println("------------Gestion de Stock-----------");
            System.out.println("1. Ajouter un Produit");
            System.out.println("2. Modifier un Produit");
            System.out.println("3. Supprimer un Produit");
            System.out.println("4. Affichier la liste des produits ");
            System.out.println("5. Rechercher un Produit");
            System.out.println("6. Calculer la valeur du Stock ");
            System.out.println("0. Quitter");
            System.out.println("Choisissez une Option :");
            choix = clavier.nextInt();

            //appel de la fonction de traitement du choix de l'utilisateur
            choisirTraitement(choix);

        } while (choix != 0);
        //Quitter l'application
        System.out.println(" MERCI POUR VOTRE VISITE ! A BIENTÔT");
    }

    static void choisirTraitement(int choix) {
        switch (choix) {
            case 1:
                ajouterProduit();
                break;
            case 2:
                modifierProduit();
                break;
            case 3:
                supprimerProduit();
                break;
            case 4:
                afficherListeProduit();
                break;
            case 5: {
                System.out.println("Entre le Code du Produit à Rechercher :");
                codeARechercher = clavier.nextInt();
                int index = rechercherProduit();
                if (index != -1)
                    System.out.println("le produit se trouve à la Position " + index + " du tableau");
                else
                    System.out.println("le produit ne se trouve pas dans le tableau");
                break;
            }
            case 6:
                calculerValeurDuStock();
                break;
            default:
                break;

        }

    }

    static void ajouterProduit() {

        System.out.println("Entrer le Code:");
        code = clavier.nextInt();
        System.out.println("Entrer le nom :");
        nom = clavier.next();
        System.out.println("Entrer la quantité:");
        qte = clavier.nextInt();
        System.out.println("Entrer le Prix:");
        prix = clavier.nextFloat();

        codeProduit[nbProduits] = code;
        nomProduit[nbProduits] = nom;
        qteProduit[nbProduits] = qte;
        prixProduit[nbProduits] = prix;

        nbProduits++;


    }

    static void modifierProduit() {
        System.out.println("Entre le Code du Produit à Modifier :");
        codeARechercher = clavier.nextInt();
        int indexProduit = rechercherProduit();

        if (indexProduit == -1) {
            System.out.println("le produit ne se trouve pas dans le tableau");
            return;
        }
        System.out.println("Entrer nouveau nom :");
        nom = clavier.next();
        System.out.println("Entrer la nouvelle quantité:");
        qte = clavier.nextInt();
        System.out.println("Entrer le nouveau Prix:");
        prix = clavier.nextFloat();

        qteProduit[indexProduit] = qte;
        codeProduit[indexProduit] = code;
        nomProduit[indexProduit] = nom;
        prixProduit[indexProduit] = prix;
    }

    static void supprimerProduit() {
        System.out.println("Entre le Code du Produit à Supprimer :");
        codeARechercher = clavier.nextInt();
        int indexProduit = rechercherProduit();
        if (indexProduit == -1) {
            System.out.println("le Produit n'existe pas");
            return;
        }
        for (int j = indexProduit; j < codeProduit.length - 1; j++) {
            codeProduit[j] = codeProduit[j+1];
            nomProduit[j] = nomProduit[j+1];
            prixProduit[j] = prixProduit[j+1];
            qteProduit[j] = qteProduit[j+1];
        }
    }

    static void afficherListeProduit() {
        System.out.println("Liste des produits :");
        System.out.printf("%-10s%-20s%-10s%-10s%n", "Code", "Nom", "Quantité", "Prix");
        System.out.println("--------------------------------------------");
        for (int i = 0; i < codeProduit.length;  i++) {
            if (codeProduit[i]!=0)
               System.out.printf("%-10s%-20s%-10s%-10s%n", codeProduit[i], nomProduit[i], qteProduit[i], prixProduit[i]);
        }
    }

    static int rechercherProduit() {
        int i = 0;
        while (i < codeProduit.length) {
            if (codeProduit[i] == codeARechercher) {

                return i;
            }
            i++;
        }
        return -1;
    }

    static void calculerValeurDuStock() {
        float valeurStock = 0f;
        int qteTotale =0;
        for (int i = 0; i < codeProduit.length;  i++) {
            if (codeProduit[i] != 0) {
                qteTotale += qteProduit[i];
                valeurStock += qteProduit[i] * prixProduit[i];
            }
        }
        System.out.println("----------Valeur en Stock----------");
        System.out.println("Nombre total de produit :" + qteTotale);
        System.out.println("valeur du stock :" + valeurStock);
    }
}
