package com.example.proje;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class SortingAlgorithmTest {

    private static final double DELTA = 1e-6;

    // Algoritmanın sonucunu Java'nın Arrays.sort ile karşılaştır
    private void assertSorted(double[] result, double[] expected) {
        double[] exp = expected.clone();
        Arrays.sort(exp);
        assertArrayEquals(exp, result, DELTA);
    }

    // ─── TEK ELEMAN ────────────────────────────────────────────────────────

    @Test
    public void insertionSort_tekEleman() {
        double[] arr = {42.0};
        AlgorithmUtils.insertionSort(arr);
        assertArrayEquals(new double[]{42.0}, arr, DELTA);
    }

    @Test
    public void selectionSort_tekEleman() {
        double[] arr = {-7.5};
        AlgorithmUtils.selectionSort(arr);
        assertArrayEquals(new double[]{-7.5}, arr, DELTA);
    }

    @Test
    public void bubbleSort_tekEleman() {
        double[] arr = {0.0};
        AlgorithmUtils.bubbleSort(arr);
        assertArrayEquals(new double[]{0.0}, arr, DELTA);
    }

    // ─── İKİ ELEMAN (yer değiştirmeli / değiştirmesiz) ────────────────────

    @Test
    public void insertionSort_ikiEleman_tersine() {
        double[] arr = {9.9, 1.1};
        AlgorithmUtils.insertionSort(arr);
        assertArrayEquals(new double[]{1.1, 9.9}, arr, DELTA);
    }

    @Test
    public void bubbleSort_ikiEleman_zatenSirali() {
        double[] arr = {-3.0, 5.0};
        AlgorithmUtils.bubbleSort(arr);
        assertArrayEquals(new double[]{-3.0, 5.0}, arr, DELTA);
    }

    @Test
    public void selectionSort_ikiEleman_esit() {
        double[] arr = {4.4, 4.4};
        AlgorithmUtils.selectionSort(arr);
        assertArrayEquals(new double[]{4.4, 4.4}, arr, DELTA);
    }

    // ─── ZATEN SIRALI ──────────────────────────────────────────────────────

    @Test
    public void shellSort_zatanSirali() {
        double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0};
        AlgorithmUtils.shellSort(arr);
        assertArrayEquals(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, arr, DELTA);
    }

    @Test
    public void mergeSort_zatanSirali() {
        double[] arr = {-5.0, 0.0, 3.5, 7.0};
        AlgorithmUtils.mergeSort(arr, 0, arr.length - 1);
        assertArrayEquals(new double[]{-5.0, 0.0, 3.5, 7.0}, arr, DELTA);
    }

    // ─── TERS SIRALI ───────────────────────────────────────────────────────

    @Test
    public void quickSort_tersSirali() {
        double[] arr = {10.0, 8.0, 6.0, 4.0, 2.0};
        AlgorithmUtils.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(new double[]{2.0, 4.0, 6.0, 8.0, 10.0}, arr, DELTA);
    }

    @Test
    public void heapSort_tersSirali() {
        double[] arr = {5.5, 4.4, 3.3, 2.2, 1.1};
        AlgorithmUtils.heapSort(arr);
        assertArrayEquals(new double[]{1.1, 2.2, 3.3, 4.4, 5.5}, arr, DELTA);
    }

    // ─── TÜM ELEMANLAR EŞİT ────────────────────────────────────────────────

    @Test
    public void bubbleSort_tumEsit() {
        double[] arr = {3.0, 3.0, 3.0, 3.0};
        AlgorithmUtils.bubbleSort(arr);
        assertArrayEquals(new double[]{3.0, 3.0, 3.0, 3.0}, arr, DELTA);
    }

    @Test
    public void quickSort3_tumEsit() {
        double[] arr = {7.7, 7.7, 7.7};
        AlgorithmUtils.quickSort3(arr, 0, arr.length - 1);
        assertArrayEquals(new double[]{7.7, 7.7, 7.7}, arr, DELTA);
    }

    // ─── NEGATİF SAYILAR ───────────────────────────────────────────────────

    @Test
    public void insertionSort_tamNegative() {
        double[] arr = {-1.0, -5.0, -3.0, -2.0, -4.0};
        double[] expected = arr.clone();
        AlgorithmUtils.insertionSort(arr);
        assertSorted(arr, expected);
    }

    @Test
    public void radixSort_negativeVePositive() {
        double[] arr = {-2.5, 3.1, -0.5, 0.0, 1.7};
        double[] expected = arr.clone();
        AlgorithmUtils.radixSort(arr);
        assertSorted(arr, expected);
    }

    @Test
    public void shakerSort_negatif() {
        double[] arr = {-10.0, -1.0, -5.0, -3.0};
        double[] expected = arr.clone();
        AlgorithmUtils.shakerSort(arr);
        assertSorted(arr, expected);
    }

    // ─── ONDALIK SAYILAR ───────────────────────────────────────────────────

    @Test
    public void mergeSort_ondalik() {
        double[] arr = {3.14, 1.41, 2.71, 0.57};
        double[] expected = arr.clone();
        AlgorithmUtils.mergeSort(arr, 0, arr.length - 1);
        assertSorted(arr, expected);
    }

    @Test
    public void heapSort_ondalik() {
        double[] arr = {0.001, 0.0001, 0.01, 0.1};
        double[] expected = arr.clone();
        AlgorithmUtils.heapSort(arr);
        assertSorted(arr, expected);
    }

    @Test
    public void combSort_ondalikNegatif() {
        double[] arr = {-1.5, 2.5, -0.5, 0.5, 1.5};
        double[] expected = arr.clone();
        AlgorithmUtils.combSort(arr);
        assertSorted(arr, expected);
    }

    // ─── SIFIR DEĞERİ ──────────────────────────────────────────────────────

    @Test
    public void shellSort_sifirIcerir() {
        double[] arr = {5.0, 0.0, -3.0, 0.0, 2.0};
        double[] expected = arr.clone();
        AlgorithmUtils.shellSort(arr);
        assertSorted(arr, expected);
    }

    @Test
    public void gnomeSort_sifirlar() {
        double[] arr = {0.0, 0.0, 0.0};
        AlgorithmUtils.gnomeSort(arr);
        assertArrayEquals(new double[]{0.0, 0.0, 0.0}, arr, DELTA);
    }

    // ─── TEKRAR EDEN ELEMANLAR ─────────────────────────────────────────────

    @Test
    public void strandSort_tekraranlar() {
        double[] arr = {4.0, 2.0, 4.0, 1.0, 2.0};
        double[] expected = arr.clone();
        AlgorithmUtils.strandSort(arr);
        assertSorted(arr, expected);
    }

    @Test
    public void bucketSort_tekraranOndalik() {
        double[] arr = {1.5, 2.5, 1.5, 3.5, 2.5};
        double[] expected = arr.clone();
        AlgorithmUtils.bucketSort(arr);
        assertSorted(arr, expected);
    }

    // ─── STOOGE SORT SINIR ─────────────────────────────────────────────────

    @Test
    public void stoogeSort_ikiEleman() {
        double[] arr = {9.0, 1.0};
        AlgorithmUtils.stoogeSort(arr, 0, arr.length - 1);
        assertArrayEquals(new double[]{1.0, 9.0}, arr, DELTA);
    }

    @Test
    public void stoogeSort_ucEleman() {
        double[] arr = {3.0, 1.0, 2.0};
        AlgorithmUtils.stoogeSort(arr, 0, arr.length - 1);
        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, arr, DELTA);
    }

    // ─── GENEL DOĞRULUK (isSorted) ─────────────────────────────────────────

    @Test
    public void isSorted_siraliBekleniyor() {
        assertTrue(AlgorithmUtils.isSorted(new double[]{1.0, 2.0, 3.0}));
    }

    @Test
    public void isSorted_siralisizBekleniyor() {
        assertFalse(AlgorithmUtils.isSorted(new double[]{3.0, 1.0, 2.0}));
    }

    @Test
    public void isSorted_tekEleman() {
        assertTrue(AlgorithmUtils.isSorted(new double[]{99.0}));
    }

    @Test
    public void isSorted_esitElemanlar() {
        assertTrue(AlgorithmUtils.isSorted(new double[]{5.0, 5.0, 5.0}));
    }
}
