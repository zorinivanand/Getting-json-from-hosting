package ru.zorinivan.gettingjsonfromhosting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ru.zorinivan.gettingjsonfromhosting.R;

public class ListViewAdapter  extends ArrayAdapter<JSONObject> {
    int listLayout;
    ArrayList<JSONObject> usersList;
    Context context;

    public ListViewAdapter(Context context, int listLayout , int field, ArrayList<JSONObject> usersList) {
        super(context, listLayout, field, usersList);
        this.context = context;
        this.listLayout=listLayout;
        this.usersList = usersList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listViewItem = inflater.inflate(listLayout, null, false);
        TextView name = listViewItem.findViewById(R.id.textViewName);
        TextView author = listViewItem.findViewById(R.id.textViewAuthor);
        TextView title = listViewItem.findViewById(R.id.textViewTitle);


        try{
            name.setText(usersList.get(position).getString("name"));
            author.setText(usersList.get(position).getString("author"));
            title.setText(usersList.get(position).getString("title"));

        }catch (JSONException je){
            je.printStackTrace();
        }
        return listViewItem;
    }


}
