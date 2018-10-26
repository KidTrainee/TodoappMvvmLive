package vn.bfc.todoappmvvmlive.tasks;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;

import vn.bfc.todoappmvvmlive.R;
import vn.bfc.todoappmvvmlive.addedittask.AddEditTaskActivity;
import vn.bfc.todoappmvvmlive.data.source.TasksRepository;
import vn.bfc.todoappmvvmlive.taskdetail.TaskDetailActivity;

/**
 * Exposes the data to be used in the task list screen.
 * <p>
 * {@link BaseObservable} implements a listener registration mechanism which is notified when a
 * property changes. This is done by assigning a {@link Bindable} annotation to the property's
 * getter method.
 */
public class TasksViewModel extends AndroidViewModel {

    private final SingleLiveEvent<Void> mNewTaskEvent = new SingleLiveEvent<>();

    private final TasksRepository mTasksRepository;

    private final SnackbarMessage mSnackbarText = new SnackbarMessage();

    private final Context mContext; // To avoid leaks, this must be an Application Context.

    public TasksViewModel(Application context, TasksRepository repository) {
        super(context);
        mContext = context.getApplicationContext(); // Force use of Application Context.
        mTasksRepository = repository;

        // Set initial state
        setFiltering(TasksFilterType.ALL_TASKS);
    }

    /**
     * Called by the Data Binding library and the FAB's click listener.
     */
    public void addNewTask() {
        mNewTaskEvent.call();
    }

    void handleActivityResult(int requestCode, int resultCode) {
        if (AddEditTaskActivity.REQUEST_CODE == requestCode) {
            switch (resultCode) {
                case TaskDetailActivity.EDIT_RESULT_OK:
                    mSnackbarText.setValue(R.string.successfully_saved_task_message);
                    break;
                case AddEditTaskActivity.ADD_EDIT_RESULT_OK:
                    mSnackbarText.setValue(R.string.successfully_added_task_message);
                    break;
                case TaskDetailActivity.DELETE_RESULT_OK:
                    mSnackbarText.setValue(R.string.successfully_deleted_task_message);
                    break;
            }
        }
    }
}
