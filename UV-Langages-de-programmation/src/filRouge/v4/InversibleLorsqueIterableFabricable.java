package filRouge.v4;

public interface InversibleLorsqueIterableFabricable<K extends FabriqueSequence<K, E>, E> extends Inversible<K>, FabriqueVide<K>, FabriqueSequence<K, E>, Iterable<E> {
	default K miroir() {
		K r = this.creer();
		for(E e : this){
			r = r.creer(e);
		}
		return r;
	}
}
