package filRouge.v4;

import java.util.Iterator;

public interface IdentifiableParIteration<K extends Mesurable & Iterable<?>, E>
		extends Identifiable<K>, Mesurable, Iterable<E> {

	default boolean estEgal(K autre) {
		if (this.taille() != autre.taille()) {
			return false;
		}
		Iterator<E> iter1 = this.iterator();
		Iterator<?> iter2 = autre.iterator();
		while (iter1.hasNext()) {
			if (!iter1.next().equals(iter2.next())) {
				return false;
			}
		}
		return true;
	}

}
