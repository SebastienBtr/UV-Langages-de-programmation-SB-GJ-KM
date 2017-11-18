package tp.v2;

public interface File<E> extends Iterable<E> {

	/*
	 * Accesseurs
	 */

	/**
	 * Recuperer le premier élément de la file
	 * @return le premier élément
	 */
	E premier();

	/**
	 * Recuperer la file sans sa tete
	 * @return la liste des éléments suivants
	 */
	File<E> suivants();

	/**
	 * Vérifie si la file est vide
	 * @return true si la file est vide
	 */
	default boolean estVide() {
		return this.taille() == 0;
	}

	/**
	 * Recuperer la taille de la file
	 * @return la taille
	 */
	int taille();
	
	/*
	 * Fabriques
	 */

	/**
	 * Créer une file
	 * @return la file créée
	 */
	File<E> creer();
	
	/*
	 * Services
	 */

	/**
	 * Ajoute un élément dans la file
	 * @param dernierDansFile l'élément à ajouter en fin de file
	 * @return la nouvelle file comprenant l'élément
	 */
	File<E> ajout(E dernierDansFile);

	/**
	 * Retire le premier élément de la file
	 * @return la nouvelle file sans l'élément retiré
	 */
	File<E> retrait();

	/**
	 * Ajoute une file à la suite de la file
	 * @param secondeFile la file à ajouter
	 * @return la nouvelle file créée
	 */
	File<E> ajout(File<E> secondeFile);

	/**
	 * Créé une représentation de la file
	 * @return la file sous forme de String la représentant
	 */
	default String representation() {
		if(this.estVide())
			return "vide";
		else
			return this.premier() + " " + this.suivants().representation();
	}

	/**
	 * Vérifie l'égalité entre file
	 * @param file la file à comparer
	 * @return true si les files sont égal
	 */
	default boolean estEgal(File<E> file){
		boolean ret = true;

		if (this.taille() == file.taille()) {

			while (!this.estVide() && ret) {
				if(! this.premier().equals(file.premier())) {
					ret = false;
				}
				else {
					ret = this.suivants().estEgal(file.suivants());
				}
			}
		}
		else {
			ret = false;
		}
		return ret;
    }

}