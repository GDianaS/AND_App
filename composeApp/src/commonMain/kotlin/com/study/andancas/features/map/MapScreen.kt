package com.study.andancas.features.map

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.study.andancas.components.MapComponent
import com.study.andancas.ui.BottomBar
import com.study.andancas.ui.Header
//import com.google.maps.android.compose.GoogleMap

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
    navController: NavHostController
){

    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),

        topBar = {/*TODO*/},

        bottomBar = { BottomBar( navController = navController) }
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Box(){
                //Google Maps
                MapComponent(
                )

                SearchBar(
                    onSearch = {/*TODO*/}
                )


            }


        }

    }

}

@Composable
fun SearchBar(
    onSearch: (String) -> Unit
){
    // `mutableStateOf` cria um objeto de estado observável.
    var searchText by remember { mutableStateOf("") }
    // `LocalSoftwareKeyboardController` permite controlar o teclado virtual.
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = searchText, // O texto atual do campo.
        onValueChange = { newValue ->
            // Atualiza o estado `searchText` sempre que o usuário digita.
            searchText = newValue
        },

        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),

        placeholder = { Text("Pesquisar por...") },
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "Ícone de pesquisa")
        },
        trailingIcon = {
            if(searchText.isNotEmpty()){
                Icon(
                    Icons.Default.Clear,
                    contentDescription = "Limpar Pesquisa",
                    modifier = Modifier.padding(8.dp) // Adiciona um padding para o ícone
                        .clickable { // Torna o ícone clicável
                            searchText = "" // Limpa o texto
                        }
                )
            }
        },

        shape = RoundedCornerShape(24.dp), // Define a forma com cantos arredondados de 24dp
        colors = OutlinedTextFieldDefaults.colors( // Personaliza as cores do OutlinedTextField
            focusedContainerColor = Color.White, // Fundo branco quando focado
            unfocusedContainerColor = Color.White, // Fundo branco quando não focado
            focusedBorderColor = Color.LightGray, // Cor da borda quando focado
            unfocusedBorderColor = Color.LightGray, // Cor da borda quando não focado
            cursorColor = Color.Black, // Cor do cursor
            focusedTextColor = Color.Black, // Cor do texto quando focado
            unfocusedTextColor = Color.Black // Cor do texto quando não focado
        ),

        keyboardOptions = KeyboardOptions(
            // Define a ação do teclado quando o usuário termina de digitar.
            // ImeAction.Search mostra um botão de "pesquisar" no teclado.
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            // Define o que acontece quando a ação do teclado (como "pesquisar") é acionada.
            onSearch = {
                onSearch(searchText) // Chama a lambda 'onSearch' passando o texto atual.
                keyboardController?.hide() // Esconde o teclado após a pesquisa.
            }
        ),
        singleLine = true // Garante que o campo de texto tenha apenas uma linha.
    )

}

