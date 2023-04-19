package net.simplifiedcoding.formvalidation.createaccount

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.simplifiedcoding.formvalidation.ui.theme.AppButton
import net.simplifiedcoding.formvalidation.ui.theme.AppTextField

@Composable
fun CreateAccountForm(paddingValues: PaddingValues, viewModel: CreateAccountViewModel) {

    val state = viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp)
    ) {

        AppTextField(
            value = state.value.name,
            hint = "Name",
            leadingIcon = Icons.Filled.Person,
            error = state.value.nameError,
            onValueChanged = { viewModel.onEvent(CreateAccountEvent.NameChanged(it)) }
        )

        AppTextField(
            value = state.value.email,
            hint = "Email",
            leadingIcon = Icons.Filled.Email,
            error = state.value.emailError,
            onValueChanged = { viewModel.onEvent(CreateAccountEvent.EmailChanged(it)) }
        )

        AppTextField(
            value = state.value.password,
            hint = "Password",
            leadingIcon = Icons.Filled.Lock,
            isPasswordField = true,
            error = state.value.passwordError,
            onValueChanged = { viewModel.onEvent(CreateAccountEvent.PasswordChanged(it)) }
        )

        AppTextField(
            value = state.value.dateOfBirth,
            hint = "Date of Birth",
            leadingIcon = Icons.Filled.CalendarMonth,
            isClickOnly = true,
            onClick = {
                //@Todo Open DOB Picker
            },
            error = state.value.dateOfBirthError,
            onValueChanged = { viewModel.onEvent(CreateAccountEvent.DateOfBirthChanged(it)) }
        )

        Spacer(modifier = Modifier.size(16.dp))

        AppButton(modifier = Modifier.fillMaxWidth(), text = "Create Account") {
            viewModel.onEvent(CreateAccountEvent.CreateAccount)
        }
    }
}