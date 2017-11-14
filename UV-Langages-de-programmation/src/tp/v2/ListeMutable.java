package tp.v2;

import java.util.Iterator;

public interface ListeMutable<E> extends Liste<E>{

	/*
	 * Accesseurs.
	 */
	default ListeMutable<E> reste() {
		throw new UnsupportedOperationException();
	}

	default void changerReste(ListeMutable<E> reste) {
		throw new UnsupportedOperationException();
	}

	default void changerTete(E tete) {
		throw new UnsupportedOperationException();
	}

	/*
	 * Services
	 */
	default ListeMutable<E> miroir(){
		return null;
	}

	public static <E> ListeMutable<E> cons(E t, ListeMutable<E> r){

		return new ListeMutable<E>() {

			public E tete() {
				return t;
			}
			public ListeMutable<E> reste() { return r; }
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
					ListeMutable<E> list = ListeMutable.cons(t, r);

					public boolean hasNext() {
						return !list.estVide();
					}

					public E next() {
						if (!hasNext()) {
							throw new UnsupportedOperationException();
						}

						ListeMutable<E> tmp = list.reste();
						this.list = ListeMutable.cons(tmp.tete(), tmp.reste());
						return list.tete();
					}
				};
			}

			public void changerReste(ListeMutable<E> reste) {
				ListeMutable<E> refReste = r;
				refReste = reste;
			}

			public void changerTete(E tete) {
				E refTete = t;
				refTete = tete;

			}

			public ListeMutable<E> miroir(){

				ListeMutable<E> inverted ;

				Iterator<E> itr = this.iterator();
				E next = this.tete();

				inverted = ListeMutable.cons(next, ListeMutable.vide());

				while (itr.hasNext()) {
					next = itr.next();

					inverted = ListeMutable.cons(next, inverted);
				}

				return inverted;
			}
		};
	}

	public static <E> ListeMutable<E> vide() {
		return new ListeMutable<E>() {
			public void changerReste(ListeMutable<E> reste) {
				throw new UnsupportedOperationException();
			}

			public void changerTete(E tete) {
				throw new UnsupportedOperationException();
			}
		};
	}

}
