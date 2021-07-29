package com.danisable.apploginsharedpersistence.presentation.fragment.notes

import com.danisable.apploginsharedpersistence.data.local.entity.NoteEntity
import com.danisable.apploginsharedpersistence.domain.model.Note

interface NotesInteractor {
    interface Presenter{

        fun createNote()
        fun getNotes()
    }

    interface View {
        fun onSuccess()
        fun setNotes(notes: List<Note>)

    }
}