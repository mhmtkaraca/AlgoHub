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
import java.util.List;

public class AlgorithmDetailActivity extends AppCompatActivity {
    private int algorithmId;
    private TextView tvDescription, tvResult;
    private TextInputEditText etInput;
    private TextInputLayout inputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm_detail);

        algorithmId = getIntent().getIntExtra("algo_id", 1);
        String title = getIntent().getStringExtra("algo_title");

        Toolbar toolbar = findViewById(R.id.toolbarDetail);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(android.graphics.Color.parseColor("#E65100"));

        tvDescription = findViewById(R.id.tvDescription);
        tvResult = findViewById(R.id.tvResult);
        etInput = findViewById(R.id.etInput);
        inputLayout = findViewById(R.id.inputLayout);
        Button btnCalculate = findViewById(R.id.btnCalculate);

        setupUI();
        btnCalculate.setOnClickListener(v -> calculate());

        // Enter tuşuna basıldığında hesaplamayı başlat
        etInput.setOnEditorActionListener((v, actionId, event) -> {
            calculate();
            return true;
        });

        // Odaklanınca ipucunu göster, odağı kaybedince ve boşsa gizle
        etInput.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                updateHint();
            } else if (etInput.getText() == null || etInput.getText().toString().isEmpty()) {
                inputLayout.setHint("");
            }
        });
    }

    private void updateHint() {
        switch (algorithmId) {
            case 1: inputLayout.setHint("Sayıyı girin (Örn: 1000)"); break;
            case 2: inputLayout.setHint("Terim sayısı girin (Örn: 10)"); break;
            case 3: inputLayout.setHint("Sayı girin (Örn: 1000)"); break;
            case 4: inputLayout.setHint("Terim sayısı girin (Örn: 10)"); break;
            case 5: inputLayout.setHint("Sayı girin (Örn: 500)"); break;
            case 6: inputLayout.setHint("n değerini girin (Örn: 10)"); break;
            case 7: inputLayout.setHint("Sayı girin (Örn: 100)"); break;
            case 8: inputLayout.setHint("n değerini girin (0-5)"); break;
            case 9: inputLayout.setHint("Sayıyı girin (Örn: 1000)"); break;
            case 10: inputLayout.setHint("Sayıyı girin (Örn: 100)"); break;
            case 11: inputLayout.setHint("Terim sayısı girin (Örn: 10)"); break;
            case 12: inputLayout.setHint("Terim sayısı girin (Örn: 10)"); break;
            case 13: inputLayout.setHint("Sayı girin (Örn: 100)"); break;
            case 14: inputLayout.setHint("n değerini girin (Örn: 10)"); break;
            case 15: inputLayout.setHint("n değerini girin (Örn: 10)"); break;
            case 16: inputLayout.setHint("Sayıyı girin (Örn: 100)"); break;
            case 17: inputLayout.setHint("Sayı girin (Örn: 142857)"); break;
            case 18: inputLayout.setHint("Sayı girin (Örn: 100)"); break;
            case 19: inputLayout.setHint("Sayı girin (Örn: 1000)"); break;
            case 20: inputLayout.setHint("4 basamaklı sayı girin (Örn: 1234)"); break;
            default: inputLayout.setHint("Sayı giriniz"); break;
        }
    }

    private void setupUI() {
        inputLayout.setHint(""); // Başlangıçta boş
        switch (algorithmId) {
            case 1: 
                tvDescription.setText("Mükemmel Sayı: Kendisi hariç pozitif tam bölenlerinin toplamı kendisine eşit olan sayıdır.\n\nBu program girdiğiniz sayıyı kontrol eder ve o sayıya kadar olan tüm mükemmel sayıları listeler."); 
                break;
            case 2: 
                tvDescription.setText("Fibonacci Sayıları: Her sayı kendinden önceki iki sayının toplamıdır.\n\nBu program girdiğiniz terim sayısına kadar seriyi hem Standart (Iterative) hem de Özyinelemeli (Recursive) olarak hesaplar."); 
                break;
            case 3: 
                tvDescription.setText("Armstrong Sayısı: N haneli bir sayının basamaklarının N'inci kuvvetleri toplamı sayının kendisine eşitse o sayı bir Armstrong sayısıdır.\n\nÖrn: 153 = 1^3 + 5^3 + 3^3"); 
                break;
            case 4: 
                tvDescription.setText("Tribonacci Sayıları: Her sayı kendinden önceki üç sayının toplamıdır (0, 0, 1, 1, 2, 4, 7...).\n\nBu program seriyi hem Standart hem de Recursive olarak hesaplar."); 
                break;
            case 5: 
                tvDescription.setText("Palindrom Sayı: Tersten okunuşu kendisine eşit olan sayıdır.\n\nBu program girdiğiniz sayının palindrom olup olmadığını denetler ve o sayıya kadar olan tüm palindrom sayıları listeler."); 
                break;
            case 6:
                tvDescription.setText("Cullen Sayısı: n * 2^n + 1 formundaki sayılardır.\n\nBu program girdiğiniz n değerine göre Cullen sayısını hesaplar ve ilk n Cullen sayısını listeler.");
                break;
            case 7:
                tvDescription.setText("Lasa (Emirp) Sayısı: Tersten yazıldığında da farklı bir asal sayı olan asal sayıdır.\n\nBu program girdiğiniz sayının Lasa olup olmadığını kontrol eder ve o sayıya kadar olan Lasa sayılarını listeler.");
                break;
            case 8:
                tvDescription.setText("Fermat Sayıları: F(n) = 2^(2^n) + 1 formundaki sayılardır.\n\nBu program girdiğiniz n değerine göre Fermat sayısını hesaplar.");
                break;
            case 9: 
                tvDescription.setText("Dost (Amicable) Sayılar: İki sayıdan birinin kendisi hariç bölenleri toplamı diğerine eşitse bu sayılar dosttur.\n\nÖrn: 220 ve 284");
                break;
            case 10: 
                tvDescription.setText("Zengin (Abundant) Sayı: Kendisi hariç pozitif tam bölenlerinin toplamı kendisinden büyük olan sayıdır.\n\nÖrn: 12 (Bölenleri: 1, 2, 3, 4, 6. Toplam: 16 > 12)");
                break;
            case 11: 
                tvDescription.setText("Lucas Serisi: Fibonacci dizisine benzer ancak 2 ve 1 ile başlar (2, 1, 3, 4, 7, 11...).\n\nBu program girdiğiniz terim sayısına kadar Lucas serisini hesaplar."); 
                break;
            case 12:
                tvDescription.setText("Tetranacci Sayıları: Her sayı kendinden önceki dört sayının toplamıdır (0, 0, 0, 1, 1, 2, 4, 8...).\n\nBu program girdiğiniz terim sayısına kadar Tetranacci serisini hesaplar.");
                break;
            case 13:
                tvDescription.setText("İkiz Sayılar: Aralarındaki fark 2 olan asal sayı çiftleridir.\n\nBu program girdiğiniz sayının bir ikiz asal olup olmadığını kontrol eder ve o sayıya kadar olan ikiz asalları listeler.");
                break;
            case 14:
                tvDescription.setText("Woodall (Weodal) Sayıları: n * 2^n - 1 formundaki sayılardır.\n\nBu program girdiğiniz n değerine göre Woodall sayısını hesaplar ve seriyi listeler.");
                break;
            case 15:
                tvDescription.setText("Mersenne Sayıları: 2^n - 1 formundaki sayılardır.\n\nBu program girdiğiniz n değerine göre Mersenne sayısını hesaplar ve seriyi listeler.");
                break;
            case 16:
                tvDescription.setText("Harshad Sayısı: Rakamları toplamına tam bölünebilen sayıdır.\n\nBu program girdiğiniz sayının Harshad olup olmadığını denetler ve o sayıya kadar olanları listeler.");
                break;
            case 17:
                tvDescription.setText("Cyclic (Döngüsel) Sayılar: n basamaklı bir sayının 1'den n'e kadar olan sayılarla çarpımı, aynı rakamların döngüsel bir kayması ise bu sayı döngüseldir.\n\nEn ünlü örnek: 142857");
                break;
            case 18:
                tvDescription.setText("Tav (Tau) Sayıları: Kendisini bölen pozitif tam sayıların sayısına tam bölünebilen sayılardır.\n\nBu program girdiğiniz sayının Tav olup olmadığını kontrol eder ve o sayıya kadar olanları listeler.");
                break;
            case 19:
                tvDescription.setText("Bağdaşık (Amicable) Sayılar: İki sayıdan her birinin kendisi hariç bölenleri toplamı diğerine eşitse bu sayılar bağdaşıktır.\n\nÖrn: 220 ve 284");
                break;
            case 20: 
                tvDescription.setText("6174 (Kaprekar Sabiti): 4 basamaklı (en az iki rakamı farklı) bir sayının rakamlarını büyükten küçüğe ve küçükten büyüğe sıralayıp birbirinden çıkarınca en sonunda 6174'e ulaşıldığı görülür.");
                break;
            default: tvDescription.setText("Sayıyı girip hesapla butonuna basınız."); break;
        }
    }

    private void calculate() {
        String inputStr = etInput.getText() != null ? etInput.getText().toString() : "";
        if (inputStr.isEmpty()) {
            tvResult.setText("Lütfen bir sayı giriniz.");
            return;
        }

        long n = Long.parseLong(inputStr);
        String result;

        switch (algorithmId) {
            case 1: result = checkPerfect(n); break;
            case 2: result = getFibonacci(n); break;
            case 3: result = checkArmstrong(n); break;
            case 4: result = getTribonacci(n); break;
            case 5: result = checkPalindrome(inputStr); break;
            case 6: result = getCullen(n); break;
            case 7: result = checkLasa(n); break;
            case 8: result = getFermat(n); break;
            case 9: result = checkAmicable(n); break;
            case 10: result = checkAbundant(n); break;
            case 11: result = getLucas(n); break;
            case 12: result = getTetranacci(n); break;
            case 13: result = checkTwinPrimes(n); break;
            case 14: result = getWoodall(n); break;
            case 15: result = getMersenne(n); break;
            case 16: result = checkHarshad(n); break;
            case 17: result = checkCyclic(inputStr); break;
            case 18: result = checkTau(n); break;
            case 19: result = checkAmicable(n); break;
            case 20: result = runKaprekar(inputStr); break;
            default: result = "Bu algoritma mantığı geliştirme aşamasındadır."; break;
        }
        tvResult.setText(result);
    }

    private String checkPerfect(long n) {
        // Girilen sayının kontrolü
        long sum = 0;
        for (long i = 1; i < n; i++) {
            if (n % i == 0) sum += i;
        }
        boolean isPerfect = (sum == n && n != 0);
        String status = isPerfect ? n + " Mükemmel bir sayıdır." : n + " Mükemmel değildir. (Bölenleri toplamı: " + sum + ")";

        // Sayıya kadar olan mükemmel sayıları listeleme
        StringBuilder listBuilder = new StringBuilder("\n\n" + n + " sayısına kadar olan Mükemmel Sayılar:\n");
        boolean foundAny = false;
        
        // Performans için üst limit (Uygulamanın donmaması için)
        long searchLimit = Math.min(n, 10000); 
        
        for (long j = 1; j <= searchLimit; j++) {
            long tempSum = 0;
            for (long k = 1; k < j; k++) {
                if (j % k == 0) tempSum += k;
            }
            if (tempSum == j && j != 0) {
                listBuilder.append(j).append(" - ");
                foundAny = true;
            }
        }
        
        if (!foundAny) {
            listBuilder.append("Bu aralıkta başka mükemmel sayı bulunamadı.");
        } else {
            // Sondaki " - " işaretini sil
            listBuilder.setLength(listBuilder.length() - 3);
        }

        if (n > 10000) {
            listBuilder.append("\n\n(Not: İşlem süresi kısalığı için sadece 10000'e kadar olanlar listelenmiştir.)");
        }

        return status + listBuilder.toString();
    }

    private String getFibonacci(long n) {
        if (n <= 0) return "Lütfen pozitif bir sayı giriniz.";
        if (n > 40) return "Hız için limit 40 olarak belirlenmiştir.";

        // 1. Standart (Iterative) Çalıştırma
        StringBuilder iterativeResult = new StringBuilder("a) Standart Çalıştırma:\n");
        long a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            iterativeResult.append(a).append(i == n - 1 ? "" : ", ");
            long temp = a + b;
            a = b;
            b = temp;
        }

        // 2. Recursive (Özyinelemeli) Çalıştırma
        StringBuilder recursiveResult = new StringBuilder("\n\nb) Recursive Çalıştırma:\n");
        for (int i = 0; i < n; i++) {
            recursiveResult.append(fibRecursive(i)).append(i == n - 1 ? "" : ", ");
        }

        return iterativeResult.toString() + recursiveResult.toString();
    }

    private long fibRecursive(int n) {
        if (n <= 1) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    private String checkArmstrong(long n) {
        // Girilen sayının kontrolü
        String s = String.valueOf(n);
        int len = s.length();
        long sum = 0;
        for (char c : s.toCharArray()) {
            sum += Math.pow(Character.getNumericValue(c), len);
        }
        boolean isArmstrong = (sum == n);
        String status = isArmstrong ? n + " bir Armstrong sayısıdır." : n + " bir Armstrong sayısı değildir.";

        // Belirli bir sınıra kadar olan Armstrong sayılarını listeleme
        StringBuilder listBuilder = new StringBuilder("\n\n" + n + " sayısına kadar olan Armstrong Sayıları:\n");
        boolean foundAny = false;
        
        long searchLimit = Math.min(n, 100000); // 100,000'e kadar arama yapalım
        
        for (long j = 0; j <= searchLimit; j++) {
            String tempS = String.valueOf(j);
            int tempLen = tempS.length();
            long tempSum = 0;
            for (char c : tempS.toCharArray()) {
                tempSum += Math.pow(Character.getNumericValue(c), tempLen);
            }
            if (tempSum == j) {
                listBuilder.append(j).append(" - ");
                foundAny = true;
            }
        }

        if (foundAny) {
            listBuilder.setLength(listBuilder.length() - 3);
        } else {
            listBuilder.append("Bulunamadı.");
        }

        if (n > 100000) {
            listBuilder.append("\n\n(Not: Performans için sadece 100.000'e kadar olanlar listelenmiştir.)");
        }

        return status + listBuilder.toString();
    }

    private String getTribonacci(long n) {
        if (n <= 0) return "Lütfen pozitif bir sayı giriniz.";
        if (n > 30) return "Recursive işlem hızı için limit 30'dur.";

        // 1. Standart (Iterative)
        StringBuilder iterativeResult = new StringBuilder("a) Standart Çalıştırma:\n");
        long a = 0, b = 0, c = 1;
        for (int i = 0; i < n; i++) {
            iterativeResult.append(a).append(i == n - 1 ? "" : ", ");
            long t = a + b + c;
            a = b;
            b = c;
            c = t;
        }

        // 2. Recursive
        StringBuilder recursiveResult = new StringBuilder("\n\nb) Recursive Çalıştırma:\n");
        for (int i = 0; i < n; i++) {
            recursiveResult.append(tribRecursive(i)).append(i == n - 1 ? "" : ", ");
        }

        return iterativeResult.toString() + recursiveResult.toString();
    }

    private long tribRecursive(int n) {
        if (n == 0 || n == 1) return 0;
        if (n == 2) return 1;
        return tribRecursive(n - 1) + tribRecursive(n - 2) + tribRecursive(n - 3);
    }

    private String checkPalindrome(String s) {
        // Girilen sayının kontrolü
        String rev = new StringBuilder(s).reverse().toString();
        boolean isPalindrome = s.equals(rev);
        String status = isPalindrome ? s + " bir Palindromdur." : s + " Palindrom değildir.";

        // Belirli bir sınıra kadar olan palindromları listeleme
        try {
            long n = Long.parseLong(s);
            StringBuilder listBuilder = new StringBuilder("\n\n" + n + " sayısına kadar olan Palindrom Sayılar:\n");
            boolean foundAny = false;
            
            // Limit 10,000 to prevent UI freezing
            long searchLimit = Math.min(n, 10000);
            
            for (long i = 0; i <= searchLimit; i++) {
                String tempS = String.valueOf(i);
                String tempRev = new StringBuilder(tempS).reverse().toString();
                if (tempS.equals(tempRev)) {
                    listBuilder.append(i).append(" - ");
                    foundAny = true;
                }
            }
            
            if (foundAny) {
                listBuilder.setLength(listBuilder.length() - 3);
            } else {
                listBuilder.append("Bulunamadı.");
            }

            if (n > 10000) {
                listBuilder.append("\n\n(Not: Performans için sadece 10.000'e kadar olanlar listelenmiştir.)");
            }
            
            return status + listBuilder.toString();
        } catch (NumberFormatException e) {
            return status;
        }
    }

    private String getCullen(long n) {
        if (n < 0) return "Pozitif değer girin.";
        if (n > 30) return "n için limit 30'dur (Sayı çok büyüyor).";

        long cullenN = (long) (n * Math.pow(2, n) + 1);
        StringBuilder sb = new StringBuilder("n=" + n + " için Cullen sayısı: " + cullenN + "\n\nSeri:\n");
        
        for (int i = 0; i <= n; i++) {
            long val = (long) (i * Math.pow(2, i) + 1);
            sb.append(val).append(i == n ? "" : " - ");
        }
        return sb.toString();
    }

    private String checkLasa(long n) {
        boolean isLasa = isEmirp(n);
        String status = isLasa ? n + " bir Lasa (Emirp) sayısıdır." : n + " Lasa değildir.";

        StringBuilder listBuilder = new StringBuilder("\n\n" + n + " sayısına kadar olan Lasa Sayıları:\n");
        boolean foundAny = false;
        long searchLimit = Math.min(n, 5000);

        for (long i = 2; i <= searchLimit; i++) {
            if (isEmirp(i)) {
                listBuilder.append(i).append(" - ");
                foundAny = true;
            }
        }

        if (foundAny) {
            listBuilder.setLength(listBuilder.length() - 3);
        } else {
            listBuilder.append("Bulunamadı.");
        }

        return status + listBuilder.toString();
    }

    private boolean isEmirp(long n) {
        if (!isPrime(n)) return false;
        String s = String.valueOf(n);
        String revS = new StringBuilder(s).reverse().toString();
        if (s.equals(revS)) return false; // Palindromlar Lasa değildir
        long revN = Long.parseLong(revS);
        return isPrime(revN);
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private String getFermat(long n) {
        if (n < 0 || n > 5) return "Lütfen 0 ile 5 arasında bir n değeri giriniz (Sayılar çok hızlı büyür).";
        
        // F(n) = 2^(2^n) + 1
        long powerOfTwo = (long) Math.pow(2, n);
        // Not: Math.pow sonucu double olduğu için hassasiyet kaybı olabilir ama n<=5 için sorun olmaz.
        // Ancak 2^32 bir long'a sığar (F(5) için 2^32 gerekir).
        long result = (long) Math.pow(2, powerOfTwo) + 1;
        
        if (n == 5) {
            // F(5) hassasiyet için manuel atanabilir veya BigInteger kullanılabilir
            return "F(5) = 4294967297\n(Bu sayı asaldır sanılıyordu ama Euler tarafından 641 * 6700417 olduğu kanıtlandı).";
        }

        return "F(" + n + ") = 2^(2^" + n + ") + 1 = " + result;
    }

    private String checkAmicable(long n) {
        // Girilen sayının dostu var mı kontrolü
        long sum1 = sumDivisors(n);
        long sum2 = sumDivisors(sum1);
        boolean hasPartner = (sum2 == n && sum1 != n);
        String status = hasPartner ? n + " sayısının dostu " + sum1 + " sayısıdır." : n + " sayısının bir dostu yoktur.";

        // Belirli bir sınıra kadar olan dost sayı çiftlerini listeleme
        StringBuilder listBuilder = new StringBuilder("\n\n" + n + " sayısına kadar olan Dost Sayı Çiftleri:\n");
        boolean foundAny = false;
        
        // Performans için limit (Arama maliyetli olduğu için)
        long searchLimit = Math.min(n, 3000); 
        
        List<Long> alreadyFound = new ArrayList<>();
        
        for (long i = 1; i <= searchLimit; i++) {
            if (alreadyFound.contains(i)) continue;
            
            long s1 = sumDivisors(i);
            long s2 = sumDivisors(s1);
            
            if (s2 == i && s1 != i) {
                listBuilder.append("(").append(i).append(", ").append(s1).append(") - ");
                alreadyFound.add(s1);
                foundAny = true;
            }
        }

        if (foundAny) {
            listBuilder.setLength(listBuilder.length() - 3);
        } else {
            listBuilder.append("Bu aralıkta başka dost sayı çifti bulunamadı.");
        }

        if (n > 3000) {
            listBuilder.append("\n\n(Not: İşlem süresi kısalığı için sadece 3000'e kadar olanlar listelenmiştir.)");
        }

        return status + listBuilder.toString();
    }

    private String checkAbundant(long n) {
        long sum = sumDivisors(n);
        boolean isAbundant = (sum > n);
        String status = isAbundant ? n + " bir Zengin sayıdır. (Bölenleri toplamı: " + sum + ")" : n + " Zengin değildir. (Bölenleri toplamı: " + sum + ")";

        StringBuilder listBuilder = new StringBuilder("\n\n" + n + " sayısına kadar olan Zengin Sayılar:\n");
        boolean foundAny = false;
        long searchLimit = Math.min(n, 5000);

        for (long i = 1; i <= searchLimit; i++) {
            if (sumDivisors(i) > i) {
                listBuilder.append(i).append(" - ");
                foundAny = true;
            }
        }

        if (foundAny) {
            listBuilder.setLength(listBuilder.length() - 3);
        } else {
            listBuilder.append("Bulunamadı.");
        }

        return status + listBuilder.toString();
    }

    private String getLucas(long n) {
        if (n <= 0) return "Lütfen pozitif bir sayı giriniz.";
        if (n > 50) return "Limit 50 olarak belirlenmiştir.";

        StringBuilder sb = new StringBuilder("Lucas Serisi (" + n + " terim):\n");
        long a = 2, b = 1;
        for (int i = 0; i < n; i++) {
            sb.append(a).append(i == n - 1 ? "" : ", ");
            long temp = a + b;
            a = b;
            b = temp;
        }
        return sb.toString();
    }

    private String getTetranacci(long n) {
        if (n <= 0) return "Lütfen pozitif bir sayı giriniz.";
        if (n > 40) return "Limit 40 olarak belirlenmiştir.";

        StringBuilder sb = new StringBuilder("Tetranacci Serisi (" + n + " terim):\n");
        long[] series = new long[(int) Math.max(n, 4)];
        series[0] = 0;
        series[1] = 0;
        series[2] = 0;
        series[3] = 1;

        for (int i = 4; i < n; i++) {
            series[i] = series[i - 1] + series[i - 2] + series[i - 3] + series[i - 4];
        }

        for (int i = 0; i < n; i++) {
            sb.append(series[i]).append(i == n - 1 ? "" : ", ");
        }
        return sb.toString();
    }

    private String checkTwinPrimes(long n) {
        boolean isNPrime = isPrime(n);
        boolean hasTwin = false;
        long twin = -1;

        if (isNPrime) {
            if (isPrime(n + 2)) {
                hasTwin = true;
                twin = n + 2;
            } else if (isPrime(n - 2)) {
                hasTwin = true;
                twin = n - 2;
            }
        }

        String status = hasTwin ? n + " bir ikiz asaldır. Eşi: " + twin : n + " bir ikiz asal değildir.";

        StringBuilder listBuilder = new StringBuilder("\n\n" + n + " sayısına kadar olan İkiz Asallar:\n");
        boolean foundAny = false;
        long searchLimit = Math.min(n, 5000);

        for (long i = 2; i <= searchLimit - 2; i++) {
            if (isPrime(i) && isPrime(i + 2)) {
                listBuilder.append("(").append(i).append(", ").append(i + 2).append(") - ");
                foundAny = true;
            }
        }

        if (foundAny) {
            listBuilder.setLength(listBuilder.length() - 3);
        } else {
            listBuilder.append("Bulunamadı.");
        }

        return status + listBuilder.toString();
    }

    private String getWoodall(long n) {
        if (n < 1) return "Lütfen pozitif bir n değeri giriniz.";
        if (n > 30) return "n için limit 30'dur (Sayılar çok hızlı büyür).";

        long woodallN = (long) (n * Math.pow(2, n) - 1);
        StringBuilder sb = new StringBuilder("n=" + n + " için Woodall sayısı: " + woodallN + "\n\nSeri:\n");
        
        for (int i = 1; i <= n; i++) {
            long val = (long) (i * Math.pow(2, i) - 1);
            sb.append(val).append(i == n ? "" : " - ");
        }
        return sb.toString();
    }

    private String getMersenne(long n) {
        if (n < 1) return "Lütfen pozitif bir n değeri giriniz.";
        if (n > 60) return "n için limit 60'tır.";

        long mersenneN = (long) (Math.pow(2, n) - 1);
        StringBuilder sb = new StringBuilder("n=" + n + " için Mersenne sayısı: " + mersenneN + "\n\nSeri:\n");
        
        for (int i = 1; i <= n; i++) {
            long val = (long) (Math.pow(2, i) - 1);
            sb.append(val).append(i == n ? "" : " - ");
        }
        return sb.toString();
    }

    private String checkHarshad(long n) {
        long sum = 0, t = n;
        while (t > 0) {
            sum += t % 10;
            t /= 10;
        }
        boolean isHarshad = (n % sum == 0);
        String status = isHarshad ? n + " bir Harshad sayısıdır." : n + " Harshad değildir.";

        StringBuilder listBuilder = new StringBuilder("\n\n" + n + " sayısına kadar olan Harshad Sayıları:\n");
        boolean foundAny = false;
        long searchLimit = Math.min(n, 5000);

        for (long i = 1; i <= searchLimit; i++) {
            long tempSum = 0, tempT = i;
            while (tempT > 0) {
                tempSum += tempT % 10;
                tempT /= 10;
            }
            if (i % tempSum == 0) {
                listBuilder.append(i).append(" - ");
                foundAny = true;
            }
        }

        if (foundAny) {
            listBuilder.setLength(listBuilder.length() - 3);
        } else {
            listBuilder.append("Bulunamadı.");
        }

        return status + listBuilder.toString();
    }

    private String checkCyclic(String s) {
        int n = s.length();
        long num;
        try {
            num = Long.parseLong(s);
        } catch (Exception e) {
            return "Çok büyük veya geçersiz sayı.";
        }

        boolean isCyclic = true;
        char[] originalSorted = s.toCharArray();
        java.util.Arrays.sort(originalSorted);
        String sortedStr = new String(originalSorted);

        for (int i = 1; i <= n; i++) {
            String product = String.valueOf(num * i);
            // Basamak sayısı farklıysa veya önünde 0 varsa (142857 örneğinde 6 basamak korunmalı)
            while (product.length() < n) product = "0" + product;
            
            if (product.length() > n) {
                isCyclic = false;
                break;
            }
            
            char[] productSorted = product.toCharArray();
            java.util.Arrays.sort(productSorted);
            if (!new String(productSorted).equals(sortedStr)) {
                isCyclic = false;
                break;
            }
        }

        return isCyclic ? s + " bir Cyclic (Döngüsel) sayıdır." : s + " bir Cyclic sayı değildir.";
    }

    private String checkTau(long n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }
        boolean isTau = (n % count == 0);
        String status = isTau ? n + " bir Tav sayısıdır. (Bölen sayısı: " + count + ")" : n + " Tav değildir. (Bölen sayısı: " + count + ")";

        StringBuilder listBuilder = new StringBuilder("\n\n" + n + " sayısına kadar olan Tav Sayıları:\n");
        boolean foundAny = false;
        long searchLimit = Math.min(n, 5000);

        for (long i = 1; i <= searchLimit; i++) {
            int tempCount = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) tempCount++;
            }
            if (i % tempCount == 0) {
                listBuilder.append(i).append(" - ");
                foundAny = true;
            }
        }

        if (foundAny) {
            listBuilder.setLength(listBuilder.length() - 3);
        } else {
            listBuilder.append("Bulunamadı.");
        }

        return status + listBuilder.toString();
    }

    private String runKaprekar(String s) {
        if (s.length() != 4) return "Lütfen tam olarak 4 basamaklı bir sayı giriniz.";
        
        char[] digits = s.toCharArray();
        if (digits[0] == digits[1] && digits[1] == digits[2] && digits[2] == digits[3]) {
            return "Tüm rakamlar aynı olamaz (Örn: 1111 geçersizdir).";
        }

        StringBuilder sb = new StringBuilder("Kaprekar Rutini:\n\n");
        String current = s;
        int step = 1;
        
        while (!current.equals("6174") && step < 15) {
            char[] chars = current.toCharArray();
            java.util.Arrays.sort(chars);
            String asc = new String(chars);
            String desc = new StringBuilder(asc).reverse().toString();
            
            int big = Integer.parseInt(desc);
            int small = Integer.parseInt(asc);
            int diff = big - small;
            
            sb.append(step).append(") ").append(desc).append(" - ").append(asc).append(" = ").append(diff).append("\n");
            
            current = String.format("%04d", diff);
            if (current.equals("0000")) break;
            step++;
        }
        
        if (current.equals("6174")) {
            sb.append("\nSabit değere (6174) ulaşıldı.");
        }
        
        return sb.toString();
    }

    private long sumDivisors(long n) {
        long s = 0;
        for (long i = 1; i < n; i++) if (n % i == 0) s += i;
        return s;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
