package com.example.focusstartsecondpart.features.events.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Event(@field:PrimaryKey
            var id: Int, var title: String?, var description: String?, var status: Int)
