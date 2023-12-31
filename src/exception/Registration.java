package exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {

    void validateRegistration(String login, String password, String confirmPassword) throws EmptyLoginException, LengthException, InvalidCharactersExceptions, PasswordConfirmationException {
        if(login == null || login.trim().length() == 0 || password == null || password.length() == 0) {
            throw new  EmptyLoginException("��� ���� ������ ���� ���������");
        }

        if(login.length() > 20 || password.length() > 20 || confirmPassword.length() > 20) {
            throw new LengthException("����� ���� �� ������ ��������� 20 ��������");
        }
        Pattern pattern = Pattern.compile("[^a-zA-Z0-1_]");
        Matcher matcher = pattern.matcher(login);
        Matcher matcher1 = pattern.matcher(password);
        Matcher matcher2 = pattern.matcher(confirmPassword);
        if(matcher.find() || matcher1.find() || matcher2.find()) {
            throw new InvalidCharactersExceptions("������� �� ���������� �������");
        }
        if(!password.equals(confirmPassword)) {
            throw new PasswordConfirmationException("������ � ��� ������������� �� ���������");
        }
    }

    public static void main(String[] args) {
        Registration registration = new Registration();
        try {
            registration.validateRegistration("10100", "tttt", "tttt_");
        } catch (EmptyLoginException e) {
            e.printStackTrace();
        } catch (LengthException e) {
            e.printStackTrace();
        } catch (InvalidCharactersExceptions e) {
            e.printStackTrace();
        } catch (PasswordConfirmationException e) {
            e.printStackTrace();
        }
        System.out.println("END");
    }
}
