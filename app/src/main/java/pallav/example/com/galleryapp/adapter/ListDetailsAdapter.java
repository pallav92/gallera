package pallav.example.com.galleryapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import pallav.example.com.galleryapp.response.MovieResponse;

/**
 * Created by pallav on 6/1/17.
 */

public class ListDetailsAdapter extends BaseAdapter {

    ArrayList<MovieResponse> movie_list =new ArrayList<>() ;
    Context context;

    public ListDetailsAdapter(Context context, ArrayList<MovieResponse> movie_list){
        this.movie_list = movie_list;
        this.context = context;
    }


    @Override
    public int getCount() {
        return movie_list.size();
    }

    @Override
    public Object getItem(int position) {
        return movie_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        if (convertView == null) {
          /*  holder = new ViewHolder();
            switch(type) {
                case LIST_ITEM_TYPE_1:
                    convertView = mInflater.inflate(R.layout.list_item_type1, null);
                    holder.textView = (TextView)convertView.findViewById(R.id.list_item_type1_text_view);
                    break;
                case LIST_ITEM_TYPE_2:
                    convertView = mInflater.inflate(R.layout.list_item_type2, null);
                    holder.textView = (TextView)convertView.findViewById(R.id.list_item_type2_button);
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.textView.setText(mData.get(position));*/

        }
        return convertView;
    }

   /* public class Holder{
        @BindView(R.id.)
    }*/
}
