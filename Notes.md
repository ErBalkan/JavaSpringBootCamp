# Spring Boot 

## Katmanları oluşturmak

1. __entities ->__ Varlık sınıfıdır. İçerisinde concretes paketi olmalıdır.

2. __dataAccess ->__ Veri erişim katmanıdır. İçerisinde concretes ve abstracts paketleri olmalıdır.

3. __business ->__ Servis katmanıdır. İçerisinde concretes ve abstracts paketleri olmalıdır.

4. __webApi ->__ APİ katmanıdır. İçerisinde controllers paketi olmalıdır.

## İlk varlığımızı oluşturalım

__entities -> concretes__ paketi içerisinde __Brand.java__ sınıfını oluşturalım.

```java
@Table(name = "brands") // bu sınıf dbdeki brands tablosuna gelecek 
// @Data // getter ve setter'ları ve parametresiz constructoru oto oluşturur(lombok)
@AllArgsConstructor // Bütün parametrelerle constructor oluşturur(lombok)
@NoArgsConstructor 
// parametresiz constructor - @Data bunu zaten oluşturuyor ama Data değil de getter setter ayrı kullanırsak Datayı kullanamayacağımız için bunu eklemeliyiz.
@Getter // sadece getterlar oluşur(lombok)
@Setter // sadece setterlar oluşur(lombok)
@Entity // Bir veritabanı varlığı olduğunu belirtiriz.
public class Brand{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
}
```

Biz projemizde `LOMBOK` kullandığımız için __getter, setter ve constructor__ oluşturmadan devam ettik.
- __@Id ->__ Bu değişkenin bir __ID__ olduğunu bildirir.
- __@GeneratedValue(strategy = GenerationType.IDENTITY) ->__ Bu değeri __IDENTITY__ seçeneğini seçerek bir bir otomatik artmasını sağladık.
- __@Column(name="id") ->__ Bu değişkenin veritabanında __id__ kolonuna geleceğini belirttik. Bu özelliği Lombok değil jakarta.persistance paketi sağlar. 

## Veri erişim katmanına başlayalım

__dataAccess -> abstracts__ paketi içerisine __BrandRepository.java__ adında bir interface oluştururuz. 

```java
// Integer- id primary key veri tipi
public interface BrandRepository extends JpaRepository<Brand,Integer>{
    // List<Brand> getAll(); // artık gerek yok şünkü JPA bütün crud metotlarını bize sunuyor.
}
```

## Servis katmanına başlayalım

__business -> abstracts__ paketi içerisinde __BrandService.java__ adında bir interface oluştururuz.

```java
public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    void add(CreateBrandRequest createBrandRequest);
}
```

