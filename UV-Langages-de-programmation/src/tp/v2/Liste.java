package tp.v2;

import java.util.Iterator;

public interface Liste<E> extends Iterable<E> {
	/*
	 * Accesseurs
	 */
	default boolean casVide() {
		return false;
	}
	default E tete() { throw new UnsupportedOperationException(); }
	default Liste<E> reste() {
		throw new UnsupportedOperationException();
	}
	default boolean casCons() {
		return false;
	}
	default public int taille(){
		return 0;
	}
	default public boolean estVide(){
		return this.taille() == 0;
	}
	
	/*
	 * Services
	 */
	default Iterator<E> iterator() {

		return new IterateurListe<>(); // Compléter puis utiliser IterateurListe.
	}

	default Liste<E> miroir(){

		return null;
	}

	/*
	 * Fabriques (statiques)
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
