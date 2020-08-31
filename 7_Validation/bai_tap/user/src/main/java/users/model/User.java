package users.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

@Component
public class User implements Validator {
    @NotEmpty(message = "First name is not empty")
    @Size(min = 5,max = 45,message = "Size first name must be between 5 and 45")
    private String first_name;

    @NotEmpty(message = "Last name is not empty")
    @Size(min = 5,max = 45,message = "Size last name must be between 5 and 45")
    private String last_name;

    private String phone;

    @NotNull(message = "Age is not empty")
    @Min(18)
    private int age;

    @NotEmpty
    @Email
    private String email;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String phone = user.getPhone();
        ValidationUtils.rejectIfEmpty(errors, "phone", "phone.empty");
        if (phone.length()>11 || phone.length()<10){
            errors.rejectValue("phone", "phone.length");
        }
        if (!phone.startsWith("0")){
            errors.rejectValue("phone", "phone.startsWith");
        }
        if (!phone.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phone", "phone.matches");
        }
    }
}
