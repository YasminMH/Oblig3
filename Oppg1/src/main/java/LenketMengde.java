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

    @Override
    public boolean erTom() {
        return antall == 0;
    }

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

    @Override
    public void leggTil(T element) {
        if (!inneholder(element)) {
            Node ny = new Node(element);
            ny.neste = forste;
            forste = ny;
            antall++;
        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        for (T element : annenMengde.tilTabell()) {
            leggTil(element);
        }
    }

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

    @Override
    public int antallElementer() {
        return antall;
    }
}
