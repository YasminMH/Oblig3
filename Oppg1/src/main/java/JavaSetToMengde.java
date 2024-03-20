import java.util.*;

public class JavaSetToMengde<T> implements MengdeADT<T> {

    private Set<T> setToMengde;

    public JavaSetToMengde() {
        setToMengde = new HashSet<T>();
    }

    @Override
    public boolean erTom() {
        return setToMengde.isEmpty();
    }

    @Override
    public boolean inneholder(T element) {
        return setToMengde.contains(element);
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        if (erTom()) {
            return true;
        }
        if (antallElementer() > annenMengde.antallElementer()) {
            return false;
        }
        for (T element : setToMengde) {
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
        if (antallElementer() != annenMengde.antallElementer()) {
            return false;
        }
        for (T element : setToMengde) {
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
        for (T element : setToMengde) {
            if (annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> snittAvToMengder = new JavaSetToMengde<>();

        for (T element : setToMengde) {
            if (annenMengde.inneholder(element)) {
                snittAvToMengder.leggTil(element);
            }
        }
        return snittAvToMengder;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        MengdeADT<T> unionAvToMengder = new JavaSetToMengde<>();

        for (T element : setToMengde) {
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
        MengdeADT<T> mengdeMinusAnnenMangde = new JavaSetToMengde<>();

        for (T element : setToMengde) {
            if (!annenMengde.inneholder(element)) {
                mengdeMinusAnnenMangde.leggTil(element);
            }
        }
        return mengdeMinusAnnenMangde;
    }

    @Override
    public void leggTil(T element) {
        setToMengde.add(element);
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        for (T element : annenMengde.tilTabell()) {
            leggTil(element);
        }
    }

    @Override
    public T fjern(T element) {
        setToMengde.remove(element);
        return element;
    }

    @Override
    public T[] tilTabell() {
        int antall = setToMengde.size();
        T[] mengdeTilTabell = (T[]) new Object[antall];
        System.arraycopy(setToMengde.toArray(), 0, mengdeTilTabell, 0, antall);
        return mengdeTilTabell;
    }

    @Override
    public int antallElementer() {
        return setToMengde.size();
    }
}
