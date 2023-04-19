package net.simplifiedcoding.formvalidation.createaccount.validation

import net.simplifiedcoding.formvalidation.R
import net.simplifiedcoding.formvalidation.validator.InputValidator
import net.simplifiedcoding.formvalidation.validator.ValidationResult

class PasswordValidator : InputValidator {
    override fun validate(input: String): ValidationResult {
        return if (input.length < 6) {
            ValidationResult(R.string.error_name_length)
        } else {
            ValidationResult()
        }
    }
}