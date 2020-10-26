package com.e.database.Data.Source.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;


import com.e.database.Data.Models.TextMessages;
import com.e.database.Data.Source.InternalDatabase;
import com.e.database.Data.Source.Dao.TextMessagesDao;

import java.util.List;


public class TextMessagesRepository {

    private TextMessagesDao textMessagesDao;
    private LiveData<List<TextMessages>> textMessages;

    public TextMessagesRepository (Application application)
    {
        InternalDatabase database = InternalDatabase.getInstance(application);
        textMessagesDao = database.textMessagesDao();
        textMessages = textMessagesDao.getTextMessages();
    }

    public void insert(TextMessages textMessage){

        new TextMessagesRepository.InsertTextMessagesAsyncTask(textMessagesDao).execute(textMessage);

    }

    public void update (TextMessages textMessage){

        new TextMessagesRepository.UpdateTextMessagesAsyncTask(textMessagesDao).execute(textMessage);

    }

    public void delete( TextMessages textMessage){

        new TextMessagesRepository.DeleteTextMessagesAsyncTask(textMessagesDao).execute(textMessage);
    }

    public LiveData<List<TextMessages>> getTextMessages(){
        return textMessages;
    }

    private static class InsertTextMessagesAsyncTask extends AsyncTask<TextMessages,Void, Void> {

        private TextMessagesDao textMessagesDao;

        private InsertTextMessagesAsyncTask(TextMessagesDao textMessagesDao)
        {
            this.textMessagesDao = textMessagesDao ;
        }

        @Override
        protected Void doInBackground(TextMessages... textMessages) {
            textMessagesDao.insert(textMessages[0]);
            return null;
        }
    }

    private static class DeleteTextMessagesAsyncTask extends AsyncTask<TextMessages,Void, Void> {

        private TextMessagesDao textMessagesDao;

        private DeleteTextMessagesAsyncTask(TextMessagesDao textMessagesDao)
        {
            this.textMessagesDao = textMessagesDao ;
        }

        @Override
        protected Void doInBackground(TextMessages... textMessage) {
            textMessagesDao.delete(textMessage[0]);
            return null;
        }
    }

    private static class UpdateTextMessagesAsyncTask extends AsyncTask<TextMessages,Void, Void> {

        private TextMessagesDao textMessagesDao;

        private UpdateTextMessagesAsyncTask(TextMessagesDao textMessagesDao)
        {
            this.textMessagesDao = textMessagesDao;
        }

        @Override
        protected Void doInBackground(TextMessages... textMessage) {
            textMessagesDao.update(textMessage[0]);
            return null;
        }
    }
}
