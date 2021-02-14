package uz.technickpro.addtofavourite;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FavAdapter extends BaseAdapter {

    Context context;
    List<FavPojo> strings;

    public FavAdapter(Context context, List<FavPojo> strings) {
        this.context = context;
        this.strings = strings;
    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public Object getItem(int position) {
        return strings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.item_fav, parent, false);

        TextView textView = convertView.findViewById(R.id.item_text);
        ImageView imgAdd = convertView.findViewById(R.id.item_add_to_fav_img);
        ImageView imgAdded = convertView.findViewById(R.id.item_added_fav_img);

        textView.setText(strings.get(position).getName());
        imgAdd.setImageResource(R.drawable.ic_baseline_favorite_border_24);
        imgAdded.setImageResource(R.drawable.ic_baseline_favorite_24);

        if (strings.get(position).isFav().equals("false")){
            imgAdd.setVisibility(View.VISIBLE);
            imgAdded.setVisibility(View.INVISIBLE);
        }
        else if (strings.get(position).isFav().equals("true")){
            imgAdded.setVisibility(View.VISIBLE);
            imgAdd.setVisibility(View.INVISIBLE);
        }

        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imgAdd.setVisibility(View.INVISIBLE);
                imgAdded.setVisibility(View.VISIBLE);



                Toast.makeText(context, "Added to favourites", Toast.LENGTH_SHORT).show();

            }
        });

        imgAdded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgAdded.setVisibility(View.INVISIBLE);
                imgAdd.setVisibility(View.VISIBLE);

                Toast.makeText(context, "Deleted from favourites", Toast.LENGTH_SHORT).show();
            }
        });


        return convertView;
    }
}
