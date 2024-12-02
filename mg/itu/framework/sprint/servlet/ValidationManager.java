package mg.itu.framework.sprint.servlet;

import java.lang.reflect.Field;
import mg.itu.framework.sprint.annotation.validation.Date;
import mg.itu.framework.sprint.annotation.validation.Mail;
import mg.itu.framework.sprint.annotation.validation.Numeric;
import mg.itu.framework.sprint.annotation.validation.Required;
import mg.itu.framework.sprint.utils.Utils;

@SuppressWarnings("null")
public class ValidationManager {

    public boolean isValid (Field field, String value) throws Exception {
        boolean result = true;

        if (field.isAnnotationPresent(Numeric.class)) {
            if (!Utils.isNumeric(value)){
                result = false;
                throw new Exception("The value of the input "+ field.getName() +" must be numeric!");
            }
        }

        if (field.isAnnotationPresent(Date.class)){
            if (!Utils.isDate(value)) {
                result = false;
                throw new Exception("The value of the input "+ field.getName() +" must be of type Date!");
            }
        }

        if (field.isAnnotationPresent(Mail.class)){
            if (!value.contains("@")){
                result = false;
                throw new Exception("The value of the input "+ field.getName() +" must be of type Mail!");
            }
        }

        if (field.isAnnotationPresent(Required.class)){
            if (value == null || value.equals("")) {
                result = false;
                throw new Exception("The input "+ field.getName() +" cannot be empty!");
            }
        }

        return result;
    }
}
