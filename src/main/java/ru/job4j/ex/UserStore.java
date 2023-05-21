package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User u : users) {
            if (login.equals(u.getUsername())) {
                user = u;
                break;
            }
        }
        if (user == null) {
            throw new UserNotFoundException("User not found.");
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean rsl = true;
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("The user: " + user.getUsername() + " is not valid");
        }
        return rsl;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user: " + user.getUsername() + " has an access");
            }
        } catch (UserInvalidException ex) {
            ex.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}
