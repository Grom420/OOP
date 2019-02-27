package psuti.pp.exam.backend.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@XmlRootElement



public class Person implements Serializable {

    private static final String NONE = "NONE";
    @NotNull
    private int id = -1;

    @NotNull
    @Size(min = 2)

    private String firstName = NONE;
    private String secondName = NONE;
    private String middleName = NONE;
    private LocalDate birthDate = LocalDate.MIN;
    private String docNumber = NONE;
    private String phoneNumber = NONE;



    private String city = NONE;
    private String county = NONE;
    private String street = NONE;
    private int building = -1;
    private char liter = ' ';
    private int corpus = -1;
    private int apartment = -1;



    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "Имя")
    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement(name = "Фамилия")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @XmlElement(name = "Отчество")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @XmlElement(name = "День рождения")
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @XmlElement(name = "Номер документов")
    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return NONE;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public Character getLiter() {
        return liter;
    }

    public void setLiter(char liter) {
        this.liter = liter;
    }

    public Integer getCorpus() {
        return corpus;
    }

    public void setCorpus(int corpus) {
        this.corpus = corpus;
    }

    public Integer getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

}
