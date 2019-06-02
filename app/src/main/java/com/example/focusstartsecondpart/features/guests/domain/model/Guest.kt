package com.example.focusstartsecondpart.features.guests.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Guest(@field:PrimaryKey
            var id: Int, val firstName: String, val lastName: String, val phone: String, var visited: Boolean) {
    var eventId: Int = 0
}
