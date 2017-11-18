package filRouge.v4;

public interface ListeImmutable<K extends FabriqueSequence<K, E>, E> extends InductifVideCons<K, E>, Mesurable, PossiblementVideLorsqueMesurable, FabriqueVide<K>,
		FabriqueSequence<K, E>, Iterable<E>, InversibleLorsqueIterableFabricable<K, E> {

}
