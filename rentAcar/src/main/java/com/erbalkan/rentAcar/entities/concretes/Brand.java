package com.erbalkan.rentAcar.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "brands") // bu sınıf dbdeki brands tablosuna gelecek 
// @Data // getter ve setter'ları ve parametresiz constructoru oto oluşturur(lombok)
@AllArgsConstructor // Bütün parametrelerle constructor oluşturur(lombok)
@NoArgsConstructor 
// parametresiz constructor - @Data bunu zaten oluşturuyor ama Data değil de getter setter ayrı kullanırsak Datayı kullanamayacağımız için bunu eklemeliyiz.
@Getter // sadece getterlar oluşur(lombok)
@Setter // sadece setterlar oluşur(lombok)
@Entity // Bir veritabanı varlığı olduğunu belirtiriz.
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    // public int getId() {
    //     return id;
    // }
    // public void setId(int id) {
    //     this.id = id;
    // }
    // public String getName() {
    //     return name;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }

    // public Brand() {}

    // public Brand(int id,String name) {
    //     this.id = id;
    //     this.name = name;
    // }
    

}
