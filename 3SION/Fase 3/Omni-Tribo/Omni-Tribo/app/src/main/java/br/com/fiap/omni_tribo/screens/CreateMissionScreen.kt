package br.com.fiap.omni_tribo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.omni_tribo.R
import br.com.fiap.omni_tribo.components.OmniTopBar
import br.com.fiap.omni_tribo.repository.AddressRepository
import br.com.fiap.omni_tribo.ui.theme.*
import kotlinx.coroutines.launch

@Composable
fun CreateMissionScreen(
    step: Int = 1,
    navController: NavController,
    onBack: () -> Unit,
    onNext: () -> Unit,
) {
    var title by remember { mutableStateOf("") }
    var originCep by remember { mutableStateOf("") }
    var originAddress by remember { mutableStateOf("") }
    var originError by remember { mutableStateOf("") }
    var isLoadingOrigin by remember { mutableStateOf(false) }
    var destinationCep by remember { mutableStateOf("") }
    var destinationAddress by remember { mutableStateOf("") }
    var destinationError by remember { mutableStateOf("") }
    var isLoadingDestination by remember { mutableStateOf(false) }

    val repository = AddressRepository()
    val scope = rememberCoroutineScope()

    val lookupOriginCep: () -> Unit = {
        val digits = originCep.filter { it.isDigit() }
        if (digits.length != 8) {
            originError = "CEP deve ter 8 dígitos"
        } else {
            scope.launch {
                isLoadingOrigin = true; originAddress = ""; originError = ""
                val result = repository.getAddress(digits)
                isLoadingOrigin = false
                if (result != null) originAddress = result.fullAddress()
                else originError = "CEP não encontrado. Verifique e tente novamente."
            }
        }
    }

    val lookupDestinationCep: () -> Unit = {
        val digits = destinationCep.filter { it.isDigit() }
        if (digits.length != 8) {
            destinationError = "CEP deve ter 8 dígitos"
        } else {
            scope.launch {
                isLoadingDestination = true; destinationAddress = ""; destinationError = ""
                val result = repository.getAddress(digits)
                isLoadingDestination = false
                if (result != null) destinationAddress = result.fullAddress()
                else destinationError = "CEP não encontrado. Verifique e tente novamente."
            }
        }
    }

    Scaffold(
        topBar = { OmniTopBar(title = stringResource(R.string.new_mission), onBack = onBack) },
        containerColor = Paper,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Stepper
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .drawBehind {
                        drawLine(Line, Offset(0f, size.height), Offset(size.width, size.height), 1.dp.toPx())
                    }
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                listOf(1, 2, 3).forEach { n ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(4.dp)
                            .background(if (n <= step) GreenPrimary else Line, RoundedCornerShape(2.dp))
                    )
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                if (step == 1) {
                    Step1Content()
                } else {
                    Step2Content(
                        title = title,
                        onTitleChange = { title = it },
                        originCep = originCep,
                        onOriginCepChange = { originCep = it },
                        onOriginSearch = lookupOriginCep,
                        originAddress = originAddress,
                        originError = originError,
                        isLoadingOrigin = isLoadingOrigin,
                        destinationCep = destinationCep,
                        onDestinationCepChange = { destinationCep = it },
                        onDestinationSearch = lookupDestinationCep,
                        destinationAddress = destinationAddress,
                        destinationError = destinationError,
                        isLoadingDestination = isLoadingDestination,
                    )
                }
            }

            // Bottom CTA
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .drawBehind {
                        drawLine(Line, Offset(0f, 0f), Offset(size.width, 0f), 1.dp.toPx())
                    }
                    .padding(14.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(48.dp)
                        .background(Color.White, RoundedCornerShape(14.dp))
                        .border(1.5.dp, Line, RoundedCornerShape(14.dp))
                        .clickable { onBack() },
                    contentAlignment = Alignment.Center,
                ) {
                    Text(stringResource(R.string.voltar), color = Ink70, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .background(GreenPrimary, RoundedCornerShape(14.dp))
                        .clickable { onNext() },
                    contentAlignment = Alignment.Center,
                ) {
                    val buttonText = if (step == 1) stringResource(R.string.continuar) else stringResource(R.string.publicar_missao)
                    Text(buttonText, color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
private fun Step1Content() {
    Text(stringResource(R.string.step1_title), color = Ink, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(4.dp))
    Text(stringResource(R.string.step1_subtitle), color = Ink70, fontSize = 13.sp)
    Spacer(modifier = Modifier.height(16.dp))

    data class Category(val icon: ImageVector, val label: String, val sub: String, val selected: Boolean)

    val categories = listOf(
        Category(Icons.Outlined.TrackChanges, stringResource(R.string.cat_entrega_label), stringResource(R.string.cat_entrega_sub), true),
        Category(Icons.Outlined.Inventory, stringResource(R.string.cat_coleta_label), stringResource(R.string.cat_coleta_sub), false),
        Category(Icons.Outlined.Groups, stringResource(R.string.cat_mutirao_label), stringResource(R.string.cat_mutirao_sub), false),
        Category(Icons.Outlined.Bolt, stringResource(R.string.cat_ajuda_label), stringResource(R.string.cat_ajuda_sub), false),
    )

    categories.chunked(2).forEach { row ->
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            row.forEach { cat ->
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .height(110.dp)
                        .background(if (cat.selected) GreenLight else Color.White, RoundedCornerShape(14.dp))
                        .border(1.5.dp, if (cat.selected) GreenPrimary else Line, RoundedCornerShape(14.dp))
                        .padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Box(
                        modifier = Modifier.size(36.dp).background(if (cat.selected) GreenPrimary else GreenLight, RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(cat.icon, null, tint = if (cat.selected) Color.White else GreenPrimary, modifier = Modifier.size(20.dp))
                    }
                    Column {
                        Text(cat.label, color = Ink, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        Text(cat.sub, color = Ink70, fontSize = 11.sp)
                    }
                }
            }
        }
    }

    Spacer(modifier = Modifier.height(8.dp))
    Text(stringResource(R.string.suggestions_title), color = Ink70, fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.6.sp, modifier = Modifier.padding(bottom = 8.dp))

    listOf(stringResource(R.string.suggestion_1), stringResource(R.string.suggestion_2)).forEach { suggestion ->
        Row(
            modifier = Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(12.dp)).border(1.dp, Line, RoundedCornerShape(12.dp)).padding(horizontal = 14.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Icon(Icons.Outlined.Bolt, null, tint = Amber, modifier = Modifier.size(16.dp))
            Text(suggestion, color = Ink, fontSize = 13.sp, modifier = Modifier.weight(1f))
            Icon(Icons.Outlined.Add, null, tint = Ink50, modifier = Modifier.size(16.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
private fun Step2Content(
    title: String,
    onTitleChange: (String) -> Unit,
    originCep: String,
    onOriginCepChange: (String) -> Unit,
    onOriginSearch: () -> Unit,
    originAddress: String,
    originError: String,
    isLoadingOrigin: Boolean,
    destinationCep: String,
    onDestinationCepChange: (String) -> Unit,
    onDestinationSearch: () -> Unit,
    destinationAddress: String,
    destinationError: String,
    isLoadingDestination: Boolean,
) {
    val focusManager = LocalFocusManager.current

    Text(stringResource(R.string.step2_title), color = Ink, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(4.dp))
    Text(stringResource(R.string.step2_subtitle), color = Ink70, fontSize = 13.sp)
    Spacer(modifier = Modifier.height(16.dp))

    FormLabel(stringResource(R.string.label_titulo))
    OutlinedTextField(
        value = title,
        onValueChange = onTitleChange,
        placeholder = { Text(stringResource(R.string.placeholder_titulo), color = Ink50, fontSize = 14.sp) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = GreenPrimary, unfocusedBorderColor = Line, focusedContainerColor = Color.White, unfocusedContainerColor = Color.White),
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
    )

    Spacer(modifier = Modifier.height(12.dp))
    FormLabel(stringResource(R.string.label_origem))
    CepInputRow(cep = originCep, onCepChange = onOriginCepChange, onSearch = { focusManager.clearFocus(); onOriginSearch() })
    AddressResult(address = originAddress, error = originError, isLoading = isLoadingOrigin)

    Spacer(modifier = Modifier.height(12.dp))
    FormLabel(stringResource(R.string.label_destino))
    CepInputRow(cep = destinationCep, onCepChange = onDestinationCepChange, onSearch = { focusManager.clearFocus(); onDestinationSearch() })
    AddressResult(address = destinationAddress, error = destinationError, isLoading = isLoadingDestination)

    Spacer(modifier = Modifier.height(12.dp))
    FormLabel(stringResource(R.string.label_recompensa))
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Column(modifier = Modifier.weight(1f).background(Color.White, RoundedCornerShape(12.dp)).border(1.dp, Line, RoundedCornerShape(12.dp)).padding(12.dp)) {
            Text(stringResource(R.string.label_xp), color = Ink70, fontSize = 11.sp)
            Text("+ 320", color = Amber, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
        Column(modifier = Modifier.weight(1f).background(Color.White, RoundedCornerShape(12.dp)).border(1.dp, Line, RoundedCornerShape(12.dp)).padding(12.dp)) {
            Text(stringResource(R.string.label_currency), color = Ink70, fontSize = 11.sp)
            Text("R$ 22", color = Ink, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun FormLabel(text: String) {
    Text(text = text, color = Ink70, fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.6.sp, modifier = Modifier.padding(bottom = 8.dp))
}

@Composable
private fun CepInputRow(cep: String, onCepChange: (String) -> Unit, onSearch: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        OutlinedTextField(
            value = cep,
            onValueChange = { if (it.length <= 9) onCepChange(it) },
            placeholder = { Text(stringResource(R.string.placeholder_cep), color = Ink50, fontSize = 14.sp) },
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = GreenPrimary, unfocusedBorderColor = Line, focusedContainerColor = Color.White, unfocusedContainerColor = Color.White),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { onSearch() }),
        )
        Box(
            modifier = Modifier.size(48.dp).background(GreenPrimary, RoundedCornerShape(12.dp)).clickable { onSearch() },
            contentAlignment = Alignment.Center,
        ) {
            Icon(Icons.Outlined.Search, null, tint = Color.White, modifier = Modifier.size(20.dp))
        }
    }
}

@Composable
private fun AddressResult(address: String, error: String, isLoading: Boolean) {
    when {
        isLoading -> Row(
            modifier = Modifier.padding(top = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            CircularProgressIndicator(color = GreenPrimary, modifier = Modifier.size(14.dp), strokeWidth = 2.dp)
            Text(stringResource(R.string.searching_cep), color = Ink70, fontSize = 12.sp)
        }
        address.isNotEmpty() -> Text(address, color = GreenDark, fontSize = 12.sp, modifier = Modifier.padding(top = 6.dp))
        error.isNotEmpty() -> Text(error, color = Coral, fontSize = 12.sp, modifier = Modifier.padding(top = 6.dp))
    }
}
