package filRouge.v5;

public interface File<K extends File<K, E>, E> extends Iterable<E>, Mesurable {

    /*
	 * Accesseurs
	 */
    E premier(); // Premier de la file
    K suivants(); // Ses suivants

    public boolean estVide();

    /*
	 * Fabriques
	 */
    K creer(); // fabrique d'une file vide

    @SuppressWarnings("unchecked")
    default K sujet(){ // Alias de this
        return (K)this;
    }

    /*
	 * Services
	 */
    K ajout(E dernierDansFile); // Ajout en fin

    K retrait(); // Retrait de premier élément

    default K ajout(K secondeFile) { // Ajout de la seconde file en fin de file
        K r = this.sujet();
        for(E e : secondeFile){
            r = r.ajout(e);
        }
        return r;
    };
}
