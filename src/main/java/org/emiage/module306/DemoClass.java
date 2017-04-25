/*
 * Class pour le module 306
 * Activité 1
 *
 */
package org.emiage.module306;

import java.util.Random;

/**
 *
 * @author cyril
 */
public final class DemoClass {

    /**
     * Constructeur privee pour empecher l'instantiation de classe.
     */
    private DemoClass() {
    }

    /**
     * Generation d'un tableau d'entiers aleatoires.
     *
     * @param size taille du tableau
     * @return un tableau d'entiers aleatoires
     */
    public static int[] randomTab(final int size) {
        Random rand = new Random();
        int[] tab = new int[size];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = rand.nextInt();
        }
        
        return tab;
        
        
        
    }

    /**
     * Renvoie l'indice du plus grand élément du tableau.
     *
     * @param tab :: tableau dans lequel on effectue la recherche
     * @param taille :: taille du tableau
     * @return indiceMax :: indice le plus grand
     *
     * return int l'indice du plus grand élément*
     */
    private static int max(final int[] tab, final int taille) {

        // on considère que le plus grand élément est le premier
        int i = 0, indiceMax = 0;

        while (i < taille) {
            if (tab[i] > tab[indiceMax]) {
                indiceMax = i;
            }
            i++;
        }

        return indiceMax;

    }

    /**
     * Échange deux éléments d'un tableau.
     *
     *
     * @param tab tableau d'entiers à trier
     * @param x : indice du premier élément
     * @param y : indice du deuxième élément return void
     *
     */
    private static void echanger(final int[]  tab, final int x, final int y) {

        int tmp;

        tmp = tab[x];
        tab[x] = tab[y];
        tab[y] = tmp;

    }

    /**
     * Tri a bulles.
     *
     * @param tab tableau d'entiers à trier
     *
     *
     */
    public static void bubbleSort(final int[] tab) {

        boolean sorted = false;
        int taille = tab.length;

        if (tab == null || tab.length == 0) {
            return;
        }

        while (!sorted) {

            sorted = true;

            for (int i = 0; i < taille - 1; i++) {

                if (tab[i] > tab[i + 1]) {
                    echanger(tab, i, i + 1);
                    sorted = false;
                }

            }

            taille--;

        }

    }

    /**
     * Tri par selection.
     *
     * @param tab tableau d'entiers à trier return void
     *
     */
    public static void selectSort(final int[] tab) {
        int indiceMax;
        int taille = tab.length;

        if (tab == null || tab.length == 0) {
            return;
        }

        // à chaque tour de boucle, on va déplacer le plus grand élément
        // vers la fin du tableau, on diminue donc à chaque fois sa taille
        // car le dernier élément est obligatoirement correctement
        // placé (et n'a donc plus besoin d'être parcouru/déplacé)
        // tant qu'il reste des éléments non triés
        for (; taille > 1; taille--) {
            indiceMax = max(tab, taille);
            echanger(tab, taille - 1, indiceMax); // on échange le dernier élément avec le plus grand
        }
    }

    /**
     * Tri rapide.
     *
     * @param tab tableau d'entiers à trier return void
     */
    public static void rapideSort(final int[] tab) {

        if (tab == null || tab.length == 0) {
            return;
        }

        int length = tab.length;
        quickSort(tab, 0, length - 1);
    }

    /**
     * Tri rapide de la sous partition.
     *
     * @param tab tableau d'entiers à trier
     * @param lowerIndex indice de debut
     * @param higherIndex indice de fin return void
     */
    private static void quickSort(final int[] tab, final int lowerIndex, final int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = tab[lowerIndex + (higherIndex - lowerIndex) / 2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a
             * number from right side which is less then the pivot value. Once
             * the search is done, then we exchange both numbers.
             */
            while (tab[i] < pivot) {
                i++;
            }
            while (tab[j] > pivot) {
                j--;
            }
            if (i <= j) {
                echanger(tab, i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j) {
            quickSort(tab, lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(tab, i, higherIndex);
        }
    }

    /**
     * Tri fusion.
     *
     * @param tab tableau d'entiers à trier
     *
     *
     */
    public static void mergeSort(final int[] tab) {
        int longueur = tab.length;
        if (longueur > 0) {
            mergeSortPartition(tab, 0, longueur - 1);
        }
    }

    /**
     * Tri fusion : paritionnement.
     *
     * @param tab tableau d'entiers à trier
     * @param deb indice début
     * @param fin indice fin
     *
     *
     */

    private static void mergeSortPartition(final int[] tab, final int deb, final int fin) {
        if (deb != fin) {
            int milieu = (fin + deb) / 2;
            mergeSortPartition(tab, deb, milieu);
            mergeSortPartition(tab, milieu + 1, fin);
            merge(tab, deb, milieu, fin);
        }
    }

      /**
     * Tri fusion : fusion finale .
     *
     * @param tab tableau d'entiers à trier
     * @param deb1 indice début initial
     * @param fin1 indice fin initial
     * @param fin2 indice fin   final
     *
     */

    private static void merge(final int[] tab, final int deb1, final int fin1, final int fin2) {
        int deb2 = fin1 + 1;

        //on recopie les éléments du début du tableau
        int[] table1  = new int[fin1 - deb1 + 1];
        for (int i = deb1; i <= fin1; i++) {
            table1[i - deb1] = tab[i];
        }

        int compt1 = deb1;
        int compt2 = deb2;

        for (int i = deb1; i <= fin2; i++) {
            //c'est que tous les éléments du premier tableau ont été utilisés
            //tous les éléments ont donc été classés
            if (compt1 == deb2) { 
                break; 
            }            //c'est que tous les éléments du second tableau ont été utilisés
            else if (compt2 == (fin2 + 1))  {
                tab[i] = table1[compt1 - deb1]; //on ajoute les éléments restants du premier tableau
                compt1++;
            } else if (table1[compt1 - deb1] < tab[compt2]) {
                tab[i] = table1[compt1 - deb1]; //on ajoute un élément du premier tableau
                compt1++;
            } else {
                tab[i] = tab[compt2]; //on ajoute un élément du second tableau
                compt2++;
            }
        }
    }

    /**
     * Programme principal.
     *
     * @param args Arguments du programme: taille du tableau
     */
    public static void main(final String[] args) {
        System.out.println("Generation du tableau");
        int[] tab ;        
        int size;
        
        if (args.length > 0){
            size = Integer.valueOf(args[0]);        
        }
        else {             
              System.out.println("tableau de paramètres vide");  
             size = 100;
        }        
        
         tab=randomTab(size);        
         mergeSort(tab);
         tab=randomTab(size); 
         rapideSort(tab);
         tab=randomTab(size); 
         selectSort(tab);
         tab=randomTab(size); 
         bubbleSort(tab);
         
    }

}
