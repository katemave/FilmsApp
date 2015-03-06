package intec.be.filmsapp.model;

import java.io.Serializable;

import intec.be.filmsapp.R;

/**
 * Created by KateM on 16/02/2015.
 */
public class Films implements Serializable {

    private static final long serialVersionUID = 1L;
    private String title, regisseur, synopsis;
    private int releasedate;
    private int imageRes;

    public Films() {

    }

    public Films(String title, String regisseur, int releasedate) {
        this(title, regisseur, releasedate, null);
    }

    public Films(String title, String regisseur, int releasedate, String synopsis) {
        this.title = title;
        this.regisseur = regisseur;
        this.releasedate = releasedate;
        this.synopsis = synopsis;
        imageRes = R.drawable.ic_launcher;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegisseur() {
        return regisseur;
    }

    public void setRegisseur(String regisseur) {
        this.regisseur = regisseur;
    }

    public int getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(int releasedate) {
        this.releasedate = releasedate;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "Films{" +
                "title='" + title + '\'' +
                ", regisseur='" + regisseur + '\'' +
                ", releasedate=" + releasedate + ", synopsis = " + synopsis +
                '}';
    }
}
