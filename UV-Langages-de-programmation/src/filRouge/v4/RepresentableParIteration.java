package filRouge.v4;

import java.util.Iterator;

public interface RepresentableParIteration<E> extends Representable, Iterable<E> { 

	default String representation() {
		Iterator<E> iter = this.iterator();
		if (!iter.hasNext()) {
			return "[]";
		}
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
}
