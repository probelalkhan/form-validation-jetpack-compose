package net.simplifiedcoding.formvalidation.createaccount

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import net.simplifiedcoding.formvalidation.createaccount.validation.CreateAccountParam
import net.simplifiedcoding.formvalidation.createaccount.validation.ValidatorFactory
import net.simplifiedcoding.formvalidation.validator.InputValidator

class CreateAccountViewModel(
    private val validators: Map<CreateAccountParam, InputValidator> = ValidatorFactory.create()
) : ViewModel() {

    private val _state = MutableStateFlow(CreateAccountState())
    val state: StateFlow<CreateAccountState> = _state

    fun onEvent(event: CreateAccountEvent) {
        when (event) {
            is CreateAccountEvent.NameChanged -> _state.value = _state.value.copy(name = event.name)
            is CreateAccountEvent.EmailChanged -> _state.value = _state.value.copy(email = event.email)
            is CreateAccountEvent.PasswordChanged -> _state.value = _state.value.copy(password = event.password)
            is CreateAccountEvent.DateOfBirthChanged -> _state.value = _state.value.copy(dateOfBirth = event.dateOfBirth)
            CreateAccountEvent.CreateAccount -> {
                if (areInputsValid()) {
                    createAccount()
                }
            }
        }
    }

    private fun areInputsValid(): Boolean {
        val nameError = validators[CreateAccountParam.FULL_NAME]?.validate(_state.value.name)
        val emailError = validators[CreateAccountParam.EMAIL]?.validate(_state.value.email)
        val passwordError = validators[CreateAccountParam.PASSWORD]?.validate(_state.value.password)
        val dateOfBirthError = validators[CreateAccountParam.DATE_OF_BIRTH]?.validate(_state.value.dateOfBirth)

        val hasError = listOf(
            nameError,
            emailError,
            passwordError,
            dateOfBirthError
        ).any { it?.isValid == false }

        _state.value = _state.value.copy(
            nameError = nameError?.errorMessage,
            emailError = emailError?.errorMessage,
            passwordError = passwordError?.errorMessage,
            dateOfBirthError = dateOfBirthError?.errorMessage,
            isCreateAccountEnabled = hasError.not()
        )

        return hasError.not()
    }

    private fun createAccount() {


    }
}