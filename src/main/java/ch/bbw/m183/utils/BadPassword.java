package ch.bbw.m183.utils;

import java.util.ArrayList;
import java.util.List;

public class BadPassword {

    public static boolean passwordIsValid(String password) {
        ArrayList<String> badPasswords = new ArrayList<>(List.of("123456", "password", "123456789", "12345678", "12345", "111111", "1234567", "sunshine", "qwerty", "iloveyou", "princess", "admin", "welcome", "666666", "abc123", "football", "123123", "monkey", "654321", "!@#$%^&*", "charlie", "aa123456", "donald", "password1", "qwerty123", "letmein", "zxcvbnm", "login", "starwars", "121212", "bailey", "freedom", "shadow", "passw0rd", "master", "baseball", "buster", "Daniel", "Hannah", "Thomas", "summer", "George", "Harley", "222222", "Jessica", "ginger", "abcdef", "Jordan", "55555", "Tigger", "Joshua", "Pepper", "Robert", "Matthew", "12341234", "Andrew", "lakers", "andrea", "1qaz2wsx", "sophie", "Ferrari", "Cheese", "Computer", "jesus", "Corvette", "Mercedes", "flower", "Blahblah", "Maverick", "Hello", "loveme", "nicole", "hunter", "amanda", "jennifer", "banana", "chelsea", "ranger", "trustno1", "merlin", "cookie", "ashley", "bandit", "killer", "aaaaaa", "1q2w3e", "zaq1zaq1", "mustang", "test", "hockey", "dallas", "whatever", "admin123", "michael", "liverpool", "querty", "william", "soccer", "london", "!@#$%^&amp;*", "trustnot", "dragon", "adobe123", "1234", "1234567890"));
        return !badPasswords.contains(password);
    }
}
