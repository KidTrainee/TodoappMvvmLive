package vn.bfc.todoappmvvmlive.addedittask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vn.bfc.todoappmvvmlive.R;

public class AddEditTaskActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 100;
    public static final int ADD_EDIT_RESULT_OK = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_task);
    }
}
