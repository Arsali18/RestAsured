# 📝 Test API Automation – Rest Assured + TestNG

Project ini adalah implementasi **API Automation Testing** menggunakan **Java**, **Rest Assured**, dan **TestNG**.
Tujuan project ini adalah untuk menguji endpoint API secara otomatis, memastikan fungsionalitas berjalan sesuai ekspektasi, serta mempermudah proses regression testing.

## 🚀 Teknologi yang Digunakan

- **Java** 17
- **Rest Assured** (library untuk HTTP request/response testing)
- **TestNG** (framework untuk test management & report)
- **Maven** (dependency & build management)
- **Jackson** (library untuk serialisasi dan deserialisasi JSON (konversi antara Java object dan JSON))



## ⚙️ Setup & Instalasi

1. **Clone repository**
   ```bash
   git clone https://github.com/username/test-api-automation.git
   cd test-api-automation
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Pastikan file `pom.xml` berisi dependensi berikut:**

   ```xml
   <dependencies>
        <!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>5.5.6</version>
            <scope>test</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/io.github.cdimascio/dotenv-java -->
        <dependency>
            <groupId>io.github.cdimascio</groupId>
            <artifactId>dotenv-java</artifactId>
            <version>3.2.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.testng/testng -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.11.0</version>
            <scope>test</scope>
        </dependency>

        <!-- jackson -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.20.0</version>
        </dependency>
    </dependencies>
   ```

## ▶️ Menjalankan Test

- Jalankan semua test:
  ```bash
  mvn test
  ```

- Jalankan test spesifik dengan TestNG:
  ```bash
  mvn -Dtest=NamaClassTest test
  ```

- Jalankan via file **testng.xml**:
  ```bash
  mvn clean test -DsuiteXmlFile=testng.xml
  ```


## 🧑‍💻 Kontribusi

1. Fork repository ini
2. Buat branch baru (`feature/nama-fitur`)
3. Commit perubahan
4. Buat Pull Request

## 📄 Lisensi

Proyek ini menggunakan lisensi **MIT** – silakan gunakan & modifikasi sesuai kebutuhan.
