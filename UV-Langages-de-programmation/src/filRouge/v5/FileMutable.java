package filRouge.v5;

public interface FileMutable<E> extends IdentifiableParIteration<FileMutable<E>, E>, RepresentableParIteration<E>, File<FileMutable<E>, E> {

    /*
	 * Accesseurs
	 */
    void ajouter(E element);
    void retirer();

    default FileMutable<E> suivants() {
        FileMutable<E> r = creerCopie();
        r.retirer();
        return r;
    }

    /*
	 * Fabriques
	 */
    FileMutable<E> creerCopie(); // Fabrique réalisant une copie de la file

    /*
	 * Services
	 */
    @Override
    default FileMutable<E> ajout(E dernierDansFile) {
        this.ajouter(dernierDansFile);
        return this;
    }

    @Override
    default FileMutable<E> retrait() {
        this.retirer();
        return this;
    }

    // Complexité en O(1).
    void ajouter(FileMutable<E> secondeFile); //facultatif

}
