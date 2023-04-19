package net.simplifiedcoding.formvalidation.createaccount.validation

import net.simplifiedcoding.formvalidation.validator.InputValidator
import net.simplifiedcoding.formvalidation.validator.ValidationResult

class PasswordValidator : InputValidator {
    override fun validate(input: String): ValidationResult {
        return if (input.length < 6) {
            ValidationResult("Password must be at least 6 characters")
        } else {
            ValidationResult()
        }
    }
}