package filRouge.v4;

public interface DecomposableSequentiellement<K, E> extends PossiblementVide { 
	E tete();
	K reste();
}
