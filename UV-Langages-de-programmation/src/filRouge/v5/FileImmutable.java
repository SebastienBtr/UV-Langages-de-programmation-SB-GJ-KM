package filRouge.v5;

public interface FileImmutable<E> extends File<FileImmutable<E>, E>,  IdentifiableParIteration<FileMutable<E>, E>, RepresentableParIteration<E> {

    /*
     * Fabriques
     */
    FileImmutable<E> creer(E dernier);
    // Fabrique d'une file formée de la file cible et
    //   d'un nouveau dernier élément

    @Override
    default FileImmutable<E> sujet() {
        return this;
    }

    /*
     * Services
     */
    @Override
    default FileImmutable<E> ajout(E dernierDansFile) {
        return this.creer(dernierDansFile);
    }

    @Override
    default FileImmutable<E> retrait() {
        return this.suivants();
    }

}
