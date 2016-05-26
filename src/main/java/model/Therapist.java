package model;


/**
 * Created by Kuba on 2016-05-08.
 */


public class Therapist extends User{
    int therapistId;
    private String name;
    private String surname;
    private String birthdate;
    private String occupation;
    private String address;
    private String email;
    private String password;
    private String mobile;
    private String picturePath;

    /**
     * Getters:
     * @return
     */
    public String getPicturePath() {
        return picturePath;
    }



    public int getTherapistId() {
        return therapistId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile() {
        return mobile;
    }

    /**
     * Constructor 1
     * @param therapistId
     * @param name
     */
    public Therapist(int therapistId, String name) {
        this.therapistId = therapistId;
        this.name = name;
    }


    /**
     * Constructor 2
     * WITH picturePath
     * @param therapistId
     * @param name
     * @param surname
     * @param birthdate
     * @param occupation
     * @param address
     * @param email
     * @param password
     * @param mobile
     * @param picturePath
     */

    public Therapist(int therapistId, String name, String surname, String birthdate, String occupation,
                     String address, String email, String password, String mobile, String picturePath) {

        this.therapistId = therapistId;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.occupation = occupation;
        this.address = address;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.picturePath = picturePath;
    }


    /**
     * Constructor 3
     * WithOut picturePath
     * @param therapistId
     * @param name
     * @param surname
     * @param birthdate
     * @param occupation
     * @param address
     * @param email
     * @param password
     * @param mobile
     */
    public Therapist(int therapistId, String name, String surname, String birthdate, String occupation,
                     String address, String email, String password, String mobile) {

        this.therapistId = therapistId;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.occupation = occupation;
        this.address = address;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
    }


}
