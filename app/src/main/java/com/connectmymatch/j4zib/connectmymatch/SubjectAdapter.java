package com.connectmymatch.j4zib.connectmymatch;

import android.media.Image;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class SubjectAdapter extends ListAdapter<Subject,SubjectAdapter.ViewHolder>{

    public SubjectAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Subject> DIFF_CALLBACK = new DiffUtil.ItemCallback<Subject>() {
        @Override
        public boolean areItemsTheSame(@NonNull Subject oldItem, @NonNull Subject newItem) {
            return oldItem.getId()==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Subject oldItem, @NonNull Subject newItem) {
            return oldItem.getName().equals(newItem.getName())
                    &&oldItem.getProgress()==newItem.getProgress();
        }
    };

    @NonNull
    @Override
    public SubjectAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.subject_row,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectAdapter.ViewHolder viewHolder, int i) {
        Subject entry = getItem(i);
        viewHolder.name.setText(entry.getName());
        viewHolder.progress.setText(String.format("%.2f", entry.getProgress())+"%");
        viewHolder.subjectProgress.setProgress((int)entry.getProgress());
        viewHolder.subjectImage.setImageResource(entry.getImage());
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name,progress;
        public ImageView subjectImage;
        public ProgressBar subjectProgress;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.subject_text);
            progress = itemView.findViewById(R.id.subject_percent);
            subjectImage = itemView.findViewById(R.id.subject_image);
            subjectProgress = itemView.findViewById(R.id.subject_progressBar);
        }
    }

}

