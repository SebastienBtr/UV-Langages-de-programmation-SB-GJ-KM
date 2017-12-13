package filRouge.v6;

import filRouge.v5.Mesurable;

public interface File<K extends File<K, E>, E> extends EtatFile<K, E>, Iterable<E>, Mesurable {

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
	
}