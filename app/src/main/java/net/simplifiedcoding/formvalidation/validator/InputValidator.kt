package net.simplifiedcoding.formvalidation.validator

interface InputValidator {
    fun validate(input: String): ValidationResult
}