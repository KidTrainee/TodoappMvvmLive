package vn.bfc.todoappmvvmlive.utils;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import vn.bfc.todoappmvvmlive.Injection;
import vn.bfc.todoappmvvmlive.addedittask.AddEditTaskViewModel;
import vn.bfc.todoappmvvmlive.data.source.TasksRepository;
import vn.bfc.todoappmvvmlive.statistics.StatisticsViewModel;
import vn.bfc.todoappmvvmlive.taskdetail.TaskDetailViewModel;
import vn.bfc.todoappmvvmlive.tasks.TasksViewModel;

/**
 * A creator is used to inject the product ID into the ViewModel
 * <p>
 * This creator is to showcase how to inject dependencies into ViewModels. It's not
 * actually necessary in this case, as the product ID can be passed in a public method.
 */
public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile ViewModelFactory INSTANCE;

    private final Application mApplication;

    private final TasksRepository mTasksRepository;

    public static ViewModelFactory getInstance(Application application) {

        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(application,
                            Injection.provideTasksRepository(application.getApplicationContext()));
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }

    private ViewModelFactory(Application application, TasksRepository repository) {
        mApplication = application;
        mTasksRepository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(StatisticsViewModel.class)) {
            //noinspection unchecked
            return (T) new StatisticsViewModel(mApplication, mTasksRepository);
        } else if (modelClass.isAssignableFrom(TaskDetailViewModel.class)) {
            //noinspection unchecked
            return (T) new TaskDetailViewModel(mApplication, mTasksRepository);
        } else if (modelClass.isAssignableFrom(AddEditTaskViewModel.class)) {
            //noinspection unchecked
            return (T) new AddEditTaskViewModel(mApplication, mTasksRepository);
        } else if (modelClass.isAssignableFrom(TasksViewModel.class)) {
            //noinspection unchecked
            return (T) new TasksViewModel(mApplication, mTasksRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
