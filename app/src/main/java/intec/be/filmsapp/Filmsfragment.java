package intec.be.filmsapp;


import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import intec.be.filmsapp.helper.CuryAdapter;
import intec.be.filmsapp.helper.FilmsAdapter;
import intec.be.filmsapp.model.Films;
import intec.be.filmsapp.persistence.FilmsDBHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class Filmsfragment extends android.support.v4.app.Fragment {
    private EditText mEtxtvdiatitel, mEtxtvdiareg, mEtxtvdiarelease, mEtxtvdiasynopsis;
    private String naam, regies, synops;
    private int releasie;
    private List<Films> list;
    private FilmsAdapter adapter;
    private ListView lv;
    private CuryAdapter curyAdapter;
    private FilmsDBHelper filmsDBHelper;


    public Filmsfragment() {
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        lv = (ListView) rootView.findViewById(R.id.listView);
//        list = FilmsAdapter.getFilms();

        filmsDBHelper = new FilmsDBHelper(getActivity());
        final Cursor cursor = filmsDBHelper.getAllFilms();

        curyAdapter = new CuryAdapter(getActivity(), cursor, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
//        FilmsAdapter adapter = new FilmsAdapter(getActivity(), list);
        lv.setAdapter(curyAdapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Films film = null;
                if(cursor.moveToPosition(position)){
                    film = new Films(cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4));
                }
//                Films film = (Films) parent.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("film", film);
                startActivity(intent);

            }
        });

        return rootView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_add) {
            addMovieWithDialog();
            Toast.makeText(getActivity(), "trolo", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    private void addMovieWithDialog() {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view = inflater.inflate(R.layout.dialog_add, null);
        mEtxtvdiareg = (EditText) view.findViewById(R.id.etxtv_addregie);
        mEtxtvdiatitel = (EditText) view.findViewById(R.id.etxtv_addtitle);
        mEtxtvdiarelease = (EditText) view.findViewById(R.id.etxtv_addrelease);
        mEtxtvdiasynopsis = (EditText) view.findViewById(R.id.etxtv_addsynops);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.setNegativeButton("Cancel", null);
        builder.setPositiveButton("Whoehoo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                naam = mEtxtvdiatitel.getText().toString();
                regies = mEtxtvdiareg.getText().toString();
                synops = mEtxtvdiasynopsis.getText().toString();
                releasie = Integer.parseInt(mEtxtvdiarelease.getText().toString());

                Films film = new Films(naam, regies, releasie, synops);

                filmsDBHelper.addFilms(film);
                curyAdapter.changeCursor(filmsDBHelper.getAllFilms());
                curyAdapter.notifyDataSetChanged();


//                list.add(film);
//                adapter = new FilmsAdapter(getActivity(), list);
//                lv.setAdapter(adapter);
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
