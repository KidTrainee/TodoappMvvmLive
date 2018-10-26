package vn.bfc.todoappmvvmlive.statistics;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import vn.bfc.todoappmvvmlive.data.source.TasksRepository;

public class StatisticsViewModel extends AndroidViewModel {
    public StatisticsViewModel(Application application, TasksRepository tasksRepository) {
        super(application);
    }
}
