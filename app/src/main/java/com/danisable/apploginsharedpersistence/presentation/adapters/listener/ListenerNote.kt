package com.danisable.apploginsharedpersistence.presentation.adapters.listener

import com.danisable.apploginsharedpersistence.domain.model.Note

interface ListenerNote {
    fun onClickNote(note: Note)
}