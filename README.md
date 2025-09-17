# 📝 Test API Automation – Rest Assured + TestNG

Project ini adalah implementasi **API Automation Testing** menggunakan **Java**, **Rest Assured**, dan **TestNG**.
Tujuan project ini adalah untuk menguji endpoint API secara otomatis, memastikan fungsionalitas berjalan sesuai ekspektasi, serta mempermudah proses regression testing.

## 🚀 Teknologi yang Digunakan

- **Java** 17
- **Rest Assured** (library untuk HTTP request/response testing)
- **TestNG** (framework untuk test management & report)
- **Maven** (dependency & build management)



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
       <!-- Rest Assured -->
       <dependency>
           <groupId>io.rest-assured</groupId>
           <artifactId>rest-assured</artifactId>
           <version>5.3.0</version>
           <scope>test</scope>
       </dependency>

       <!-- TestNG -->
       <dependency>
           <groupId>org.testng</groupId>
           <artifactId>testng</artifactId>
           <version>7.7.0</version>
           <scope>test</scope>
       </dependency>

       <!-- JSON Path (opsional) -->
       <dependency>
           <groupId>io.rest-assured</groupId>
           <artifactId>json-path</artifactId>
           <version>5.3.0</version>
           <scope>test</scope>
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
