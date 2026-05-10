# İstenenler Kontrol Listesi

Kaynak ödev dosyasındaki ana isterlere göre proje kapsamı:

- Java Servlet, JSP, JSTL, JDBC, MySQL, Tomcat yapısı hazırlandı.
- MVC klasör yapısı: model, dao, controller/servlet, filter, view/JSP.
- Kullanıcı tarafı: ana sayfa, kategori filtreleme, ürün detay, kayıt, giriş, sepet, adet güncelleme, sipariş oluşturma, siparişlerim, sipariş detay.
- Admin tarafı: admin login, dashboard, kategori yönetimi, ürün yönetimi, sipariş yönetimi, kullanıcı listeleme.
- Session: user/admin login bilgisi ve sepet session üzerinde tutulur.
- SQL: users, categories, products, orders, order_items tabloları ve demo kayıtlar.
- JSTL: c:forEach, c:if, c:choose, fmt:formatNumber, fmt:formatDate kullanıldı.
- Form doğrulama: HTML ve Servlet tarafında temel kontroller eklendi.
- Ek özellikler: ürün arama, sipariş durumunda renkli gösterim, şifreleri SHA-256 hashleme.

Not: Maven bu çalışma ortamında kurulu olmadığı için WAR paketi burada üretilemedi; Java sınıfları servlet-api ile sözdizimi açısından kontrol edildi. Kendi bilgisayarınızda `mvn clean package` komutu ile WAR dosyasını alabilirsiniz.
