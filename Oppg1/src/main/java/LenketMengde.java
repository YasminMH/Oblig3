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

    // Ferdig ------------------------
    @Override
    public boolean inneholder(T element) {
        if (erTom()) {
            return false;
        }
        Node temp = forste;
        while (temp != null) {
            if (temp.data.equals(element)) {
                return true;
            }
            temp = temp.neste;
        }
        return false;
    }

    // Ferdig ------------------------
    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        if (erTom()){
            return true;
        }
        if (antall > annenMengde.antallElementer()){
            return false;
        }
        for (T element: tilTabell()){
            if (!annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    // Ferdig ------------------------
    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        if (erTom() && annenMengde.erTom()) {
            return true;
        }
        if (antall != annenMengde.antallElementer()) {
            return false;
        }
        for (T element : tilTabell()){
            if (!annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    // Ferdig ------------------------
    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        if (erTom() && annenMengde.erTom()) {
            return false;
        }
        for (T element : tilTabell()) {
            if (annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    // Ferdig ------------------------
    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> snittAvToMengder = new LenketMengde<>();

        for (T element : tilTabell()) {
            if (annenMengde.inneholder(element)) {
                snittAvToMengder.leggTil(element);
            }
        }
        return snittAvToMengder;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        MengdeADT<T> unionAvToMengder = new LenketMengde<>();

        for (T element : tilTabell()) {
            if (!unionAvToMengder.inneholder(element)) {
                unionAvToMengder.leggTil(element);
            }
        }
        for (T element : annenMengde.tilTabell()) {
            if (!unionAvToMengder.inneholder(element)) {
                unionAvToMengder.leggTil(element);
            }
        }
        return unionAvToMengder;
    }

    // Ferdig ------------------------
    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        MengdeADT<T> mengdeMinusAnnenMangde = new LenketMengde<>();

        for (T element : tilTabell()) {
            if (!annenMengde.inneholder(element)) {
                mengdeMinusAnnenMangde.leggTil(element);
            }
        }
        return mengdeMinusAnnenMangde;
    }

    // Ferdig ------------------------
    @Override
    public void leggTil(T element) {
        Node ny = new Node(element);
        ny.neste = forste;
        forste = ny;
        antall++;
    }

    // Ferdig ------------------------
    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        for (T element : annenMengde.tilTabell()) {
            leggTil(element);
        }
    }

    // Ferdig ------------------------
    @Override
    public T fjern(T element) {
        if (erTom()) {
            return null;
        }
        Node temp = forste;
        while (temp != null) {
            if (temp.data.equals(element)) {
                temp.data = forste.data;
                forste = forste.neste;
                antall--;
                return element;
            }
            temp = temp.neste;
        }
        return null;
    }

    // Ferdig ------------------------
    @Override
    public T[] tilTabell() {
        @SuppressWarnings("unchecked")
        T[] mengdeTilTabell = (T[]) new Object[antall];

        Node temp = forste;
        int i = 0;
        while (temp != null) {
            mengdeTilTabell[i] = temp.data;
            temp = temp.neste;
            i++;
        }

        return mengdeTilTabell;
    }

    // Ferdig ------------------------
    @Override
    public int antallElementer() {
        return antall;
    }
}
