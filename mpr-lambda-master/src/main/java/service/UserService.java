package service;

import model.Role;
import model.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Locale.filter;


public class UserService {

    public static List<User> findUsersWhoHaveMoreThanOneAddress(List<User> users) {

        return users.stream()
        .filter(u -> u.getPersonDetails().getAddresses().size() > 1)
                .collect(Collectors.toList());
    }

    public static User findOldestPerson(List<User> users) {
        return users.stream().filter(user -> user.getPersonDetails().getAge() == users.stream().mapToInt(user1 -> user1.getPersonDetails().getAge()).max().getAsInt()).findFirst().get();
    }

    public static User findUserWithLongestUsername(List<User> users) {

        return  users.stream()
                .max((u1, u2) -> u1.getName().length() - u2.getName().length())
                .get();
    }

    public static String getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18(List<User> users) {
       return users.stream()
               .filter(u -> u.getPersonDetails().getAge() >18)
               .map(u -> u.getPersonDetails().getName() + " " + u.getPersonDetails().getSurname())
               .collect(Collectors.joining(","));

    }

    public static List<String> getSortedPermissionsOfUsersWithNameStartingWithA(List<User> users) {
        return (List<String>) users.stream()
                .filter(user -> user.getName().toUpperCase().startsWith("A"))
                .map(user -> user.getPersonDetails().getRole().getPermissions())
                .flatMap(List::stream)
                .map(permission -> permission.getName())
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<String> printCapitalizedPermissionNamesOfUsersWithSurnameStartingWithS(List<User> users) {
        return (List<String>) users.stream()
                .filter(u -> u.getPersonDetails().getSurname().toUpperCase().startsWith("S"))
                .map(user -> user.getPersonDetails().getRole().getPermissions())
                .flatMap(List::stream)
                .map(permission -> permission.getName())
                .sorted()
                .collect(Collectors.toList());
    }

    public static Map<Role, List<User>> groupUsersByRole(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(user -> user.getPersonDetails().getRole()));
    }

    public static Map<Boolean, List<User>> partitionUserByUnderAndOver18(List<User> users) {
        return users.stream()
                .collect(Collectors.partitioningBy(user -> user.getPersonDetails().getAge() > 18));
    }
}
