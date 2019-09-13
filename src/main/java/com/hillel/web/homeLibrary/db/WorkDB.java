package com.hillel.web.homeLibrary.db;

import com.hillel.web.homeLibrary.film.Film;
import com.hillel.web.homeLibrary.staff.Actor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkDB {

    Connection connect = null;
    PreparedStatement statement = null;
    ResultSet rs = null;

    public List<Film> findFilmsForYear(int y1,int y2) {

        List<Film> films = new ArrayList<Film>();
        String query = "SELECT id, title, director, actor, date_release, country FROM hillel.films \n" +
                "WHERE date_release >= " + "'" + y1 + "'" + " AND date_release <=" + "'" + y2 + "'";


        try {
            connect = ConnectionDB.getConnection();
            statement = connect.prepareStatement(query);
            rs = statement.executeQuery();

            while (rs.next()) {
                films.add(addFilmToList(rs));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        clouse(connect,statement,rs);

        for (Film i : films) {
            System.out.println(i);
        }

        return films;
    }


    private Film addFilmToList(ResultSet rs) {

        if (rs == null) {
            throw new UnsupportedOperationException("Необходим ResultSet");
        }

        int id = 0;
        String title = "";
        String director = "";
        String actor = "";
        int dateRelease = 0;
        String country = "";

        try {
            id = rs.getInt(1);
            title = rs.getString(2);
            director = rs.getString(3);
            actor = rs.getString(4);
            dateRelease = rs.getInt(5);
            country = rs.getString(6);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Film(id,title,director,actor,dateRelease,country);
    }

    public List<Actor> findActorForFilm(String titleFilm) {

        List<Actor> actors = new ArrayList<Actor>();

        String query = "SELECT id, name_actor, date FROM hillel.actors WHERE name_actor IN" +
                "(SELECT actor FROM hillel.films WHERE title =" + "'" + titleFilm + "')";

        workInDB(actors, query);

        return actors;
    }

    public List<Actor> findAcror(int numberOfFilms) {

        List<Actor> actors = new ArrayList<Actor>();

        String query = "SELECT hillel.actors.id, hillel.actors.name_actor, hillel.actors.date " +
                "FROM hillel.actors WHERE hillel.actors.id = EXISTS " +
                "(SELECT hillel.films.actor, COUNT(*) c FROM hillel.films " +
                "GROUP BY hillel.films.actor HAVING  c =" + "'" + numberOfFilms + "')";

        workInDB(actors, query);

        return actors;

    }

    public List<Actor> findActorAsDirector() {

        List<Actor> actors = new ArrayList<Actor>();

        String query = "SELECT hillel.directors.id, hillel.directors.name_director, hillel.directors.date " +
                "FROM hillel.directors " +
                "JOIN hillel.films " +
                "ON hillel.directors.name_director=hillel.films.actor";

        workInDB(actors, query);

        return actors;
    }

    public void deleteFilm(int year) {

        String query = "DELETE FROM hillel.films WHERE date_release <" + year;

        try {
            connect = ConnectionDB.getConnection();
            statement = connect.prepareStatement(query);
            statement.executeUpdate();

        } catch (SQLException error) {
            error.printStackTrace();
        }
        clouse(connect,statement,rs);
    }
    private void workInDB(List<Actor> list, String query){
        try {
            connect = ConnectionDB.getConnection();
            statement = connect.prepareStatement(query);
            rs = statement.executeQuery();

            while (rs.next()) {
                list.add(new Actor(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        clouse(connect,statement,rs);

    }

    private void clouse(Connection connect,PreparedStatement statement,ResultSet rs) {

        closeConnection(connect);
        closePrStatement(statement);
        closeResultSet(rs);
    }

    private void closeConnection(Connection connect) {

        if (connect == null) {
            return;
        }

        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closePrStatement(PreparedStatement preparedStatement) {

        if (preparedStatement == null) {
            return;
        }

        try {
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeResultSet(ResultSet rs) {

        if (rs == null) {
            return;
        }

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
