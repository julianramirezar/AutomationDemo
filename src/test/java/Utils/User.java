package Utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import com.github.javafaker.Faker;

/*
String gender, String username, String password, String day,
String month, String year, String firstName, String lastName,
String company, String address1, String address2, String country, 
String state, String City, String zipCode, String mobile
*/

public class User {
	private String email;
	private String gender;
	private String username;
	private String password;
	private LocalDate birthday;
	private String day;
	private String month;
	private String year;
	private String firstName;
	private String lastName;
	private String company;
	private String address1;
	private String address2;
	private int country;
	private String state;
	private String city;
	private String zipCode;
	private String mobile;

	public User() {
		Faker faker = new Faker();
		email = faker.internet().emailAddress();
		gender = (ThreadLocalRandom.current().nextInt(0, 2) < 1) ? "M" : "F";
		username = faker.name().username();
		password = faker.internet().password();
		LocalDate birthday = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		day = Integer.toString(birthday.getDayOfMonth());
		month = birthday.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		year = Integer.toString(birthday.getYear());
		firstName = faker.name().firstName();
		lastName = faker.name().lastName();
		company = faker.company().name();
		address1 = faker.address().streetAddress();
		address2 = faker.address().streetAddress();
		country = ThreadLocalRandom.current().nextInt(0, 7);
		state = faker.address().state();
		city = faker.address().cityName();
		zipCode = faker.address().zipCode();
		mobile = faker.phoneNumber().cellPhone();
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public String getGender() {
		return gender;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public String getMonth() {
		return month;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public String getDay() {
		return day;
	}

	public String getYear() {
		return year;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getCompany() {
		return company;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public int getCountry() {
		return country;
	}

	public String getState() {
		return state;
	}

}