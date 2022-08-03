package me.dio.WomensFootball.ui.favorites;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import me.dio.WomensFootball.data.SoccerNewsRepository;
import me.dio.WomensFootball.domain.News;

public class FavoritesViewModel extends ViewModel {

    public FavoritesViewModel() {

    }

    public LiveData<List<News>> loadFavoriteNews() {
        return SoccerNewsRepository.getInstance().getLocalDb().newsDao().loadFavoriteNews();
    }

    public void saveNews(News news) {
        AsyncTask.execute(() -> SoccerNewsRepository.getInstance().getLocalDb().newsDao().save(news));
    }

}