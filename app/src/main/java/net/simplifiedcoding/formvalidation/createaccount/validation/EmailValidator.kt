package net.simplifiedcoding.formvalidation.createaccount.validation

import net.simplifiedcoding.formvalidation.validator.InputValidator
import net.simplifiedcoding.formvalidation.validator.ValidationResult

class EmailValidator : InputValidator {

    private val emailPattern = Regex("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,}$", RegexOption.IGNORE_CASE)

    override fun validate(input: String): ValidationResult {
        return if (input.isEmpty()) {
            ValidationResult("Email cannot be empty")
        } else if (!emailPattern.matches(input)) {
            return ValidationResult("Email is not valid")
        } else {
            ValidationResult()
        }
    }
}