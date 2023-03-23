package id.Federation.Internationale.de.Basketball.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benasher44.uuid.uuid4
import id.Federation.Internationale.de.Basketball.model.dataplayer
import id.Federation.Internationale.de.Basketball.persistences.dataplayerDao
import id.Federation.Internationale.de.Basketball.ui.theme.Purple700
import id.Federation.Internationale.de.Basketball.ui.theme.Teal200
import kotlinx.coroutines.launch


@Composable
fun Formdataplayer(dataplayerDao: dataplayerDao) {
    val scope = rememberCoroutineScope()
    val nopunggung = remember { mutableStateOf(TextFieldValue("")) }
    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val role = remember { mutableStateOf(TextFieldValue("")) }
    val nasionality = remember { mutableStateOf(TextFieldValue("")) }
    val gaji = remember { mutableStateOf(TextFieldValue("")) }
    val tinggibadan = remember { mutableStateOf(TextFieldValue("")) }


    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {
        OutlinedTextField(
            label = { Text(text = "No Punggung") },
            value = nopunggung.value,
            onValueChange = {
                nopunggung.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "023") }
        )
        OutlinedTextField(
            label = { Text(text = "Nama Pemain") },
            value = nama.value,
            onValueChange = {
                nama.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            placeholder = { Text(text = "Michael Jordan") }
        )
        OutlinedTextField(
            label = { Text(text = "Role Pemain") },
            value = role.value,
            onValueChange = {
                role.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Point Guard") }
        )
        OutlinedTextField(
            label = { Text(text = "Kebangsaan") },
            value = nasionality.value,
            onValueChange = {
                nasionality.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Cumberland") }
        )
        OutlinedTextField(
            label = { Text(text = "Gaji") },
            value = gaji.value,
            onValueChange = {
                gaji.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            placeholder = { Text(text = "145 Juta Dollar") }
        )
        OutlinedTextField(
            label = { Text(text = "Tinggi Badan") },
            value = tinggibadan.value,
            onValueChange = {
                tinggibadan.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "198 cm") }
        )

        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Purple700,
            contentColor = Teal200
        )
        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal200,
            contentColor = Purple700
        )
        Row (modifier = Modifier.padding(4.dp).fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {
                val id = uuid4().toString()
                val item = dataplayer(id, nopunggung.value.text, nama.value.text,
                    role.value.text, nasionality.value.text, gaji.value.text,
                    tinggibadan.value.text)
                scope.launch { dataplayerDao.insertAll(item) }
                nopunggung.value = TextFieldValue("")
                nama.value = TextFieldValue("")
                role.value = TextFieldValue("")
                nasionality.value = TextFieldValue("")
                gaji.value = TextFieldValue("")
                tinggibadan.value = TextFieldValue("")

            }, colors = loginButtonColors) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
            Button(modifier = Modifier.weight(5f), onClick = {
                nopunggung.value = TextFieldValue("")
                nama.value = TextFieldValue("")
                role.value = TextFieldValue("")
                nasionality.value = TextFieldValue("")
                gaji.value = TextFieldValue("")
                tinggibadan.value = TextFieldValue("")
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}