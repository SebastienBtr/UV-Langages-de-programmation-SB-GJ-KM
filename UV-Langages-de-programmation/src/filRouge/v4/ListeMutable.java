package filRouge.v4;

public interface ListeMutable<K extends FabriqueSequence<K, E>, E> extends ListeImmutable<K, E>, ModifiableSequentiellement<K, E> {

}
