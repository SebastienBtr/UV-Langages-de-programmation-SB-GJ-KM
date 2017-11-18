package tp.v2;

import java.util.Iterator;

public class FileImmutableImplementation<E> implements FileImmutable<E> {
    Liste<E> debut;
    Liste<E> fin;

    public FileImmutableImplementation(){
        debut = ListeMutable.vide();
        fin = ListeMutable.vide();
    }

    @Override
    public E premier() {
        return debut.tete();
    }

    @Override
    public FileImmutableImplementation<E> suivants() {
        FileImmutableImplementation<E> ret = new FileImmutableImplementation<E>();

        ret.debut = this.debut.reste();
        return ret;

    }

    @Override
    public int taille() {
        return debut.taille();
    }

    @Override
    public Iterator<E> iterator() {

        return new IterateurListe<E>() {
            FileMutable<E> list = new FileMutableImplementation<E>();

            public boolean hasNext() {
                return !list.estVide();
            }

            public E next() {
                E ret = list.premier();
                list = list.suivants();

                return ret;
            }
        };
    }

    @Override
    public FileImmutableImplementation<E> creer() {
        FileImmutableImplementation<E> ret = new FileImmutableImplementation<>();

        return ret;
    }

    @Override
    public FileImmutableImplementation<E> creer(E dernier) {
        FileImmutableImplementation<E> ret = new FileImmutableImplementation<>();
        ret.debut = Liste.cons(dernier, Liste.vide());

        return ret;
    }

    public FileImmutable<E> creer(FileImmutable<E> file, E dernier) {
        FileImmutableImplementation<E> ret = this.creer();

        //TODO

        return ret;
    }

}