package com.e.database.Data.Source;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.e.database.Data.Models.User;
import com.e.database.Data.Source.Repositories.UserRepozitory;

public class UserViewModel extends AndroidViewModel {
    private UserRepozitory repozitory;
    private LiveData<User> user;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repozitory = new UserRepozitory(application);
        user = repozitory.getUser();
    }

    public void insert(User user)
    {
        repozitory.insert(user);
    }

    public void update(User user)
    {
        repozitory.update(user);
    }

    public void delete(User user)
    {
        repozitory.delete(user);
    }

    public LiveData<User> getUser()
    {
        return user;
    }


}
