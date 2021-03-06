package model;

import model.Child;
import model.President;
import model.Therapist;
import view.CreateChildProfileView;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Kuba, Gregory on 2016-05-08.
 *
 * references:
 * https://www.youtube.com/watch?v=QsBQnFUx388
 *
 */
public class Database {

    private Connection conn;

    // how can we re-use that?
    private PreparedStatement statement;

    //empty reference - doesnt unneceserely use resources
    private static Database dbInstance= null;

    //object is to be synchronized    private static Object mutex= new Object();
    private static Object mutex = new Object();


    /**
     * Constructor
     */
    private Database() {
        //comparing hashcodes of class instance is to help
        //recognize valiation of Singleton principles

        String DB_URL = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7118051";
        String USER = "sql7118051";
        String PASS = "EY414dsxHW";

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {

            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public static Database getInstance(){
        if(dbInstance==null){
            synchronized (mutex){
                if(dbInstance==null) dbInstance= new Database();
            }
        }
        return dbInstance;
    }

    /**
     *  Queries *******************************************************************************************************
     */

    public void addNewPresident( String name, String surname, String birthdate, String address, String email, String password,
                                 String mobile) {
        String sql = "INSERT INTO useraccount VALUES(null, ?, ?, ?, ?, ?, ? ,? )";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, birthdate);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, password);
            preparedStatement.setString(7, mobile);


            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addNewTherapist( String name, String surname, String birthdate,String occupation,  String address, String email,
                                 String password, String mobile) {
        String sql = "INSERT INTO useraccount VALUES(null, ?, ?, ?, ?, ?, ?, ?, ? )";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, birthdate);
            preparedStatement.setString(4, occupation);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, password);
            preparedStatement.setString(8, mobile);


            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addNewChild( String name, String surname, String birthdate, String address, String email, String password,
                             String mobile1, String mobile2, String disabilities) {
        String sql = "INSERT INTO useraccount VALUES(null, ?, ?, ?, ?, ?, ? ,?, ?,? )";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, birthdate);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, password);
            preparedStatement.setString(7, mobile1);
            preparedStatement.setString(8, mobile2);
            preparedStatement.setString(9, disabilities);


            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Child retrieveChildIfAllowedToLogIn(String email, String password) {
        String sql = "SELECT * FROM children WHERE email = ? AND password= ?";
        Child child = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int childId = resultSet.getInt(1);
                String name = resultSet.getString(2);

                child = new Child(childId, name);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return child;
    }

    public President retrievePresidentIfAllowedToLogIn(String email, String password) {
        String sql = "SELECT * FROM presidents WHERE email = ? AND password= ?";
        President president = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int presidentId = resultSet.getInt(1);
                String name = resultSet.getString(2);


                president = new President(presidentId, name);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return president;
    }


    public Therapist retrieveTherapistIfAllowedToLogIn(String email, String password) {
        String sql = "SELECT * FROM therapists WHERE email = ? AND password= ?";
        Therapist therapist = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int therapistId = resultSet.getInt(1);
                String name = resultSet.getString(2);



                therapist = new Therapist(therapistId, name);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return therapist;
    }

    public ArrayList<Child> getChildren() {
        ArrayList<Child> children = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Children";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //preparedStatement.setInt(1, childId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Child child = new Child(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),
                        resultSet.getString(8), resultSet.getString(9), resultSet.getString(10));
                children.add(child);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return children;
    }

    public ArrayList<Therapist> getTherapists() {
        ArrayList<Therapist> therapists = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Therapists";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //preparedStatemex`nt.setInt(1, childId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Therapist therapist = new Therapist(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),
                        resultSet.getString(8), resultSet.getString(9));
                therapists.add(therapist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return therapists;
    }

    //make method for returning therapist assigned to a child!!!!!


    public ArrayList<Therapist> getTherapistsforChild(int childId) {
        ArrayList<Therapist> therapists = new ArrayList<>();

        try {
         //   String sql = "SELECT * FROM Therapists INNER JOIN Associations ON Therapists.therapistId = Associations.therapistId WHERE Associations.childId = ? ";
         String sql = "SELECT * FROM Therapists INNER JOIN Associations ON Therapists.therapistId = Associations.oligo" +
                 " OR Therapists.therapistId = Associations.hipo OR Therapists.therapistId = Associations.logo OR Therapists.therapistId = Associations.water" +
                 " OR Therapists.therapistId = Associations.physio WHERE Associations.childId = ? ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, childId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Therapist therapist = new Therapist(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),
                        resultSet.getString(8), resultSet.getString(9));
                therapists.add(therapist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return therapists;
    }

    /******************************************
     *  queries for TherapistsResume
     *  ***************************************
     */


    /**
     *  method returns all theraphists of
     *
     */
    public ArrayList<Therapist> getTherapistsByOccupation() {

        String occupation = CreateChildProfileView.currentOccupation;
        System.out.println("Database, occupation = " + occupation);

        //container to return
        ArrayList<Therapist> therapistsList = new ArrayList<>();



        try {

            String sql = "SELECT * FROM Therapists WHERE occupation = ? ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, occupation);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {

                Therapist therapist = new Therapist(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                                                    resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                                                    resultSet.getString(7), resultSet.getString(8), resultSet.getString(9));
                therapistsList.add(therapist);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



        return therapistsList;
    }


    /**
     *  Return TherapistResume based on therapistId
     */


    public TherapistResume getResumeByTherapistId(int therapistId) {

        //container to return
        ArrayList<Therapist> therapistsList = new ArrayList<>();
        TherapistResume resume = null;


        try {

            String sql = "SELECT * FROM TherapistsResume WHERE therapistId = ? ";
            PreparedStatement preparedStatement = null;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, therapistId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                resume = new TherapistResume(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resume;
    }





}
