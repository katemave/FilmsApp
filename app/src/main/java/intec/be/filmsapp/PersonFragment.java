package intec.be.filmsapp;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonFragment extends ListFragment {


    public PersonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] persons = getActivity().getResources().getStringArray(R.array.personen);
        int[] ages = getActivity().getResources().getIntArray(R.array.leeftijd);

        final List<HashMap<String, String>> list = new ArrayList<>();

        String[] from = {"age", "person"};
        int[] to = {R.id.txtv_geboortejaar, R.id.txtv_person};
        HashMap<String, String> map = null;

        for (int i = 0; i < ages.length; i++) {

            map = new HashMap<>();
            map.put("age", String.valueOf(ages[i]));
            map.put("person", persons[i]);
            list.add(map);
        }

        ListView lv = getListView();
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), list, R.layout.one_person, from, to);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                TextView mtv = (TextView) view.findViewById(R.id.txtv_person);
//                TextView mtvleeftijd = (TextView) view.findViewById(R.id.txtv_geboortejaar);
//
//                Toast.makeText(getActivity(), mtv.getText(), Toast.LENGTH_LONG).show();
//                Toast.makeText(getActivity(), mtvleeftijd.getText(), Toast.LENGTH_LONG).show();

                android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new Filmsfragment());
                transaction.commit();
            }
    });

    }
}
