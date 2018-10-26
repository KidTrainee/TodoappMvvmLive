package vn.bfc.todoappmvvmlive.taskdetail;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import vn.bfc.todoappmvvmlive.data.source.TasksRepository;

public class TaskDetailViewModel extends AndroidViewModel {
    public TaskDetailViewModel(Application application, TasksRepository tasksRepository) {
        super(application);
    }
}
