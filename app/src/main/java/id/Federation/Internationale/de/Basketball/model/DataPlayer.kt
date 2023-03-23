package id.Federation.Internationale.de.Basketball.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class dataplayer(
    @PrimaryKey val id: String,
    val nopunggung: String,
    val nama: String,
    val role: String,
    val nasionality: String,
    val gaji: String,
    val tinggibadan: String
)
