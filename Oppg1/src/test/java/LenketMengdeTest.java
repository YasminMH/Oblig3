import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LenketMengdeTest {
    private MengdeADT<Integer> m0;
    private MengdeADT<Integer> mi1;
    private MengdeADT<Integer> mi2;
    private MengdeADT<Integer> resMi;
    private MengdeADT<String> ms1;
    private MengdeADT<String> ms2;

    @BeforeEach
    void nullstill() {
        m0 = new LenketMengde<>();

        mi1 = new LenketMengde<>();
        mi1.leggTil(1);
        mi1.leggTil(4);

        mi2 = new LenketMengde<>();
        mi2.leggTil(1);
        mi2.leggTil(2);
        mi2.leggTil(3);

        resMi = new LenketMengde<>();
        resMi.leggTil(1);

        ms1 = new LenketMengde<>();
        ms1.leggTil("Test");

        ms2 = new LenketMengde<>();
        ms2.leggTil("Test");
        ms2.leggTil("Testesen");
    }



    // Ferdig ------------------------
    @Test
    void erTom() {
        assertEquals(0, m0.antallElementer());
        assertTrue(m0.antallElementer() == 0);
        assertTrue(m0.erTom());
        assertFalse(mi1.erTom());
        assertFalse(ms1.erTom());
    }

    // Ferdig ------------------------
    @Test
    void inneholder() {
        assertTrue(mi1.inneholder(1));
        assertTrue(mi2.inneholder(1));
        assertTrue(ms1.inneholder("Test"));
        assertFalse(m0.inneholder(0));
        assertFalse(mi1.inneholder(2));
    }

    @Test
    void erDelmengdeAv() {
        assertTrue(m0.erDelmengdeAv(m0));
        assertFalse(mi1.erDelmengdeAv(mi2));
        assertTrue(ms1.erDelmengdeAv(ms2));
        assertFalse(ms2.erDelmengdeAv(ms1));
    }

    @Test
    void erLik() {
        assertTrue(m0.erLik(m0));
        assertTrue(mi1.erLik(mi1));
        assertTrue(ms1.erLik(ms1));
        assertFalse(mi1.erLik(mi2));

    }

    @Test
    void erDisjunkt() {
        assertTrue(mi1.erDisjunkt(m0));
        assertFalse(mi1.erDisjunkt(mi2));
        assertFalse(ms1.erDisjunkt(ms2));
    }

    @Test
    void snitt() {
        assertArrayEquals(resMi.tilTabell(), mi1.snitt(mi2).tilTabell());
    }

    @Test
    void union() {
        assertArrayEquals(mi2.tilTabell(), mi2.union(resMi).tilTabell());
    }

    @Test
    void minus() {
        assertArrayEquals(m0.tilTabell(), mi1.minus(mi1).tilTabell());
    }

    // Ferdig ------------------------
    @Test
    void leggTil() {
        m0.leggTil(1);
        assertArrayEquals(resMi.tilTabell(), m0.tilTabell());
    }

    // Ferdig ------------------------
    @Test
    void leggTilAlleFra() {
        m0.leggTilAlleFra(mi2);
        assertTrue(m0.inneholder(1));
        assertTrue(m0.inneholder(2));
        assertTrue(m0.inneholder(3));
        assertFalse(m0.erTom());
    }

    // Ferdig ------------------------
    @Test
    void fjern() {
        mi1.fjern(4);
        assertArrayEquals(resMi.tilTabell(), mi1.tilTabell());
    }

    // Ferdig ------------------------
    @Test
    void tilTabell() {
        Object[] result = m0.tilTabell();
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    // Ferdig ------------------------
    @Test
    void antallElementer() {
        assertEquals(0, m0.antallElementer());
        assertEquals(2, mi1.antallElementer());
        assertEquals(3, mi2.antallElementer());
        assertEquals(1, ms1.antallElementer());
        assertEquals(2, ms2.antallElementer());
        assertNotEquals(1, mi2.antallElementer());
    }
}