package net.simplifiedcoding.formvalidation.createaccount.validation

import net.simplifiedcoding.formvalidation.validator.InputValidator

object ValidatorFactory {

    fun create(): Map<CreateAccountParam, InputValidator> = mapOf(
        CreateAccountParam.FULL_NAME to NameValidator(),
        CreateAccountParam.EMAIL to EmailValidator(),
        CreateAccountParam.PASSWORD to PasswordValidator(),
        CreateAccountParam.DATE_OF_BIRTH to DateOfBirthValidator(),
    )

}