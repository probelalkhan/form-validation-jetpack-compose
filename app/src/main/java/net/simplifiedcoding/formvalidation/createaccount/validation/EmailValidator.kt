package net.simplifiedcoding.formvalidation.createaccount.validation

import net.simplifiedcoding.formvalidation.R
import net.simplifiedcoding.formvalidation.validator.InputValidator
import net.simplifiedcoding.formvalidation.validator.ValidationResult

class EmailValidator : InputValidator {

    private val emailPattern = Regex("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,}$", RegexOption.IGNORE_CASE)

    override fun validate(input: String): ValidationResult {
        return if (input.isEmpty()) {
            ValidationResult(R.string.error_email_empty)
        } else if (!emailPattern.matches(input)) {
            return ValidationResult(R.string.error_email_invalid)
        } else {
            ValidationResult()
        }
    }
}