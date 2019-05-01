package Controllers;

public class ModelTable1 {
    public String getPersonName1() {
        return PersonName1;
    }

    public void setPersonName1(String personName1) {
        PersonName1 = personName1;
    }

    public String getPersonSurname1() {
        return PersonSurname1;
    }

    public void setPersonSurname1(String personSurname1) {
        PersonSurname1 = personSurname1;
    }

    public String getPersonSkill1() {
        return PersonSkill1;
    }

    public void setPersonSkill1(String personSkill1) {
        PersonSkill1 = personSkill1;
    }

    public String getPersonPhoneNumber1() {
        return PersonPhoneNumber1;
    }

    public void setPersonPhoneNumber1(String personPhoneNumber1) {
        PersonPhoneNumber1 = personPhoneNumber1;
    }

    public String getPersonUniversity1() {
        return PersonUniversity1;
    }

    public void setPersonUniversity1(String personUniversity1) {
        PersonUniversity1 = personUniversity1;
    }

    String PersonName1;
    String PersonSurname1;
    String PersonSkill1;
    String PersonPhoneNumber1;
    String PersonUniversity1;

    public ModelTable1(   String PersonName1,
            String PersonSurname1,
            String PersonSkill1,
            String PersonPhoneNumber1,
            String PersonUniversity1){

        this.PersonName1=PersonName1;
        this.PersonSurname1=PersonSurname1;
        this.PersonSkill1=PersonSkill1;
        this.PersonPhoneNumber1=PersonPhoneNumber1;
        this.PersonUniversity1=PersonUniversity1;
    }
}
