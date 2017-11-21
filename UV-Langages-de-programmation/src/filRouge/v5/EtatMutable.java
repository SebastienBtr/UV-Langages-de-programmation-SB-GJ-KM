package filRouge.v5;

import java.util.Iterator;

public interface EtatMutable<E> {

    /*
	 * Accesseurs
	 */
    void ajouter(E element);
    void retirer();

    default public boolean estVide(){
        return this.taille() == 0;
    }

    default EtatMutable<E> suivants() {
        EtatMutable<E> r = creerCopie();
        r.retirer();
        return r;
    }

    E premier();

    int taille();

    Iterator<E> iterator();

    /*
	 * Fabriques
	 */

    EtatMutable<E> creer();

    EtatMutable<E> creerCopie(); // Fabrique réalisant une copie de la file


}
