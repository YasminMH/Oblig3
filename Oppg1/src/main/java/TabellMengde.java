import java.util.Arrays;

public class TabellMengde<T> implements MengdeADT<T> {

    private static final int DEFAULT_KAPASITET = 10;
    private T[] tabell;
    private int antall;
    public TabellMengde(){
        this(DEFAULT_KAPASITET);
    }
    @SuppressWarnings("unchecked")
    public TabellMengde(int kapasitet){
        tabell = (T[]) new Object[kapasitet];
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
        for (int i = 0; i < antall; i++) {
            T elementFraTabell = tabell[i];
            if (elementFraTabell.equals(element)){
                return true;
            }
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
        for (T element: tabell){
            if (element == null) {
                continue;
            }
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
        for (T element : tabell){
            if (element == null) {
                continue;
            }
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
        for (T element : tabell) {
            if (element == null) {
                continue;
            }
            if (annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> snittAvToMengder = new TabellMengde<>();

        for (T element : tabell) {
            if (element == null) {
                continue;
            }
            if (annenMengde.inneholder(element)) {
                snittAvToMengder.leggTil(element);
            }
        }
        return snittAvToMengder;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        MengdeADT<T> unionAvToMengder = new TabellMengde<>();

        for (T element : tabell) {
            if (element == null) {
                continue;
            }
            if (!unionAvToMengder.inneholder(element)) {
                unionAvToMengder.leggTil(element);
            }
        }
        for (T element : annenMengde.tilTabell()) {
            if (element == null) {
                continue;
            }
            if (!unionAvToMengder.inneholder(element)) {
                unionAvToMengder.leggTil(element);
            }
        }
        return unionAvToMengder;
    }


    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        MengdeADT<T> mengdeMinusAnnenMangde = new TabellMengde<>();

        for (T element : tabell) {
            if (element == null) {
                continue;
            }
            if (!annenMengde.inneholder(element)) {
                mengdeMinusAnnenMangde.leggTil(element);
            }
        }
        return mengdeMinusAnnenMangde;
    }

    @Override
    public void leggTil(T element) {
        if (antall == tabell.length) {
            tabell = Arrays.copyOf(tabell, tabell.length * 2);
        }
        if (!inneholder(element)) {
            tabell[antall] = element;
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
        int indeks = 0;

        if (erTom()) {
            return null;
        }
        while (indeks < antall) {
            if (element.equals(tabell[indeks])) {
                tabell[indeks] = tabell[antall - 1];
                tabell[antall -1] = null;
                antall--;
                return element;
            } else {
                indeks++;
            }
        }
        return null;
    }

    @Override
    public T[] tilTabell() {
        T[] mengdeTilTabell = (T[]) new Object[antall];

        for (int i = 0; i < antall; i++) {
            mengdeTilTabell[i] = tabell[i];
        }
        return mengdeTilTabell;
    }

    @Override
    public int antallElementer() {
        return antall;
    }
}
