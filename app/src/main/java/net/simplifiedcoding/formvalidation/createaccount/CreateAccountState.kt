package net.simplifiedcoding.formvalidation.createaccount

data class CreateAccountState(
    val name: String = "",
    val nameError: String? = null,

    val email: String = "",
    val emailError: String? = null,

    val dateOfBirth: String = "",
    val dateOfBirthError: String? = null,

    val password: String = "",
    val passwordError: String? = null,

    val isCreateAccountEnabled: Boolean = false
)