package co.gov.heqc.healthcite.utils.constants;

public class PeopleConstants {

    private PeopleConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String PERSON_CREATED_MESSAGE = "Person created successfully";
    public static final String PERSON_NOT_FOUND_MESSAGE = "Person not found with provided id";
    public static final String PEOPLE_NO_DATA_FOUND_MESSAGE = "No people found in the database";
    public static final String PERSON_ALREADY_EXISTS_MESSAGE = "A person already exists with the document provided";
    public static final String MAIL_ALREADY_EXISTS_MESSAGE = "A person already exists with the mail provided";

}
