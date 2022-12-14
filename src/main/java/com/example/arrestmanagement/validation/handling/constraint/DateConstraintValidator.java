package com.example.arrestmanagement.validation.handling.constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DateConstraintValidator implements ConstraintValidator<DateConstraint, Date> {

    private static final String DATE_PATTERN =
            "^((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";

    private static final Pattern pattern = Pattern.compile(DATE_PATTERN);

    @Override
    public void initialize(DateConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {

        boolean result = false;


        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int mon = cal.get(Calendar.MONTH);

        int MM = mon + 1;

//        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int YYYY = cal.get(Calendar.YEAR);
//        int YYYY = localDate.getYear();
//        int DD = localDate.getDayOfMonth();
        int DD = cal.get(Calendar.DAY_OF_MONTH);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(YYYY).append("-").append(MM).append("-").append(DD);

        Matcher matcher = pattern.matcher(stringBuilder);
        if (matcher.matches()) {
            result = true;
            int year = Integer.parseInt(matcher.group(1));
            String month = matcher.group(2);
            String day = matcher.group(3);
            if ((month.equals("4") || month.equals("6") || month.equals("9") ||
                    month.equals("04") || month.equals("06") || month.equals("09") ||
                    month.equals("11")) && day.equals("31")) {
                result = false;
            } else if (month.equals("2") || month.equals("02")) {
                if (day.equals("30") || day.equals("31")) {
                    result = false;
                } else if (day.equals("29")) {
                    if (!isLeapYear(year)) {
                        result = false;
                    }
                }
            }

        }
        return result;
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

}


