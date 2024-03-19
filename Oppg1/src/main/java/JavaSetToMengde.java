import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class JavaSetToMengde<T> implements MengdeADT<T> {

    private Set<T> setToMengde;

    public JavaSetToMengde() {
        setToMengde = new HashSet<T>();
    }

    // Ferdig ------------------------
    @Override
    public boolean erTom() {
        return setToMengde.isEmpty();
    }

    // Ferdig ------------------------
    @Override
    public boolean inneholder(T element) {
        return setToMengde.contains(element);
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        if (setToMengde.isEmpty()) {
            return true;
        }
        return setToMengde.containsAll((Collection<?>) annenMengde);
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
        setToMengde.add(element);
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
        setToMengde.remove(element);
        return element;
    }

    // Ferdig ------------------------
    @Override
    public T[] tilTabell() {
        int antall = setToMengde.size();
        T[] mengdeTilTabell = (T[]) new Object[antall];
        System.arraycopy(setToMengde.toArray(), 0, mengdeTilTabell, 0, antall);
        return mengdeTilTabell;
    }

    // Ferdig ------------------------
    @Override
    public int antallElementer() {
        return setToMengde.size();
    }
}
