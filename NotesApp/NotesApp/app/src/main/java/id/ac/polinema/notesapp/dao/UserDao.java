package id.ac.polinema.notesapp.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import id.ac.polinema.notesapp.models.User;

@Dao
public interface UserDao {

    @Insert
    void insert(User... user);

    @Query("select * from users where username = :username limit 1")
    LiveData<User> getUserByUsername(String username);

}
