package com.example.proje;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortingDetailActivity extends AppCompatActivity {
    private int sortId;
    private TextView tvDescription, tvUnsorted, tvSorted;
    private TextInputEditText etInput;
    private TextInputLayout inputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorting_detail);

        sortId = getIntent().getIntExtra("sort_id", 1);
        String title = getIntent().getStringExtra("sort_title");

        Toolbar toolbar = findViewById(R.id.toolbarSortDetail);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(android.graphics.Color.parseColor("#E65100"));

        tvDescription = findViewById(R.id.tvSortDescription);
        tvUnsorted = findViewById(R.id.tvUnsorted);
        tvSorted = findViewById(R.id.tvSorted);
        etInput = findViewById(R.id.etSortInput);
        inputLayout = findViewById(R.id.inputLayout);
        Button btnSort = findViewById(R.id.btnSort);

        setupUI();
        btnSort.setOnClickListener(v -> handleSort());

        etInput.setOnEditorActionListener((v, actionId, event) -> {
            handleSort();
            return true;
        });

        etInput.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                inputLayout.setHint("Sayıları virgülle ayırarak girin (Örn: 5,2,9,1)");
            } else if (etInput.getText() == null || etInput.getText().toString().isEmpty()) {
                inputLayout.setHint("");
            }
        });
    }

    private void setupUI() {
        switch (sortId) {
            case 1: tvDescription.setText("Insertion Sort: Her elemanı önündekilerle karşılaştırarak doğru yere yerleştirir."); break;
            case 2: tvDescription.setText("Selection Sort: Her adımda dizideki en küçük elemanı bulup başa alır."); break;
            case 3: tvDescription.setText("Bubble Sort: Komşu elemanları karşılaştırıp gerekirse yer değiştirir."); break;
            case 4: tvDescription.setText("Divide and Conquer Sort: Diziyi üçe bölerek özyinelemeli sıralama yapar."); break;
            case 5: tvDescription.setText("Shell Sort: Insertion Sort'un geliştirilmiş hali; uzak elemanları karşılaştırır."); break;
            case 6: tvDescription.setText("Merge Sort: Diziyi ikiye böler, sıralar ve birleştirir."); break;
            case 7: tvDescription.setText("Quick Sort: Bir pivot seçer ve etrafında sıralar."); break;
            case 8: tvDescription.setText("Quick Sort 3: Üç bölümlü hızlı sıralama; eşit elemanları ayrı tutar."); break;
            case 9: tvDescription.setText("Heap Sort: Yığın veri yapısı kullanarak sıralar."); break;
            case 10: tvDescription.setText("Radix Sort: Sayıları basamak basamak sıralar."); break;
            case 11: tvDescription.setText("Shaker Sort: Çift yönlü Bubble Sort; her turda iki yönde de tarar."); break;
            case 12: tvDescription.setText("Rastgele Sort: Her adımda rastgele iki eleman karşılaştırıp gerekirse yer değiştirir."); break;
            case 13: tvDescription.setText("Lucky Sort: Her turda şanslı bir indis seçerek minimum elemanı yerleştirir."); break;
            case 14: tvDescription.setText("Stooge Sort: Özyinelemeli olarak ilk 2/3 ve son 2/3'ü sıralar."); break;
            case 15: tvDescription.setText("Flash Sort: Elemanları sınıflara bölerek hızlı sıralama yapar."); break;
            case 16: tvDescription.setText("Comb Sort: Bubble Sort'un gelişmiş hali; giderek küçülen aralıklarla karşılaştırır."); break;
            case 17: tvDescription.setText("Gnome Sort: Cüce sıralaması; yanlış yerdeki elemanı geriye taşıyarak sıralar."); break;
            case 18: tvDescription.setText("Permütasyon Sort: Sıralı permütasyon bulunana kadar dizi karıştırılır (maks. 1000 deneme)."); break;
            case 19: tvDescription.setText("Strand Sort: Sıralı alt dizileri çıkarıp birleştirerek sıralar."); break;
            case 20: tvDescription.setText("Kova Sort: Elemanları kovaya dağıtıp her kovayı ayrı sıralar."); break;
            default: tvDescription.setText("Lütfen sayıları girip SIRALA butonuna basın."); break;
        }
    }

    private void handleSort() {
        String input = etInput.getText().toString();
        if (input.isEmpty()) return;

        try {
            String[] parts = input.split(",");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i].trim());
            }

            tvUnsorted.setText(Arrays.toString(arr));

            switch (sortId) {
                case 1: insertionSort(arr); break;
                case 2: selectionSort(arr); break;
                case 3: bubbleSort(arr); break;
                case 4: divideAndConquerSort(arr, 0, arr.length - 1); break;
                case 5: shellSort(arr); break;
                case 6: mergeSort(arr, 0, arr.length - 1); break;
                case 7: quickSort(arr, 0, arr.length - 1); break;
                case 8: quickSort3(arr, 0, arr.length - 1); break;
                case 9: heapSort(arr); break;
                case 10: radixSort(arr); break;
                case 11: shakerSort(arr); break;
                case 12: randomSort(arr); break;
                case 13: luckySort(arr); break;
                case 14: stoogeSort(arr, 0, arr.length - 1); break;
                case 15: flashSort(arr); break;
                case 16: combSort(arr); break;
                case 17: gnomeSort(arr); break;
                case 18: permutationSort(arr); break;
                case 19: strandSort(arr); break;
                case 20: bucketSort(arr); break;
                default: Arrays.sort(arr); break;
            }

            tvSorted.setText(Arrays.toString(arr));

        } catch (Exception e) {
            tvSorted.setText("Hata: Geçersiz giriş formatı!");
        }
    }

    private void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) { arr[j + 1] = arr[j]; j--; }
            arr[j + 1] = key;
        }
    }

    private void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[min_idx]) min_idx = j;
            int temp = arr[min_idx]; arr[min_idx] = arr[i]; arr[i] = temp;
        }
    }

    private void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) { int t = arr[j]; arr[j] = arr[j+1]; arr[j+1] = t; }
    }

    private void divideAndConquerSort(int[] arr, int l, int r) {
        if (r - l < 1) return;
        if (r - l == 1) {
            if (arr[l] > arr[r]) { int t = arr[l]; arr[l] = arr[r]; arr[r] = t; }
            return;
        }
        int mid1 = l + (r - l) / 3;
        int mid2 = l + 2 * (r - l) / 3;
        divideAndConquerSort(arr, l, mid1);
        divideAndConquerSort(arr, mid1 + 1, mid2);
        divideAndConquerSort(arr, mid2 + 1, r);
        mergeRanges(arr, l, mid1, mid2);
        mergeRanges(arr, l, mid2, r);
    }

    private void mergeRanges(int[] arr, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length)
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    private void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int[] L = Arrays.copyOfRange(arr, l, m + 1);
        int[] R = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < L.length && j < R.length)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < L.length) arr[k++] = L[i++];
        while (j < R.length) arr[k++] = R[j++];
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) { i++; int t = arr[i]; arr[i] = arr[j]; arr[j] = t; }
        }
        int t = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = t;
        return i + 1;
    }

    private void quickSort3(int[] arr, int low, int high) {
        if (low >= high) return;
        int pivot = arr[high], lt = low, gt = high, i = low;
        while (i <= gt) {
            if (arr[i] < pivot) { int t = arr[lt]; arr[lt] = arr[i]; arr[i] = t; lt++; i++; }
            else if (arr[i] > pivot) { int t = arr[gt]; arr[gt] = arr[i]; arr[i] = t; gt--; }
            else i++;
        }
        quickSort3(arr, low, lt - 1);
        quickSort3(arr, gt + 1, high);
    }

    private void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int t = arr[0]; arr[0] = arr[i]; arr[i] = t;
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i, l = 2 * i + 1, r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;
        if (largest != i) {
            int t = arr[i]; arr[i] = arr[largest]; arr[largest] = t;
            heapify(arr, n, largest);
        }
    }

    private void radixSort(int[] arr) {
        int min = arr[0];
        for (int v : arr) if (v < min) min = v;
        if (min < 0) for (int i = 0; i < arr.length; i++) arr[i] -= min;
        int max = arr[0];
        for (int v : arr) if (v > max) max = v;
        for (int exp = 1; max / exp > 0; exp *= 10) {
            int n = arr.length;
            int[] output = new int[n];
            int[] count = new int[10];
            for (int v : arr) count[(v / exp) % 10]++;
            for (int i = 1; i < 10; i++) count[i] += count[i - 1];
            for (int i = n - 1; i >= 0; i--) output[--count[(arr[i] / exp) % 10]] = arr[i];
            System.arraycopy(output, 0, arr, 0, n);
        }
        if (min < 0) for (int i = 0; i < arr.length; i++) arr[i] += min;
    }

    private void shakerSort(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            for (int i = left; i < right; i++)
                if (arr[i] > arr[i + 1]) { int t = arr[i]; arr[i] = arr[i+1]; arr[i+1] = t; }
            right--;
            for (int i = right; i > left; i--)
                if (arr[i] < arr[i - 1]) { int t = arr[i]; arr[i] = arr[i-1]; arr[i-1] = t; }
            left++;
        }
    }

    private void randomSort(int[] arr) {
        Random rand = new Random();
        int maxIter = 10000;
        while (!isSorted(arr) && maxIter-- > 0) {
            int i = rand.nextInt(arr.length);
            int j = rand.nextInt(arr.length);
            if (arr[i] > arr[j]) { int t = arr[i]; arr[i] = arr[j]; arr[j] = t; }
        }
        if (!isSorted(arr)) Arrays.sort(arr);
    }

    private void luckySort(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[minIdx]) minIdx = j;
            int luckyIdx = i + rand.nextInt(arr.length - i);
            int t = arr[luckyIdx]; arr[luckyIdx] = arr[minIdx]; arr[minIdx] = t;
            t = arr[i]; arr[i] = arr[minIdx]; arr[minIdx] = t;
        }
    }

    private void stoogeSort(int[] arr, int l, int h) {
        if (l >= h) return;
        if (arr[l] > arr[h]) { int t = arr[l]; arr[l] = arr[h]; arr[h] = t; }
        if (h - l + 1 > 2) {
            int t = (h - l + 1) / 3;
            stoogeSort(arr, l, h - t);
            stoogeSort(arr, l + t, h);
            stoogeSort(arr, l, h - t);
        }
    }

    private void flashSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) return;
        int max = arr[0], minIdx = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < arr[minIdx]) minIdx = i;
        }
        if (max == arr[minIdx]) return;
        int m = Math.max(1, (int)(0.45 * n));
        int[] L = new int[m];
        double c = (double)(m - 1) / (max - arr[minIdx]);
        for (int i = 0; i < n; i++) L[(int)(c * (arr[i] - arr[minIdx]))]++;
        for (int i = 1; i < m; i++) L[i] += L[i - 1];
        int t2 = arr[minIdx]; arr[minIdx] = arr[0]; arr[0] = t2;
        int nmove = 0, j = 0, flash, k;
        while (nmove < n - 1) {
            while (j >= L[(k = (int)(c * (arr[j] - arr[minIdx])))]) j++;
            flash = arr[j];
            while (j != L[k]) {
                k = (int)(c * (flash - arr[minIdx]));
                int hold = arr[L[k] - 1];
                arr[L[k] - 1] = flash;
                flash = hold;
                L[k]--;
                nmove++;
            }
        }
        insertionSort(arr);
    }

    private void combSort(int[] arr) {
        int n = arr.length, gap = n;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            gap = Math.max(1, (int)(gap / 1.3));
            swapped = false;
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    int t = arr[i]; arr[i] = arr[i + gap]; arr[i + gap] = t;
                    swapped = true;
                }
            }
        }
    }

    private void gnomeSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (i == 0 || arr[i] >= arr[i - 1]) i++;
            else { int t = arr[i]; arr[i] = arr[i - 1]; arr[i - 1] = t; i--; }
        }
    }

    private void permutationSort(int[] arr) {
        Random rand = new Random();
        int maxIter = 1000;
        while (!isSorted(arr) && maxIter-- > 0) {
            for (int i = arr.length - 1; i > 0; i--) {
                int j = rand.nextInt(i + 1);
                int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            }
        }
        if (!isSorted(arr)) Arrays.sort(arr);
    }

    private void strandSort(int[] arr) {
        List<Integer> input = new ArrayList<>();
        for (int v : arr) input.add(v);
        List<Integer> result = new ArrayList<>();
        while (!input.isEmpty()) {
            List<Integer> strand = new ArrayList<>();
            strand.add(input.remove(0));
            List<Integer> remaining = new ArrayList<>();
            for (int v : input) {
                if (v >= strand.get(strand.size() - 1)) strand.add(v);
                else remaining.add(v);
            }
            input = remaining;
            List<Integer> merged = new ArrayList<>();
            int i = 0, j = 0;
            while (i < result.size() && j < strand.size())
                merged.add(result.get(i) <= strand.get(j) ? result.get(i++) : strand.get(j++));
            while (i < result.size()) merged.add(result.get(i++));
            while (j < strand.size()) merged.add(strand.get(j++));
            result = merged;
        }
        for (int i = 0; i < arr.length; i++) arr[i] = result.get(i);
    }

    private void bucketSort(int[] arr) {
        if (arr.length == 0) return;
        int max = arr[0], min = arr[0];
        for (int v : arr) { if (v > max) max = v; if (v < min) min = v; }
        int bucketCount = Math.max(1, arr.length / 2);
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) buckets.add(new ArrayList<>());
        double range = (double)(max - min + 1) / bucketCount;
        for (int v : arr) buckets.get((int)((v - min) / range)).add(v);
        int idx = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int v : bucket) arr[idx++] = v;
        }
    }

    private boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] > arr[i + 1]) return false;
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
