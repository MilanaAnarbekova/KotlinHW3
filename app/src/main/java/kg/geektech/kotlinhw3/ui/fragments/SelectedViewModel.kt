package kg.geektech.kotlinhw3.ui.fragments

import android.graphics.Picture
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kg.geektech.kotlinhw3.data.model.Pictures

class SelectedViewModel : ViewModel() {

    private val _listState = MutableLiveData<ArrayList<Pictures>>()
    var listState: LiveData<ArrayList<Pictures>> = _listState

    fun putPicture(list: ArrayList<Pictures>) {
        _listState.postValue(list)
    }

}