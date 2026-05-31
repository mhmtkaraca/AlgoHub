package com.example.proje;

import org.junit.Test;
import static org.junit.Assert.*;

public class SearchAlgorithmTest {

    private static final double DELTA = 1e-6;

    // ─── LINEAR SEARCH ─────────────────────────────────────────────────────

    @Test
    public void linearSearch_ilkEleman() {
        double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0};
        assertEquals(0, AlgorithmUtils.linearSearch(arr, 1.0));
    }

    @Test
    public void linearSearch_sonEleman() {
        double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0};
        assertEquals(4, AlgorithmUtils.linearSearch(arr, 5.0));
    }

    @Test
    public void linearSearch_ortaEleman() {
        double[] arr = {10.0, 20.0, 30.0, 40.0, 50.0};
        assertEquals(2, AlgorithmUtils.linearSearch(arr, 30.0));
    }

    @Test
    public void linearSearch_bulunamadi() {
        double[] arr = {1.0, 2.0, 3.0};
        assertEquals(-1, AlgorithmUtils.linearSearch(arr, 99.0));
    }

    @Test
    public void linearSearch_tekEleman_bulundu() {
        double[] arr = {42.0};
        assertEquals(0, AlgorithmUtils.linearSearch(arr, 42.0));
    }

    @Test
    public void linearSearch_tekEleman_bulunamadi() {
        double[] arr = {42.0};
        assertEquals(-1, AlgorithmUtils.linearSearch(arr, 0.0));
    }

    @Test
    public void linearSearch_negatifHedef() {
        double[] arr = {-5.0, -3.0, -1.0, 0.0, 2.0};
        assertEquals(0, AlgorithmUtils.linearSearch(arr, -5.0));
    }

    @Test
    public void linearSearch_sifirHedef() {
        double[] arr = {-1.0, 0.0, 1.0};
        assertEquals(1, AlgorithmUtils.linearSearch(arr, 0.0));
    }

    @Test
    public void linearSearch_ondalikHedef() {
        double[] arr = {1.1, 2.2, 3.3, 4.4};
        assertEquals(2, AlgorithmUtils.linearSearch(arr, 3.3));
    }

    @Test
    public void linearSearch_tumEsit_ilkBulunur() {
        double[] arr = {5.0, 5.0, 5.0};
        assertEquals(0, AlgorithmUtils.linearSearch(arr, 5.0));
    }

    // ─── BINARY SEARCH ─────────────────────────────────────────────────────

    @Test
    public void binarySearch_ilkEleman() {
        double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0};
        assertNotEquals(-1, AlgorithmUtils.binarySearch(arr, 1.0));
    }

    @Test
    public void binarySearch_sonEleman() {
        double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0};
        assertNotEquals(-1, AlgorithmUtils.binarySearch(arr, 5.0));
    }

    @Test
    public void binarySearch_ortaEleman() {
        double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0};
        assertNotEquals(-1, AlgorithmUtils.binarySearch(arr, 3.0));
    }

    @Test
    public void binarySearch_bulunamadi() {
        double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0};
        assertEquals(-1, AlgorithmUtils.binarySearch(arr, 6.0));
    }

    @Test
    public void binarySearch_tekEleman_bulundu() {
        double[] arr = {7.0};
        assertNotEquals(-1, AlgorithmUtils.binarySearch(arr, 7.0));
    }

    @Test
    public void binarySearch_tekEleman_bulunamadi() {
        double[] arr = {7.0};
        assertEquals(-1, AlgorithmUtils.binarySearch(arr, 8.0));
    }

    @Test
    public void binarySearch_negatifSayilar() {
        double[] arr = {-10.0, -5.0, -1.0, 0.0, 3.0};
        assertNotEquals(-1, AlgorithmUtils.binarySearch(arr, -10.0));
    }

    @Test
    public void binarySearch_sifir() {
        double[] arr = {-2.0, 0.0, 2.0};
        assertNotEquals(-1, AlgorithmUtils.binarySearch(arr, 0.0));
    }

    @Test
    public void binarySearch_ondalik() {
        double[] arr = {1.5, 2.5, 3.5};
        assertNotEquals(-1, AlgorithmUtils.binarySearch(arr, 2.5));
    }

    @Test
    public void binarySearch_sirasisizGiris_bulundu() {
        // Binary search kendi içinde sıralıyor olmalı
        double[] arr = {5.0, 1.0, 3.0, 2.0, 4.0};
        assertNotEquals(-1, AlgorithmUtils.binarySearch(arr, 1.0));
    }

    @Test
    public void binarySearch_sirasisizGiris_bulunamadi() {
        double[] arr = {5.0, 1.0, 3.0};
        assertEquals(-1, AlgorithmUtils.binarySearch(arr, 99.0));
    }

    // ─── INTERPOLATION SEARCH ──────────────────────────────────────────────

    @Test
    public void interpolationSearch_ilkEleman() {
        double[] arr = {10.0, 20.0, 30.0, 40.0, 50.0};
        assertNotEquals(-1, AlgorithmUtils.interpolationSearch(arr, 10.0));
    }

    @Test
    public void interpolationSearch_sonEleman() {
        double[] arr = {10.0, 20.0, 30.0, 40.0, 50.0};
        assertNotEquals(-1, AlgorithmUtils.interpolationSearch(arr, 50.0));
    }

    @Test
    public void interpolationSearch_ortaEleman() {
        double[] arr = {10.0, 20.0, 30.0, 40.0, 50.0};
        assertNotEquals(-1, AlgorithmUtils.interpolationSearch(arr, 30.0));
    }

    @Test
    public void interpolationSearch_bulunamadi() {
        double[] arr = {10.0, 20.0, 30.0};
        assertEquals(-1, AlgorithmUtils.interpolationSearch(arr, 25.0));
    }

    @Test
    public void interpolationSearch_tekEleman_bulundu() {
        double[] arr = {15.0};
        assertNotEquals(-1, AlgorithmUtils.interpolationSearch(arr, 15.0));
    }

    @Test
    public void interpolationSearch_tekEleman_bulunamadi() {
        double[] arr = {15.0};
        assertEquals(-1, AlgorithmUtils.interpolationSearch(arr, 16.0));
    }

    @Test
    public void interpolationSearch_tumEsit_bulundu() {
        // Sıfıra bölme sınır durumu
        double[] arr = {5.0, 5.0, 5.0};
        assertNotEquals(-1, AlgorithmUtils.interpolationSearch(arr, 5.0));
    }

    @Test
    public void interpolationSearch_tumEsit_bulunamadi() {
        // Sıfıra bölme sınır durumu - farklı değer aranıyor
        double[] arr = {5.0, 5.0, 5.0};
        assertEquals(-1, AlgorithmUtils.interpolationSearch(arr, 6.0));
    }

    @Test
    public void interpolationSearch_negatif() {
        double[] arr = {-20.0, -10.0, 0.0, 10.0, 20.0};
        assertNotEquals(-1, AlgorithmUtils.interpolationSearch(arr, -20.0));
    }

    @Test
    public void interpolationSearch_ondalik() {
        double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0};
        // 1.5 dizide yok
        assertEquals(-1, AlgorithmUtils.interpolationSearch(arr, 1.5));
    }
}
