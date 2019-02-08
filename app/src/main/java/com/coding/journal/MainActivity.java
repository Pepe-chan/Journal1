package com.coding.journal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcJournals;
    JournalAdapter journalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcJournals = findViewById(R.id.rv_journals);
        rcJournals.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Journal> journals = Journal.getTestingDatas();
        journalAdapter = new JournalAdapter(journals);
        rcJournals.setAdapter(journalAdapter);
    }

    public void OnclickJournal(int position) {
        Intent intent = new Intent(this, JournalActivity.class);
        intent.putExtra(JournalActivity.JOURNAL_POSITION, position);
        startActivity(intent);
    }


    public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.JournalHolder> {

        private ArrayList<Journal> journals;

        public JournalAdapter(ArrayList<Journal> journals) {
            this.journals = journals;
        }

        @NonNull
        @Override
        public JournalHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.list_journal_item, viewGroup, false);
            return new JournalHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull JournalHolder journalHolder, final int i) {
            Journal journal = journals.get(i);
            journalHolder.txtSubject.setText(journal.getSubject());
            journalHolder.txtTeacher.setText(journal.getTeacher());
            journalHolder.txtCourseType.setText(journal.getCourseType());
            journalHolder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnclickJournal(i);
                }
            });
        }

        @Override
        public int getItemCount() {
            return journals.size();
        }

        public class JournalHolder extends RecyclerView.ViewHolder {

            public View view;
            public TextView txtSubject;
            public TextView txtTeacher;
            public TextView txtCourseType;

            public JournalHolder(@NonNull View itemView) {
                super(itemView);

                view = itemView;
                txtSubject = itemView.findViewById(R.id.txt_subject);
                txtTeacher = itemView.findViewById(R.id.txt_teacher);
                txtCourseType = itemView.findViewById(R.id.txt_course_type);
            }
        }
    }
}
