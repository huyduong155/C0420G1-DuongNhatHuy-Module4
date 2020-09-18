package validate;

import org.springframework.beans.factory.annotation.Configurable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@Configurable
public class IntegerValidation implements ConstraintValidator<Integer, java.lang.Integer> {
    @Override
    public void initialize(Integer constraintAnnotation) {

    }

    @Override
    public boolean isValid(java.lang.Integer value, ConstraintValidatorContext context) {
        if(value==0){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("must be the number").addConstraintViolation();
            return false;
        }

        try{
            if (value < 0){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("the number must be >= 0").addConstraintViolation();
                return false;
        }
            return true;
        }catch (Exception e){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("must be the number").addConstraintViolation();
        }
        return true;
    }

}
