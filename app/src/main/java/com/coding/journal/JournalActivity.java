package com.coding.journal;

import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class JournalActivity extends AppCompatActivity {

    public static final String JOURNAL_POSITION = "JOURNAL_POSITION";

    RecyclerView rvMarks;
    MarkAdapter markAdapter;

    ShowMarksTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        int position = getIntent().getIntExtra(JOURNAL_POSITION, 0);
        Toast.makeText(this, "" + position, Toast.LENGTH_SHORT).show();

        int columnCount = 5;
        rvMarks = findViewById(R.id.rv_marks);
        rvMarks.setLayoutManager(new GridLayoutManager(this, columnCount));
        ArrayList<Mark> marks = Mark.getTestingDatas();
        markAdapter = new MarkAdapter(new ArrayList<Mark>());
        rvMarks.setAdapter(markAdapter);

        if(task == null) {
            task = new ShowMarksTask(marks);
            task.execute();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (task != null) {
            if (task.isCancelled() == false){
                task.cancel(true);
            }
        }
    }

    public class MarkAdapter extends RecyclerView.Adapter<MarkAdapter.MarkHolder> {

        private ArrayList<Mark> marks;

        public MarkAdapter(ArrayList<Mark> marks) {
            this.marks = marks;
        }

        @NonNull
        @Override
        public MarkHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.list_mark_item, viewGroup, false);
            return new MarkHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MarkHolder markHolder, int i) {
            Mark mark = marks.get(i);
            markHolder.txtDate.setText(mark.getDate());
            markHolder.txtMark.setText(mark.getValue());
        }

        @Override
        public int getItemCount() {
            return marks.size();
        }

        public void add(Mark mark) { marks.add(mark);}

        public class MarkHolder extends RecyclerView.ViewHolder {

            public MarkHolder(@NonNull View itemView) {
                super(itemView);

                view = itemView;
                txtDate = itemView.findViewById(R.id.txt_date);
                txtMark = itemView.findViewById(R.id.txt_mark);
            }

            public View view;
            public TextView txtDate;
            public TextView txtMark;
        }
    }
    public class ShowMarksTask extends AsyncTask<Void, Mark, Void> {

        ArrayList<Mark> marks;

        public ShowMarksTask(ArrayList<Mark> marks) {
            this.marks = marks;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (Mark mark: marks) {
                publishProgress(mark);
                try {
                    Thread.sleep(1000 * 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Mark... values) {
            super.onProgressUpdate(values);

            markAdapter.add(values[0]);
            markAdapter.notifyDataSetChanged();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            task = null;
        }
    }
}
