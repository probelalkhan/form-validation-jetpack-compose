package net.simplifiedcoding.formvalidation.validator

data class ValidationResult(
    val errorMessage: String? = null
) {
    val isValid: Boolean
        get() = errorMessage == null
}