package intec.be.filmsapp.helper;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import intec.be.filmsapp.R;

/**
 * Created by KateM on 23/02/2015.
 */
public class CuryAdapter extends CursorAdapter {

    public CuryAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, null);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView reg, title, synopsys, release;

        reg = (TextView) view.findViewById(R.id.txtv_reg);
        title = (TextView) view.findViewById(R.id.txtv_title);
        synopsys = (TextView) view.findViewById(R.id.txtv_synopsis);
        release = (TextView) view.findViewById(R.id.txtv_release);

        reg.setText(cursor.getString(1));
        title.setText(cursor.getString(2));
        synopsys.setText(cursor.getString(4));
        release.setText(cursor.getInt(3) + " ");

    }
}
