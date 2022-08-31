package com.laioffer.tinnews.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.laioffer.tinnews.model.NewsResponse;
import com.laioffer.tinnews.repository.NewsRepository;


public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> countryInput=new MutableLiveData<>();
    private final NewsRepository repository;

    public HomeViewModel(NewsRepository newsRepository){
        this.repository= newsRepository;
    }

    public LiveData<NewsResponse> getTopHeadlines(){
        return Transformations.switchMap(countryInput, repository::getTopHeadlines);
    }

    public void setCountryInput(String country) {
        countryInput.setValue(country);
    }

}
