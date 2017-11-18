package filRouge.v4;

import java.util.Iterator;

public interface FileImmutable<E> extends 
	File<FileImmutable<E>, E>,
	FabriqueSequence<FileImmutable<E>, E>,
	RepresentableParIteration<E>, IdentifiableParIteration<FileImmutable<?>, E>
{

	@Override
	default FileImmutable<E> ajout(E e) {
		return this.creer(e);
	}

	@Override
	default FileImmutable<E> retrait() {
		return this.reste();
	}

	@Override
	default Iterator<E> iterator() {
		return new IterateurSequence<FileImmutable<E>, E>(this);
	}
	
}
