package com.example.composenoteapp.ui.previwnote

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composenoteapp.model.Note
import com.example.composenoteapp.model.NotesDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PreviewNoteViewModel @Inject constructor(
    val  db:NotesDatabase
): ViewModel() {

    var note by mutableStateOf<Note>(Note(title = "", content = ""))
        private set


    fun getSingleNote(note: Note){
        db.dao.getSingleNote(note.id).onEach { notes->
            this.note = notes
        }.launchIn(viewModelScope)
    }
    fun insert(note:Note){
        viewModelScope.launch {
            db.dao.insertNote(note)
        }

    }



}
