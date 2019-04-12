package id.ac.polinema.notesapp.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import id.ac.polinema.notesapp.dao.AppDatabase;
import id.ac.polinema.notesapp.dao.UserDao;
import id.ac.polinema.notesapp.models.User;

public class UserRepository {

    private UserDao dao;
    private  UserDao asyncTaskDao;

    public UserRepository(Application application){
        AppDatabase db = AppDatabase.getInstance(application);
        dao = db.userDao();
    }

    public LiveData<User> getUserByUsername(String username) {
        return dao.getUserByUsername(username);
    }
    public void insert(User user){
        new InsertAsyncTask(dao).execute(user);
    }


    private static class InsertAsyncTask extends AsyncTask<User, Void, Void>{

        private UserDao asyncTaskDao;
        private UserDao dao;

        public InsertAsyncTask(UserDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(User... users) {
            asyncTaskDao.insert(users);
            return null;
        }
        public void insert(User user){
        }
        
    }
}
