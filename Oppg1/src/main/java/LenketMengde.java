public class LenketMengde<T> implements MengdeADT<T>{

    private class Node {

        private T data;
        private Node neste;

        private Node(T data) {
            this.data = data;
            this.neste = null;
        }
    }

    private Node forste;
    private int antall;

    public LenketMengde() {
        forste = null;
        antall = 0;
    }

    // Ferdig ------------------------
    @Override
    public boolean erTom() {
        return antall == 0;
    }

    @Override
    public boolean inneholder(T element) {
        if (erTom()) {
            return false;
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        return false;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        return false;
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        return false;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        return null;
    }

    // Ferdig ------------------------
    @Override
    public void leggTil(T element) {
        Node ny = new Node(element);
        ny.neste = forste;
        forste = ny;
        antall++;
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        for (T element : annenMengde.tilTabell()) {
            leggTil(element);
        }
    }

    @Override
    public T fjern(T element) {
        return null;
    }

    @Override
    public T[] tilTabell() {
        @SuppressWarnings("unchecked")
        T[] mengdeTilTabell = (T[]) new Object[antall];

        // Kopiere over alle elementene

        return mengdeTilTabell;
    }

    // Ferdig ------------------------
    @Override
    public int antallElementer() {
        return antall;
    }
}
