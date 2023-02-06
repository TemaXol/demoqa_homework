package utils;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomeData {


    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String phone = faker.number().numberBetween(7926000000L, 7926999999L) + "";
    public String address = faker.address().fullAddress();

    List<String> random = Arrays.asList("English", "Chemistry", "Commerce", "Economics", "Hindi", "History");
    Random Dice = new Random();
    int n = Dice.nextInt(5);
    public String subject = random.get(n);

    List<String> randomSex = Arrays.asList("Female", "Other", "Male");
    Random Dices = new Random();
    int nt = Dices.nextInt(2);
    public String sex = randomSex.get(nt);

    List<String> randomHobbie = Arrays.asList("Sports", "Reading", "Music");
    Random Dicer = new Random();
    int arr = Dicer.nextInt(2);
    public String hobbie = randomHobbie.get(arr);

    List<String> randomImage = Arrays.asList("82762.jpg", "second.webp", "three.jpg");
    Random D = new Random();
    int array = D.nextInt(2);
    public String image = randomImage.get(array);

    public String state = "NCR";

    List<String> randomCity = Arrays.asList("Noida", "Gurgaon", "Noida");
    Random Var = new Random();
    int arrayCity = Var.nextInt(2);
    public String city = randomCity.get(arrayCity);

    public String day = faker.options().option("01", "02", "03", "04", "05", "06", "07", "08",
            "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19");
    public String month = faker.options().option("January", "February", "March",
            "April", "May", "June", "July", "August", "September", "October", "November", "December");
    public String year = faker.options().option("2012", "2013", "2010", "2015", "2022", "2024");

}
