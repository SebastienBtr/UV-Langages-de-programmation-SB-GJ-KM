package tp.v2;

import java.util.Iterator;

public interface Liste<E> extends Iterable<E> {
	/*
	 * Accesseurs
	 */

    /**
     * Vérifie si la liste est une liste vide
     * @return true si la liste est une liste vide
     */
	default boolean casVide() {
		return false;
	}

    /**
     * Récupère l'élément en tête de liste
     * @return l'élément de la tête de la liste
     */
	default E tete() { throw new UnsupportedOperationException(); }

    /**
     * Acceder au reste de la liste, c'est à dire la liste
     * sans la tete
     * @return une liste qui est le reste de la liste
     */
	default Liste<E> reste() {
		throw new UnsupportedOperationException();
	}

    /**
     * Vérifie si la liste est un liste créé (non liste vide)
     * @return true si la liste est créé (non liste vide)
     */
	default boolean casCons() {
		return false;
	}

    /**
     * Acceder à la taille de la liste
     * @return la taille de la liste
     */
	default public int taille(){
		return 0;
	}

    /**
     * Vérifie si la liste est vide
     * @return true si la liste est vide
     */
	default public boolean estVide(){
		return this.taille() == 0;
	}
	
	/*
	 * Services
	 */

    /**
     * Créé un iterateur
     * @return l'iterateur créé
     */
	default Iterator<E> iterator() {

		return new IterateurListe<>();
	}

    /**
     * Inverse la liste
     * @return la nouvelle liste inversé
     */
	default Liste<E> miroir(){

		return null;
	}

	/*
	 * Fabriques (statiques)
	 */

    /**
     * Créé une liste vide
     * @param <E> le type d'élément de la liste
     * @return la liste vide créé
     */
	public static <E> Liste<E> vide() {

		return new Liste<E>() {

			public boolean casVide() {
				return true;
			}

			public Iterator<E> iterator() {

				return null;
			}

			public Liste<E> miroir(){

				return this;
			}

		};
	}

    /**
     * Créé un liste non vide
     * @param t l'élément en tête de liste
     * @param r une liste représentant le reste de la liste
     * @param <E> le type d'élément de la liste
     * @return la liste non vide
     */
	public static <E> Liste<E> cons(E t, Liste<E> r) {

		return new Liste<E>() {

			public E tete() {
				return t;
			}
			public Liste<E> reste() { return r; }
			public boolean casCons() {
				return true;
			}
			public int taille(){
				return 1 + this.reste().taille();
			}
			public boolean estVide(){
				return this.reste().taille() == 0;
			}


			public Iterator<E> iterator() {
				return new IterateurListe<E>() {
					Liste<E> list = Liste.cons(t, r);

					public boolean hasNext() {
						return !list.estVide();
					}

					public E next() {
						if (!hasNext()) {
							throw new UnsupportedOperationException();
						}

						Liste<E> tmp = list.reste();
						this.list = Liste.cons(tmp.tete(), tmp.reste());
						return list.tete();
					}
				};
			}

			public Liste<E> miroir(){

				Liste<E> inverted;
				Iterator<E> itr = this.iterator();
				E next = this.tete();

				inverted = Liste.cons(next, Liste.vide());

				while (itr.hasNext()) {
					next = itr.next();

					inverted = Liste.cons(next, inverted);
				}

				return inverted;
			}

		};
	}
	
}
