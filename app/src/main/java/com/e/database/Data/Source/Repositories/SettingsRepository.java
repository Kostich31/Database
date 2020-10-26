package com.e.database.Data.Source.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.e.database.Data.Models.Settings;
import com.e.database.Data.Source.InternalDatabase;
import com.e.database.Data.Source.Dao.SettingsDao;


import java.util.List;


public class SettingsRepository {

    private SettingsDao settingsDao;
    private LiveData<List<Settings>> settings;

    public SettingsRepository (Application application)
    {
        InternalDatabase database = InternalDatabase.getInstance(application);
        settingsDao = database.settingsDao();
        settings = settingsDao.getSettings();
    }

    public void insert(Settings setting){

        new SettingsRepository.InsertSettingsAsyncTask(settingsDao).execute(setting);

    }

    public void update (Settings setting){

        new SettingsRepository.UpdateSettingsAsyncTask(settingsDao).execute(setting);

    }

    public void delete( Settings setting){

        new SettingsRepository.DeleteSettingsAsyncTask(settingsDao).execute(setting);
    }

    public LiveData<List<Settings>> getSettings(){
        return settings;
    }

    private static class InsertSettingsAsyncTask extends AsyncTask<Settings,Void, Void> {

        private SettingsDao settingsDao;

        private InsertSettingsAsyncTask(SettingsDao settingsDao)
        {
            this.settingsDao = settingsDao ;
        }

        @Override
        protected Void doInBackground(Settings... settings) {
            settingsDao.insert(settings[0]);
            return null;
        }
    }

    private static class DeleteSettingsAsyncTask extends AsyncTask<Settings,Void, Void> {

        private SettingsDao settingsDao;

        private DeleteSettingsAsyncTask(SettingsDao settingsDao)
        {
            this.settingsDao = settingsDao ;
        }

        @Override
        protected Void doInBackground(Settings... settings) {
            settingsDao.delete(settings[0]);
            return null;
        }
    }

    private static class UpdateSettingsAsyncTask extends AsyncTask<Settings,Void, Void> {

        private SettingsDao settingsDao;

        private UpdateSettingsAsyncTask(SettingsDao settingsDao)
        {
            this.settingsDao = settingsDao ;
        }

        @Override
        protected Void doInBackground(Settings... settings) {
            settingsDao.update(settings[0]);
            return null;
        }
    }
}
