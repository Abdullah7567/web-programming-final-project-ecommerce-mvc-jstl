# Java MVC ve JSTL ile Temel E-Ticaret Portalı

Bu proje **Java Servlet + JSP + JSTL + JDBC** kullanılarak geliştirilmiş temel bir e-ticaret portalıdır.

Projede kullanıcı tarafında ürün listeleme, kategori filtreleme, ürün detay görüntüleme, sepet işlemleri, kullanıcı kayıt/giriş işlemleri ve sipariş oluşturma özellikleri bulunmaktadır. Yönetici tarafında ise kategori, ürün, sipariş ve kullanıcı yönetimi yapılabilir.

---

## Kullanılan Teknolojiler

- Java JDK
- Java Servlet
- JSP
- JSTL
- JDBC
- MySQL
- Apache Tomcat 9
- Maven
- HTML / CSS / Bootstrap

---

## Demo Kullanıcı Bilgileri

### Admin

```text
E-posta: admin@site.com
Şifre: admin123
```

### Müşteri

```text
E-posta: user@site.com
Şifre: user123
```

> Not: Eğer `database.sql` dosyasında farklı admin bilgisi varsa, phpMyAdmin üzerinden `users` tablosunu kontrol edebilirsiniz.

---

# Kurulum ve Çalıştırma Adımları

## 1. Projeyi ZIP'ten çıkarın

ZIP dosyasını bilgisayarınızda uygun bir yere çıkarın.

Önerilen klasör:

```text
C:\ecommerce-mvc-jstl
```

Klasörün içinde şu dosyalar/klasörler bulunmalıdır:

```text
pom.xml
src
sql
README.md
```

---

## 2. XAMPP üzerinden MySQL'i başlatın

XAMPP Control Panel'i açın.

Şunları başlatın:

```text
Apache → Start
MySQL → Start
```

- **Apache**, phpMyAdmin kullanmak için gereklidir.
- **MySQL**, projenin veritabanı için gereklidir.

> Not: Projeyi çalıştırmak için XAMPP Tomcat kullanılmayacaktır. Proje için ayrıca **Apache Tomcat 9** kullanılmalıdır.

---

## 3. Veritabanını phpMyAdmin üzerinden oluşturun

Tarayıcıdan şu adrese girin:

```text
http://localhost/phpmyadmin
```

Ardından:

```text
Import / İçe Aktar → Choose File / Dosya Seç
```

Şu dosyayı seçin:

```text
C:\ecommerce-mvc-jstl\sql\database.sql
```

Sonra en alttan:

```text
Import
```

butonuna basın.

İşlem başarılı olursa sol tarafta şu veritabanı oluşmalıdır:

```text
ecommerce_mvc_jstl
```

---

## 4. Veritabanı bağlantı ayarlarını kontrol edin

Şu dosyayı açın:

```text
C:\ecommerce-mvc-jstl\src\main\resources\db.properties
```

XAMPP kullanıyorsanız genelde ayarlar şöyle olmalıdır:

```properties
db.url=jdbc:mysql://localhost:3306/ecommerce_mvc_jstl?useSSL=false&serverTimezone=UTC
db.username=root
db.password=
```

Eğer MySQL şifreniz yoksa:

```properties
db.password=
```

kısmı boş kalmalıdır.

Eğer MySQL şifreniz varsa:

```properties
db.password=MYSQL_SIFRENIZ
```

şeklinde yazın.

---

# Maven ile WAR Dosyası Oluşturma

## 5. CMD ile proje klasörüne girin

CMD açın ve `pom.xml` dosyasının bulunduğu klasöre gidin:

```cmd
cd C:\ecommerce-mvc-jstl
```

Kontrol etmek için:

```cmd
dir
```

çıktısında `pom.xml` görünmelidir.

---

## 6. Projeyi derleyin

Şu komutu çalıştırın:

```cmd
mvn clean package
```

Başarılı olursa şu dosya oluşur:

```text
C:\ecommerce-mvc-jstl\target\ecommerce-mvc-jstl.war
```

---

# Maven Hatası: `mvn is not recognized`

Eğer şu hata çıkarsa:

```text
mvn is not recognized as an internal or external command
```

bu, Maven'in kurulu olmadığı veya PATH'e eklenmediği anlamına gelir.

## Maven Kurulumu

### 1. Maven'i indirin

Google'da arayın:

```text
Apache Maven download
```

Resmi siteden **Binary zip** dosyasını indirin.

Örnek dosya adı:

```text
apache-maven-3.9.x-bin.zip
```

### 2. ZIP dosyasını çıkarın

Önerilen konum:

```text
C:\apache-maven
```

İçinde şu klasör bulunmalıdır:

```text
C:\apache-maven\bin
```

### 3. Maven'i PATH'e ekleyin

Windows aramasına şunu yazın:

```text
Environment Variables
```

Sonra şu yolu izleyin:

```text
Edit the system environment variables
Environment Variables
System variables
Path
Edit
New
```

Şunu ekleyin:

```text
C:\apache-maven\bin
```

Tüm pencerelere **OK** deyin.

### 4. CMD'yi yeniden açın

Eski CMD'yi kapatıp yeni CMD açın.

Kontrol edin:

```cmd
mvn -v
```

Maven sürümü görünüyorsa kurulum tamamdır.

Sonra tekrar proje klasörüne girip çalıştırın:

```cmd
cd C:\ecommerce-mvc-jstl
mvn clean package
```

---

# Maven Hatası: `there is no POM in this directory`

Eğer şöyle bir hata çıkarsa:

```text
The goal you specified requires a project to execute but there is no POM in this directory
```

bu, Maven komutunu yanlış klasörde çalıştırdığınız anlamına gelir.

Çözüm:

```cmd
dir
```

komutu ile bulunduğunuz klasörde `pom.xml` var mı kontrol edin.

Eğer yoksa, proje klasörünün içine girin. Örneğin:

```cmd
cd C:\Users\kullanici\Desktop\ecommerce-mvc-jstl
```

Tekrar kontrol edin:

```cmd
dir
```

`pom.xml` görünüyorsa:

```cmd
mvn clean package
```

komutunu yeniden çalıştırın.

---

# Tomcat 9 Kurulumu

## 7. Tomcat 9 indirin

Google'da arayın:

```text
Apache Tomcat 9 download
```

Resmi siteden şunu indirin:

```text
Tomcat 9 → 64-bit Windows zip
```

Örnek dosya adı:

```text
apache-tomcat-9.0.xxx-windows-x64.zip
```

---

## 8. Tomcat ZIP dosyasını çıkarın

ZIP dosyasını şu konuma çıkarabilirsiniz:

```text
C:\apache-tomcat-9.0.xxx
```

İçinde şu klasörler olmalıdır:

```text
bin
conf
lib
logs
webapps
```

---

# JAVA_HOME Ayarlaması

Tomcat'i çalıştırırken şu hata alınırsa:

```text
Neither the JAVA_HOME nor the JRE_HOME environment variable is defined
```

bu, Tomcat'in Java'yı bulamadığı anlamına gelir.

## 9. JDK kurulu mu kontrol edin

CMD'de yazın:

```cmd
java -version
javac -version
```

İkisi de sürüm gösteriyorsa JDK kurulu demektir.

Örnek:

```text
java version "21.0.8"
javac 21.0.8
```

---

## 10. JDK klasörünü bulun

Genelde şu klasörde bulunur:

```text
C:\Program Files\Java
```

İçinde şöyle bir klasör olabilir:

```text
jdk-21
```

veya:

```text
jdk-17
```

Örnek doğru JAVA_HOME yolu:

```text
C:\Program Files\Java\jdk-21
```

Dikkat: Sonuna `\bin` yazılmamalıdır.

Yanlış:

```text
C:\Program Files\Java\jdk-21\bin
```

Doğru:

```text
C:\Program Files\Java\jdk-21
```

---

## 11. JAVA_HOME ekleyin

Windows aramasına yazın:

```text
Environment Variables
```

Sonra:

```text
Edit the system environment variables
Environment Variables
System variables
New
```

Şöyle ekleyin:

```text
Variable name: JAVA_HOME
Variable value: C:\Program Files\Java\jdk-21
```

Sizin bilgisayarınızda JDK klasörü farklıysa kendi JDK yolunuzu yazın.

---

## 12. Path'e Java bin klasörünü ekleyin

Aynı ekranda:

```text
System variables
Path
Edit
New
```

Şunu ekleyin:

```text
%JAVA_HOME%\bin
```

Tüm pencerelere **OK** deyin.

CMD'yi kapatıp yeniden açın.

Kontrol edin:

```cmd
echo %JAVA_HOME%
java -version
javac -version
```

---

# WAR Dosyasını Tomcat'e Yükleme

## 13. Eski deploy dosyalarını temizleyin

Tomcat `webapps` klasörüne gidin:

```text
C:\apache-tomcat-9.0.xxx\webapps
```

Eğer daha önce koyduysanız şu dosya ve klasörü silin:

```text
ecommerce-mvc-jstl.war
ecommerce-mvc-jstl
```

---

## 14. Yeni WAR dosyasını kopyalayın

Şu dosyayı:

```text
C:\ecommerce-mvc-jstl\target\ecommerce-mvc-jstl.war
```

Tomcat'in `webapps` klasörüne kopyalayın:

```text
C:\apache-tomcat-9.0.xxx\webapps
```

Sonuç şöyle olmalıdır:

```text
C:\apache-tomcat-9.0.xxx\webapps\ecommerce-mvc-jstl.war
```

---

# Tomcat'i Çalıştırma

## 15. Tomcat'i CMD üzerinden çalıştırın

CMD açın:

```cmd
cd C:\apache-tomcat-9.0.xxx\bin
catalina.bat run
```

CMD penceresini kapatmayın. Açık kalmalıdır.

Başarılı çalışırsa şu tarz satırlar görünür:

```text
Deployment of web application archive ... has finished
Server startup
```

---

## 16. Tarayıcıdan projeyi açın

Önce Tomcat ana sayfasını kontrol edin:

```text
http://localhost:8080/
```

Sonra projeyi açın:

```text
http://localhost:8080/ecommerce-mvc-jstl/
```

Admin paneli:

```text
http://localhost:8080/ecommerce-mvc-jstl/admin/login
```

---

# Sık Karşılaşılan Hatalar ve Çözümleri

## 1. `localhost refused to connect`

Bu hata Tomcat'in çalışmadığını gösterir.

Çözüm:

```cmd
cd C:\apache-tomcat-9.0.xxx\bin
catalina.bat run
```

komutuyla Tomcat'i tekrar başlatın.

---

## 2. `HTTP Status 404 - Not Found`

Bu hata genelde projenin deploy edilmediğini veya yanlış linke girildiğini gösterir.

Kontrol edin:

```text
C:\apache-tomcat-9.0.xxx\webapps\ecommerce-mvc-jstl.war
C:\apache-tomcat-9.0.xxx\webapps\ecommerce-mvc-jstl
```

Bu dosya ve klasör var mı bakın.

Doğru link:

```text
http://localhost:8080/ecommerce-mvc-jstl/
```

---

## 3. `HTTP Status 500`

Bu hata genelde veritabanı bağlantı sorunudur.

Kontrol edin:

- XAMPP MySQL açık mı?
- `database.sql` phpMyAdmin'den import edildi mi?
- `db.properties` içindeki kullanıcı adı ve şifre doğru mu?

---

# Proje Linkleri

Kullanıcı tarafı:

```text
http://localhost:8080/ecommerce-mvc-jstl/
```

Admin giriş:

```text
http://localhost:8080/ecommerce-mvc-jstl/admin/login
```

---

# Kısa Özet

```text
1. ZIP dosyasını çıkar.
2. XAMPP Apache + MySQL başlat.
3. phpMyAdmin'den sql/database.sql dosyasını import et.
4. db.properties dosyasını kontrol et.
5. pom.xml olan klasörde mvn clean package çalıştır.
6. Oluşan ecommerce-mvc-jstl.war dosyasını Tomcat 9 webapps içine koy.
7. JAVA_HOME ayarlı değilse ayarla.
8. Tomcat'i catalina.bat run ile başlat.
9. http://localhost:8080/ecommerce-mvc-jstl/ adresinden projeyi aç.
```

---

# Notlar

- XAMPP Tomcat 8.5 yerine **Apache Tomcat 9** kullanılması önerilir.
- XAMPP sadece Apache/phpMyAdmin ve MySQL için kullanılabilir.
- Proje `Servlet + JSP + JSTL + JDBC` mimarisiyle geliştirilmiştir.
- Spring Boot, Hibernate, JPA, React, Angular veya Vue kullanılmamıştır.
