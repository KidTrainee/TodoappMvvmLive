package vn.bfc.todoappmvvmlive.taskdetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vn.bfc.todoappmvvmlive.R;

public class TaskDetailActivity extends AppCompatActivity {

    public static final String EXTRA_TASK_ID = "TASK_ID";
    public static final int EDIT_RESULT_OK = 1000;
    public static final int DELETE_RESULT_OK = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
    }
}
