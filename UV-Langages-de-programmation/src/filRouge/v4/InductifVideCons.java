package filRouge.v4;

public interface InductifVideCons<K, E> extends DecomposableSequentiellement<K, E> {
	default boolean casVide() {
		return false;
	}
	default boolean casCons() {
		return false;
	}
	default E tete() {
		throw new UnsupportedOperationException();
	}
	default K reste() {
		throw new UnsupportedOperationException();
	}
}
