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
import java.util.*;

public class SearchDetailActivity extends AppCompatActivity {
    private int searchId;
    private TextView tvDescription, tvResult;
    private TextInputEditText etData, etTarget;
    private TextInputLayout inputLayoutData, inputLayoutTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_detail);

        searchId = getIntent().getIntExtra("search_id", 1);
        String title = getIntent().getStringExtra("search_title");

        Toolbar toolbar = findViewById(R.id.toolbarSearchDetail);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(android.graphics.Color.parseColor("#E65100"));

        tvDescription = findViewById(R.id.tvSearchDescription);
        tvResult = findViewById(R.id.tvSearchResult);
        etData = findViewById(R.id.etSearchData);
        etTarget = findViewById(R.id.etSearchTarget);
        inputLayoutData = findViewById(R.id.inputLayoutData);
        inputLayoutTarget = findViewById(R.id.inputLayoutTarget);
        Button btnExecute = findViewById(R.id.btnSearchExecute);

        setupUI();
        btnExecute.setOnClickListener(v -> handleSearch());

        etTarget.setOnEditorActionListener((v, actionId, event) -> { handleSearch(); return true; });
        etData.setOnEditorActionListener((v, actionId, event) -> { handleSearch(); return true; });

        etData.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) inputLayoutData.setHint(getDataHint());
            else if (etData.getText() == null || etData.getText().toString().isEmpty())
                inputLayoutData.setHint("");
        });

        etTarget.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) inputLayoutTarget.setHint(getTargetHint());
            else if (etTarget.getText() == null || etTarget.getText().toString().isEmpty())
                inputLayoutTarget.setHint("");
        });
    }

    private String getDataHint() {
        switch (searchId) {
            case 4: case 5: case 6: case 7: case 8: case 9: case 10:
                return "Kenarlar (Örn: 0-1:4 0-2:3 1-2:1)";
            case 11: return "BST değerleri (Örn: 5,3,7,1,4)";
            case 12: return "Prüfer dizisi (Örn: 1,1,2)";
            case 13: case 14: case 15: return "Metin";
            default: return "Veri kümesi (Örn: 1,3,5,7,9)";
        }
    }

    private String getTargetHint() {
        switch (searchId) {
            case 4: return "Başlangıç düğümü (Örn: 0)";
            case 5: case 9: return "Başlangıç ve hedef (Örn: 0 3)";
            case 6: return "Düğüm sayısı (Örn: 4)";
            case 7: return "Başlangıç düğümü (Örn: 0)";
            case 8: return "Düğüm sayısı (Örn: 4)";
            case 10: return "Başlangıç düğümü (Örn: 0)";
            case 11: return "Aranacak değer (Örn: 3)";
            case 12: return "Düğüm sayısı (Örn: 5)";
            default: return "Aranacak değer";
        }
    }

    private void setupUI() {
        switch (searchId) {
            case 1: tvDescription.setText("Linear Search: Verileri sırayla kontrol eder.\nGiriş: sayı listesi, hedef sayı"); break;
            case 2: tvDescription.setText("Binary Search: Sıralı dizide ortadan bölerek arama yapar.\nGiriş: sayı listesi, hedef sayı"); break;
            case 3: tvDescription.setText("Interpolation Search: Tahmin yürüterek arama yapar.\nGiriş: sayı listesi, hedef sayı"); break;
            case 4: tvDescription.setText("Graf BFS: Genişlik öncelikli arama ile düğümleri gezer.\nKenar formatı: 0-1:4 0-2:3 | Hedef: başlangıç düğümü"); break;
            case 5: tvDescription.setText("Uniform Cost Search: En düşük maliyetli yolu bulur.\nKenar formatı: 0-1:4 0-2:3 | Hedef: başlangıç bitiş (Örn: 0 3)"); break;
            case 6: tvDescription.setText("Floyd Warshall: Tüm düğüm çiftleri arası en kısa yolları bulur.\nKenar formatı: 0-1:4 0-2:3 | Hedef: düğüm sayısı"); break;
            case 7: tvDescription.setText("Prim's Algorithm: Minimum yayılan ağacı oluşturur.\nKenar formatı: 0-1:4 0-2:3 | Hedef: başlangıç düğümü"); break;
            case 8: tvDescription.setText("Kruskal Algorithm: En düşük ağırlıklı kenarları seçerek MST oluşturur.\nKenar formatı: 0-1:4 0-2:3 | Hedef: düğüm sayısı"); break;
            case 9: tvDescription.setText("Dijkstra: Tek kaynaktan en kısa yolları bulur.\nKenar formatı: 0-1:4 0-2:3 | Hedef: başlangıç bitiş (Örn: 0 3)"); break;
            case 10: tvDescription.setText("Bellman-Ford: Negatif ağırlıklı graflarda en kısa yolları bulur.\nKenar formatı: 0-1:4 0-2:-1 | Hedef: başlangıç düğümü"); break;
            case 11: tvDescription.setText("Binary Search Tree: İkili arama ağacına değer ekler ve arar.\nGiriş: eklenecek değerler (virgülle) | Hedef: aranacak değer"); break;
            case 12: tvDescription.setText("Prüfer Dizisi: Ağacı Prüfer dizisine dönüştürür/geri çözer.\nGiriş: Prüfer dizisi (virgülle) | Hedef: düğüm sayısı"); break;
            case 13: tvDescription.setText("Text Search: Metin içinde örüntü arar."); break;
            case 14: tvDescription.setText("Horspool Search: Boyer-Moore-Horspool algoritması; sağdan sola karşılaştırarak metin arar."); break;
            case 15: tvDescription.setText("Brute Force Text Search: Metin içerisinde kelimeyi karakter karakter kaba kuvvetle arar."); break;
        }
    }

    private void handleSearch() {
        String dataInput = etData.getText().toString().trim();
        String targetInput = etTarget.getText().toString().trim();
        if (dataInput.isEmpty()) return;

        String result;
        try {
            switch (searchId) {
                case 1: case 2: case 3: {
                    String[] parts = dataInput.split(",");
                    double[] arr = new double[parts.length];
                    for (int i = 0; i < parts.length; i++)
                        arr[i] = Double.parseDouble(parts[i].trim().replace(",", "."));
                    double target = Double.parseDouble(targetInput.trim().replace(",", "."));
                    if (searchId == 1) result = linearSearch(arr, target);
                    else if (searchId == 2) result = binarySearch(arr, target);
                    else result = interpolationSearch(arr, target);
                    break;
                }
                case 4: result = bfsSearch(dataInput, targetInput); break;
                case 5: result = uniformCostSearch(dataInput, targetInput); break;
                case 6: result = floydWarshall(dataInput, targetInput); break;
                case 7: result = primMST(dataInput, targetInput); break;
                case 8: result = kruskalMST(dataInput, targetInput); break;
                case 9: result = dijkstra(dataInput, targetInput); break;
                case 10: result = bellmanFord(dataInput, targetInput); break;
                case 11: result = bstOperations(dataInput, targetInput); break;
                case 12: result = pruferDecode(dataInput, targetInput); break;
                case 13: result = textSearch(dataInput, targetInput); break;
                case 14: result = horspoolSearch(dataInput, targetInput); break;
                case 15: result = bruteForceTextSearch(dataInput, targetInput); break;
                default: result = "Bilinmeyen algoritma.";
            }
        } catch (Exception e) {
            result = "Hata: Giriş formatını kontrol edin!\n" + e.getMessage();
        }
        tvResult.setText(result);
    }

    // --- Dizi Aramaları ---

    private String linearSearch(double[] arr, double target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target) return "Bulundu! İndis: " + i;
        return "Bulunamadı.";
    }

    private String binarySearch(double[] arr, double target) {
        Arrays.sort(arr);
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return "Bulundu (Sıralı dizide)! İndis: " + mid;
            if (arr[mid] < target) low = mid + 1; else high = mid - 1;
        }
        return "Bulunamadı.";
    }

    private String interpolationSearch(double[] arr, double target) {
        Arrays.sort(arr);
        int low = 0, high = arr.length - 1;
        while (low <= high && target >= arr[low] && target <= arr[high]) {
            if (low == high) return arr[low] == target ? "Bulundu! İndis: " + low : "Bulunamadı.";
            if (arr[high] == arr[low]) return arr[low] == target ? "Bulundu! İndis: " + low : "Bulunamadı.";
            int pos = (int)(low + ((double)(high - low) / (arr[high] - arr[low])) * (target - arr[low]));
            if (pos < low || pos > high) break;
            if (arr[pos] == target) return "Bulundu! İndis: " + pos;
            if (arr[pos] < target) low = pos + 1; else high = pos - 1;
        }
        return "Bulunamadı.";
    }

    // --- Graf Yardımcıları ---

    private static class Edge implements Comparable<Edge> {
        int from, to, weight;
        Edge(int f, int t, int w) { from = f; to = t; weight = w; }
        public int compareTo(Edge o) { return this.weight - o.weight; }
    }

    private List<Edge> parseEdges(String input) {
        List<Edge> edges = new ArrayList<>();
        for (String part : input.trim().split("\\s+")) {
            String[] sides = part.split("-");
            int from = Integer.parseInt(sides[0]);
            String[] toW = sides[1].split(":");
            int to = Integer.parseInt(toW[0]);
            int weight = toW.length > 1 ? Integer.parseInt(toW[1]) : 1;
            edges.add(new Edge(from, to, weight));
            edges.add(new Edge(to, from, weight));
        }
        return edges;
    }

    private Map<Integer, List<Edge>> buildGraph(List<Edge> edges) {
        Map<Integer, List<Edge>> graph = new TreeMap<>();
        for (Edge e : edges) {
            graph.computeIfAbsent(e.from, k -> new ArrayList<>()).add(e);
        }
        return graph;
    }

    private int maxNode(List<Edge> edges) {
        int max = 0;
        for (Edge e : edges) { if (e.from > max) max = e.from; if (e.to > max) max = e.to; }
        return max;
    }

    // --- BFS (Case 4) ---

    private String bfsSearch(String data, String target) {
        List<Edge> edges = parseEdges(data);
        Map<Integer, List<Edge>> graph = buildGraph(edges);
        int start = Integer.parseInt(target.trim());
        Set<Integer> visited = new LinkedHashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Edge> neighbors = graph.getOrDefault(node, new ArrayList<>());
            neighbors.sort((a, b) -> a.to - b.to);
            for (Edge e : neighbors) {
                if (!visited.contains(e.to)) { visited.add(e.to); queue.add(e.to); }
            }
        }
        return "BFS Gezme Sırası: " + visited.toString();
    }

    // --- Uniform Cost Search (Case 5) ---

    private String uniformCostSearch(String data, String target) {
        List<Edge> edges = parseEdges(data);
        Map<Integer, List<Edge>> graph = buildGraph(edges);
        String[] parts = target.trim().split("\\s+");
        int start = Integer.parseInt(parts[0]), end = Integer.parseInt(parts[1]);
        Map<Integer, Integer> cost = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});
        cost.put(start, 0);
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], c = curr[1];
            if (node == end) break;
            if (c > cost.getOrDefault(node, Integer.MAX_VALUE)) continue;
            for (Edge e : graph.getOrDefault(node, new ArrayList<>())) {
                int newCost = c + e.weight;
                if (newCost < cost.getOrDefault(e.to, Integer.MAX_VALUE)) {
                    cost.put(e.to, newCost);
                    parent.put(e.to, node);
                    pq.add(new int[]{e.to, newCost});
                }
            }
        }
        if (!cost.containsKey(end)) return "Yol bulunamadı.";
        List<Integer> path = new ArrayList<>();
        for (int n = end; n != start; n = parent.get(n)) path.add(0, n);
        path.add(0, start);
        return "UCS En Kısa Yol: " + path + "\nToplam Maliyet: " + cost.get(end);
    }

    // --- Floyd Warshall (Case 6) ---

    private String floydWarshall(String data, String target) {
        int n = Integer.parseInt(target.trim());
        int INF = 99999;
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, INF);
        for (int i = 0; i < n; i++) dist[i][i] = 0;
        for (String part : data.trim().split("\\s+")) {
            String[] sides = part.split("-");
            int from = Integer.parseInt(sides[0]);
            String[] toW = sides[1].split(":");
            int to = Integer.parseInt(toW[0]);
            int w = toW.length > 1 ? Integer.parseInt(toW[1]) : 1;
            dist[from][to] = w;
            dist[to][from] = w;
        }
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][k] != INF && dist[k][j] != INF)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        StringBuilder sb = new StringBuilder("Floyd-Warshall En Kısa Mesafe Matrisi:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(dist[i][j] == INF ? "∞" : dist[i][j]);
                if (j < n - 1) sb.append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // --- Prim's MST (Case 7) ---

    private String primMST(String data, String target) {
        List<Edge> edges = parseEdges(data);
        int n = maxNode(edges) + 1;
        int start = Integer.parseInt(target.trim());
        Map<Integer, List<Edge>> graph = buildGraph(edges);
        boolean[] inMST = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        inMST[start] = true;
        pq.addAll(graph.getOrDefault(start, new ArrayList<>()));
        List<String> mstEdges = new ArrayList<>();
        int totalWeight = 0;
        while (!pq.isEmpty() && mstEdges.size() < n - 1) {
            Edge e = pq.poll();
            if (inMST[e.to]) continue;
            inMST[e.to] = true;
            mstEdges.add(e.from + "-" + e.to + ":" + e.weight);
            totalWeight += e.weight;
            pq.addAll(graph.getOrDefault(e.to, new ArrayList<>()));
        }
        return "Prim MST Kenarları:\n" + String.join("\n", mstEdges) + "\nToplam Ağırlık: " + totalWeight;
    }

    // --- Kruskal MST (Case 8) ---

    private String kruskalMST(String data, String target) {
        int n = Integer.parseInt(target.trim());
        List<Edge> allEdges = new ArrayList<>();
        for (String part : data.trim().split("\\s+")) {
            String[] sides = part.split("-");
            int from = Integer.parseInt(sides[0]);
            String[] toW = sides[1].split(":");
            int to = Integer.parseInt(toW[0]);
            int w = toW.length > 1 ? Integer.parseInt(toW[1]) : 1;
            allEdges.add(new Edge(from, to, w));
        }
        Collections.sort(allEdges);
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        List<String> mstEdges = new ArrayList<>();
        int totalWeight = 0;
        for (Edge e : allEdges) {
            int pA = find(parent, e.from), pB = find(parent, e.to);
            if (pA != pB) {
                mstEdges.add(e.from + "-" + e.to + ":" + e.weight);
                totalWeight += e.weight;
                parent[pA] = pB;
            }
        }
        return "Kruskal MST Kenarları:\n" + String.join("\n", mstEdges) + "\nToplam Ağırlık: " + totalWeight;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    // --- Dijkstra (Case 9) ---

    private String dijkstra(String data, String target) {
        List<Edge> edges = parseEdges(data);
        Map<Integer, List<Edge>> graph = buildGraph(edges);
        int n = maxNode(edges) + 1;
        String[] parts = target.trim().split("\\s+");
        int start = Integer.parseInt(parts[0]);
        int end = parts.length > 1 ? Integer.parseInt(parts[1]) : -1;
        int[] dist = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], d = curr[1];
            if (d > dist[node]) continue;
            for (Edge e : graph.getOrDefault(node, new ArrayList<>())) {
                if (dist[node] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[node] + e.weight;
                    parent[e.to] = node;
                    pq.add(new int[]{e.to, dist[e.to]});
                }
            }
        }
        StringBuilder sb = new StringBuilder("Dijkstra Sonuçları (kaynak: " + start + "):\n");
        if (end >= 0 && end < n && dist[end] != Integer.MAX_VALUE) {
            List<Integer> path = new ArrayList<>();
            for (int x = end; x != -1; x = parent[x]) path.add(0, x);
            sb.append("En kısa yol " + start + "→" + end + ": " + path + "\n");
            sb.append("Mesafe: " + dist[end] + "\n\nTüm mesafeler:\n");
        }
        for (int i = 0; i < n; i++)
            sb.append(start + "→" + i + ": " + (dist[i] == Integer.MAX_VALUE ? "∞" : dist[i]) + "\n");
        return sb.toString().trim();
    }

    // --- Bellman-Ford (Case 10) ---

    private String bellmanFord(String data, String target) {
        List<Edge> rawEdges = new ArrayList<>();
        for (String part : data.trim().split("\\s+")) {
            String[] sides = part.split("-");
            int from = Integer.parseInt(sides[0]);
            String[] toW = sides[1].split(":");
            int to = Integer.parseInt(toW[0]);
            int w = toW.length > 1 ? Integer.parseInt(toW[1]) : 1;
            rawEdges.add(new Edge(from, to, w));
        }
        int n = 0;
        for (Edge e : rawEdges) { if (e.from > n) n = e.from; if (e.to > n) n = e.to; }
        n++;
        int src = Integer.parseInt(target.trim());
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < n - 1; i++)
            for (Edge e : rawEdges)
                if (dist[e.from] != Integer.MAX_VALUE && dist[e.from] + e.weight < dist[e.to])
                    dist[e.to] = dist[e.from] + e.weight;
        boolean hasNegCycle = false;
        for (Edge e : rawEdges)
            if (dist[e.from] != Integer.MAX_VALUE && dist[e.from] + e.weight < dist[e.to])
                hasNegCycle = true;
        StringBuilder sb = new StringBuilder("Bellman-Ford (kaynak: " + src + "):\n");
        for (int i = 0; i < n; i++)
            sb.append(src + "→" + i + ": " + (dist[i] == Integer.MAX_VALUE ? "∞" : dist[i]) + "\n");
        if (hasNegCycle) sb.append("\n⚠ Negatif döngü tespit edildi!");
        return sb.toString().trim();
    }

    // --- Binary Search Tree (Case 11) ---

    private int[] bstTree;
    private int bstSize;

    private String bstOperations(String data, String target) {
        String[] parts = data.split(",");
        bstTree = new int[1024];
        Arrays.fill(bstTree, Integer.MIN_VALUE);
        bstSize = 0;
        for (String p : parts) bstInsert(Integer.parseInt(p.trim()), 0);
        int searchVal = Integer.parseInt(target.trim());
        boolean found = bstSearch(searchVal, 0);
        StringBuilder sb = new StringBuilder("BST Eklenen Değerler: " + data + "\n");
        sb.append("Inorder (Sıralı): ");
        List<Integer> inorder = new ArrayList<>();
        bstInorder(0, inorder);
        sb.append(inorder + "\n");
        sb.append("Aranan: " + searchVal + " → " + (found ? "Bulundu!" : "Bulunamadı."));
        return sb.toString();
    }

    private void bstInsert(int val, int idx) {
        if (idx >= bstTree.length) return;
        if (bstTree[idx] == Integer.MIN_VALUE) { bstTree[idx] = val; bstSize++; return; }
        if (val < bstTree[idx]) bstInsert(val, 2 * idx + 1);
        else if (val > bstTree[idx]) bstInsert(val, 2 * idx + 2);
    }

    private boolean bstSearch(int val, int idx) {
        if (idx >= bstTree.length || bstTree[idx] == Integer.MIN_VALUE) return false;
        if (bstTree[idx] == val) return true;
        if (val < bstTree[idx]) return bstSearch(val, 2 * idx + 1);
        return bstSearch(val, 2 * idx + 2);
    }

    private void bstInorder(int idx, List<Integer> result) {
        if (idx >= bstTree.length || bstTree[idx] == Integer.MIN_VALUE) return;
        bstInorder(2 * idx + 1, result);
        result.add(bstTree[idx]);
        bstInorder(2 * idx + 2, result);
    }

    // --- Prüfer Dizisi Çözme (Case 12) ---

    private String pruferDecode(String data, String target) {
        String[] parts = data.split(",");
        int[] seq = new int[parts.length];
        for (int i = 0; i < parts.length; i++) seq[i] = Integer.parseInt(parts[i].trim());
        int n = seq.length + 2;
        int[] degree = new int[n];
        Arrays.fill(degree, 1);
        for (int v : seq) degree[v]++;
        List<String> edges = new ArrayList<>();
        for (int v : seq) {
            for (int u = 0; u < n; u++) {
                if (degree[u] == 1) {
                    edges.add(u + "-" + v);
                    degree[u]--;
                    degree[v]--;
                    break;
                }
            }
        }
        List<Integer> last = new ArrayList<>();
        for (int i = 0; i < n; i++) if (degree[i] == 1) last.add(i);
        if (last.size() == 2) edges.add(last.get(0) + "-" + last.get(1));
        return "Prüfer Dizisi: " + Arrays.toString(seq) + "\nDüğüm Sayısı: " + n + "\nAğaç Kenarları:\n" + String.join("\n", edges);
    }

    // --- Metin Aramaları ---

    private String textSearch(String text, String pattern) {
        int index = text.indexOf(pattern);
        if (index != -1) return "Metin içinde bulundu! Başlangıç indisi: " + index;
        return "Metin içinde bulunamadı.";
    }

    private String horspoolSearch(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        if (m == 0) return "Bulundu! Başlangıç indisi: 0";
        if (m > n) return "Bulunamadı.";
        int[] shift = new int[256];
        Arrays.fill(shift, m);
        for (int i = 0; i < m - 1; i++) shift[pattern.charAt(i)] = m - 1 - i;
        int k = m - 1;
        while (k < n) {
            int j = m - 1, i = k;
            while (j >= 0 && text.charAt(i) == pattern.charAt(j)) { i--; j--; }
            if (j == -1) return "Bulundu (Horspool)! Başlangıç indisi: " + (i + 1);
            k += shift[text.charAt(k)];
        }
        return "Bulunamadı.";
    }

    private String bruteForceTextSearch(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++)
                if (text.charAt(i + j) != pattern.charAt(j)) break;
            if (j == m) return "Bulundu (Brute Force)! Başlangıç indisi: " + i;
        }
        return "Bulunamadı.";
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
