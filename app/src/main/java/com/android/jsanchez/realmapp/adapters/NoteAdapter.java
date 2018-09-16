package com.android.jsanchez.realmapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.jsanchez.realmapp.R;
import com.android.jsanchez.realmapp.models.Note;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class NoteAdapter extends BaseAdapter {

    private Context context;
    private List<Note> list;
    private int layout;

    public NoteAdapter(Context context, List<Note> list, int layout) {
        this.context = context;
        this.list = list;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Note getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder vh;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, null);
            vh = new ViewHolder();
            vh.noteDescription = convertView.findViewById(R.id.textViewNoteDescription);
            vh.noteCreatedAt = convertView.findViewById(R.id.textViewNoteCreatedAt);
            convertView.setTag(vh);

        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Note note = list.get(position);

        vh.noteDescription.setText(note.getDescription());

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String createAt = df.format(note.getCreateAt());
        vh.noteCreatedAt.setText(createAt);

        return convertView;
    }

    public class ViewHolder {
        TextView noteDescription;
        TextView noteCreatedAt;
    }
}
