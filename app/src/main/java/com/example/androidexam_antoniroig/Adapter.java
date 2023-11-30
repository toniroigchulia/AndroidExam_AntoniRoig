package com.example.androidexam_antoniroig;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adapter extends ArrayAdapter<Object> {
    private Activity context;
    private Exercice[] exercices;
    public Adapter (Activity context, Exercice[] exercices){
        super(context, R.layout.exercice, exercices);
        this.exercices = exercices;
        this.context = context;
    }

    static class ViewHolder {
        TextView exerciceText;
        ImageView exerciceImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView;
        ViewHolder holder = new ViewHolder();
        if(item == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            item = inflater.inflate(R.layout.exercice, null);
            holder.exerciceText = item.findViewById(R.id.exercice);
            holder.exerciceImage = item.findViewById(R.id.image);
            item.setTag(holder);
        }else{
            holder = (ViewHolder) item.getTag();
        }
        holder.exerciceText.setText(exercices[position].getName());
        holder.exerciceImage.setImageResource(exercices[position].getImageResource());

        return (item);
    }
}
