package filRouge.v2;

import java.util.Iterator;

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
		if (this.estVide()) {
			return "[]";
		}
		Iterator<E> iter = this.iterator();
		StringBuilder r = new StringBuilder();
		r.append("[");
		r.append(iter.next().toString());
		while (iter.hasNext()) {
			r.append(", ");
			r.append(iter.next().toString());
		}
		r.append("]");
		return r.toString();
	}

	default boolean estEgal(File<E> file){
		if(this.taille() != file.taille()){
			return false;
		}
		Iterator<E> iter1 = this.iterator();
		Iterator<E> iter2 = file.iterator();
		while (iter1.hasNext()) {
			if(!iter1.next().equals(iter2.next())){
				return false;
			}
		}
		return true;
	}
	
	
}