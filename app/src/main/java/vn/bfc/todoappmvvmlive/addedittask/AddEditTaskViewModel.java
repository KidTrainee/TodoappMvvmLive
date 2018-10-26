package vn.bfc.todoappmvvmlive.addedittask;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import vn.bfc.todoappmvvmlive.data.source.TasksRepository;

public class AddEditTaskViewModel extends AndroidViewModel {
    public AddEditTaskViewModel(Application application, TasksRepository tasksRepository) {
        super(application);
    }
}
