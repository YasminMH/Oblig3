import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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

    @Override
    public void leggTil(T element) {
        setToMengde.add(element);

    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {

    }

    @Override
    public T fjern(T element) {
        return null;
    }

    @Override
    public T[] tilTabell() {
        return setToMengde.toArray();
    }

    @Override
    public int antallElementer() {
        return 0;
    }
}
