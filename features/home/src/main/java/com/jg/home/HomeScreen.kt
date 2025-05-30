import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jg.home.HomeUIState
import com.jg.home.HomeViewModel

@Composable
fun HomeScreen( viewmodel : HomeViewModel = hiltViewModel()){

    val budget = viewmodel.budgetResponse.collectAsState()
    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primary)){
        when(budget.value){
            is HomeUIState.Error -> {Box(Modifier.size(50.dp).offset(x =0.dp, y=100.dp).background(Color.Red))}
            is HomeUIState.IDLE -> {Box(Modifier.size(50.dp).offset(x =0.dp, y=100.dp).background(Color.Gray))}
            is HomeUIState.Loading -> {Box(Modifier.size(50.dp).offset(x =0.dp, y=100.dp).background(Color.Yellow))}
            is HomeUIState.Success -> {Box(Modifier.size(50.dp).offset(x =0.dp, y=100.dp).background(Color.Green))}
        }
    }
}
