package tp.v2;

public interface File<E> extends Iterable<E> {

	/*
	 * Accesseurs
	 */
	E premier();
	File<E> suivants();
	
	default boolean estVide() {
		return this.taille() == 0;
	}
	int taille();
	
	/*
	 * Fabriques
	 */
	File<E> creer();
	
	/*
	 * Services
	 */
	File<E> ajout(E dernierDansFile);
	File<E> retrait();
	File<E> ajout(File<E> secondeFile);
	
	default String representation() {
		return this.premier() + " " + this.suivants().representation();
	}

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