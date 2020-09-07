package validate;

import org.springframework.beans.factory.annotation.Configurable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Configurable
public class PhoneNumberValidation implements ConstraintValidator<PhoneNumber,String> {

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.length() > 11 || value.length() < 10) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("length form 10 to 11.").addConstraintViolation();
            return false;
        }
        if (!value.startsWith("09")){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("phone number start with 09.").addConstraintViolation();
            return false;
        }
        return true;
    }
}
