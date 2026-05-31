package com.example.proje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AlgorithmUtils {

    // ===================== SIRALAMA =====================

    public static void insertionSort(double[] arr) {
        for (int i = 1; i < arr.length; i++) {
            double key = arr[i]; int j = i - 1;
            while (j >= 0 && arr[j] > key) { arr[j + 1] = arr[j]; j--; }
            arr[j + 1] = key;
        }
    }

    public static void selectionSort(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) if (arr[j] < arr[min]) min = j;
            double t = arr[min]; arr[min] = arr[i]; arr[i] = t;
        }
    }

    public static void bubbleSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) { double t = arr[j]; arr[j] = arr[j+1]; arr[j+1] = t; }
    }

    public static void shellSort(double[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2)
            for (int i = gap; i < n; i++) {
                double temp = arr[i]; int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) arr[j] = arr[j - gap];
                arr[j] = temp;
            }
    }

    public static void mergeSort(double[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m); mergeSort(arr, m + 1, r);
            double[] L = Arrays.copyOfRange(arr, l, m + 1);
            double[] R = Arrays.copyOfRange(arr, m + 1, r + 1);
            int i = 0, j = 0, k = l;
            while (i < L.length && j < R.length) arr[k++] = L[i] <= R[j] ? L[i++] : R[j++];
            while (i < L.length) arr[k++] = L[i++];
            while (j < R.length) arr[k++] = R[j++];
        }
    }

    public static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            double pivot = arr[high]; int i = low - 1;
            for (int j = low; j < high; j++)
                if (arr[j] < pivot) { i++; double t = arr[i]; arr[i] = arr[j]; arr[j] = t; }
            double t = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = t;
            int pi = i + 1;
            quickSort(arr, low, pi - 1); quickSort(arr, pi + 1, high);
        }
    }

    public static void quickSort3(double[] arr, int low, int high) {
        if (low >= high) return;
        double pivot = arr[high]; int lt = low, gt = high, i = low;
        while (i <= gt) {
            if (arr[i] < pivot) { double t = arr[lt]; arr[lt] = arr[i]; arr[i] = t; lt++; i++; }
            else if (arr[i] > pivot) { double t = arr[gt]; arr[gt] = arr[i]; arr[i] = t; gt--; }
            else i++;
        }
        quickSort3(arr, low, lt - 1); quickSort3(arr, gt + 1, high);
    }

    public static void heapSort(double[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            double t = arr[0]; arr[0] = arr[i]; arr[i] = t; heapify(arr, i, 0);
        }
    }

    private static void heapify(double[] arr, int n, int i) {
        int largest = i, l = 2*i+1, r = 2*i+2;
        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;
        if (largest != i) {
            double t = arr[i]; arr[i] = arr[largest]; arr[largest] = t;
            heapify(arr, n, largest);
        }
    }

    public static void radixSort(double[] arr) {
        double min = arr[0];
        for (double v : arr) if (v < min) min = v;
        long scale = 1000000L;
        long[] scaled = new long[arr.length];
        for (int i = 0; i < arr.length; i++) scaled[i] = Math.round((arr[i] - min) * scale);
        long maxVal = scaled[0];
        for (long v : scaled) if (v > maxVal) maxVal = v;
        for (long exp = 1; maxVal / exp > 0; exp *= 10) {
            int n = scaled.length;
            long[] output = new long[n]; int[] count = new int[10];
            for (long v : scaled) count[(int)((v / exp) % 10)]++;
            for (int i = 1; i < 10; i++) count[i] += count[i-1];
            for (int i = n - 1; i >= 0; i--) output[--count[(int)((scaled[i]/exp)%10)]] = scaled[i];
            System.arraycopy(output, 0, scaled, 0, n);
        }
        for (int i = 0; i < arr.length; i++)
            arr[i] = Math.round((scaled[i] / (double) scale + min) * 1e6) / 1e6;
    }

    public static void shakerSort(double[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            for (int i = left; i < right; i++)
                if (arr[i] > arr[i+1]) { double t = arr[i]; arr[i] = arr[i+1]; arr[i+1] = t; }
            right--;
            for (int i = right; i > left; i--)
                if (arr[i] < arr[i-1]) { double t = arr[i]; arr[i] = arr[i-1]; arr[i-1] = t; }
            left++;
        }
    }

    public static void combSort(double[] arr) {
        int n = arr.length, gap = n; boolean swapped = true;
        while (gap != 1 || swapped) {
            gap = Math.max(1, (int)(gap / 1.3)); swapped = false;
            for (int i = 0; i < n - gap; i++)
                if (arr[i] > arr[i+gap]) {
                    double t = arr[i]; arr[i] = arr[i+gap]; arr[i+gap] = t; swapped = true;
                }
        }
    }

    public static void gnomeSort(double[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (i == 0 || arr[i] >= arr[i-1]) i++;
            else { double t = arr[i]; arr[i] = arr[i-1]; arr[i-1] = t; i--; }
        }
    }

    public static void strandSort(double[] arr) {
        List<Double> input = new ArrayList<>();
        for (double v : arr) input.add(v);
        List<Double> result = new ArrayList<>();
        while (!input.isEmpty()) {
            List<Double> strand = new ArrayList<>();
            strand.add(input.remove(0));
            List<Double> remaining = new ArrayList<>();
            for (double v : input) {
                if (v >= strand.get(strand.size()-1)) strand.add(v);
                else remaining.add(v);
            }
            input = remaining;
            List<Double> merged = new ArrayList<>();
            int i = 0, j = 0;
            while (i < result.size() && j < strand.size())
                merged.add(result.get(i) <= strand.get(j) ? result.get(i++) : strand.get(j++));
            while (i < result.size()) merged.add(result.get(i++));
            while (j < strand.size()) merged.add(strand.get(j++));
            result = merged;
        }
        for (int i = 0; i < arr.length; i++) arr[i] = result.get(i);
    }

    public static void bucketSort(double[] arr) {
        if (arr.length == 0) return;
        double max = arr[0], min = arr[0];
        for (double v : arr) { if (v > max) max = v; if (v < min) min = v; }
        int bc = Math.max(1, arr.length / 2);
        List<List<Double>> buckets = new ArrayList<>();
        for (int i = 0; i < bc; i++) buckets.add(new ArrayList<>());
        double range = (max - min + 1e-9) / bc;
        for (double v : arr) buckets.get((int)((v - min) / range)).add(v);
        int idx = 0;
        for (List<Double> b : buckets) { Collections.sort(b); for (double v : b) arr[idx++] = v; }
    }

    public static void stoogeSort(double[] arr, int l, int h) {
        if (l >= h) return;
        if (arr[l] > arr[h]) { double t = arr[l]; arr[l] = arr[h]; arr[h] = t; }
        if (h - l + 1 > 2) {
            int t = (h - l + 1) / 3;
            stoogeSort(arr, l, h-t); stoogeSort(arr, l+t, h); stoogeSort(arr, l, h-t);
        }
    }

    public static boolean isSorted(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) if (arr[i] > arr[i+1]) return false;
        return true;
    }

    // ===================== ARAMA =====================

    public static int linearSearch(double[] arr, double target) {
        for (int i = 0; i < arr.length; i++) if (arr[i] == target) return i;
        return -1;
    }

    public static int binarySearch(double[] arr, double target) {
        double[] sorted = arr.clone(); Arrays.sort(sorted);
        int low = 0, high = sorted.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sorted[mid] == target) return mid;
            if (sorted[mid] < target) low = mid + 1; else high = mid - 1;
        }
        return -1;
    }

    public static int interpolationSearch(double[] arr, double target) {
        double[] sorted = arr.clone(); Arrays.sort(sorted);
        int low = 0, high = sorted.length - 1;
        while (low <= high && target >= sorted[low] && target <= sorted[high]) {
            if (low == high) return sorted[low] == target ? low : -1;
            if (sorted[high] == sorted[low]) return sorted[low] == target ? low : -1;
            int pos = (int)(low + ((double)(high - low) / (sorted[high] - sorted[low])) * (target - sorted[low]));
            if (pos < low || pos > high) break;
            if (sorted[pos] == target) return pos;
            if (sorted[pos] < target) low = pos + 1; else high = pos - 1;
        }
        return -1;
    }
}
