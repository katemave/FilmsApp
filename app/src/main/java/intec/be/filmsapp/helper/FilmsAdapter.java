package intec.be.filmsapp.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import intec.be.filmsapp.R;
import intec.be.filmsapp.model.Films;

/**
 * Created by KateM on 16/02/2015.
 */
public class FilmsAdapter extends BaseAdapter{
    private List<Films> list;
    private Context context;


    public FilmsAdapter(Context context, List<Films> list){
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Films getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = null;


        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_item, null);
            holder= new ViewHolder();
            holder.regie = (TextView) convertView.findViewById(R.id.txtv_reg);
            holder.naam = (TextView) convertView.findViewById(R.id.txtv_title);
            holder.jaar = (TextView) convertView.findViewById(R.id.txtv_release);

//            store the holder within the view
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

//        TextView reg= (TextView) convertView.findViewById(R.id.txtv_reg);
//        TextView title = (TextView) convertView.findViewById(R.id.txtv_title);
//        TextView release = (TextView) convertView.findViewById(R.id.txtv_release);

//        TextView synopsis = (TextView) convertView.findViewById(R.id.txtv_synopsis);

        holder.regie.setText(getItem(position).getRegisseur());
        holder.naam.setText(getItem(position).getTitle());
        holder.jaar.setText(String.valueOf(getItem(position).getReleasedate()));

        return convertView;

    }

    private class ViewHolder{
        public TextView regie, naam, jaar;
    }

//    Helper methode
    public static List<Films> getFilms(){
        List<Films> list = new ArrayList<>();
        list.add(new Films("Bob", "Bobby", 1999, "den Bob"));
        list.add(new Films("The lovely Bones", "Peter Jackson", 1989, "Een surrealistisch psychologisch drama"));
        list.add(new Films("Interstellar", "wtf", 2014, "Een stomme film"));
        list.add(new Films("The simpsons", "Mat Groening", 2013, "De film versie van de bekende animatie serie"));
        list.add(new Films("From Dusk Till Dawn", "Quinten Tarantino", 1997, "Een legendarische vampierenfilm"));
        list.add(new Films("The godfather", "Francis Ford Coppola", 1972, "De trilogie van een Italiaanse familie"));
        return list;
    }
}
