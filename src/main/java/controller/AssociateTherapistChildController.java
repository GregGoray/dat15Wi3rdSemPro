package controller;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import model.Child;
import model.Database;
import model.Therapist;
import view.AssociateTherapistChild;

import java.util.ArrayList;

/**
 * Created by Grzegorz Goraj on 22-05-2016.
 * email: greg.goray@gmail.com
 */
public class AssociateTherapistChildController {

    Database db = Database.getInstance();
    // AssociateTherapistChild associateTherapistChild = new AssociateTherapistChild();



    public ObservableList<Child> setChildernToTable() {

        ObservableList<Child> childernFromDb = (ObservableList)db.getChildren();
        return childernFromDb;

    }


    public ArrayList<Therapist> setTherapistToTable() {

        ArrayList<Therapist> therapistsFromDb = db.getTherapists();
        return therapistsFromDb;
    }



}
