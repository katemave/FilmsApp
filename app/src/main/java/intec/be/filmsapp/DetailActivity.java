package intec.be.filmsapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import intec.be.filmsapp.model.Films;


public class DetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private TextView mTxtv_titledet, mTxtv_regdet, mTxtv_synopsis, mTxtv_releasedet;
        private Films film;
        private String title, synopsis, reg;
        private int release, mImgRes;
        private ImageView mImgIcon;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_detail, container, false);

            mTxtv_titledet = (TextView) rootView.findViewById(R.id.txtv_titledet);
            mTxtv_regdet = (TextView) rootView.findViewById(R.id.txtv_regdet);
            mTxtv_releasedet = (TextView) rootView.findViewById(R.id.txtv_releasedet);
            mTxtv_synopsis = (TextView) rootView.findViewById(R.id.txtv_synopsis);
            mImgIcon = (ImageView)rootView.findViewById(R.id.txtv_afbeelding);

            Bundle bundle = getActivity().getIntent().getExtras();
            if (bundle != null) {
                film = (Films)  bundle.get("film");
                reg = film.getRegisseur();
                title = film.getTitle();
                synopsis = film.getSynopsis();
                release = film.getReleasedate();
                mImgRes = film.getImageRes();
            }

//            Log.v("film", film.toString());

            mTxtv_titledet.setText(title);
            mTxtv_regdet.setText(reg);
            mTxtv_synopsis.setText(synopsis);
            mTxtv_releasedet.setText(release + " ");
            mImgIcon.setImageResource(mImgRes);



            return rootView;
        }
    }
}
