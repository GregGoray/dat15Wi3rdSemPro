package model;

/**
 * Created by Grzegorz Goraj on 24-05-2016.
 * email: greg.goray@gmail.com
 */


public class TherapistResume {


    private String summary;
    private String highlights;
    private String workExperience;
    private String education;
    private String certification;
    private String picturePath;


    public TherapistResume(int therapistId, String summary, String highlights, String workExperience,
                           String education, String certification, String picturePath) {

        this.therapistId = therapistId;
        this.summary = summary;
        this.highlights = highlights;
        this.workExperience = workExperience;
        this.education = education;
        this.certification = certification;
        this.picturePath = picturePath;

    }

    private int therapistId;

    public int getTherapistId() {
        return therapistId;
    }

    public String getSummary() {
        return summary;
    }

    public String getHighlights() {
        return highlights;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public String getEducation() {
        return education;
    }

    public String getCertification() {
        return certification;
    }
    public String getPicturePath() {
        return picturePath;
    }

}
