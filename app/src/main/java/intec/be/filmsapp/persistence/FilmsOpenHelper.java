package intec.be.filmsapp.persistence;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by KateM on 23/02/2015.
 */
public class FilmsOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "films.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Films";

    private static final String FILMS_COLUMN_ID = "_id";
    private static final String FILMS_COLUMN_REG = "Regisseur";
    private static final String FILMS_COLUMN_TITLE = "title";
    private static final String FILMS_COLUMN_SYNOPSYS = "Synopsis";
    private static final String FILMS_COLUMN_RELEASE = "Release";

    // Set the name and version of the database
    public FilmsOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL("Create Table " + TABLE_NAME + "(" +
                    FILMS_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    FILMS_COLUMN_REG + " TEXT, " +
                    FILMS_COLUMN_TITLE + " TEXT, " +
                    FILMS_COLUMN_SYNOPSYS + " TEXT, " + FILMS_COLUMN_RELEASE + " TEXT);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Upgrade database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
