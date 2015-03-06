package intec.be.filmsapp.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import intec.be.filmsapp.model.Films;

/**
 * Created by KateM on 23/02/2015.
 */
public class FilmsDBHelper {

    private static final String TABLE_NAME = "Films";

    private static final String FILMS_COLUMN_ID = "_id";
    private static final String FILMS_COLUMN_REG = "Regisseur";
    private static final String FILMS_COLUMN_TITLE = "title";
    private static final String FILMS_COLUMN_SYNOPSYS = "Synopsis";
    private static final String FILMS_COLUMN_RELEASE = "Release";

    private FilmsOpenHelper openHelper;
    private SQLiteDatabase db;

    public FilmsDBHelper(Context context) {
        openHelper = new FilmsOpenHelper(context);
        db = openHelper.getWritableDatabase();
    }

    public void addFilms(Films film) {
        ContentValues values = new ContentValues();
        values.put(FILMS_COLUMN_REG, film.getRegisseur());
        values.put(FILMS_COLUMN_TITLE, film.getTitle());
        values.put(FILMS_COLUMN_RELEASE, film.getReleasedate());
        values.put(FILMS_COLUMN_SYNOPSYS, film.getSynopsis());
        db.insert(TABLE_NAME, null, values);
    }

    public void deleteFilms(int id) {
        db.delete(TABLE_NAME, FILMS_COLUMN_ID + " = " + id, null);
    }

    public Cursor getAllFilms() {
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }
}
