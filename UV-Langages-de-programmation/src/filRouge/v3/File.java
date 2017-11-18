package filRouge.v3;

import java.util.Iterator;

public interface File<K extends File<K, E>, E> extends Iterable<E> {

	/*
	 * Accesseurs
	 */
	E premier();
	K suivants();
	
	default boolean estVide() {
		return this.taille() == 0;
	}
	int taille();
	
	/*
	 * Fabriques
	 */
	K creer();
	K sujet();
	
	/*
	 * Services
	 */
	K ajout(E dernierDansFile);
	K retrait();
	default K ajout(K secondeFile){
		K r = this.sujet();
		for(E e : secondeFile){
			r = r.ajout(e);
		}
		return r;
	}
	
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

	default boolean estEgal(K file){
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